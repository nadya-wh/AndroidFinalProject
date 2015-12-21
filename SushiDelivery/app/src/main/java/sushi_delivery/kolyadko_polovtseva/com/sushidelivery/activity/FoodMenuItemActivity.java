package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.R;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.action.RowModelBuilder;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.Food;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.FoodType;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.RowModel;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.init.FoodInitializer;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.util.CustomFoodItemAdapter;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.util.CustomOrderAdapter;

public class FoodMenuItemActivity extends AppCompatActivity {


    private ArrayList<RowModel> rows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu_item);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extras = getIntent().getExtras();
        FoodType type = FoodType.fromInteger(extras.getInt("food_type"));
        ListView listView = (ListView) findViewById(R.id.listView);

        ArrayList<Food> food;
        FoodInitializer foodInitializer = null;
        switch (type) {
            case DRINK:
                foodInitializer = new FoodInitializer(FoodType.DRINK,
                        getResources().openRawResource(R.raw.drinks));
                break;
            case SALAD:
                foodInitializer = new FoodInitializer(FoodType.SALAD,
                        getResources().openRawResource(R.raw.salads));
                break;
            case SOUP:
                foodInitializer = new FoodInitializer(FoodType.SOUP,
                        getResources().openRawResource(R.raw.soups));
                break;
            case SUSHI:
                foodInitializer = new FoodInitializer(FoodType.SUSHI,
                        getResources().openRawResource(R.raw.sushi));
                break;
        }


        if (foodInitializer.init()) {
            food = foodInitializer.initFoodItems();
            rows = RowModelBuilder.buildRowModel(food);
            CustomOrderAdapter adapter = new CustomOrderAdapter(this, rows);
            listView.setAdapter(adapter);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}