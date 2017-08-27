package hsmnzaydn.serkanozaydin.net;

import android.content.Context;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
    private String cekilecekVeriler;
    private String cekilecekVerilerArray[];


    public JsonParse(Context context,String cekilecekVeriler){
        this.setContext(context);

        this.cekilecekVeriler=cekilecekVeriler;

    }

    public JsonParse(Context context,String cekilecekVerilerArray[]){
        this.setContext(context);

        this.cekilecekVerilerArray=cekilecekVerilerArray;

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


    public List<Komut> KomutlariCek(){
        InputStream is=context.getResources().openRawResource(R.raw.veriler_turkce);

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


                komutlar.add(new Komut(komutBasligi,komutIcerigi));
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }







return komutlar;

    }

    public List<Komut> komutlariCekIngilizce(){
        InputStream is=context.getResources().openRawResource(R.raw.veriler_ingilizce);

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


                komutlar.add(new Komut(komutBasligi,komutIcerigi));
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }







        return komutlar;

    }



    public List<Komut> topluKomutlariCek(){
        InputStream is=context.getResources().openRawResource(R.raw.veriler_turkce);

        try {

            byte buffer[]=new byte[is.available()];
            while (is.read(buffer)!=-1);

            String jsonVerisi=new String(buffer);
            JSONObject jsonObject=new JSONObject(jsonVerisi);
            for(int a=0;a<cekilecekVerilerArray.length;a++) {
                JSONArray personel = jsonObject.getJSONArray(cekilecekVerilerArray[a].toString());

                for (int i = 0; i < personel.length(); i++) {

                    JSONObject object = personel.getJSONObject(i);

                    String komutBasligi = object.getString("KomutAdi");
                    String komutIcerigi = object.getString("Islevi");


                    komutlar.add(new Komut(komutBasligi, komutIcerigi));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

return komutlar;
    }





    public List<Komut> topluKomutlariCekIngilizce(){
        InputStream is=context.getResources().openRawResource(R.raw.veriler_ingilizce);

        try {

            byte buffer[]=new byte[is.available()];
            while (is.read(buffer)!=-1);

            String jsonVerisi=new String(buffer);
            JSONObject jsonObject=new JSONObject(jsonVerisi);
            for(int a=0;a<cekilecekVerilerArray.length;a++) {
                JSONArray personel = jsonObject.getJSONArray(cekilecekVerilerArray[a].toString());

                for (int i = 0; i < personel.length(); i++) {

                    JSONObject object = personel.getJSONObject(i);

                    String komutBasligi = object.getString("KomutAdi");
                    String komutIcerigi = object.getString("Islevi");


                    komutlar.add(new Komut(komutBasligi, komutIcerigi));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return komutlar;
    }


}
