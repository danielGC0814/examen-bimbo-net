package com.bimbo.net.applogin.repository.network.model.beer;

public class IngredientResponse {
    private String name;
    private VolumeResponse amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VolumeResponse getAmount() {
        return amount;
    }

    public void setAmount(VolumeResponse amount) {
        this.amount = amount;
    }
}
