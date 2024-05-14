package com.example.real_state_application_4984.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.real_state_application_4984.Domain.ItemsDomain;
import com.example.real_state_application_4984.R;

import java.text.DecimalFormat;

public class DetailActivity extends AppCompatActivity {
    private TextView titleTxt, addressTxt, bedTxt, bathTxt, wifiTxt, descriptionTxt, priceTxt;
    private ImageView pic;

    DecimalFormat formatter = new DecimalFormat("###,###,###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initViews();
        displayItemDetails();
    }

    private void displayItemDetails() {
        ItemsDomain item = (ItemsDomain) getIntent().getSerializableExtra("object");

        if (item != null) {
            titleTxt.setText(item.getTitle());
            addressTxt.setText(item.getAddress());
            bedTxt.setText(item.getBed() + " Bed");
            bathTxt.setText(item.getBath() + " Bath");
            descriptionTxt.setText(item.getDescription());
            priceTxt.setText("$" + formatter.format(item.getPrice()));

            if (item.isWifi()) {
                wifiTxt.setText("WiFi");
            } else {
                wifiTxt.setText("No WiFi");
            }

            int drawableResourceID = getResources().getIdentifier(item.getPic(), "drawable", getPackageName());

            Glide.with(this)
                    .load(drawableResourceID)
                    .into(pic);
        }
    }

    private void initViews() {
        titleTxt = findViewById(R.id.titleTxt);
        addressTxt = findViewById(R.id.addressTxt);
        bedTxt = findViewById(R.id.bedTxt);
        bathTxt = findViewById(R.id.bathTxt);
        wifiTxt = findViewById(R.id.wifiTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        pic = findViewById(R.id.pic);
        priceTxt = findViewById(R.id.priceTxt);
    }
}
