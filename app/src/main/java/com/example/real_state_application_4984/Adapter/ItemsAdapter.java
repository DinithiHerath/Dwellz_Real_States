package com.example.real_state_application_4984.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.real_state_application_4984.Domain.ItemsDomain;
import com.example.real_state_application_4984.R;
import com.example.real_state_application_4984.activities.DetailActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    ArrayList<ItemsDomain> items;
    DecimalFormat formatter;
    Context context;

    public ItemsAdapter(ArrayList<ItemsDomain> items) {
        this.items = items;
        formatter=new DecimalFormat("###,###,###,###.##");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewholder,parent,false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemsDomain item = items.get(position);

        // Ensure the title, address, and price are valid strings
        if (item.getTitle() != null) {
            holder.titleTxt.setText(item.getTitle());
        } else {
            holder.titleTxt.setText(R.string.default_title);  // Ensure this is defined in strings.xml
        }

        if (item.getAddress() != null) {
            holder.addressTxt.setText(item.getAddress());
        } else {
            holder.addressTxt.setText(R.string.default_address);  // Ensure this is defined in strings.xml
        }

        if (item.getPrice() != 0) {
            holder.priceText.setText("$" + formatter.format(item.getPrice()));
        } else {
            holder.priceText.setText(R.string.default_price);  // Ensure this is defined in strings.xml
        }

        // Ensure the picture resource ID is valid
        int drawableResourceId = holder.itemView.getResources().getIdentifier(item.getPic(), "drawable", holder.itemView.getContext().getPackageName());
        if (drawableResourceId != 0) {
            Glide.with(holder.itemView.getContext())
                    .load(drawableResourceId)
                    .into(holder.pic);
        } else {
            holder.pic.setImageResource(R.drawable.pic1);  // Ensure this is defined in your drawable resources
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("object", item);
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {

        return items.size();
    }



    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleTxt, addressTxt, priceText;
        ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt=itemView.findViewById(R.id.titleTxt);
            addressTxt=itemView.findViewById(R.id.addressTxt);
            priceText=itemView.findViewById(R.id.priceTxt);
            pic=itemView.findViewById(R.id.pic);
        }
    }
}