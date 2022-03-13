package com.example.arrayadapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketActivity extends AppCompatActivity {
    Button button;
    ListView listView;
    int orderIncrement;
    HashMap<String, Object> hashMap;
    ArrayList<HashMap<String, Object>> list;
    int total;
    public void increment(){
        SharedPreferences prefs = getSharedPreferences("OrderIncrement",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        orderIncrement = prefs.getInt("OrderIncrement",0);

        orderIncrement = orderIncrement + 1;
        editor.putInt("OrderIncrement",orderIncrement);

        editor.apply();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket);

        listView=findViewById(R.id.simple_list_view);
        DataBaseHelper dataBaseHelper = new DataBaseHelper(BasketActivity.this);

        List<ProductOrderModel> produkty= dataBaseHelper.getAllProductOrders();
        for(int i=0;i<produkty.size();i++){
            total+=produkty.get(i).getCena_calosc();
        }
        ArrayList<ArrayList> lista2=new ArrayList<>();
        for(int i=0;i<produkty.size();i++){
            ArrayList<String> lista3=new ArrayList();
            String cena_jeden="ilosc: "+String.valueOf(produkty.get(i).getCena_jednostka());
            String cena_calosc="cena całościowa: "+String.valueOf(produkty.get(i).getCena_calosc());
            String ilosc="cena za jedno: "+String.valueOf(produkty.get(i).getIlosc());
            String nazwa="nazwa produktu: "+String.valueOf(dataBaseHelper.getProductName(produkty.get(i).getId_produktu()));
            lista3.add(cena_jeden);
            lista3.add(cena_calosc);
            lista3.add(ilosc);
            lista3.add(nazwa);
            lista2.add(lista3);
        }
        TextView textView=(TextView) findViewById(R.id.cena_za_calosc);
        textView.setText(String.valueOf(total));
        ArrayAdapter productsArrayAdapter=new ArrayAdapter<ArrayList>(BasketActivity.this, android.R.layout.simple_list_item_1, lista2);
        listView.setAdapter(productsArrayAdapter);
        button=findViewById(R.id.kup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increment();
                SharedPreferences prefs=getSharedPreferences("OrderIncrement",Context.MODE_PRIVATE);
                int order= prefs.getInt("OrderIncrement",0);
                OrderModel orderModel=new OrderModel(order,total);
                DataBaseHelper dataBaseHelper= new DataBaseHelper(BasketActivity.this);
                dataBaseHelper.addOneOrder(orderModel);
                mailTo();
                dataBaseHelper.turncate("productOrder_table");
                textView.setText(String.valueOf(0));
                productsArrayAdapter.clear();
            }
        });

    }
    public void mailTo(){
        TextView textView=(TextView) findViewById(R.id.cena_za_calosc);

        TextView textView1=(TextView) findViewById(R.id.imie);

        CharSequence czas= Instant.now()+"\n"+textView.getText().toString()+"\n"+textView1.getText().toString();
        Intent mail = new Intent(Intent.ACTION_SEND);
        String[] maile= {
                textView1.getText().toString()
        };
        mail.setData(Uri.parse("mailto:"));
        mail.setType("text/plain");
        mail.putExtra(Intent.EXTRA_EMAIL,maile);
        mail.putExtra(Intent.EXTRA_SUBJECT,"zamowienie");
        mail.putExtra(Intent.EXTRA_TEXT,  czas);

        mail.setType("message/rfc822");

        startActivity(Intent.createChooser(mail,"Text"));
    }
}
