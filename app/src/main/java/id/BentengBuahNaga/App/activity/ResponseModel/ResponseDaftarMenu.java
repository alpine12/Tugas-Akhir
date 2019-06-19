package id.BentengBuahNaga.App.activity.ResponseModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.BentengBuahNaga.App.activity.model.DaftarMenuModel;


public class ResponseDaftarMenu {

    @SerializedName("daftarmenu")
    private List<DaftarMenuModel> daftarmenu;

    @SerializedName("menu")
    private DaftarMenuModel menu;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public DaftarMenuModel getMenu() {
        return menu;
    }

    public List<DaftarMenuModel> getDaftarmenu() {
        return daftarmenu;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }
}