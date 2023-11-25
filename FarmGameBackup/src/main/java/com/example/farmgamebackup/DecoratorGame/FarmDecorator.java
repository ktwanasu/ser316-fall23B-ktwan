package com.example.farmgamebackup.DecoratorGame;

public abstract class FarmDecorator implements FarmComponent {
    protected FarmComponent decoratedFarm;

    public FarmDecorator(FarmComponent farm) {
        this.decoratedFarm = farm;
    }

    @Override
    public void performDayActions() {
        decoratedFarm.performDayActions();
    }

    @Override
    public int getIncome() {
        return decoratedFarm.getIncome();
    }

    @Override
    public String getDescription() {
        return decoratedFarm.getDescription();
    }
}
