package com.example.controlleradvice.entity;

/**
 * @author yuhao
 * @date: 2021/1/21
 * @description:
 */
public class Book {
    private String name;
    private  Long price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
