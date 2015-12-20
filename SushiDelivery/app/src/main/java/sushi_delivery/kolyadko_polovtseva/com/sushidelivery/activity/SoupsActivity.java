package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.R;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.action.RowModelBuilder;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.Food;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.FoodType;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.RowModel;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.init.FoodInitializer;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.util.CustomFoodItemAdapter;

public class SoupsActivity extends AppCompatActivity {

    private ArrayList<RowModel> rows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soups);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.listView);

        ArrayList<Food> soups;
        FoodInitializer foodInitializer = new FoodInitializer(FoodType.SOUP,
                getResources().openRawResource(R.raw.soups));

        if (foodInitializer.init()) {
            soups = foodInitializer.initFoodItems();
            rows = RowModelBuilder.buildRowModel(soups);
            CustomFoodItemAdapter adapter = new CustomFoodItemAdapter(this, rows);
            listView.setAdapter(adapter);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SoupsActivity.this, NewOrderActivity.class));
            }
        });
    }

}
