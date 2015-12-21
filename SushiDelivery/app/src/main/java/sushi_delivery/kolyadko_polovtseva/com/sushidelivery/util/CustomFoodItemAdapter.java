package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
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
public class CustomFoodItemAdapter extends ArrayAdapter {
    private ArrayList<RowModel> modelItems = null;
    private Context context;
    private HashMap<Integer, ImageView> imageViews;

    public CustomFoodItemAdapter(Context context, ArrayList<RowModel> resource) {
        super(context, R.layout.row, resource);
        this.context = context;
        this.modelItems = resource;
        imageViews = new HashMap<>(resource.size());
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.row, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        imageViews.put(position, imageView);

        name.setText(modelItems.get(position).getName() + "\n" + modelItems.get(position).getPrice());

        DownloadPictureTask downloadPictureTask = new DownloadPictureTask();
        downloadPictureTask.execute(new DownloadPictureTaskBean(position, modelItems.get(position).getImageUrl()));

        if (modelItems.get(position).isValue())
            checkBox.setChecked(true);
        else
            checkBox.setChecked(false);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (modelItems.get(position).isValue()) {
                    checkBox.setChecked(false);
                    modelItems.get(position).setValue(false);
                    ServerMockery.getCurrentOrder().removeFoodItem(new Food(modelItems.get(position).getType(),
                            modelItems.get(position).getName(), modelItems.get(position).getPrice(),
                            modelItems.get(position).getImageUrl()));
                } else {
                    checkBox.setChecked(true);
                    modelItems.get(position).setValue(true);
                    Food foodItem = new Food(modelItems.get(position).getType(),
                            modelItems.get(position).getName(), modelItems.get(position).getPrice(),
                            modelItems.get(position).getImageUrl());
                    ServerMockery.getCurrentOrder().addFoodItem(foodItem);
                }
            }
        });

        return convertView;
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
