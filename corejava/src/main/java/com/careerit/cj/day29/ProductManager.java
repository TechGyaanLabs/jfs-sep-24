package com.careerit.cj.day29;

record Product(String pid, String pname, double price) {

    Product(String name, double price) {
            this(getId(), name, price);
    }

    private static String getId() {
           return "1001"+(int)(Math.random()*1000);
    }

    @Override
        public String toString() {
            return "Product{" +
                    "pid='" + pid + '\'' +
                    ", pname='" + pname + '\'' +
                    ", price=" + price +
                    '}';
        }
}

public class ProductManager {


    public static void main(String[] args) {
        Product product = new Product("Dell Laptop", 45000);
        System.out.println(product);

    }
}
