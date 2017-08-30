package hsmnzaydn.serkanozaydin.net.Network;

/**
 * Created by hsmnzaydn on 28.08.2017.
 */

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

public class RetrofitClient {
    public static final String BASE_URL = "http://serkanozaydin.net";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}