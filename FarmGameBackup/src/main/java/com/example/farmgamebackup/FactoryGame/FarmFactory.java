package com.example.farmgamebackup.FactoryGame;

// FarmFactory is responsible for creating different types of Farm instances.
public abstract class FarmFactory {
// Static method to create a farm based on the specified FarmType.
    public static Farm createFarm(FarmType type) {
        switch (type) {
            case ANIMAL_FARM:
                return new Farm(FarmType.ANIMAL_FARM);
            case CROP_FARM:
                return new Farm(FarmType.CROP_FARM);
            case HYBRID_FARM:
                return new Farm(FarmType.HYBRID_FARM);
            default:
                throw new IllegalArgumentException("Unknown farm type: " + type);
        }
    }
}
