package com.careerit.cj.day22;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Apple {
    private String color;
    private double weight;

}

interface ApplePredicate {
    boolean test(Apple apple);
}

class AppleService {

    List<Apple> list = new ArrayList<>();

    public AppleService() {
        list.add(new Apple("Red", 120));
        list.add(new Apple("Green", 150));
        list.add(new Apple("Red", 130));
        list.add(new Apple("Green", 140));
        list.add(new Apple("Red", 110));
        list.add(new Apple("Green", 160));
        list.add(new Apple("Red", 100));
        list.add(new Apple("Green", 170));
        list.add(new Apple("Red", 90));
        list.add(new Apple("Green", 180));
        list.add(new Apple("Red", 80));
    }

    public List<Apple> filter(ApplePredicate predicate) {
        List<Apple> filteredList = new ArrayList<>();
        for (Apple apple : list) {
            if (predicate.test(apple)) {
                filteredList.add(apple);
            }
        }
        return filteredList;
    }

}

public class LambdaExpression {


    public static void main(String[] args) {

        AppleService service = new AppleService();
        List<Apple> redAppleList = service.filter((apple) -> apple.getColor().equals("Red"));
        List<Apple> readAppMoreThan100 = service.filter((apple) -> apple.getColor().equals("Red") && apple.getWeight() > 120);
        System.out.println(redAppleList);
        System.out.println(readAppMoreThan100);

        BiFunction<Integer, Integer, Double> res = (a, b) -> a / b.doubleValue();
        System.out.println(res.apply(10, 3));

        Predicate<Integer> isEven = (num) -> num % 2 == 0;
        System.out.println(isEven.test(10));

        Consumer<String> consumer = (message) ->{
            message = message.trim().toUpperCase();
            System.out.println(message);
        };
        consumer.accept("Hello");
    }
}
