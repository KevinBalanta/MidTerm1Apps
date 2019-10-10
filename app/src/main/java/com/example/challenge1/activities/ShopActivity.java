package com.example.challenge1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.challenge1.R;
import com.example.challenge1.activities.model.adapter.ShopItemAdapter;
import com.example.challenge1.activities.model.entity.ShopItem;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {

    private ListView listShopItems;
    private TextView myScoreTv;
    private ShopItemAdapter adapter;
    private ArrayList<ShopItem> shopItems;
    private Button backBut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        shopItems = new ArrayList<>();
        ShopItem lapiz = new ShopItem(ShopItem.LAPICERO, ShopItem.LAPICERO_PUNTOS);
        ShopItem cuaderno = new ShopItem(ShopItem.CUADERNO, ShopItem.CUADERNO_PUNTOS);
        ShopItem libreta = new ShopItem(ShopItem.LIBRETA, ShopItem.LIBRETA_PUNTOS);
        ShopItem camiseta = new ShopItem(ShopItem.CAMISETA, ShopItem.CAMISETA_PUNTOS);
        ShopItem saco = new ShopItem(ShopItem.SACO, ShopItem.SACO_PUNTOS);

        shopItems.add(lapiz);
        shopItems.add(cuaderno);
        shopItems.add(libreta);
        shopItems.add(camiseta);
        shopItems.add(saco);

        listShopItems = findViewById(R.id.shop_list);
        myScoreTv = findViewById(R.id.score_tv);
        backBut = findViewById(R.id.back_buy_button);
        adapter = new ShopItemAdapter(shopItems, this);
        listShopItems.setAdapter(adapter);
        myScoreTv.setText(adapter.getScore()+"Pts");

        backBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ShopActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    public void showToast(String msg) {
        Toast.makeText(this.getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void updateScore(int score){
        myScoreTv.setText(score+"Pts");
    }
}
