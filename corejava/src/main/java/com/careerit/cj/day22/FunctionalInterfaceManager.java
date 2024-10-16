package com.careerit.cj.day22;


interface Shape{

}

class Circle implements Shape{
    public void draw(){
        System.out.println("Circle is drawn");
    }
}
class Student implements  Cloneable{
    String id;
    String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void show() {
        System.out.println("Id : "+id+" Name : "+name);
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}
public class FunctionalInterfaceManager {

    public static void main(String[] args) throws CloneNotSupportedException {

            Student s1 = new Student("1001", "Krish");
            s1.show();
            Student s2 = s1.clone();
            s2.show();
    }
}
