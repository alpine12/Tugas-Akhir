package id.BentengBuahNaga.App.activity.model;

import com.google.gson.annotations.SerializedName;

import id.BentengBuahNaga.App.activity.contract.DaftarPesananContract;

public class DaftarPesananModel implements DaftarPesananContract.Model {


    @SerializedName("kode_promo")
    private String kodePromo;

    @SerializedName("kode_transaksi")
    private String kodeTransaksi;

    @SerializedName("id_pesanan")
    private String idPesanan;

    @SerializedName("waktu_transaksi")
    private String waktuTransaksi;

    @SerializedName("status_bayar")
    private String statusBayar;

    @SerializedName("catatan")
    private String catatan;

    @SerializedName("kode_meja")
    private String kodeMeja;

    @SerializedName("total_pembayaran")
    private String totalPembayaran;

    @SerializedName("id_pelanggan")
    private String idPelanggan;

    @SerializedName("proses")
    private String proses;

    @SerializedName("id_pengguna")
    private String idPengguna;

    public String getKodePromo() {
        return kodePromo;
    }

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public String getIdPesanan() {
        return idPesanan;
    }

    public String getWaktuTransaksi() {
        return waktuTransaksi;
    }

    public String getStatusBayar() {
        return statusBayar;
    }

    public String getCatatan() {
        return catatan;
    }

    public String getKodeMeja() {
        return kodeMeja;
    }

    public String getTotalPembayaran() {
        return totalPembayaran;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getProses() {
        return proses;
    }

    public String getIdPengguna() {
        return idPengguna;
    }
}
