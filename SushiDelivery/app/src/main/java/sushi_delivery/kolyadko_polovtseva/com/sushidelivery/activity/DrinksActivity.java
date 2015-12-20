package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.R;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.action.RowModelBuilder;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.Food;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.FoodType;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.RowModel;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.init.FoodInitializer;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.util.CustomAdapter;

public class DrinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        ListView listView = (ListView) findViewById(R.id.listView);

        ArrayList<Food> drinks;
        FoodInitializer foodInitializer = new FoodInitializer(FoodType.DRINK,
                getResources().openRawResource(R.raw.drinks));

        if (foodInitializer.init()) {
            drinks = foodInitializer.initFoodItems();
            ArrayList<RowModel> rows = RowModelBuilder.buildRowModel(drinks);
            CustomAdapter adapter = new CustomAdapter(this, rows);
            listView.setAdapter(adapter);
        }
    }
}
