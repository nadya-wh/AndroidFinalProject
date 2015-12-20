package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.util;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.R;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.action.ImageDownloadTask;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.RowModel;

/**
 * Created by User on 20.12.2015.
 */
public class CustomOrderAdapter extends ArrayAdapter {
    ArrayList<RowModel> modelItems = null;
    Context context;

    public CustomOrderAdapter(Context context, ArrayList<RowModel> resource) {
        //super(context, R.layout.order_row);
        super(context, R.layout.order_row, resource);
        this.context = context;
        this.modelItems = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.i("LAL", "position: " + position + " " + modelItems.size());
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.order_row, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.textView);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        name.setText(modelItems.get(position).getName() + "\n" + modelItems.get(position).getPrice());
        try {
            imageView.setImageBitmap(new ImageDownloadTask().execute(modelItems.get(position).getImageUrl()).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return convertView;
    }

    @Override
    public int getCount() {

        Log.i("LAL", "getCount: " + modelItems.size());
        return modelItems.size();
    }

}
