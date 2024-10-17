package com.careerit.cj.day23;

class Product{

    private final int pid;
    private final String pname;
    private final double price;

    public Product(int pid, String pname, double price) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
    }

    public int getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public double getPrice() {
        return price;
    }

    public Product increasePrice(double amount){
        return new Product(pid, pname, price + amount);
    }


    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                '}';
    }
}
public class ImmutableObjects {

    public static void main(String[] args) {

        Product product1 = new Product(1001, "Dell Laptop", 45000);
        System.out.println(product1);

        Product product2 = product1.increasePrice(5000);
        System.out.println(product2);

        System.out.println(product1.hashCode());
        System.out.println(product2.hashCode());

    }
}
