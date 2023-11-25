package com.example.farmgamebackup.SingletonGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Singleton class to manage the game
public class GameManager {//All static instances of GameManager
    private static GameManager instance;
    private int currency;
    private List<Farm> farms;
    private int currentCycle;
    private Random random = new Random();


    // Private constructor to prevent instantiation from outside the class
    private GameManager() {
        farms = new ArrayList<>();
        currency = 1000; // Starting currency
        currentCycle = 0;
    }

    // Public static method to get the instance of GameManager.
    public static synchronized GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void addFarm(FarmType type) {
        farms.add(new Farm(type));
    }

    /*Not used when it's automated
    public void advanceCycle() {
        currentCycle++;
        currency += 100; // Increment currency by 100 each cycle, assuming you get 100 everyday
        System.out.println("Advancing to cycle: " + currentCycle);
        System.out.println("Currency increased to: " + currency);
        // Additional logic can be implemented here
    }*/

    // Getter for currency
    public int getCurrency() {
        return currency;
    }

    // Setter for currency
    public void setCurrency(int currency) {
        this.currency = currency;
    }

    // Getter for farms list
    public List<Farm> getFarms() {
        return new ArrayList<>(farms); // Return a copy to maintain encapsulation
    }

    // Method to add a farm to the list
    public void addFarm(Farm farm) {
        farms.add(farm);
    }

    // Method to remove a farm from the list
    public boolean removeFarm(Farm farm) {
        return farms.remove(farm);
    }

//Automated prompt
    public void startDay() {
        currentCycle++;
        addRandomAnimalFarm();

        // Currency increment logic
        int income = 100 + random.nextInt(401); // 401 is the range (500 - 100 + 1)
        currency += income;

        // Display the income message
        Farm lastAddedFarm = farms.get(farms.size() - 1);

        System.out.println(String.format("You made %d in day %d!", income, currentCycle));
        System.out.println(String.format("You now have %d with your farm.", currency));
    }

    // Adds a farm with a randomly selected animal type
    private void addRandomAnimalFarm() {

        AnimalType[] animalTypes = AnimalType.values();
        AnimalType selectedType = animalTypes[random.nextInt(animalTypes.length)];
        Farm newFarm = new Farm(FarmType.ANIMAL_FARM);
        farms.add(newFarm);
        System.out.println("\nAdvancing to day " + currentCycle + "!");
        System.out.println("Added a " + selectedType + " farm.");
    }

   /* private void deductAnimalMaintenanceCosts() {
        for (Farm farm : farms) {
            int maintenanceCost = farm.calculateMaintenanceCost();
            currency -= maintenanceCost; // Deduct maintenance cost for each farm
            System.out.println("Deducted " + maintenanceCost + " for animal maintenance.");
        }
    }*/
}




