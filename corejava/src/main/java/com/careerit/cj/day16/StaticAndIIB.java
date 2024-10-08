package com.careerit.cj.day16;

class Product {
    int pid;
    String name;
    double price;
    String desc;
    double discount;

    public static int count = 0;

    {
       count++;
    }

    static{

    }

    public Product(int pid, String name, double price) {
        this.pid = pid;
        this.name = name;
        this.price = price;
    }

    public Product(int pid, String name, double price, String desc) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    public Product(int pid, String name, double price, String desc, double discount) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                ", discount=" + discount +
                '}';
    }
}

public class StaticAndIIB {

    public static void main(String[] args) {

        Product p1 = new Product(10001, "Lenovo ThinkPad", 560000);
        System.out.println(p1);
    }
}
