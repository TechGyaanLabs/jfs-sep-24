package com.careerit.cj.day18;
abstract class Game{
        public void start(){
            System.out.println("The game "+this.getClass().getSimpleName()+" is started");
        }
        abstract void play();
        public void stop(){
            System.out.println("The game "+this.getClass().getSimpleName()+" is stopped");
        }
}
class Car extends  Game{
        public void play(){
            System.out.println("You are playing game \""+this.getClass().getSimpleName()+"\", please wear seat belt....");
        }
        public void fly(){
            System.out.println("Car can fly when speed reached more 500KMPH....");
        }
}
class Bike extends Game{
    public void play(){
        System.out.println("You are playing game \""+this.getClass().getSimpleName()+"\", please wear helmet ...");
    }
}
class Ship extends  Game{
    public void play(){
        System.out.println("You are playing game \""+this.getClass().getSimpleName()+"\", please wear water jacket....");
    }
}

enum GameType{
    CAR,BIKE,SHIP;
}

public class TypeCastingWithReferenceTypes {

    public static void main(String[] args) {

        Game game = getGame(GameType.CAR);
        game.start();
        game.play();
        if(game instanceof Car car){
            car.fly();
        }
        game.stop();

    }

    public static Game getGame(GameType gameType){
        return switch (gameType){
            case CAR -> new Car();
            case BIKE -> new Bike();
            case SHIP -> new Ship();
            default -> throw new IllegalArgumentException("Unknown game type");
        };
    }

}
