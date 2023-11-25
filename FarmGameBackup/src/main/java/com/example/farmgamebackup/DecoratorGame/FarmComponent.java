package com.example.farmgamebackup.DecoratorGame;

public interface FarmComponent {
    void performDayActions();
    int getIncome();

    String getDescription();
    // Other farm-related methods
}
