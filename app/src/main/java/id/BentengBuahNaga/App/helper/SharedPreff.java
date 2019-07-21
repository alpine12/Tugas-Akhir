package id.BentengBuahNaga.App.helper;

public class SharedPreff {

    private static SharedPreff mInstance = null;

    private static String idPelanggan = "idPelanggan";

    private static String namaPengguna = "namaPengguna";

    private static String namaLengkap = "namaLengkap";

    private static String noHp = "noHp";

    private static String tanggalLahir = "tanggalLahir";

    private static String pekerjaan = "pekerjaan";

    private static String alamat = "alamat";

    private static String meja = "meja";

    private static String isLogin = "login";

    public static String getPekerjaan() {
        return pekerjaan;
    }

    public static String getIsLogin() {
        return isLogin;
    }

    public static String getMeja() {
        return meja;
    }

    public static String getIdPelanggan() {
        return idPelanggan;
    }

    public static String getNamaPengguna() {
        return namaPengguna;
    }

    public static String getNamaLengkap() {
        return namaLengkap;
    }

    public static String getNoHp() {
        return noHp;
    }

    public static String getTanggalLahir() {
        return tanggalLahir;
    }

    public static String getAlamat() {
        return alamat;
    }


}
