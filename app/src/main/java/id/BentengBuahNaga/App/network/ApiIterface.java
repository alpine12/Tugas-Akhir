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
import retrofit2.http.Query;

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
     *Delete Menu Keranjang
     */
    @DELETE("keranjang/{param}/{id}")
    Call<ResponseDeffault> hapusMenuKeranjang(@Path("param") String param,
                                              @Path("id") String id);

    /*
     *CheckOut Keranjang
     */
    @FormUrlEncoded
    @POST("transaksi")
    Call<ResponseDeffault> checkout(@FieldMap HashMap<String, String> data);

    /*
     *Delete Keranjang
     */
    @DELETE("keranjang/{param}/{id}")
    Call<ResponseDeffault> deleteListKeranjang(@Path("param") String param,
                                               @Path("id") String id);

    /*
     * Promo
     */
    @GET("promo")
    Call<ResponseDeffault> promo(@Query("kode") String kodePromo);

    /*
     *Get Daftar Pesanan
     */
    @GET("transaksi")
    Call<ResponseDeffault> getDaftarPesanan(@Query("param") String param,
                                            @Query("id_pelanggan") String idPelanggan);

    /*
     *Detail Pesanan
     */
    @GET("detail_transaksi/{id}")
    Call<ResponseDeffault> detailPesanan9(@Path("id") String idPesanan);
}
