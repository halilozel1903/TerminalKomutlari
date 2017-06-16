package hsmnzaydn.serkanozaydin.net.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Kategori;
import hsmnzaydn.serkanozaydin.net.R;

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
        public RelativeLayout rel;

        //Hüseyin Serkan Özaydin:Cardviewdeki veriler ile classtaki verileri baplıyoruz
        public ViewHolder(View view) {
            super(view);

            card_view = (CardView) view.findViewById(R.id.kategori_satir_layout_cardview);
            kategoriBasligi = (TextView) view.findViewById(R.id.kategori_satir_layout_kategoriBasligi);
            kategoriResmi = (ImageView) view.findViewById(R.id.kategori_satir_layout_kategoriResmi);
            rel= (RelativeLayout) view.findViewById(R.id.lineerlayout);



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
        if(kategori.getKategoriBasligi().equals("FTP Komutları")){
            holder.kategoriResmi.setImageResource(R.drawable.ftp);

        }
        if(kategori.getKategoriBasligi().equals("Arama Komutları")){
            holder.kategoriResmi.setImageResource(R.drawable.search);

        }
        if(kategori.getKategoriBasligi().equals("Sıkıştırma Komutları")){
            holder.kategoriResmi.setImageResource(R.drawable.compression);

        }







    }




    @Override
    public int getItemCount() {

        return liste_kategori.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
