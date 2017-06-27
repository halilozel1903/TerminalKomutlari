package hsmnzaydn.serkanozaydin.net.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hsmnzaydn.serkanozaydin.net.KurucuClasslar.onlineKomutlar;
import hsmnzaydn.serkanozaydin.net.R;

/**
 * Created by hsmnzaydn on 23.06.2017.
 */

public class onlineKomutlarAdapter extends RecyclerView.Adapter<onlineKomutlarAdapter.ViewHolder>{

    private Context context;
    private List<onlineKomutlar> liste_komut;



    public onlineKomutlarAdapter(List<onlineKomutlar> liste_komut, Context context) {

        this.liste_komut = liste_komut;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView komutBasligi;
        private TextView komutIcerigi;
        private TextView kategori;


        public ViewHolder(View view) {
            super(view);

            komutBasligi = (TextView) view.findViewById(R.id.onlinekomut_satir_layout_komut_basligi);
            komutIcerigi = (TextView) view.findViewById(R.id.onlinekomut_satir_layout_komut_islevi);
            kategori= (TextView) view.findViewById(R.id.onlinekomut_satir_layout_kategori);



        }
    }


    @Override
    public onlineKomutlarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.onlinekomutlar_satir_layout, parent, false);

        onlineKomutlarAdapter.ViewHolder view_holder = new onlineKomutlarAdapter.ViewHolder(v);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(onlineKomutlarAdapter.ViewHolder holder, final int position) {
        onlineKomutlar komut= liste_komut.get(position);
        holder.komutBasligi.setText(komut.getKomut());
        holder.komutIcerigi.setText(komut.getKomutIcerigi());
        holder.kategori.setText(komut.getKategori());


    }




    @Override
    public int getItemCount() {

        return liste_komut.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setFilter(ArrayList<onlineKomutlar> newList){

        liste_komut=new ArrayList<>();
        liste_komut.addAll(newList);
        notifyDataSetChanged();
    }


}
