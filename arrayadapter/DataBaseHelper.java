package com.example.arrayadapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String productOrder_table="productOrder_table";
    public static final String product_table="product_table";
    public static final String order_table="order_table";
    public static final String kolumna_id_zmowiania = "id_zmowiania";
    public static final String kolumna_id_produktu = "id_produktu";
    BasketActivity basketActivity=new BasketActivity();

    public DataBaseHelper(@Nullable Context context) {
        super(context, "sklep.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatementProductOrder="CREATE TABLE " + productOrder_table + " (" + kolumna_id_zmowiania + " INTEGER, " + kolumna_id_produktu + " INTEGER , ilosc INTEGER, cena_jednostkowa INTEGER, cena_calosci INTEGER) ";
        String createTableStatementProduct="CREATE TABLE "+product_table+ " (" + kolumna_id_produktu + " INTEGER PRIMARY KEY NOT NULL, nazwa Varchar(150), opis TEXT, cena INTEGER)";
        String createTableStatementOrder="CREATE TABLE " + order_table + " (" + kolumna_id_zmowiania + " INTEGER PRIMARY KEY NOT NULL, cena INTEGER)";


        sqLiteDatabase.execSQL(createTableStatementProductOrder);
        sqLiteDatabase.execSQL(createTableStatementProduct);
        sqLiteDatabase.execSQL(createTableStatementOrder);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public boolean addOneProductOrder(ProductOrderModel productOrderModel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(kolumna_id_zmowiania,productOrderModel.getId_zamowienia());
        cv.put(kolumna_id_produktu,productOrderModel.getId_produktu());
        cv.put("cena_jednostkowa",productOrderModel.getCena_jednostka());
        cv.put("ilosc",productOrderModel.getIlosc());
        cv.put("cena_calosci",productOrderModel.getCena_calosc());

        long insert = db.insert(productOrder_table, null, cv);
        if(insert==-1){
            return false;
        }
        return true;
    }
    public boolean addOneProduct(ProductModel productModel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(kolumna_id_produktu,productModel.getId());
        cv.put("nazwa",productModel.getNazwa());
        cv.put("opis",productModel.getOpis());
        cv.put("cena",productModel.getCena());

        long insert = db.insert(product_table,null,cv);
        if(insert==-1){
            return false;
        }
        return true;
    }
    public boolean addOneOrder(OrderModel orderModel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(kolumna_id_zmowiania,orderModel.getId());
        cv.put("cena",orderModel.getCena());


        long insert = db.insert(order_table,null,cv);
        if(insert==-1){
            return false;
        }
        return true;
    }
    public List<ProductOrderModel> getAllProductOrders(){
        List<ProductOrderModel> returnList=new ArrayList<>();
        String querryString="SELECT * FROM "+productOrder_table+" WHERE "+kolumna_id_zmowiania+" = "+1+"";

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor = db.rawQuery(querryString,null);

        if(cursor.moveToFirst()){
            do{
                int zamowienieID=cursor.getInt(0);
                int produktID=cursor.getInt(1);
                int ilosc=cursor.getInt(3);
                int cena_jednostkowa=cursor.getInt(2);

                ProductOrderModel productOrderModel=new ProductOrderModel(zamowienieID,produktID,ilosc,cena_jednostkowa);
                returnList.add(productOrderModel);
            }while(cursor.moveToNext());
        }
        else{
            // lmao
        }
        cursor.close();
        db.close();
        return returnList;
    };
    public int getProductId(String nazwa){

        SQLiteDatabase db=this.getReadableDatabase();
        String querryString="SELECT * FROM "+product_table+ " WHERE nazwa=\""+nazwa+"\"";
        Cursor cursor=db.rawQuery(querryString,null);
        if(cursor.moveToFirst())
            do{
                int produktId=cursor.getInt(0);
                return produktId;
            }while (cursor.moveToNext());
        return 1;
    }
    public String getProductName(int id){

        SQLiteDatabase db=this.getReadableDatabase();
        String querryString="SELECT * FROM "+product_table+ " WHERE id_produktu = "+id;
        Cursor cursor=db.rawQuery(querryString,null);
        if(cursor.moveToFirst())
            do{
                String produktNazwa=cursor.getString(1);
                return produktNazwa;
            }while (cursor.moveToNext());
        return "XD";
    }
    public boolean turncate(String tabela){
        SQLiteDatabase db=this.getWritableDatabase();
        String turncate="DELETE FROM "+tabela;
        db.execSQL(turncate);
        return true;
    }

}
