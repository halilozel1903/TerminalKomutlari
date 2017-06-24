package hsmnzaydn.serkanozaydin.net;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hsmnzaydn.serkanozaydin.net.Adapter.onlineKomutlarAdapter;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.onlineKomutlar;

/**
 * Created by hsmnzaydn on 23.06.2017.
 */

public class MysqlConnect  {

    private String url_veriCek="http://www.serkanozaydin.net/baglanti/veriCek.php";
    private String url_veriGonder="http://www.serkanozaydin.net/baglanti/veriGonder.php";
    private Context context;
    private RecyclerView recyclerView;
    private Map<String,String> params;





    public MysqlConnect(Context context, RecyclerView recyclerView){
        this.setContext(context);
        this.recyclerView=recyclerView;

    }
    public MysqlConnect(Context context){
        this.setContext(context);


    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    public void VeriGetir(){
        final List<onlineKomutlar> komutlarList=new ArrayList<onlineKomutlar>();
        final ProgressDialog pd = new ProgressDialog(getContext());
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());

        pd.setMessage("İşlem Gerçekleştiriliyor.Lütfen Bekleyiniz..");
        pd.show();
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, url_veriCek, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray komutlar= response.getJSONArray("komutlar");

                    for (int i=0; i<komutlar.length();i++){

                        JSONObject komut=komutlar.getJSONObject(i);
                        String baslik=komut.getString("komut");
                        String icerik=komut.getString("komut_icerigi");
                        String tarih=komut.getString("tarih");
                        String kategori=komut.getString("kategori");
                        int kabul=komut.getInt("kabul");


                        if(kabul==1) {
                            komutlarList.add(new onlineKomutlar(baslik, icerik, tarih, kategori));
                        }


                    }



                    onlineKomutlarAdapter adapter=new onlineKomutlarAdapter(komutlarList,getContext());

                    recyclerView.setHasFixedSize(true);

                    recyclerView.setAdapter(adapter);

                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    adapter.notifyDataSetChanged();

                    pd.dismiss();
                } catch (JSONException e) {
                    Log.e("Hata",e.getLocalizedMessage());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Hata ErrorResponse",error.getLocalizedMessage());
            }
        });
        requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonObjectRequest);



    }








    public void VeriKaydet(final String komut, final String komut_icerigi, final String tarih, final String kategori){

        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        StringRequest request=new StringRequest(Request.Method.POST, url_veriGonder, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {



            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                try {
                    params=new HashMap<String,String>();

                    params.put("komut", komut.toString());
                    params.put("komut_icerigi", komut_icerigi.toString());
                    params.put("tarih", tarih.toString());
                    params.put("kategori", kategori.toString());
                }
                catch (Exception e){

                }



                return params;


            }
        };

        requestQueue.add(request);
    }
}
