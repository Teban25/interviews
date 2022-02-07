package com.quickreview.interviews.persistence;

import lombok.Data;

import java.util.List;

@Data
public class Product {

    private String productId;


    private String name;
    private List<Category> categories;
    private Vendor vendor;
}
