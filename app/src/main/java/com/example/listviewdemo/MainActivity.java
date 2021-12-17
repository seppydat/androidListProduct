package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listProducts;
    private List<Product> productList;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listProducts = findViewById(R.id.lv_main_items);

        productList = new ArrayList<>();
        // fake data
        productList.add(new Product("Vinfast Fadil", 15000, "https://giaxeoto.vn/admin/upload/images/resize/640-gia-xe-vinfast-lux-sa20.JPG"));
        productList.add(new Product("Vinfast Lux A", 19500, "https://giaxeoto.vn/admin/upload/images/resize/640-gia-xe-vinfast-lux-sa20.JPG"));
        productList.add(new Product("Vinfast Lux A2.0", 25000, "https://giaxeoto.vn/admin/upload/images/resize/640-gia-xe-vinfast-lux-sa20.JPG"));
        productList.add(new Product("Vinfast Tes", 18000, "https://giaxeoto.vn/admin/upload/images/resize/640-gia-xe-vinfast-lux-sa20.JPG"));

        //create adapter
        productAdapter = new ProductAdapter(this, productList);

        //set adapter to listview

        listProducts.setAdapter(productAdapter);

    }
}