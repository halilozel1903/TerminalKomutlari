package hsmnzaydn.serkanozaydin.net.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.internal.NavigationMenu;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

import hsmnzaydn.serkanozaydin.net.Adapter.KategoriAdapter;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Kategori;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Komut;
import hsmnzaydn.serkanozaydin.net.MysqlConnect;
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
    private AdView adView;





    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Terminal Komutları");
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
                        AlertDialog.Builder yerelKomut=new AlertDialog.Builder(getContext());
                        View mView=inflater.inflate(R.layout.dialog_yerel_komut_ekle,null);
                        final EditText yerelBaslik= (EditText) mView.findViewById(R.id.dialog_yerel_komut_ekle_baslik);
                        final EditText yerelAciklama= (EditText) mView.findViewById(R.id.dialog_yerel_komut_ekle_aciklama);
                        Button yerelEkle= (Button) mView.findViewById(R.id.dialog_yerel_komut_ekle);

                        yerelKomut.setView(mView);
                        final AlertDialog dialog=yerelKomut.create();
                        dialog.show();
                        yerelEkle.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String baslik=yerelBaslik.getText().toString();
                                String icerik=yerelAciklama.getText().toString();

                                Veritabanı db=new Veritabanı(getContext());
                                db.KayitEkle(new Komut(baslik,icerik));
                                Toast.makeText(getContext(),"Komutunuz eklendi",Toast.LENGTH_SHORT).show();

                                dialog.cancel();
                            }
                        });


                        break;
                    case R.id.online_ekle:
                        AlertDialog.Builder yerelOnlineKomut=new AlertDialog.Builder(getContext());
                        View mViewOnline=inflater.inflate(R.layout.dialog_online_komut_ekle,null);
                        final EditText onlineBaslik= (EditText) mViewOnline.findViewById(R.id.dialog_online_komut_ekle_baslik);
                        final EditText onlineAciklama= (EditText) mViewOnline.findViewById(R.id.dialog_online_komut_ekle_aciklama);
                        final EditText onlineKategori= (EditText) mViewOnline.findViewById(R.id.dialog_online_komut_ekle_kategori);

                        Button onlineEkle= (Button) mViewOnline.findViewById(R.id.dialog_online_komut_ekle);

                        yerelOnlineKomut.setView(mViewOnline);
                        final AlertDialog dialogOnline=yerelOnlineKomut.create();
                        dialogOnline.show();
                        onlineEkle.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MysqlConnect connect=new MysqlConnect(getContext());
                                String komut=onlineBaslik.getText().toString();
                                String aciklama=onlineAciklama.getText().toString();
                                String kategori=onlineKategori.getText().toString();

                                if(!komut.trim().equals("") && !aciklama.trim().equals("") && !kategori.trim().equals("")){
                                    connect.VeriKaydet(komut,aciklama,kategori);
                                    Toast.makeText(getContext(),"Komutunuz gönderildi",Toast.LENGTH_SHORT).show();

                                    dialogOnline.cancel();

                                }
                                else {
                                    Toast.makeText(getContext(),"Lütfen tüm alanları doldurun",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
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
        fragmentManager = ((FragmentActivity)getContext()).getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
       SearchKomutlarReycliviewFragment fragment = new SearchKomutlarReycliviewFragment();
        transaction.replace(R.id.container, fragment, "deneme");
        transaction.setCustomAnimations( android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        transaction.addToBackStack(null);
        transaction.commit();



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
