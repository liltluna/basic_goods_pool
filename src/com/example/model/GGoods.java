package com.example.model;
import java.util.Date;

public class GGoods{
    private int goods_id;
    private String goods_name;
    private double goods_price;
    private String goods_description;
    private Date date;

    public GGoods(){
        goods_id = 0;
        goods_description = "this is a test";
        goods_name = "test";
        goods_price = -1.0;
        date = new Date();
    }

    public int getGoods_id() {
        return goods_id;
    }
    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }
    public String getGoods_name() {
        return goods_name;
    }
    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }
    public double getGoods_price() {
        return goods_price;
    }
    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }
    public String getGoods_description() {
        return goods_description;
    }
    public void setGoods_description(String goods_description) {
        this.goods_description = goods_description;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}