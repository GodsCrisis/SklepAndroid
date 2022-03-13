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

public class ScreenActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView progres;
    private SeekBar seekBar;
    private Button button;
    BasketActivity basketActivity;
    String[] nazwy = {"Monitor Samsung C27G55TQWR 1ms 144Hz",
            "Monitor HP X24ih 1ms 144Hz",
            "Monitor Samsung C27F396FHR"};

    int[] pcty = {
            R.drawable.oddyssey,
            R.drawable.hp,
            R.drawable.samsung
    };
    Spinner spinner;
    String [] opisy={"27 cali, DisplayPort x1, HDMI x1, HDR, zakrzywienie","23,8 cala, DiplayPort x1, HDMI x1, AMD FreeSync","27 cali, HDMI x1, VGA x1, AMD FreeSync, zakrzywiony ekran"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter arrayAdapter = new ArrayAdapter(ScreenActivity.this, android.R.layout.simple_spinner_item, nazwy);
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
                DataBaseHelper dataBaseHelper= new DataBaseHelper(ScreenActivity.this);
                try {

                    productOrderModel = new ProductOrderModel(1, dataBaseHelper.getProductId(textView4.getText().toString()), Integer.parseInt(progres.getText().toString()), Integer.parseInt(textView1.getText().toString()));
                }catch(Exception e){
                    productOrderModel = new ProductOrderModel(-1,-1,0,0);
                }


                boolean b = dataBaseHelper.addOneProductOrder(productOrderModel);

                Toast.makeText(ScreenActivity.this,"Dodano",Toast.LENGTH_SHORT).show();
            }
        });
        switch (position) {
            case 0:
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
            case 1:
                imageView.setImageResource(pcty[position]);

                textView.setText(opisy[position]);

                textView1.setText("700");

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

                textView1.setText("800");

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
