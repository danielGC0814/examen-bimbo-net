package com.bimbo.net.applogin.repository.network.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("success")
    private Boolean success;

    @SerializedName("message")
    private String message;

    @SerializedName("result")
    private ResultDataUser result;

    @SerializedName("token")
    private String token;

    @SerializedName("status")
    private Integer status;

    @SerializedName("errors")
    private Object[] errors;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultDataUser getResult() {
        return result;
    }

    public void setResult(ResultDataUser result) {
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
