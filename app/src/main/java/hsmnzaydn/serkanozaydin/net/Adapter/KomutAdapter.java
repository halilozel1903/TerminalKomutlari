package hsmnzaydn.serkanozaydin.net.Adapter;

import android.content.Context;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Komut;
import hsmnzaydn.serkanozaydin.net.R;


/**
 * Created by hsmnzaydn on 16.06.2017.
 */

public class KomutAdapter extends RecyclerView.Adapter<KomutAdapter.ViewHolder>{

    //Hüseyin Serkan Özaydin:Kurucu yöntem
    private Context context;
    private List<Komut> liste_komut;



    public KomutAdapter(List<Komut> liste_komut, Context context) {

        this.liste_komut = liste_komut;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView komutBasligi;
        private TextView komutIcerigi;


        //Hüseyin Serkan Özaydin:Cardviewdeki veriler ile classtaki verileri baplıyoruz
        public ViewHolder(View view) {
            super(view);

            komutBasligi = (TextView) view.findViewById(R.id.komut_satir_layout_komut_basligi);
            komutIcerigi = (TextView) view.findViewById(R.id.komut_satir_layout_komut_islevi);



        }
    }


    @Override
    public KomutAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.komut_satir_layout, parent, false);

        KomutAdapter.ViewHolder view_holder = new KomutAdapter.ViewHolder(v);
        return view_holder;
    }

    //Hüseyin Serkan Özaydin:Listenin verilerini belirlediğimiz yer ve duyurunun linkini DuyurugösterFragmente yolladığımız kısım
    @Override
    public void onBindViewHolder(KomutAdapter.ViewHolder holder, final int position) {
        Komut komut= liste_komut.get(position);
        holder.komutBasligi.setText(komut.getKomutBasligi());
        holder.komutIcerigi.setText(komut.getKomutIslevi());
    }




    @Override
    public int getItemCount() {
        return liste_komut.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
