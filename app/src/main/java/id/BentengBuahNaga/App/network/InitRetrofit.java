package id.BentengBuahNaga.App.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class InitRetrofit {

   // private static final String URL = "http://192.168.43.238/";
//     private static final String URL = "http://192.168.6.199/";
   //private static final String URL = "http://192.168.0.106/";

//    private static final String BASE_URL =URL+ "simcafe/api_client/";
//    private static final String IMAGEURL = URL+"simcafe/assets/img/foto_menu/";
//    private static final String IMAGEURL_BANNER = URL+"simcafe/assets/img/banner_web/";

    private static final String BASE_URL ="https://api.hometech.web.id/api_client/";
    private static final String ASSETS = "https://manajemen.hometech.web.id/assets/img/";
    private static final String IMAGEURL = ASSETS+"foto_menu/";
    private static final String IMAGEURL_BANNER = ASSETS+"banner_web/";

    private static Retrofit Instance() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        Gson gson = gsonBuilder.create();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logging).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
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

    public static String getImageurlBanner() {
        return IMAGEURL_BANNER;
    }
}
