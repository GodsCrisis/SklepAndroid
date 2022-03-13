package com.example.arrayadapter;



public class ProductModel {
    private int id;
    public int cena;
    public String nazwa;
    public String opis;


    public ProductModel(int id, String nazwa, String opis, int cena) {
        this.id = id;
        this.nazwa = nazwa;
        this.opis = opis;
        this.cena = cena;

    }

    public ProductModel() {

    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", cena=" + cena +
                ", nazwa='" + nazwa + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}

