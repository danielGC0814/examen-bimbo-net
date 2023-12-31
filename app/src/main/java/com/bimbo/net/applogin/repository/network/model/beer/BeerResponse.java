package com.bimbo.net.applogin.repository.network.model.beer;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BeerResponse {
    private Long id;
    private String name;
    private String tagline;

    @SerializedName("first_brewed")
    private String firstBrewed;
    private String description;

    @SerializedName("image_url")
    private String imageUrl;
    private Double abv;
    private Double ibu;

    @SerializedName("target_fg")
    private Double targetFg;

    @SerializedName("target_og")
    private Double targetOg;
    private Double ebc;
    private Double srm;
    private Double ph;

    @SerializedName("attenuation_level")
    private Double attenuationLevel;

    private VolumeResponse volume;

    @SerializedName("boil_volume")
    private VolumeResponse boilVolume;

    private MethodResponse method;

    private IngredientsResponse ingredients;

    @SerializedName("food_pairing")
    private List<String> foodPairing;

    @SerializedName("brewers_tips")
    private String brewersTips;

    @SerializedName("contributed_by")
    private String contributedBy;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getFirstBrewed() {
        return firstBrewed;
    }

    public void setFirstBrewed(String firstBrewed) {
        this.firstBrewed = firstBrewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
    }

    public Double getIbu() {
        return ibu;
    }

    public void setIbu(Double ibu) {
        this.ibu = ibu;
    }

    public Double getTargetFg() {
        return targetFg;
    }

    public void setTargetFg(Double targetFg) {
        this.targetFg = targetFg;
    }

    public Double getTargetOg() {
        return targetOg;
    }

    public void setTargetOg(Double targetOg) {
        this.targetOg = targetOg;
    }

    public Double getEbc() {
        return ebc;
    }

    public void setEbc(Double ebc) {
        this.ebc = ebc;
    }

    public Double getSrm() {
        return srm;
    }

    public void setSrm(Double srm) {
        this.srm = srm;
    }

    public Double getPh() {
        return ph;
    }

    public void setPh(Double ph) {
        this.ph = ph;
    }

    public Double getAttenuationLevel() {
        return attenuationLevel;
    }

    public void setAttenuationLevel(Double attenuationLevel) {
        this.attenuationLevel = attenuationLevel;
    }

    public VolumeResponse getVolume() {
        return volume;
    }

    public void setVolume(VolumeResponse volume) {
        this.volume = volume;
    }

    public VolumeResponse getBoilVolume() {
        return boilVolume;
    }

    public void setBoilVolume(VolumeResponse boilVolume) {
        this.boilVolume = boilVolume;
    }

    public MethodResponse getMethod() {
        return method;
    }

    public void setMethod(MethodResponse method) {
        this.method = method;
    }

    public IngredientsResponse getIngredients() {
        return ingredients;
    }

    public void setIngredients(IngredientsResponse ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getFoodPairing() {
        return foodPairing;
    }

    public void setFoodPairing(List<String> foodPairing) {
        this.foodPairing = foodPairing;
    }

    public String getBrewersTips() {
        return brewersTips;
    }

    public void setBrewersTips(String brewersTips) {
        this.brewersTips = brewersTips;
    }

    public String getContributedBy() {
        return contributedBy;
    }

    public void setContributedBy(String contributedBy) {
        this.contributedBy = contributedBy;
    }
}
