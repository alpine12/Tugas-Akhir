package id.BentengBuahNaga.App.activity.model;

import com.google.gson.annotations.SerializedName;

public class BerandaFragmentModel {

    @SerializedName("judul_banner")
    private String judulBanner;

    @SerializedName("banner_url")
    private String bannerUrl;

    @SerializedName("kategori")
    private String kategori;

    @SerializedName("deskripsi")
    private String deskripsi;

    @SerializedName("id_banner")
    private String idBanner;

    @SerializedName("gambar")
    private String gambar;

    @SerializedName("id_promo")
    private String idPromo;

    @SerializedName("sampai")
    private Object sampai;

    @SerializedName("status")
    private String status;

    public String getJudulBanner(){
        return judulBanner;
    }

    public String getBannerUrl(){
        return bannerUrl;
    }

    public String getKategori(){
        return kategori;
    }

    public String getDeskripsi(){
        return deskripsi;
    }

    public String getIdBanner(){
        return idBanner;
    }

    public String getGambar(){
        return gambar;
    }

    public String getIdPromo(){
        return idPromo;
    }

    public Object getSampai(){
        return sampai;
    }

    public String getStatus(){
        return status;
    }
}
