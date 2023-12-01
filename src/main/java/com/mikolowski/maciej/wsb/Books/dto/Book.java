package com.mikolowski.maciej.wsb.Books.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    @Positive
    private Float price;

    public Float getPrice() {
        if (price != null) {
            return (Math.round(price * 100f) / 100f);
        }

        return 0f;
    }

    public Float setPrice(Float price) {
        return this.price = (Math.round(price * 100f) / 100f);
    }
}
