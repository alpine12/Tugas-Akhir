package id.BentengBuahNaga.App.activity.model;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import id.BentengBuahNaga.App.activity.contract.LoginContract;

public class LoginModel implements LoginContract.Model {

    @SerializedName("no_hp")
    private String noHp;

    @SerializedName("pekerjaan")
    private String pekerjaan;

    @SerializedName("nama_pengguna")
    private String namaPengguna;

    @SerializedName("nama_lengkap")
    private String namaLengkap;

    @SerializedName("id_pelanggan")
    private String idPelanggan;

    @SerializedName("tanggal_lahir")
    private String tanggalLahir;

    @SerializedName("createAt")
    private String createAt;

    @SerializedName("token")
    private String token;

    @SerializedName("alamat")
    private String alamat;

    public String getNoHp() {
        return noHp;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getToken() {
        return token;
    }

    public String getAlamat() {
        return alamat;
    }
}
