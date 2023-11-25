package com.example.farmgamebackup.FactoryGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager {
    private int currency;
    private List<Farm> farms;
    private int currentCycle;
    private Random random = new Random();

    public GameManager() {
        farms = new ArrayList<>();
        currency = 1000; // Starting currency
        currentCycle = 0;
    }

    public void startDay() {
        currentCycle++;
        System.out.println("\n----- Day " + currentCycle + " -----");
        addRandomFarm();
        processFarmActivities();
        System.out.println("End of day " + currentCycle + ", Total currency: " + currency);
    }

    private void addRandomFarm() {
        FarmType[] types = FarmType.values();
        FarmType selectedType = types[random.nextInt(types.length)];
        Farm newFarm = FarmFactory.createFarm(selectedType);
        farms.add(newFarm);
        System.out.println("Added a " + selectedType + " farm with capacity " + newFarm.getCapacity());
    }

    private void processFarmActivities() {
        for (Farm farm : farms) {
            farm.handleAnimalLifeCycle(currentCycle);
            farm.checkForUpgrade();
            int farmIncome = farm.calculateIncome();
            currency += farmIncome;
            System.out.println("Farm of type " + farm.getType() + " generated " + farmIncome + " currency.");
            if (farm.getType() == FarmType.ANIMAL_FARM) {
                System.out.println("\nAnimal count in farm: " + farm.getAnimalCount());
            }
        }
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public List<Farm> getFarms() {
        return new ArrayList<>(farms);
    }

    public void setFarms(List<Farm> farms) {
        this.farms = new ArrayList<>(farms);
    }

    public int getCurrentCycle() {
        return currentCycle;
    }

    public void setCurrentCycle(int currentCycle) {
        this.currentCycle = currentCycle;
    }
}
