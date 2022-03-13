package com.example.arrayadapter;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
    private Button koszyk;
    private Button zakupy;

    String [] nazwy={"Komputer ACTINA R5-3600",
            "Komputer Vist RGB VR6",
            "G4M3R HERO",
            "LOGITECH G Pro League Of Legends",
            "GLORIOUS Model O(white)",
            "LOGITECH G502 Lightspeed",
            "SteelSeries Apex 3",
            "Logitech G413 TKL SE (czarny)",
            "Corsair K55 RGB Pro",
            "Monitor Samsung C27G55TQWR 1ms 144Hz",
            "Monitor HP X24ih 1ms 144Hz",
            "Monitor Samsung C27F396FHR"};
    String [] opisy={" 16GB SSD 1TB GeForce RTX3060Ti Windows 10 Home",
            "Core i5-10400F, 16 GB, RTX 3060, 512 GB M.2 PCIe Windows 10 Pro",
            "i5-11400F/16GB/1TB/RTX3060",
            "Bezprzewodowa,przewodowa optyczna 25600dpi USB",
            "Bezprzewodowa, optyczna 19000dpi USB",
            "bezprzewodowa ptyczna 25600dpi USB",
            "membranowa, USB, przewodowa, podświetlenie",
            "mechaniczna, USB, przewodowa, podświetlenie",
            "membranowa, USB, przewodowa, podświetlenie",
            "27 cali, DisplayPort x1, HDMI x1, HDR, zakrzywienie",
            "23,8 cala, DiplayPort x1, HDMI x1, AMD FreeSync",
            "27 cali, HDMI x1, VGA x1, AMD FreeSync, zakrzywiony ekran"};
    int[] ceny={
            3000,
            5832,
            7764,
            400,
            300,
            200,
            400,
            500,
            600,
            600,
            700,
            800
    };

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_draw_open,R.string.navigation_draw_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        for (int i=0;i<nazwy.length;i++){
            ProductModel productModel = new ProductModel(i+1,nazwy[i],opisy[i],ceny[i]);
            DataBaseHelper dataBaseHelper= new DataBaseHelper(MainActivity.this);

            boolean b = dataBaseHelper.addOneProduct(productModel);
            System.out.println(b);

        }
        koszyk=findViewById(R.id.menu_przejscie_koszyk);
        koszyk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent basketIntent=new Intent(getApplicationContext(), BasketActivity.class);
                startActivity(basketIntent);
            }
        });
        zakupy=findViewById(R.id.menu_przejscie_zakupy);
        zakupy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper= new DataBaseHelper(MainActivity.this);

                Intent pcIntent=new Intent(getApplicationContext(), PcActivity.class);
                startActivity(pcIntent);
            }
        });
    }
    @SuppressLint("NonConstantResourceId")
    public void OnOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.pc:
                Intent pcIntent=new Intent(getApplicationContext(), PcActivity.class);
                startActivity(pcIntent);
                break;
            case R.id.basket:
                Intent basketIntent=new Intent(getApplicationContext(), BasketActivity.class);
                startActivity(basketIntent);
                break;
            case R.id.mouse:
                Intent mouseIntent=new Intent(getApplicationContext(), MouseActivity.class);
                startActivity(mouseIntent);
                break;
            case R.id.screen:
                Intent screenIntent=new Intent(getApplicationContext(), ScreenActivity.class);
                startActivity(screenIntent);
                break;
            case R.id.keyboards:
                Intent keyboardsIntent=new Intent(getApplicationContext(), KeyboardsActivity.class);
                startActivity(keyboardsIntent);
                break;
            case R.id.info:
                Intent aboutIntent=new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(aboutIntent);
                break;
        }
    }
}