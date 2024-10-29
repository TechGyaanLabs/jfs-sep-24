package com.careerit.cj.day29;

import java.lang.annotation.*;

@AuthorInfo(version = 1, name = "Krish", email = "krish@gmail.com")
class Employee {

        private String empno;
        private String ename;
        private String email;

        public Employee(String empno, String ename, String email) {
            this.empno = empno;
            this.ename = ename;
            this.email = email;
        }

    @Override
    public String toString() {
        return "Employee{" +
                "empno='" + empno + '\'' +
                ", ename='" + ename + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface  AuthorInfo{
    int version() default 1;
    String name() default "user";
    String email() default "user@gmail.com";
}
public class Manager {

    public static void main(String[] args) {

            Employee emp = new Employee("1001","Krish","krish@gmail.com");
            System.out.println(emp);

            Annotation[] annotations = emp.getClass().getAnnotations();

            for(Annotation annotation:annotations){
                if(annotation instanceof AuthorInfo){
                    AuthorInfo authorInfo = (AuthorInfo)annotation;
                    System.out.println("Version : "+authorInfo.version());
                    System.out.println("Name : "+authorInfo.name());
                    System.out.println("Email : "+authorInfo.email());
                }
            }
    }
}
