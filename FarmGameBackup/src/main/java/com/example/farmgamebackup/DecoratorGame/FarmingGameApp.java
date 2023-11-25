package com.example.farmgamebackup.DecoratorGame;

public class FarmingGameApp {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();

        // Specify the type of farm along with the income
        FarmComponent basicFarm = new BasicFarm(FarmType.ANIMAL_FARM, 100); // Example type


        gameManager.addFarm(basicFarm);


        for (int i = 0; i < 20; i++) { // Looping 20 times for assignment
            gameManager.startDay();
        }
    }
}
