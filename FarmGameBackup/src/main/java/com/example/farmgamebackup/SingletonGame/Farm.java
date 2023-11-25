package com.example.farmgamebackup.SingletonGame;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    private FarmType type;

    private int capacity;
    private int currency;
    private static final int MAINTENANCE_COST_PER_ANIMAL = 100; // Example cost
    private int upgradeCost = 1000;//Not being used right now for this assignment

    public Farm(FarmType type) {
        this.type = type;

        this.capacity = 10; // Initial capacity
        this.currency = 0;  // Initial currency
    }

   /* public void addAnimal(Animal animal) {
        if (animals.size() < capacity) {
            animals.add(animal);
        }
    }*/

    public boolean canUpgrade() {//unused upgrade prommpt
        // Example condition for upgrade
        return currency >= upgradeCost * 1.2;
    }

    public void upgrade() {//unused upgrade
        capacity += 5; // Increase capacity
        currency -= upgradeCost; // Deduct the cost of upgrade
        System.out.println("Farm upgraded. New capacity: " + capacity);
    }

  /*  public int calculateMaintenanceCost() {
        return animals.size() * MAINTENANCE_COST_PER_ANIMAL;
    }*/




    public String getType() {
        return null;
    }
}




