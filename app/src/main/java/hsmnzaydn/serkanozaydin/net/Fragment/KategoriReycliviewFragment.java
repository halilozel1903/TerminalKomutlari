package hsmnzaydn.serkanozaydin.net.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hsmnzaydn.serkanozaydin.net.Adapter.KategoriAdapter;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Kategori;
import hsmnzaydn.serkanozaydin.net.R;

/**
 * Created by hsmnzaydn on 16.06.2017.
 */

public class KategoriReycliviewFragment extends Fragment {
    private View root;
    private RecyclerView Kategoriler;
    private List<Kategori> kategoriList=new ArrayList<Kategori>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.reycliview_layout,container,false);
        kategoriList.add(new Kategori(R.drawable.folder,"Dosya Komutları"));
        kategoriList.add(new Kategori(R.drawable.search,"Arama Komutları"));
        kategoriList.add(new Kategori(R.drawable.compression,"Sıkıştırma Komutları"));
        kategoriList.add(new Kategori(R.drawable.ftp,"FTP Komutları"));
        kategoriList.add(new Kategori(R.drawable.search,"Ağ Komutları"));
        kategoriList.add(new Kategori(R.drawable.search,"İzin Komutları"));
        kategoriList.add(new Kategori(R.drawable.search,"Sistem Komutları"));




        init();



        KategoriAdapter adapter=new KategoriAdapter(kategoriList,getContext());

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
        Kategoriler= (RecyclerView) root.findViewById(R.id.reycliview_fragment_komut_basliklari);
    }
}
