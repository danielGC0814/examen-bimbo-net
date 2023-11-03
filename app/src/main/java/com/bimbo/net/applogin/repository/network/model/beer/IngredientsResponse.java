package com.bimbo.net.applogin.repository.network.model.beer;

import java.util.List;

public class IngredientsResponse {
    private List<IngredientResponse> malt;
    private List<IngredientResponse> hops;

    private String yeast;

    public List<IngredientResponse> getMalt() {
        return malt;
    }

    public void setMalt(List<IngredientResponse> malt) {
        this.malt = malt;
    }

    public List<IngredientResponse> getHops() {
        return hops;
    }

    public void setHops(List<IngredientResponse> hops) {
        this.hops = hops;
    }

    public String getYeast() {
        return yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }
}
