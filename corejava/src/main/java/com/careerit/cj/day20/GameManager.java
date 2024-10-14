package com.careerit.cj.day20;

interface  Game{
    void play();
}

class Bike implements Game{

    @Override
    public void play() {
        System.out.println("You are playing bike game");
    }
}

class Car implements Game{
    @Override
    public void play() {
        System.out.println("You are playing car game");
    }
}

class Plane implements Game{
    @Override
    public void play() {
        System.out.println("You are playing plane game");
    }
}

enum GameType{
    BIKE,CAR,PLANE
}

public class GameManager {
    public static void main(String[] args) {

            Game game = getSelectedGame(GameType.BIKE);
            game.play();
    }

    private static Game getSelectedGame(GameType gameType) {
        return switch (gameType) {
            case BIKE -> new Bike();
            case CAR -> new Car();
            case PLANE -> new Plane();
            default -> throw new IllegalArgumentException("Unexpected value: " + gameType);
        };
    }
}
