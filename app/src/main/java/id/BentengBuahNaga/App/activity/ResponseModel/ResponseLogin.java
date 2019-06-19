package id.BentengBuahNaga.App.activity.ResponseModel;

import com.google.gson.annotations.SerializedName;

import id.BentengBuahNaga.App.activity.model.LoginModel;


public class ResponseLogin {

    @SerializedName("Pengguna")
    private LoginModel loginModel;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public LoginModel getPengguna() {
        return loginModel;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }
}