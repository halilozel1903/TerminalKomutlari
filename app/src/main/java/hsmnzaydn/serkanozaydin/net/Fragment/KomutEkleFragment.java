package hsmnzaydn.serkanozaydin.net.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.spark.submitbutton.SubmitButton;

import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Komut;
import hsmnzaydn.serkanozaydin.net.R;
import hsmnzaydn.serkanozaydin.net.Veritabanı;

/**
 * Created by hsmnzaydn on 17.06.2017.
 */

public class KomutEkleFragment extends Fragment{
    private View root;
    private EditText kod,aciklama;
    private SubmitButton ekle;



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



            }
        });





        return root;
    }

    public void init(){
        kod= (EditText) root.findViewById(R.id.fragment_komut_ekle_kod_EditText);
        aciklama= (EditText) root.findViewById(R.id.fragment_komut_ekle_aciklama_EditText);
        ekle= (SubmitButton) root.findViewById(R.id.fragment_komut_ekle_ekle_button);


    }
}
