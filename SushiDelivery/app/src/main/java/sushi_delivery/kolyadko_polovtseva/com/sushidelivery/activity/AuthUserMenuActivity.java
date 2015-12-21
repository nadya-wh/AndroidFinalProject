package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.R;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.User;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.server.ServerMockery;

public class AuthUserMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_user_menu);
        Typeface font = Typeface.createFromAsset(getAssets(), getString(R.string.font_path));
        ViewGroup menu = (ViewGroup) findViewById(R.id.menu_layout);
        setFont(menu, font);
        TextView usernameTextView = (TextView) findViewById(R.id.username_line);
        TextView addressTextView = (TextView) findViewById(R.id.address_line);
        TextView phoneTextView = (TextView) findViewById(R.id.phone_line);

        TextView newOrderView = (TextView) findViewById(R.id.new_order_text_view);
        TextView historyView = (TextView) findViewById(R.id.show_history_view);
        TextView logOutView = (TextView) findViewById(R.id.log_out_text_view);

        User currentUser = ServerMockery.getCurrentUser();
        usernameTextView.setText(currentUser.getName());
        addressTextView.setText(currentUser.getAddress());
        phoneTextView.setText(currentUser.getPhoneNumber());

        newOrderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newOrderActivity = new Intent(AuthUserMenuActivity.this, NewOrderActivity.class);
                startActivity(newOrderActivity);
            }
        });

        historyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
//                Intent loginActivity = new Intent(AuthUserMenuActivity.this, LoginActivity.class);
//                startActivity(loginActivity);
            }
        });

        logOutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerMockery.logOut();
                Intent activity = new Intent(AuthUserMenuActivity.this, MainActivity.class);
                startActivity(activity);
            }
        });
    }

    // Sets the font on all TextViews in the ViewGroup.
    public void setFont(ViewGroup group, Typeface font) {
        int count = group.getChildCount();
        View v;
        for (int i = 0; i < count; i++) {
            v = group.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTypeface(font);
            } else if (v instanceof ViewGroup) {
                setFont((ViewGroup) v, font);
            }
        }
    }
}