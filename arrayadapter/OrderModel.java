package com.example.arrayadapter;

public class OrderModel {
    private int id;
    private int cena;
    public OrderModel(int id, int cena){
        this.id=id;
        this.cena=cena;
    }
    public OrderModel(){

    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "id=" + id +
                ", cena=" + cena +
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
}
