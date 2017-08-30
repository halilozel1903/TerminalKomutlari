package hsmnzaydn.serkanozaydin.net.Network;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Komut;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.onlineKomutlar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hsmnzaydn on 28.08.2017.
 */

public class Network {
    private Activity activity;
    private List<onlineKomutlar> listOfKomut;

    public Network(Activity activity){
        this.activity=activity;
    }


    public void getJsonDatas(final NetworkHandler networkHandler){
        RetrofitInterface retroInterface = RetrofitClient.getClient().create(RetrofitInterface.class);
        Call<onlineKomutlar[]> call = retroInterface.getJsonValues();
        call.enqueue(new Callback<onlineKomutlar[]>() {
            @Override
            public void onResponse(Call<onlineKomutlar[]> call, Response<onlineKomutlar[]> response) {
                listOfKomut= new ArrayList<>();

                for(onlineKomutlar onlineKomutlar:Arrays.asList(response.body())){
                        if(onlineKomutlar.kabul.equals("1")){
                            listOfKomut.add(onlineKomutlar);
                        }
                }

                networkHandler.getCommandList(listOfKomut);


            }

            @Override
            public void onFailure(Call<onlineKomutlar[]> call, Throwable t) {

            }
        });
    }
}
