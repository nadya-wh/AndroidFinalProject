package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.R;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.action.ImageDownloadTask;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.DownloadPictureTaskBean;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.Food;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.RowModel;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.server.ServerMockery;

/**
 * Created by User on 20.12.2015.
 */
public class CustomOrderAdapter extends ArrayAdapter {
    ArrayList<RowModel> modelItems = null;
    Context context;
    private HashMap<Integer, ImageView> imageViews;

    public CustomOrderAdapter(Context context, ArrayList<RowModel> resource) {
        //super(context, R.layout.order_row);
        super(context, R.layout.order_row, resource);
        this.context = context;
        this.modelItems = resource;
        imageViews = new HashMap<>(resource.size());
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.i("LAL", "position: " + position + " " + modelItems.size());
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.order_row, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.textView);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        imageViews.put(position, imageView);

        name.setText(modelItems.get(position).getName() + "\n" + modelItems.get(position).getPrice());
//        try {
//            imageView.setImageBitmap(new ImageDownloadTask().execute(modelItems.get(position).getImageUrl()).get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        DownloadPictureTask downloadPictureTask = new DownloadPictureTask();
        downloadPictureTask.execute(new DownloadPictureTaskBean(position, modelItems.get(position).getImageUrl()));

        name.setOnLongClickListener(new View.OnLongClickListener() { //TODO:dosen't work
            @Override
            public boolean onLongClick(View v) {
                final CharSequence[] items = {context.getText(R.string.yes), context.getText(R.string.no)};
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(R.string.message);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0: {
                                ServerMockery.getCurrentOrder().removeFoodItem(new Food(modelItems.get(position).getType(),
                                        modelItems.get(position).getName(), modelItems.get(position).getPrice(),
                                        modelItems.get(position).getImageUrl()));
                                modelItems.remove(position);
                                break;
                            }
                            case 1:
                                break;
                        }

                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                return true;
            }
        });

        return convertView;
    }

    @Override
    public int getCount() {

        Log.i("LAL", "getCount: " + modelItems.size());
        return modelItems.size();
    }

    class DownloadPictureTask extends AsyncTask<DownloadPictureTaskBean, Void, Bitmap> {
        private Integer id;

        @Override
        protected Bitmap doInBackground(DownloadPictureTaskBean... params) {
            try {
                this.id = params[0].getImageViewId();
                java.net.URL url = new java.net.URL(params[0].getImageUrl());
                HttpURLConnection connection = (HttpURLConnection) url
                        .openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            ImageView imageView = imageViews.get(id);
            imageView.setImageBitmap(bitmap);
        }
    }

}
