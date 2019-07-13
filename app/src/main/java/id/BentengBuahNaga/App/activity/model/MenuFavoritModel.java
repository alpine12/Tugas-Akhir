package id.BentengBuahNaga.App.activity.model;

import com.google.gson.annotations.SerializedName;

public class MenuFavoritModel {
    @SerializedName("id_menu")
    private String idMenu;

    @SerializedName("nama_menu")
    private String namaMenu;

    @SerializedName("harga")
    private String harga;

    @SerializedName("banyak_dipesan")
    private String banyakDipesan;

    @SerializedName("kategori")
    private String kategori;

    @SerializedName("stok")
    private String stok;

    @SerializedName("deskripsi")
    private String deskripsi;

    @SerializedName("gambar")
    private String gambar;

    public String getIdMenu(){
        return idMenu;
    }

    public String getNamaMenu(){
        return namaMenu;
    }

    public String getHarga(){
        return harga;
    }

    public String getBanyakDipesan(){
        return banyakDipesan;
    }

    public String getKategori(){
        return kategori;
    }

    public String getStok(){
        return stok;
    }

    public String getDeskripsi(){
        return deskripsi;
    }

    public String getGambar(){
        return gambar;
    }

}
