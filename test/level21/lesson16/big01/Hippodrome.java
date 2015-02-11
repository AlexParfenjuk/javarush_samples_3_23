package com.javarush.test.level21.lesson16.big01;



import java.util.ArrayList;

/**
 * Created by Roodie on 23.08.2014.
 */
public class Hippodrome {
    public static Hippodrome game;
    public ArrayList<Horse> horses = new ArrayList<>();
    public static void main(String[] args) {
        game = new Hippodrome();
        game.getHorses().add( new Horse( "Diamond", 3, 0 ) );
        game.getHorses().add( new Horse( "Dragon", 3, 0 ) );
        game.getHorses().add( new Horse( "Thunder", 3, 0 ) );
        game.run();
        game.printWinner();

    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run () {
        try {
            for (int i = 1; i <= 100; i++) {
                move();
                print();
                Thread.sleep(10);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void print() {
        for (Horse horse : horses)
            horse.print();
        System.out.println();
        System.out.println();
    }


    public void move () {
        for (Horse horse : horses)
            horse.move();
    }

    public Horse getWinner(){
        Horse winner;
        winner = null;
        for(Horse a : getHorses()){
            if(winner == null){
                winner = a;
            }
            else{
                if (winner.getDistance()< a.getDistance())
                    winner = a;
            }
        }

        return winner;
    }
    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() +"!");

    }


}
