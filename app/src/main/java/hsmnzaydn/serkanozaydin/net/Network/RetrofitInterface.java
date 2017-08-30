package hsmnzaydn.serkanozaydin.net.Network;

/**
 * Created by hsmnzaydn on 28.08.2017.
 */

import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Komut;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.onlineKomutlar;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @GET("/baglanti/json.php")
    Call<onlineKomutlar[]> getJsonValues();

    @POST("/baglanti/veriGonder.php")
    Call<onlineKomutlar[]> post(@Body Komut komut);
}