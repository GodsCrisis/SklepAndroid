//package com.example.arrayadapter;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
//
//
//    String [] opisy={"Komputer ACTINA R5-3600 16GB SSD 1TB GeForce RTX3060Ti Windows 10 Home",
//            "Komputer Vist RGB VR6, Core i5-10400F, 16 GB, RTX 3060, 512 GB M.2 PCIe Windows 10 Pro",
//            "G4M3R HERO i5-11400F/16GB/1TB/RTX3060"};
//
//    int[] pcty={
//            R.drawable.vist,
//            R.drawable.actina,
//            R.drawable.g4m3r
//    };
//    Spinner spinner;
//    private int orderTotal;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.spinner);
//
//        spinner=findViewById(R.id.spinner);
//        spinner.setOnItemSelectedListener(this);
//
//        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_spinner_item,opisy);
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//        spinner.setAdapter(arrayAdapter);
//
//        MyAdapter myAdapter=new MyAdapter(getApplicationContext(),pcty,opisy);
//        spinner.setAdapter(myAdapter);
//
//    }
//
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//        switch (position){
//            case 0: orderTotal+=3824; break;
//            case 1: orderTotal+=5832; break;
//            case 2: orderTotal+=7764; break;
//            default:;
//        }
//        Toast.makeText(getApplicationContext(),opisy[position]+" "+orderTotal,Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
//}
