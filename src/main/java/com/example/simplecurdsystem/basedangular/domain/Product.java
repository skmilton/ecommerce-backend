package com.example.simplecurdsystem.basedangular.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "product")
public class Product extends BaseEntity{

    private String productName;

    private String code;

    private String qty;

    private String description;

    private String unitPrice;

    private String unitInStock;
    private  String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
