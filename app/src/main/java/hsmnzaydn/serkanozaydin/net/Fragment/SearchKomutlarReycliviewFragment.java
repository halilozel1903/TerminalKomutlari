package hsmnzaydn.serkanozaydin.net.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

import hsmnzaydn.serkanozaydin.net.Adapter.KomutAdapter;
import hsmnzaydn.serkanozaydin.net.JsonParse;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Komut;
import hsmnzaydn.serkanozaydin.net.R;

/**
 * Created by hsmnzaydn on 04.07.2017.
 */

public class SearchKomutlarReycliviewFragment extends Fragment implements SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener {
private View root;
    private RecyclerView Komutlar;
    private List<Komut> liste_komut;
    private KomutAdapter adapter;
    private Boolean language;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
root=inflater.inflate(R.layout.fragment_reycliview_komutlar_search,container,false);
        init();
        SharedPreferences app_preferences = PreferenceManager
                .getDefaultSharedPreferences(getContext());
        language = app_preferences.getBoolean("language",false);
if (language) {

    String komutlarim[] = {"Dosya Komutları", "Arama Komutları", "Sıkıştırma Komutları", "FTP Komutları", "Ağ Komutları", "İzin Komutları", "İzin Komutları", "Sistem Komutları", "Git Komutları", "APT Komutları", "Pacman Komutları", "Milis Linux Komutları", "Fux Project Komutları"};
    JsonParse parse = new JsonParse(getContext(), komutlarim);
    liste_komut = parse.topluKomutlariCek();
}

else {
    String komutlarim[] = {"File Commands", "Search Commands", "Compression Commands", "FTP Commands", "Network Commands", "Permission Commands", "System Commands", "Git Commands", "APT Commands", "Pacman Commands"};
    JsonParse parse = new JsonParse(getContext(), komutlarim);
    liste_komut = parse.topluKomutlariCekIngilizce();
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
        Komutlar= (RecyclerView) root.findViewById(R.id.fragment_reycliview_komutlar_search_reycliview);


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);


    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.searchfragment, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchItem.expandActionView();
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setIconified(false);
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
