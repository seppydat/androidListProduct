package com.example.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ProductAdapter extends BaseAdapter {

    private Context context;
    private List<Product> data;

    public ProductAdapter(Context context, List<Product> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position +1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false);
        }

        ImageView imgItem = convertView.findViewById(R.id.img_image_item);
        TextView nameItem = convertView.findViewById(R.id.tv_name_item);
        TextView priceItem = convertView.findViewById(R.id.tv_price_item);

        Product product = data.get(position);

        nameItem.setText(product.getName());
        priceItem.setText(convertCurrency(product.getPrice()));

        if (product.getImage() != null && !product.getImage().isEmpty()) {
            Glide.with(convertView).load(product.getImage()).into(imgItem);
        }

        imgItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, String.format("Image product %s", product.getName()), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    private String convertCurrency(float price) {
        Locale usa = new Locale("en", "US");
        NumberFormat dollarsFormat = NumberFormat.getCurrencyInstance(usa);

        return dollarsFormat.format(price);
    }
}
