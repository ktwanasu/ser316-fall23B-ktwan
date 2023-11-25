package com.example.farmgamebackup.FactoryGame;

public class Farm {
    private FarmType type;
    private int capacity;
    private int currency;
    private String affinity; // New field for affinity
    private int animalCount; // Field to track the number of animals

    public Farm(FarmType type) {
        this.type = type;
        this.capacity = 10; // Default capacity
        this.currency = 0;  // Initial currency
        this.animalCount = 0; // Initial number of animals
    }

    public FarmType getType() {
        return type;
    }

    public void setType(FarmType type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public String getAffinity() {
        return affinity;
    }

    public void setAffinity(String affinity) {
        this.affinity = affinity;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public void setAnimalCount(int animalCount) {
        this.animalCount = animalCount;
    }

    public int calculateIncome() {
        int baseIncome = 100;
        if ("animal".equals(affinity)) {
            return baseIncome + 20; // Animal affinity bonus
        } else if ("crop".equals(affinity)) {
            return baseIncome + 10; // Crop affinity bonus
        }
        return baseIncome;
    }

    public void checkForUpgrade() {
        if (currency >= 1200) {
            setCapacity(capacity + 5); // Increase capacity
            setCurrency(currency - 1000); // Deduct upgrade cost
            System.out.println("Farm upgraded to capacity " + capacity);
        }
    }

    public void handleAnimalLifeCycle(int currentCycle) {
        if (type == FarmType.ANIMAL_FARM) {
            if (currentCycle % 4 == 0) {
                animalCount += (int) (Math.random() * 3); // New animals born
            }
            if (currentCycle % 14 == 0) {
                animalCount -= (int) (Math.random() * 3); // Some animals pass away
            }
        }
    }
}
