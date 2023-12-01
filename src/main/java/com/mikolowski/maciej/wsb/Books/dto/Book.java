package com.mikolowski.maciej.wsb.Books.dto;

import lombok.Data;

@Data
public class Book {

    private Integer id;

    private String title;

    private String author;

    private Float price;

    public Float getPrice() {
        return (Math.round(price * 100f) / 100f);
    }

    public Float setPrice(Float price) {
        return this.price = (Math.round(price * 100f) / 100f);
    }
}
