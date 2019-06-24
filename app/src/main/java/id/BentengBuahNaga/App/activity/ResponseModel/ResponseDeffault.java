package id.BentengBuahNaga.App.activity.ResponseModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.BentengBuahNaga.App.activity.model.DaftarMenuModel;
import id.BentengBuahNaga.App.activity.model.DaftarPesananModel;
import id.BentengBuahNaga.App.activity.model.KeranjangFragmentModel;
import id.BentengBuahNaga.App.activity.model.LoginModel;


public class ResponseDeffault {

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    @SerializedName("daftarKeranjang")
    private List<KeranjangFragmentModel> daftarKeranjang;

    @SerializedName("daftarmenu")
    private List<DaftarMenuModel> daftarmenu;

    @SerializedName("menu")
    private DaftarMenuModel menu;

    @SerializedName("Pengguna")
    private LoginModel Pengguna;

    @SerializedName("daftar_pesaan")
    private List<DaftarPesananModel> daftarPesaan;


    public List<DaftarPesananModel> getDaftarPesaan() {
        return daftarPesaan;
    }

    public List<KeranjangFragmentModel> getDaftarKeranjang() {
        return daftarKeranjang;
    }

    public List<DaftarMenuModel> getDaftarmenu() {
        return daftarmenu;
    }

    public DaftarMenuModel getMenu() {
        return menu;
    }

    public LoginModel getPengguna() {
        return Pengguna;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }
}