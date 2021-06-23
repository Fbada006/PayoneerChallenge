package com.payoneer.payoneerchallenge.utils;

import com.payoneer.payoneerchallenge.models.Product;
import java.util.ArrayList;
import java.util.List;

public class FakeProductsGenerator {

    public static List<Product> generateFakeProducts() {
        List<Product> products = new ArrayList<Product>();
        for (int i = 1; i <= 10; i++) {
            products.add(new Product( "Product number " + i, "$ " + i * 100, i));
        }
        return products;
    }
}
