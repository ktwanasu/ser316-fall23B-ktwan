package com.example.farmgamebackup.FactoryGame;

//Entry point of the application. This is staged in automation to loop 20 times for this assignment.
public class FarmingGameApp {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();

        for (int i = 0; i < 20; i++) {//simulate for 20 days
            gameManager.startDay();
        }

        System.out.println("\nSimulation completed. Total currency: " + gameManager.getCurrency());
    }
}
