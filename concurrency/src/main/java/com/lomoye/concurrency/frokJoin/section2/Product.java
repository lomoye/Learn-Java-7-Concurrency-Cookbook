package com.lomoye.concurrency.frokJoin.section2;

/**
 * Created by lomoye on 2017/7/21.
 * 存储产品的名称和价格
 */
public class Product {
    private String name;

    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
