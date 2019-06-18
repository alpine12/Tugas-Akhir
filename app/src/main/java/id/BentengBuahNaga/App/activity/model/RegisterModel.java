package id.BentengBuahNaga.App.activity.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import id.BentengBuahNaga.App.activity.contract.RegisterContract;

public class RegisterModel implements RegisterContract.Model {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("nama_pengguna")
    @Expose
    private String namaPengguna;
    @SerializedName("nama_lengkap")
    @Expose
    private String namaLengkap;
    @SerializedName("tanggal_lahir")
    @Expose
    private String tanggalLahir;
    @SerializedName("no_hp")
    @Expose
    private String noHp;
    @SerializedName("pekerjaan")
    @Expose
    private String pekerjaan;
    @SerializedName("alamat")
    @Expose
    private String alamat;

    public RegisterModel(String token, String namaPengguna, String namaLengkap, String tanggalLahir, String noHp, String pekerjaan, String alamat) {
        this.token = token;
        this.namaPengguna = namaPengguna;
        this.namaLengkap = namaLengkap;
        this.tanggalLahir = tanggalLahir;
        this.noHp = noHp;
        this.pekerjaan = pekerjaan;
        this.alamat = alamat;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public String getNamaPengguna() {
        return namaPengguna;
    }

    @Override
    public String getNamaLengkap() {
        return namaLengkap;
    }

    @Override
    public String getTanggalLahir() {
        return tanggalLahir;
    }

    @Override
    public String getNoHp() {
        return noHp;
    }

    @Override
    public String getPekerjaan() {
        return pekerjaan;
    }

    @Override
    public String getAlamat() {
        return alamat;
    }




}
