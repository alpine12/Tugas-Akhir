package id.BentengBuahNaga.App.network;

import java.util.HashMap;
import java.util.Map;

import id.BentengBuahNaga.App.activity.ResponseModel.ResponseDeffault;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiIterface {

    /*
     * Authentikasi
     */
    @FormUrlEncoded
    @POST("login")
    Call<ResponseDeffault> login(@Field("username") String username,
                                 @Field("token") String token);

    /*
     *Regristasi
     */
    @FormUrlEncoded
    @POST("register")
    Call<ResponseDeffault> Register(@FieldMap Map<String, String> data);

    /*
     * Load Daftar Menu
     */
    @GET("daftar_menu/{id}")
    Call<ResponseDeffault> daftarMenu(@Path("id") String id);

    /*
     * Detail Menu
     */
    @GET("detail_menu/{id}")
    Call<ResponseDeffault> deatailMenu(@Path("id") String id);

    /*
     *insert keranjang
     */

    @FormUrlEncoded
    @POST("keranjang")
    Call<ResponseDeffault> tambahKeranjang(@FieldMap HashMap<String, String> data);

    @GET("keranjang/{id}")
    Call<ResponseDeffault> getKeranjang(@Path("id") String IdPelanggan);

    /*
     *CheckOut Keranjang
     */
    @FormUrlEncoded
    @POST("transaksi")
    Call<ResponseDeffault> checkout(@FieldMap HashMap<String, String> data);

    /*
     *Delete Keranjang
     */
    @DELETE("keranjang/{id}")
    Call<ResponseDeffault> deleteListKeranjang(@Path("id") String id);

    /*
     *Get Daftar Pesanan
     */
    @GET("transaksi/{id}")
    Call<ResponseDeffault> getDaftarPesanan(@Path("id") String id);

    /*
     *Detail Pesanan
     */
    @GET("detail_transaksi/{id}")
    Call<ResponseDeffault> detailPesanan9(@Path("id") String idPesanan);
}
