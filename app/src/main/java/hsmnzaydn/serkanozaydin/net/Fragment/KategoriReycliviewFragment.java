package hsmnzaydn.serkanozaydin.net.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hsmnzaydn.serkanozaydin.net.Adapter.KategoriAdapter;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Kategori;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Komut;
import hsmnzaydn.serkanozaydin.net.R;
import hsmnzaydn.serkanozaydin.net.Veritabanı;
import io.github.yavski.fabspeeddial.FabSpeedDial;

/**
 * Created by hsmnzaydn on 16.06.2017.
 */

public class KategoriReycliviewFragment extends Fragment implements SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener {
    private View root;
    private RecyclerView Kategoriler;
    private List<Kategori> kategoriList=new ArrayList<Kategori>();
    private KategoriAdapter adapter;
    private FragmentManager fragmentManager;
    private FabSpeedDial actionButton;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_kategori_reycliview,container,false);
        init();
        actionButton.setMenuListener(new FabSpeedDial.MenuListener() {
            @Override
            public boolean onPrepareMenu(NavigationMenu navigationMenu) {
                return true;
            }

            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.yerel_ekle:
                        fragmentManager = ((FragmentActivity)getContext()).getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        KomutEkleFragment fragment = new KomutEkleFragment();
                        transaction.replace(R.id.container, fragment, "deneme");
                        transaction.setCustomAnimations( android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;
                    case R.id.online_ekle:
                        fragmentManager = ((FragmentActivity)getContext()).getSupportFragmentManager();
                        FragmentTransaction transaction2 = fragmentManager.beginTransaction();
                        onlineKomutEkleFragment fragment2 = new onlineKomutEkleFragment();
                        transaction2.replace(R.id.container, fragment2, "deneme");
                        transaction2.setCustomAnimations( android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                        transaction2.addToBackStack(null);
                        transaction2.commit();
                        break;
                    case R.id.paylas:
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);

                        shareIntent.setType("text/plain");

                        shareIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=hsmnzaydn.serkanozaydin.net");

                        startActivity(Intent.createChooser(shareIntent, "Terminal komutları"));


                }
                return true;
            }

            @Override
            public void onMenuClosed() {

            }
        });


        Veritabanı db=new Veritabanı(getContext());
        if(kategoriList.size()==0) {
            kategoriList.add(new Kategori("Dosya Komutları"));
            kategoriList.add(new Kategori( "Arama Komutları"));
            kategoriList.add(new Kategori("Sıkıştırma Komutları"));
            kategoriList.add(new Kategori( "FTP Komutları"));
            kategoriList.add(new Kategori("Ağ Komutları"));
            kategoriList.add(new Kategori("İzin Komutları"));
            kategoriList.add(new Kategori("Sistem Komutları"));
            kategoriList.add(new Kategori("Git Komutları"));
            kategoriList.add(new Kategori("APT Komutları"));
            kategoriList.add(new Kategori("Pacman Komutları"));
            kategoriList.add(new Kategori("Milis Linux Komutları"));
            kategoriList.add(new Kategori("Fux Project Komutları"));
            kategoriList.add(new Kategori("Benim Komutlarım"));
            kategoriList.add(new Kategori("Online Komutlar"));



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
            kategoriList.add(new Kategori("Git Komutları"));
            kategoriList.add(new Kategori("APT Komutları"));
            kategoriList.add(new Kategori("Pacman Komutları"));
            kategoriList.add(new Kategori("Milis Linux Komutları"));
            kategoriList.add(new Kategori("Fux Project Komutları"));
            kategoriList.add(new Kategori("Benim Komutlarım"));
            kategoriList.add(new Kategori("Online Komutlar"));
        }







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
        actionButton= (FabSpeedDial) root.findViewById(R.id.reycliview_fragment_kategori_actionButton);


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
        ArrayList<Kategori> newList=new ArrayList<>();
        for(Kategori kategori:kategoriList){
            String name=kategori.getKategoriBasligi().toLowerCase();
            if(name.contains(newText))
            newList.add(kategori);
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

    public interface OnItem1SelectedListener {
        void OnItem1SelectedListener(String item);
    }

}
