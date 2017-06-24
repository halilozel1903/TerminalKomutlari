package hsmnzaydn.serkanozaydin.net.Fragment;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Komut;
import hsmnzaydn.serkanozaydin.net.MysqlConnect;
import hsmnzaydn.serkanozaydin.net.R;
import hsmnzaydn.serkanozaydin.net.Veritabanı;

/**
 * Created by hsmnzaydn on 17.06.2017.
 */

public class KomutEkleFragment extends Fragment{
    private View root;
    private EditText kod,aciklama,onlineKod,onlineAciklama,onlineKategori;
    private Button ekle,onlineEkle;
    private String tarih;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_komut_ekle,container,false);
        init();


        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String baslik=kod.getText().toString();
                String icerik=aciklama.getText().toString();

                Veritabanı db=new Veritabanı(getContext());
                db.KayitEkle(new Komut(baslik,icerik));

                kod.setText("");
                aciklama.setText("");
                Toast.makeText(getContext(),"Kodunuz Benim Komutlarım kategorisine eklendi",Toast.LENGTH_SHORT).show();
            }
        });

        onlineEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MysqlConnect connect=new MysqlConnect(getContext());
                String komut=onlineKod.getText().toString();
                String aciklama=onlineAciklama.getText().toString();
                String kategori=onlineKategori.getText().toString();

                connect.VeriKaydet(komut,aciklama,"",kategori);

                onlineKod.setText("");
                onlineAciklama.setText("");
                onlineKategori.setText("");

                Toast.makeText(getContext(),"Terminal komutunuz yollandı moderatörün onayı için bekleniyor",Toast.LENGTH_SHORT).show();
            }
        });



        return root;
    }

    public void init(){
        kod= (EditText) root.findViewById(R.id.fragment_komut_ekle_kod_EditText);
        aciklama= (EditText) root.findViewById(R.id.fragment_komut_ekle_aciklama_EditText);
        ekle= (Button) root.findViewById(R.id.fragment_komut_ekle_ekle_button);
        onlineKod= (EditText) root.findViewById(R.id.fragment_komut_ekle_onlinekod_EditText);
        onlineAciklama= (EditText) root.findViewById(R.id.fragment_komut_ekle_onlineaciklama_EditText);
        onlineKategori= (EditText) root.findViewById(R.id.fragment_komut_ekle_onlinekategori_EditText);
        onlineEkle= (Button) root.findViewById(R.id.fragment_komut_ekle_onlineekle_button);

    }
}
