package id.BentengBuahNaga.App.network;

import java.util.Map;

import id.BentengBuahNaga.App.activity.ResponseModel.ResponseLogin;
import id.BentengBuahNaga.App.activity.ResponseModel.ResponseRegister;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiIterface {

    /*
     * Authentikasi
     */
    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin> login(@Field("username") String username,
                              @Field("token") String token);

    @FormUrlEncoded
    @POST("register")
    Call<ResponseRegister> Register(@FieldMap Map<String, String> data);
}
