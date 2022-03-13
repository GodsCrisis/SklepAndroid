package com.example.arrayadapter;

public class ProductOrderModel {
    public int id_zamowienia;
    public int id_produktu;
    public int ilosc;
    public int cena_jednostka;
    public int cena_calosc;
    public ProductOrderModel(int id_zamowienia, int id_produktu, int ilosc, int cena_jednostka){
        this.id_zamowienia=id_zamowienia;
        this.id_produktu=id_produktu;
        this.ilosc=ilosc;
        this.cena_jednostka=cena_jednostka;
        this.cena_calosc=ilosc*cena_jednostka;
    }
    public ProductOrderModel(){

    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "id_zamowienia=" + id_zamowienia +
                ", id_produktu=" + id_produktu +
                ", ilosc=" + ilosc +
                ", cena_jednostka=" + cena_jednostka +
                ", cena_calosc=" + cena_calosc +
                '}';
    }

    public int getId_zamowienia() {
        return id_zamowienia;
    }

    public void setId_zamowienia(int id_zamowienia) {
        this.id_zamowienia = id_zamowienia;
    }

    public int getId_produktu() {
        return id_produktu;
    }

    public void setId_produktu(int id_produktu) {
        this.id_produktu = id_produktu;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public int getCena_jednostka() {
        return cena_jednostka;
    }

    public void setCena_jednostka(int cena_jednostka) {
        this.cena_jednostka = cena_jednostka;
    }

    public int getCena_calosc() {
        return cena_calosc;
    }

    public void setCena_calosc(int cena_calosc) {
        this.cena_calosc = cena_calosc;
    }
}
