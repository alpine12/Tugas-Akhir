package id.BentengBuahNaga.App.activity.model;

import com.google.gson.annotations.SerializedName;

import id.BentengBuahNaga.App.activity.contract.DaftarMenuContract;

public class DaftarMenuModel implements DaftarMenuContract.Model {
    @SerializedName("id_menu")
    private String idMenu;

    @SerializedName("nama_menu")
    private String namaMenu;

    @SerializedName("harga")
    private String harga;

    @SerializedName("kategori")
    private String kategori;

    @SerializedName("stok")
    private String stok;

    @SerializedName("deskripsi")
    private String deskripsi;

    @SerializedName("gambar")
    private String gambar;

    public String getIdMenu() {
        return idMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public String getHarga() {
        return harga;
    }

    public String getKategori() {
        return kategori;
    }

    public String getStok() {
        return stok;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getGambar() {
        return gambar;
    }
}
