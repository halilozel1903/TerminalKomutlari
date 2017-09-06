package hsmnzaydn.serkanozaydin.net.Adapter;

import android.content.Context;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.github.ivbaranov.mfb.MaterialFavoriteButton;

import java.util.ArrayList;
import java.util.List;

import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Komut;
import hsmnzaydn.serkanozaydin.net.R;
import hsmnzaydn.serkanozaydin.net.Veritabanı;


/**
 * Created by hsmnzaydn on 16.06.2017.
 */

public class KomutAdapter extends RecyclerView.Adapter<KomutAdapter.ViewHolder>{

    private Context context;
    private List<Komut> liste_komut;



    public KomutAdapter(List<Komut> liste_komut, Context context) {

        this.liste_komut = liste_komut;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView komutBasligi;
        private TextView komutIcerigi;
        public LinearLayout linearLayout;
        private MaterialFavoriteButton favori;


        public ViewHolder(View view) {
            super(view);

            komutBasligi = (TextView) view.findViewById(R.id.komut_satir_layout_komut_basligi);
            komutIcerigi = (TextView) view.findViewById(R.id.komut_satir_layout_komut_islevi);
            linearLayout= (LinearLayout) view.findViewById(R.id.komut_satir_layout_lineerlayout);
            favori= (MaterialFavoriteButton) view.findViewById(R.id.komut_satir_layout_favori);


        }
    }


    @Override
    public KomutAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.komut_satir_layout, parent, false);

        KomutAdapter.ViewHolder view_holder = new KomutAdapter.ViewHolder(v);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(final KomutAdapter.ViewHolder holder, final int position) {
        final Komut komut= liste_komut.get(position);
        holder.komutBasligi.setText(komut.getKomutBasligi());
        holder.komutIcerigi.setText(komut.getKomutIslevi());


        final Veritabanı db=new Veritabanı(context);

        List<Komut> komutList=db.TumKayitlariGetir();

        for(Komut komut1:komutList){
            if (komut1.getKomutBasligi().toString().equals(komut.getKomutBasligi().toString())){
                holder.favori.setFavorite(true);
            }
        }


        holder.favori.setOnFavoriteChangeListener(new MaterialFavoriteButton.OnFavoriteChangeListener() {
            @Override
            public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                if(favorite){
                    try{
                        db.KayitEkle(komut);
                        Snackbar.make(holder.linearLayout,context.getString(R.string.added_favorite),Snackbar.LENGTH_LONG).show();
                    }
                    catch (Exception e){

                    }


                }
                else {
                    try {
                        db.kayitSil(komut.getKomutBasligi());
                        Snackbar.make(holder.linearLayout,context.getString(R.string.deleted_favorite),Snackbar.LENGTH_LONG).show();
                    }
                    catch (Exception e){

                    }
                }
            }
        });

    }




    @Override
    public int getItemCount() {

        return liste_komut.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setFilter(ArrayList<Komut> newList){

        liste_komut=new ArrayList<>();
        liste_komut.addAll(newList );
        notifyDataSetChanged();
    }


}
