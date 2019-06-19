package id.BentengBuahNaga.App.network;

import java.util.Map;

import id.BentengBuahNaga.App.activity.ResponseModel.ResponseDaftarMenu;
import id.BentengBuahNaga.App.activity.ResponseModel.ResponseLogin;
import id.BentengBuahNaga.App.activity.ResponseModel.ResponseRegister;
import retrofit2.Call;
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
    Call<ResponseLogin> login(@Field("username") String username,
                              @Field("token") String token);

    /*
     *Regristasi
     */
    @FormUrlEncoded
    @POST("register")
    Call<ResponseRegister> Register(@FieldMap Map<String, String> data);

    /*
     * Load Daftar Menu
     */
    @GET("daftar_menu/{id}")
    Call<ResponseDaftarMenu> daftarMenu(@Path("id") String id);

    /*
     * Detail Menu
     */
    @GET("detail_menu/{id}")
    Call<ResponseDaftarMenu> deatailMenu(@Path("id") String id);
}
