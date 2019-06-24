package id.BentengBuahNaga.App.activity.model;

import com.google.gson.annotations.SerializedName;

import id.BentengBuahNaga.App.activity.contract.KeranjangFragmentContract;

public class KeranjangFragmentModel implements KeranjangFragmentContract.Model {

    @SerializedName("id_menu")
    private String idMenu;

    @SerializedName("nama_menu")
    private String namaMenu;

    @SerializedName("jumlah")
    private String jumlah;

    @SerializedName("harga")
    private String harga;

    @SerializedName("session")
    private String session;

    @SerializedName("kategori")
    private String kategori;

    @SerializedName("stok")
    private String stok;

    @SerializedName("deskripsi")
    private String deskripsi;

    @SerializedName("id_pesanan_temp")
    private String idPesananTemp;

    @SerializedName("id_pelanggan")
    private String idPelanggan;

    @SerializedName("waktu_order")
    private String waktuOrder;

    @SerializedName("gambar")
    private String gambar;

    public String getIdMenu() {
        return idMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public String getJumlah() {
        return jumlah;
    }

    public String getHarga() {
        return harga;
    }

    public String getSession() {
        return session;
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

    public String getIdPesananTemp() {
        return idPesananTemp;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getWaktuOrder() {
        return waktuOrder;
    }

    public String getGambar() {
        return gambar;
    }
}
