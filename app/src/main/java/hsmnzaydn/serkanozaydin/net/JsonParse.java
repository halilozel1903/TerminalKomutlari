package hsmnzaydn.serkanozaydin.net;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import hsmnzaydn.serkanozaydin.net.Adapter.KomutAdapter;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Komut;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by hsmnzaydn on 16.06.2017.
 */

public class JsonParse {
    private List<Komut> komutlar =new ArrayList<Komut>();
    private Context context;
    private RecyclerView recyclerView;
    private String cekilecekVeriler;


    public JsonParse(Context context, RecyclerView recyclerView,String cekilecekVeriler){
        this.setContext(context);
        this.recyclerView=recyclerView;
        this.cekilecekVeriler=cekilecekVeriler;

    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Komut> getKomutlar() {
        return komutlar;
    }

    public void setKomutlar(List<Komut> komutlar) {
        this.komutlar = komutlar;
    }


    public void DuyurulariCek(){
        InputStream is=context.getResources().openRawResource(R.raw.veriler);

        try {

            byte buffer[]=new byte[is.available()];
            while (is.read(buffer)!=-1);

            String jsonVerisi=new String(buffer);
            JSONObject jsonObject=new JSONObject(jsonVerisi);
            JSONArray personel=jsonObject.getJSONArray(cekilecekVeriler);

            for (int i=0; i<personel.length(); i++)
            {

                JSONObject object=personel.getJSONObject(i);

                String komutBasligi=object.getString("KomutAdi");
                String komutIcerigi=object.getString("Islevi");
                Log.i("deneme",komutBasligi);


                komutlar.add(new Komut(komutBasligi,komutIcerigi));
            }

            KomutAdapter adapter=new KomutAdapter(komutlar,getContext());

            recyclerView.setHasFixedSize(true);

            recyclerView.setAdapter(adapter);

            recyclerView.setItemAnimator(new DefaultItemAnimator());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }









    }




}
