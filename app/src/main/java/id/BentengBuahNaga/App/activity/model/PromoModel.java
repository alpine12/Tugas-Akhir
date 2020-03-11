package id.BentengBuahNaga.App.activity.model;

import com.google.gson.annotations.SerializedName;


public class PromoModel {

    @SerializedName("kode_promo")
    private String kodePromo;

    @SerializedName("nama_promo")
    private String namaPromo;

    @SerializedName("tanggal_mulai")
    private String tanggalMulai;

    @SerializedName("tanggal_berakhir")
    private String tanggalBerakhir;

    @SerializedName("potongan")
    private String potongan;

    @SerializedName("id_promo")
    private String idPromo;

    @SerializedName("status")
    private String status;

    public String getKodePromo() {
        return kodePromo;
    }

    public String getNamaPromo() {
        return namaPromo;
    }

    public String getTanggalMulai() {
        return tanggalMulai;
    }

    public String getTanggalBerakhir() {
        return tanggalBerakhir;
    }

    public String getPotongan() {
        return potongan;
    }

    public String getIdPromo() {
        return idPromo;
    }

    public String getStatus() {
        return status;
    }
}