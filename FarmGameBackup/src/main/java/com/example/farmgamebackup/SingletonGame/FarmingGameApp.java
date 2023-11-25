package com.example.farmgamebackup.SingletonGame;

//Adding this based on the automation requested from assignment.
public class FarmingGameApp {

    private static GameManager gameManager = GameManager.getInstance();

    public static void main(String[] args) {
        runSimulationFor20Days();
    }

    private static void runSimulationFor20Days() {
        System.out.println("Starting the Farming Simulation for 20 Days");
        for (int i = 0; i < 20; i++) {
            gameManager.startDay();
        }
        System.out.println("\n\nSimulation completed. Total currency: " + gameManager.getCurrency());
    }
}
