package id.BentengBuahNaga.App.activity.ResponseModel;

import com.google.gson.annotations.SerializedName;


public class ResponseRegister {

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;


    public String getMessage() {
        return message;
    }


    public Boolean isStatus() {
        return status;
    }
}