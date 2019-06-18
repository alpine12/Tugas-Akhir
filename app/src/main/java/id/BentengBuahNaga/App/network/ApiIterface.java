package id.BentengBuahNaga.App.network;

import java.util.Map;

import id.BentengBuahNaga.App.activity.ResponseModel.ResponseRegister;
import id.BentengBuahNaga.App.activity.model.RegisterModel;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiIterface {

    @FormUrlEncoded
    @POST("register")
    Call<ResponseRegister> Register(@FieldMap Map<String, String> data);
}
