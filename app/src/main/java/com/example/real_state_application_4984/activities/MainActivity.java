package com.example.real_state_application_4984.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.real_state_application_4984.Adapter.ItemsAdapter;
import com.example.real_state_application_4984.Domain.ItemsDomain;
import com.example.real_state_application_4984.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPopular, adapterNew;
    private RecyclerView recyclerViewPopular, recyclerViewNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycleview();
    }

    private void initRecycleview() {
        ArrayList<ItemsDomain> ItemsArraylist = new ArrayList<>();

        ItemsArraylist.add(new ItemsDomain("House with a great view", "San Francisco, CA 94110", "This 2 bed /1 bath home boasts an enormous,\n" +
                "open-living plan,accented by striking \n" +
                "architectural features and high-end finishes.\n" +
                "Feel inspired by open sight lines that\n" +
                "embrace the outdoors, crowned by stunning\n" +
                "coffered ceilings.", 2, 1, 841156, "pic1", true));

        ItemsArraylist.add(new ItemsDomain("House with a great view", "San Francisco, CA 94110", "This 2 bed /1 bath home boasts an enormous,\n" +
                "open-living plan,accented by striking \n" +
                "architectural features and high-end finishes.\n" +
                "Feel inspired by open sight lines that\n" +
                "embrace the outdoors, crowned by stunning\n" +
                "coffered ceilings.", 3, 1, 654987, "pic2", false));

        ItemsArraylist.add(new ItemsDomain("House with a great view", "San Francisco, CA 94110", "This 2 bed /1 bath home boasts an enormous,\n" +
                "open-living plan,accented by striking \n" +
                "architectural features and high-end finishes.\n" +
                "Feel inspired by open sight lines that\n" +
                "embrace the outdoors, crowned by stunning\n" +
                "coffered ceilings.", 3, 1, 841156, "pic1", true));

        recyclerViewPopular = findViewById(R.id.viewPopular);
        recyclerViewNew = findViewById(R.id.viewNew);

        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewNew.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterNew = new ItemsAdapter(ItemsArraylist);
        adapterPopular = new ItemsAdapter(ItemsArraylist);

        recyclerViewNew.setAdapter(adapterNew);
        recyclerViewPopular.setAdapter(adapterPopular);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
