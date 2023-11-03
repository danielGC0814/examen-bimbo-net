package com.bimbo.net.applogin.repository.network.model.beer;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MethodResponse {

    @SerializedName("mash_temp")
    private List<MashTempResponse> mashTemp;

    private FermentationResponse fermentation;

    private Object twist;

    public List<MashTempResponse> getMashTemp() {
        return mashTemp;
    }

    public void setMashTemp(List<MashTempResponse> mashTemp) {
        this.mashTemp = mashTemp;
    }

    public FermentationResponse getFermentation() {
        return fermentation;
    }

    public void setFermentation(FermentationResponse fermentation) {
        this.fermentation = fermentation;
    }

    public Object getTwist() {
        return twist;
    }

    public void setTwist(Object twist) {
        this.twist = twist;
    }
}
