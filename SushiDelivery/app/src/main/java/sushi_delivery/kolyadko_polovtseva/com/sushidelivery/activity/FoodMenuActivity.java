package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.R;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.FoodType;

public class FoodMenuActivity extends AppCompatActivity {

    private String[] food = {"Drinks", "Soups", "Salads", "Sushi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, food);
        listView.setAdapter(adapter);
        //getListView().getChildAt(position).setBackgroundColor(Color.CYAN);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position,
                                    long id) {
                Intent intent = new Intent(FoodMenuActivity.this, FoodMenuItemActivity.class);
                switch (position) {
                    case 0:
                        intent.putExtra("food_type", FoodType.DRINK.ordinal());
                        break;
                    case 1:
                        intent.putExtra("food_type", FoodType.SOUP.ordinal());
                        break;
                    case 2:
                        intent.putExtra("food_type", FoodType.SALAD.ordinal());
                        break;
                    case 3:
                        intent.putExtra("food_type", FoodType.SUSHI.ordinal());
                        break;
                }
                startActivity(intent);
            }

        };
        listView.setOnItemClickListener(itemListener);
    }
}
