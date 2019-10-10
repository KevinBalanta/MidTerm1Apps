package com.example.challenge1.activities.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.challenge1.R;
import com.example.challenge1.activities.ShopActivity;
import com.example.challenge1.activities.model.data.ScoreManager;
import com.example.challenge1.activities.model.entity.Score;
import com.example.challenge1.activities.model.entity.ShopItem;

import java.util.ArrayList;

public class ShopItemAdapter extends BaseAdapter {

    private ArrayList<ShopItem> shopItems;

    private ScoreManager scoreManager;

    private ShopActivity shopActivity;



    public ShopItemAdapter() {
        scoreManager = new ScoreManager(shopActivity.getApplicationContext());
    }

    public ShopItemAdapter(ArrayList<ShopItem> items, ShopActivity shopA) {
        scoreManager = new ScoreManager(shopA.getApplicationContext());
    shopItems = items;
    shopActivity = shopA;
    }

    @Override
    public int getCount() {
        return shopItems.size();
    }

    @Override
    public Object getItem(int i) {
        return shopItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row, null);

        TextView itemText = view.findViewById(R.id.item_name_et);
        Button itemBut = view.findViewById(R.id.item_buy_but);

        itemText.setText(shopItems.get(position).getName()+ " "+shopItems.get(position).getCost());

        itemBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //se compra item : restar de los puntos
                //actualizar puntaje
                Score score = scoreManager.getScore();

                int points = score.getScore();

                ShopItem item = shopItems.get(position);

                int cost = item.getCost();


                int value = points - cost;
                if(value >= 0){
                    scoreManager.setScore(value);
                    shopActivity.updateScore(value);
                    shopActivity.showToast("Felicitaciones has comprado un "+item.getName());
                }



                notifyDataSetChanged();
            }
        });

        return view;
    }

    public int getScore(){
        Score score = scoreManager.getScore();

        int points = score.getScore();

        return points;
    }
}
