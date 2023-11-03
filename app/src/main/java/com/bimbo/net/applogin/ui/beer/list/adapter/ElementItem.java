package com.bimbo.net.applogin.ui.beer.list.adapter;

public class ElementItem {
    String srcImage;
    String nameElement;
    String descriptionElement;

    public ElementItem(String srcImage, String nameElement, String descriptionElement) {
        this.srcImage = srcImage;
        this.nameElement = nameElement;
        this.descriptionElement = descriptionElement;
    }

    public String getSrcImage() {
        return srcImage;
    }

    public void setSrcImage(String srcImage) {
        this.srcImage = srcImage;
    }

    public String getNameElement() {
        return nameElement;
    }

    public void setNameElement(String nameElement) {
        this.nameElement = nameElement;
    }

    public String getDescriptionElement() {
        return descriptionElement;
    }

    public void setDescriptionElement(String descriptionElement) {
        this.descriptionElement = descriptionElement;
    }
}
