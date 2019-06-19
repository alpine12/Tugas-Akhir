package id.BentengBuahNaga.App.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitRetrofit {

    private static final String BASE_URL = "http://192.168.4.102/simcafe/api/";
    private static final String IMAGEURL = "http://192.168.4.102/simcafe/assets/img/foto_menu/";

    private static Retrofit Instance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static ApiIterface getInstance() {
        return Instance().create(ApiIterface.class);
    }

    public static String getIMAGEURL() {
        return IMAGEURL;
    }

}
