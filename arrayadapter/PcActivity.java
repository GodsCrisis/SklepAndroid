package com.example.arrayadapter;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ShareCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.w3c.dom.Text;

public class PcActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView progres;
    private SeekBar seekBar;
    private Button button;
    String [] opisy={" 16GB SSD 1TB GeForce RTX3060Ti Windows 10 Home",
            "Core i5-10400F, 16 GB, RTX 3060, 512 GB M.2 PCIe Windows 10 Pro",
            "i5-11400F/16GB/1TB/RTX3060"};
    String [] nazwy={"Komputer ACTINA R5-3600","Komputer Vist RGB VR6","G4M3R HERO"

    };

    int[] pcty={
            R.drawable.vist,
            R.drawable.actina,
            R.drawable.g4m3r,
    };
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        spinner=findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter arrayAdapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,nazwy);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(arrayAdapter);

        MyAdapter myAdapter=new MyAdapter(getApplicationContext(),pcty,nazwy);
        spinner.setAdapter(myAdapter);

        progres= (TextView) findViewById(R.id.progres);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ImageView imageView=(ImageView) findViewById(R.id.photo);
        TextView textView=(TextView) findViewById(R.id.opis);
        TextView textView1=(TextView) findViewById(R.id.price_one);
        TextView textView2=(TextView) findViewById(R.id.price_all);
        TextView textView4=(TextView) findViewById(R.id.nazwa);
        progres= (TextView) findViewById(R.id.progres);
        button=findViewById(R.id.add_basket);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductOrderModel productOrderModel;
                DataBaseHelper dataBaseHelper= new DataBaseHelper(PcActivity.this);
                try {

                    productOrderModel = new ProductOrderModel(1, dataBaseHelper.getProductId(textView4.getText().toString()), Integer.parseInt(progres.getText().toString()), Integer.parseInt(textView1.getText().toString()));
                }catch(Exception e){
                    productOrderModel = new ProductOrderModel(-1,-1,0,0);
                }


                boolean b = dataBaseHelper.addOneProductOrder(productOrderModel);

                Toast.makeText(PcActivity.this,"Dodano",Toast.LENGTH_SHORT).show();
            }
        });
        switch (position){
            case 0:
                    imageView.setImageResource(pcty[position]);

                    textView.setText(opisy[position]);

                    textView1.setText("3000");

                    textView4.setText(nazwy[position]);

                    progres= (TextView) findViewById(R.id.progres);
                    seekBar= (SeekBar) findViewById(R.id.seekbar);
                    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            progres.setText(String.valueOf(i));
                            textView2.setText(String.valueOf(Integer.parseInt(String.valueOf(textView1.getText()))*i));
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }
                    });

                    break;
            case 1:
                imageView.setImageResource(pcty[position]);

                textView.setText(opisy[position]);

                textView1.setText("5832");

                textView4.setText(nazwy[position]);

                progres= (TextView) findViewById(R.id.progres);
                seekBar= (SeekBar) findViewById(R.id.seekbar);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        progres.setText(String.valueOf(i));
                        textView2.setText(String.valueOf(Integer.parseInt(String.valueOf(textView1.getText()))*i));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                break;
            case 2:                 imageView.setImageResource(pcty[position]);

                textView.setText(opisy[position]);

                textView1.setText("7764");

                textView4.setText(nazwy[position]);

                progres= (TextView) findViewById(R.id.progres);
                seekBar= (SeekBar) findViewById(R.id.seekbar);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        progres.setText(String.valueOf(i));
                        textView2.setText(String.valueOf(Integer.parseInt(String.valueOf(textView1.getText()))*i));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                break;
            default:;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
