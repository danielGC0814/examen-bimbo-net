package com.bimbo.net.applogin.repository.local.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.bimbo.net.applogin.repository.network.model.beer.VolumeResponse;

import io.reactivex.annotations.NonNull;

@Entity
public class BeerDetail {

    @PrimaryKey
    @NonNull
    private Long id;
    private String name;
    private String description;
    private String imageUrl;

    private Double content;
    private String unit;
    private String brewersTips;
    private String contributedBy;

    public BeerDetail(@NonNull Long id, String name, String description, String imageUrl, Double content, String unit, String brewersTips, String contributedBy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.content = content;
        this.unit = unit;
        this.brewersTips = brewersTips;
        this.contributedBy = contributedBy;
    }

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

    public Double getContent() {
        return content;
    }

    public void setContent(Double content) {
        this.content = content;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
