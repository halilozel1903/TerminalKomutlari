package hsmnzaydn.serkanozaydin.net.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import hsmnzaydn.serkanozaydin.net.JsonParse;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Kategori;
import hsmnzaydn.serkanozaydin.net.R;
import hsmnzaydn.serkanozaydin.net.Veritabanı;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by hsmnzaydn on 16.06.2017.
 */

public class KomutReycliviewFragment extends Fragment {
    private View root;
    private RecyclerView Komutlar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_komut_reycliview,container,false);
        init();

        SharedPreferences shared_preferences = getContext().getSharedPreferences("dosya_adi",MODE_PRIVATE);

        Gson gson = new Gson();
        String json = shared_preferences.getString("key", "");
        Kategori kategori = gson.fromJson(json, Kategori.class);


        if(kategori.getKategoriBasligi().equals("Benim Komutlarım")){
            Veritabanı db=new Veritabanı(getContext(),Komutlar);
            db.TumKayitlariGetir();

        }
        else {
            JsonParse parse=new JsonParse(getContext(),Komutlar,kategori.getKategoriBasligi());
            parse.KomutlariCek();
        }



        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        Komutlar.setLayoutManager(layoutManager);



        return root;

    }

    public void init(){
        Komutlar= (RecyclerView) root.findViewById(R.id.reycliview_fragment_komut_basliklari);

    }
}
