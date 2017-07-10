package hsmnzaydn.serkanozaydin.net.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


import com.spark.submitbutton.SubmitButton;

import hsmnzaydn.serkanozaydin.net.MysqlConnect;
import hsmnzaydn.serkanozaydin.net.R;

/**
 * Created by hsmnzaydn on 25.06.2017.
 */

public class onlineKomutEkleFragment extends Fragment {
private View root;
    private EditText onlineKod,onlineAciklama,onlineKategori;
    private SubmitButton onlineEkle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_onlinekomutekle,container,false);
init();
        onlineEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MysqlConnect connect=new MysqlConnect(getContext());
                String komut=onlineKod.getText().toString();
                String aciklama=onlineAciklama.getText().toString();
                String kategori=onlineKategori.getText().toString();

                if(!komut.trim().equals("") && !aciklama.trim().equals("") && !kategori.trim().equals("")){
                    connect.VeriKaydet(komut,aciklama,kategori);

                }
                else {
                    Toast.makeText(getContext(),"Lütfen tüm alanları doldurun",Toast.LENGTH_SHORT).show();
                }


                onlineKod.setText("");
                onlineAciklama.setText("");
                onlineKategori.setText("");


                }
        });


        return root;
    }

    public void init(){
        onlineKod= (EditText) root.findViewById(R.id.fragment_onlinekomut_ekle_onlinekod_EditText);
        onlineAciklama= (EditText) root.findViewById(R.id.fragment_onlinekomut_ekle_onlineaciklama_EditText);
        onlineKategori= (EditText) root.findViewById(R.id.fragment_onlinekomut_ekle_onlinekategori_EditText);
        onlineEkle= (SubmitButton) root.findViewById(R.id.fragment_onlinekomut_ekle_onlineekle_button);


    }
}
