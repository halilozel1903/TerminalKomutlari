package hsmnzaydn.serkanozaydin.net.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import hsmnzaydn.serkanozaydin.net.Fragment.KomutReycliviewFragment;
import hsmnzaydn.serkanozaydin.net.Fragment.onlineKomutlarReycliviewFragment;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Kategori;
import hsmnzaydn.serkanozaydin.net.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by hsmnzaydn on 16.06.2017.
 */

public class KategoriAdapter  extends RecyclerView.Adapter<KategoriAdapter.ViewHolder>{

    //Hüseyin Serkan Özaydin:Kurucu yöntem
    private Context context;
    private List<Kategori> liste_kategori;
    private FragmentManager fragmentManager;



    public KategoriAdapter(List<Kategori> liste_kategori, Context context) {

        this.liste_kategori = liste_kategori;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private ImageView kategoriResmi;
        private TextView kategoriBasligi;

        private CardView card_view;
        public LinearLayout rel;

        //Hüseyin Serkan Özaydin:Cardviewdeki veriler_turkce ile classtaki verileri baplıyoruz
        public ViewHolder(View view) {
            super(view);

            card_view = (CardView) view.findViewById(R.id.kategori_satir_layout_cardview);
            kategoriBasligi = (TextView) view.findViewById(R.id.kategori_satir_layout_kategoriBasligi);
            kategoriResmi = (ImageView) view.findViewById(R.id.kategori_satir_layout_kategoriResmi);
            rel= (LinearLayout) view.findViewById(R.id.lineerlayout);



        }
    }


    //Hüseyin Serkan Özaydin:Satır Layout ile classı bağladığımız yer
    @Override
    public KategoriAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.kategori_satir_layout, parent, false);

        ViewHolder view_holder = new ViewHolder(v);
        return view_holder;
    }

    //Hüseyin Serkan Özaydin:Listenin verilerini belirlediğimiz yer ve duyurunun linkini DuyurugösterFragmente yolladığımız kısım
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Kategori kategori= liste_kategori.get(position);
        holder.kategoriBasligi.setText(kategori.getKategoriBasligi());

        if (kategori.getKategoriBasligi().equals("Dosya Komutları")){
            holder.kategoriResmi.setImageResource(R.drawable.folder);
        }
        if (kategori.getKategoriBasligi().equals("File Commands")){
            holder.kategoriResmi.setImageResource(R.drawable.folder);
        }
        if(kategori.getKategoriBasligi().equals("FTP Komutları")){
            holder.kategoriResmi.setImageResource(R.drawable.ftp);

        }
        if(kategori.getKategoriBasligi().equals("FTP Commands")){
            holder.kategoriResmi.setImageResource(R.drawable.ftp);

        }
        if(kategori.getKategoriBasligi().equals("Arama Komutları")){
            holder.kategoriResmi.setImageResource(R.drawable.search);

        }
        if(kategori.getKategoriBasligi().equals("Search Commands")){
            holder.kategoriResmi.setImageResource(R.drawable.search);

        }
        if(kategori.getKategoriBasligi().equals("Sıkıştırma Komutları")){
            holder.kategoriResmi.setImageResource(R.drawable.compression);

        }
        if(kategori.getKategoriBasligi().equals("Compression Commands")){
            holder.kategoriResmi.setImageResource(R.drawable.compression);

        }
        if(kategori.getKategoriBasligi().equals("Ağ Komutları")){
            holder.kategoriResmi.setImageResource(R.drawable.network);

        }
        if(kategori.getKategoriBasligi().equals("Network Commands")){
            holder.kategoriResmi.setImageResource(R.drawable.network);

        }
        if(kategori.getKategoriBasligi().equals("İzin Komutları")){
            holder.kategoriResmi.setImageResource(R.drawable.lock);

        }
        if(kategori.getKategoriBasligi().equals("Permission Commands")){
            holder.kategoriResmi.setImageResource(R.drawable.lock);

        }
        if(kategori.getKategoriBasligi().equals("Sistem Komutları")){
            holder.kategoriResmi.setImageResource(R.drawable.system);

        }
        if(kategori.getKategoriBasligi().equals("System Commands")){
            holder.kategoriResmi.setImageResource(R.drawable.system);

        }
        if(kategori.getKategoriBasligi().equals("Pacman Komutları")){
            holder.kategoriResmi.setImageResource(R.drawable.pacman);

        }
        if(kategori.getKategoriBasligi().equals("Pacman Commands")){
            holder.kategoriResmi.setImageResource(R.drawable.pacman);

        }
        if(kategori.getKategoriBasligi().equals("Fux Project Komutları")){
            holder.kategoriResmi.setImageResource(R.drawable.fux);

        }
        if(kategori.getKategoriBasligi().equals("Fux Project Commands")){
            holder.kategoriResmi.setImageResource(R.drawable.fux);

        }
        if(kategori.getKategoriBasligi().equals("Milis Linux Komutları")){
            holder.kategoriResmi.setImageResource(R.drawable.milis);

        }
        if(kategori.getKategoriBasligi().equals("Milis Linux Commands")){
            holder.kategoriResmi.setImageResource(R.drawable.milis);

        }
        if(kategori.getKategoriBasligi().equals("Benim Komutlarım")){
            holder.kategoriResmi.setImageResource(R.drawable.mycode);

        }
        if(kategori.getKategoriBasligi().equals("My Commands")){
            holder.kategoriResmi.setImageResource(R.drawable.mycode);

        }
        if(kategori.getKategoriBasligi().equals("Git Komutları")){
            holder.kategoriResmi.setImageResource(R.drawable.git);

        }
        if(kategori.getKategoriBasligi().equals("Git Commands")){
            holder.kategoriResmi.setImageResource(R.drawable.git);

        }if(kategori.getKategoriBasligi().equals("APT Komutları")){
            holder.kategoriResmi.setImageResource(R.drawable.apt);

        }
        if(kategori.getKategoriBasligi().equals("APT Commands")){
            holder.kategoriResmi.setImageResource(R.drawable.apt);

        }if(kategori.getKategoriBasligi().equals("Online Komutlar")){
            holder.kategoriResmi.setImageResource(R.drawable.sync);

        }
        if(kategori.getKategoriBasligi().equals("Online Commands")){
            holder.kategoriResmi.setImageResource(R.drawable.sync);

        }

        holder.rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences shared_preferences = context.getSharedPreferences("dosya_adi",MODE_PRIVATE);

                SharedPreferences.Editor editor = shared_preferences.edit();

                Gson gson = new Gson();
                String json = gson.toJson(kategori);
                editor.putString("key", json);
                editor.commit();

                if(kategori.getKategoriBasligi().equals("Online Komutlar") ||kategori.getKategoriBasligi().equals("Online Commands") ){
                    fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    onlineKomutlarReycliviewFragment fragment = new onlineKomutlarReycliviewFragment();
                    transaction.replace(R.id.container, fragment, "deneme");
                    transaction.setCustomAnimations( android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else {


                    fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    KomutReycliviewFragment fragment = new KomutReycliviewFragment();
                    transaction.replace(R.id.container, fragment, "deneme");
                    transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }

            }
        });






    }




    @Override
    public int getItemCount() {
        return liste_kategori.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setFilter(ArrayList<Kategori> newList){

        liste_kategori=new ArrayList<>();
        liste_kategori.addAll(newList );
        notifyDataSetChanged();
    }


}
