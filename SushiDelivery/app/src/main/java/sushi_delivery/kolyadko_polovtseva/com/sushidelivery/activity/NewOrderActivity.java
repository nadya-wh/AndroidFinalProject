package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.getbase.floatingactionbutton.*;

import java.util.ArrayList;

import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.R;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.action.OrderAction;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.Order;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.server.ServerMockery;

public class NewOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (ServerMockery.getCurrentOrder() == null) {
            ServerMockery.setCurrentOrder(new Order());
        }
        //FloatingActionButton drinksFab = (FloatingActionButton) findViewById(R.id.drinks);
        //drinksFab.setImageDrawable(android.R.drawable.drink);
        ListView listView = (ListView) findViewById(R.id.listView);

        ArrayList<String> list = OrderAction.getFoodNames(ServerMockery.getCurrentOrder());
        if (list.size() == 0) {
            list.add(getString(sushi_delivery.kolyadko_polovtseva.com.sushidelivery.R.string.no_items));
        }

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                list);

        listView.setAdapter(adapter);

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