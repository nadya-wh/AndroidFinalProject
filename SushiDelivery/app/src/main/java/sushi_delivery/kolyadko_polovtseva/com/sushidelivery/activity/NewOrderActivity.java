package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import com.getbase.floatingactionbutton.*;

import java.util.ArrayList;
import java.util.List;

import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.R;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.action.RowModelBuilder;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.Food;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.Order;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.RowModel;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.server.ServerMockery;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.util.CustomOrderAdapter;


public class NewOrderActivity extends AppCompatActivity {

    private ArrayList<RowModel> rows;
    private ListView listView;
    private CustomOrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);
        if (ServerMockery.getCurrentOrder() == null) {
            ServerMockery.setCurrentOrder(new Order());
        }
        //FloatingActionButton drinksFab = (FloatingActionButton) findViewById(R.id.drinks);
        //drinksFab.setImageDrawable(android.R.drawable.drink);
        listView = (ListView) findViewById(R.id.listView);

        List<Food> food = ServerMockery.getCurrentOrder().getFood();
        if (food != null) {
            rows = RowModelBuilder.buildRowModel(food);
            adapter = new CustomOrderAdapter(this, rows);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
        FloatingActionButton drinks = (FloatingActionButton) findViewById(R.id.drinks);
        FloatingActionButton salads = (FloatingActionButton) findViewById(R.id.salad);
        FloatingActionButton soups = (FloatingActionButton) findViewById(R.id.soups);
        FloatingActionButton sushi = (FloatingActionButton) findViewById(R.id.sushi);

        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewOrderActivity.this, DrinksActivity.class));
            }
        });

        salads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewOrderActivity.this, SaladsActivity.class));
            }
        });

    }
}
