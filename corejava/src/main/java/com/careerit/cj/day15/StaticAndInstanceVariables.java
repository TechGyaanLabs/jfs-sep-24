package com.careerit.cj.day15;

import java.util.List;

class Product {
    String pid;
    String name;
    double price;
    static int count = 0;

    public Product(String pid, String name, double price) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        count++;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

public class StaticAndInstanceVariables {

    public static void main(String[] args) {
        System.out.println(Product.count);
        List<Product> products = loadProducts();
        System.out.println(Product.count);
    }

    private static List<Product> loadProducts() {

        Product p1 = new Product("P1001", "Mac AirPro", 55000);
        Product p2 = new Product("P1002", "Mac ProM2", 89000);
        Product p3 = new Product("P1002", "Mac ProM3", 120000);
        return List.of(p1, p2, p3);

    }
}
