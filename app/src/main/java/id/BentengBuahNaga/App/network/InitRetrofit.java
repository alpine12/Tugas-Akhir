package id.BentengBuahNaga.App.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class InitRetrofit {

    private static final String URL = "http://192.168.4.102/";
    private static final String BASE_URL =URL+ "simcafe/api/";
    private static final String IMAGEURL = URL+"simcafe/assets/img/foto_menu/";

    private static Retrofit Instance() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }

    public static ApiIterface getInstance() {
        return Instance().create(ApiIterface.class);
    }

    public static String getIMAGEURL() {
        return IMAGEURL;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }
}
