package com.example.farmgamebackup.DecoratorGame;

import java.util.Random;

public class BasicFarm implements FarmComponent {
    private FarmType type;
    private Random random = new Random();

    public BasicFarm(FarmType type, int i) {
        this.type = type;
    }

    @Override
    public void performDayActions() {
        // Basic farm day actions
    }

    @Override
    public int getIncome() {
        // Random income between 100 and 200
        return 100 + random.nextInt(101); // 101 is the range (200 - 100 + 1)
    }

    @Override
    public String getDescription() {
        return "Basic Farm";
    }
}
