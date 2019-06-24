package id.BentengBuahNaga.App.activity.model;

import com.google.gson.annotations.SerializedName;

import id.BentengBuahNaga.App.activity.contract.DetailDaftarPesananContract;

public class DetailDaftarPesananModel implements DetailDaftarPesananContract.Model {
    @SerializedName("id_menu")
    private String idMenu;

    @SerializedName("nama_menu")
    private String namaMenu;

    @SerializedName("id_pesanan")
    private String idPesanan;

    @SerializedName("jumlah")
    private String jumlah;

    @SerializedName("harga")
    private String harga;

    @SerializedName("id_pesanan_detail")
    private String idPesananDetail;

    @SerializedName("selesai_masak")
    private String selesaiMasak;

    @SerializedName("gambar")
    private String gambar;

    public String getIdMenu(){
        return idMenu;
    }

    public String getNamaMenu(){
        return namaMenu;
    }

    public String getIdPesanan(){
        return idPesanan;
    }

    public String getJumlah(){
        return jumlah;
    }

    public String getHarga(){
        return harga;
    }

    public String getIdPesananDetail(){
        return idPesananDetail;
    }

    public String getSelesaiMasak(){
        return selesaiMasak;
    }

    public String getGambar(){
        return gambar;
    }
}
