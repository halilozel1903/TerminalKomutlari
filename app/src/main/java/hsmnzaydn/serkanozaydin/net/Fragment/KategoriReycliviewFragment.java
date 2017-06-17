package hsmnzaydn.serkanozaydin.net.Fragment;

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

import java.util.ArrayList;
import java.util.List;

import hsmnzaydn.serkanozaydin.net.Adapter.KategoriAdapter;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Kategori;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Komut;
import hsmnzaydn.serkanozaydin.net.R;
import hsmnzaydn.serkanozaydin.net.Veritabanı;

/**
 * Created by hsmnzaydn on 16.06.2017.
 */

public class KategoriReycliviewFragment extends Fragment implements SearchView.OnQueryTextListener {
    private View root;
    private RecyclerView Kategoriler;
    private List<Kategori> kategoriList=new ArrayList<Kategori>();
    private KategoriAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_kategori_reycliview,container,false);
        Veritabanı db=new Veritabanı(getContext());
        if(kategoriList.size()==0) {
            kategoriList.add(new Kategori("Dosya Komutları"));
            kategoriList.add(new Kategori( "Arama Komutları"));
            kategoriList.add(new Kategori("Sıkıştırma Komutları"));
            kategoriList.add(new Kategori( "FTP Komutları"));
            kategoriList.add(new Kategori("Ağ Komutları"));
            kategoriList.add(new Kategori("İzin Komutları"));
            kategoriList.add(new Kategori("Sistem Komutları"));
            kategoriList.add(new Kategori("Pacman Komutları"));
            kategoriList.add(new Kategori("Milis Linux Komutları"));
            kategoriList.add(new Kategori("Fux Project Komutları"));
            kategoriList.add(new Kategori("Benim Komutlarım"));


        }
        else {
            kategoriList.clear();
            kategoriList.add(new Kategori("Dosya Komutları"));
            kategoriList.add(new Kategori( "Arama Komutları"));
            kategoriList.add(new Kategori("Sıkıştırma Komutları"));
            kategoriList.add(new Kategori( "FTP Komutları"));
            kategoriList.add(new Kategori("Ağ Komutları"));
            kategoriList.add(new Kategori("İzin Komutları"));
            kategoriList.add(new Kategori("Sistem Komutları"));
            kategoriList.add(new Kategori("Pacman Komutları"));
            kategoriList.add(new Kategori("Milis Linux Komutları"));
            kategoriList.add(new Kategori("Fux Project Komutları"));
            kategoriList.add(new Kategori("Benim Komutlarım"));
        }



        init();



        adapter=new KategoriAdapter(kategoriList,getContext());

        Kategoriler.setHasFixedSize(true);

        Kategoriler.setAdapter(adapter);

        Kategoriler.setItemAnimator(new DefaultItemAnimator());


        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        Kategoriler.setLayoutManager(layoutManager);




        return root;
    }

    public void init(){
        Kategoriler= (RecyclerView) root.findViewById(R.id.reycliview_fragment_kategori_basliklari);
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.drawer, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Search");

        super.onCreateOptionsMenu(menu, inflater);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}