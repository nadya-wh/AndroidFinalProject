package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;

import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.R;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.server.ServerMockery;

public class ApproveOrderActivity extends AppCompatActivity {
    private ImageButton homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView totalSumTextView = (TextView) findViewById(R.id.total_sum);
        TextView totalSumLabelTextView = (TextView) findViewById(R.id.total_sum_label);
        homeButton = (ImageButton) findViewById(R.id.home_button);
        Typeface font = Typeface.createFromAsset(getAssets(), getString(R.string.font_path));
        totalSumTextView.setTypeface(font);
        totalSumLabelTextView.setTypeface(font);
        Intent intent = getIntent();
        totalSumTextView.setText(customFormat("###,###.#", Double.parseDouble(intent.getStringExtra("totalSum"))));

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerMockery.setCurrentOrder(null);
                startActivity(new Intent(ApproveOrderActivity.this, AuthUserMenuActivity.class));
            }
        });

        //  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private String customFormat(String pattern, double value) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        return value + "  " + pattern + "  " + output;
    }
}
