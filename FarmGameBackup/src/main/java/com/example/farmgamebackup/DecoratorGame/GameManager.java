package com.example.farmgamebackup.DecoratorGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager {
    private int currency;
    private List<FarmComponent> farms;
    private int currentCycle;
    private Random random = new Random();

    public GameManager() {
        farms = new ArrayList<>();
        currency = 10000; // Starting currency
        currentCycle = 0;
    }

    public void addFarm(FarmComponent farm) {
        farms.add(farm);
    }

    public void startDay() {
        currentCycle++;
        System.out.println("\nAdvancing to day " + currentCycle + "!");

        // Add a random farm and perform actions for each farm
        addRandomFarm();
        int incomeForTheDay = 0;
        for (FarmComponent farm : farms) {
            farm.performDayActions();
            incomeForTheDay += farm.getIncome();
        }
        currency += incomeForTheDay;

        // Print the day's summary
        System.out.println(String.format("You made %d in day %d!", incomeForTheDay, currentCycle));
        System.out.println(String.format("You now have %d with your farm.", currency));
    }

    private void addRandomFarm() {
        FarmType[] types = FarmType.values();
        FarmType selectedType = types[random.nextInt(types.length)];
        FarmComponent farm = new BasicFarm(selectedType, 100);
        farms.add(farm);
        System.out.println("Added a " + selectedType + " farm.");
    }


}
