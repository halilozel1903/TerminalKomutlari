package hsmnzaydn.serkanozaydin.net.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import hsmnzaydn.serkanozaydin.net.Adapter.KomutAdapter;
import hsmnzaydn.serkanozaydin.net.JsonParse;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Kategori;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Komut;
import hsmnzaydn.serkanozaydin.net.R;
import hsmnzaydn.serkanozaydin.net.Veritabanı;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by hsmnzaydn on 16.06.2017.
 */

public class KomutReycliviewFragment extends Fragment implements SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener{
    private View root;
    private RecyclerView Komutlar;
    private List<Komut> liste_komut;
    private KomutAdapter adapter;
    private Kategori kategori;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SharedPreferences shared_preferences = getContext().getSharedPreferences("dosya_adi",MODE_PRIVATE);

        Gson gson = new Gson();
        String json = shared_preferences.getString("key", "");
        kategori = gson.fromJson(json, Kategori.class);
        getActivity().setTitle(kategori.getKategoriBasligi());
        root=inflater.inflate(R.layout.fragment_komut_reycliview,container,false);
        init();




        if(kategori.getKategoriBasligi().equals("Benim Komutlarım")){
            Veritabanı db=new Veritabanı(getContext(),Komutlar);
            liste_komut=db.TumKayitlariGetir();

        }
        else {
            JsonParse parse=new JsonParse(getContext(),kategori.getKategoriBasligi());
           liste_komut= parse.KomutlariCek();
        }


         adapter=new KomutAdapter(liste_komut,getContext());

        Komutlar.setHasFixedSize(true);

        Komutlar.setAdapter(adapter);

        Komutlar.setItemAnimator(new DefaultItemAnimator());

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        Komutlar.setLayoutManager(layoutManager);



        return root;

    }

    public void init(){
        Komutlar= (RecyclerView) root.findViewById(R.id.reycliview_fragment_komut_basliklari);

      
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);


    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.drawer, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Ara...");

        super.onCreateOptionsMenu(menu, inflater);

        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase();
        ArrayList<Komut> newList=new ArrayList<>();
        for(Komut komut:liste_komut){
            String name=komut.getKomutBasligi().toLowerCase();
            if(name.contains(newText))
                newList.add(komut);
        }

        adapter.setFilter(newList);

        return true;
    }
    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        return true;
    }



}
