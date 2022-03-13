package com.example.arrayadapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class KeyboardsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView progres;
    private SeekBar seekBar;
    private Button button;
    BasketActivity basketActivity;
    String[] nazwy = {"SteelSeries Apex 3",
            "Logitech G413 TKL SE (czarny)",
            "Corsair K55 RGB Pro"};

    int[] pcty = {
            R.drawable.apex,
            R.drawable.logitech,
            R.drawable.corsair
    };
    Spinner spinner;
    String [] opisy={"membranowa, USB, przewodowa, podświetlenie","mechaniczna, USB, przewodowa, podświetlenie","membranowa, USB, przewodowa, podświetlenie"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter arrayAdapter = new ArrayAdapter(KeyboardsActivity.this, android.R.layout.simple_spinner_item, nazwy);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(arrayAdapter);

        MyAdapter myAdapter = new MyAdapter(getApplicationContext(), pcty, nazwy);
        spinner.setAdapter(myAdapter);

        progres = (TextView) findViewById(R.id.progres);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ImageView imageView=(ImageView) findViewById(R.id.photo);
        TextView textView=(TextView) findViewById(R.id.opis);
        TextView textView1=(TextView) findViewById(R.id.price_one);
        TextView textView2=(TextView) findViewById(R.id.price_all);
        TextView textView4=(TextView) findViewById(R.id.nazwa);
        button=findViewById(R.id.add_basket);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductOrderModel productOrderModel;
                DataBaseHelper dataBaseHelper= new DataBaseHelper(KeyboardsActivity.this);
                try {

                    productOrderModel = new ProductOrderModel(1, dataBaseHelper.getProductId(textView4.getText().toString()), Integer.parseInt(progres.getText().toString()), Integer.parseInt(textView1.getText().toString()));
                }catch(Exception e){
                    productOrderModel = new ProductOrderModel(-1,-1,0,0);
                }


                boolean b = dataBaseHelper.addOneProductOrder(productOrderModel);

                Toast.makeText(KeyboardsActivity.this,"Dodano",Toast.LENGTH_SHORT).show();
            }
        });
        switch (position) {
            case 0:
                imageView.setImageResource(pcty[position]);

                textView.setText(opisy[position]);

                textView1.setText("400");

                textView4.setText(nazwy[position]);

                progres = (TextView) findViewById(R.id.progres);
                seekBar = (SeekBar) findViewById(R.id.seekbar);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        progres.setText(String.valueOf(i));
                        textView2.setText(String.valueOf(Integer.parseInt(String.valueOf(textView1.getText())) * i));
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

                textView1.setText("500");

                textView4.setText(nazwy[position]);

                progres = (TextView) findViewById(R.id.progres);
                seekBar = (SeekBar) findViewById(R.id.seekbar);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        progres.setText(String.valueOf(i));
                        textView2.setText(String.valueOf(Integer.parseInt(String.valueOf(textView1.getText())) * i));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                break;
            case 2:
                imageView.setImageResource(pcty[position]);

                textView.setText(opisy[position]);

                textView1.setText("600");

                textView4.setText(nazwy[position]);

                progres = (TextView) findViewById(R.id.progres);
                seekBar = (SeekBar) findViewById(R.id.seekbar);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        progres.setText(String.valueOf(i));
                        textView2.setText(String.valueOf(Integer.parseInt(String.valueOf(textView1.getText())) * i));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                break;
            default:
                ;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
