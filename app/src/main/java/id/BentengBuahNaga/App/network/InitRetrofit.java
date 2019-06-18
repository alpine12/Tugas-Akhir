package id.BentengBuahNaga.App.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitRetrofit {

    public static final String BASE_URL = "http://192.168.6.199/simcafe/api/";

    private static Retrofit Instance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static ApiIterface getInstance(){
        return Instance().create(ApiIterface.class);
    }

}
