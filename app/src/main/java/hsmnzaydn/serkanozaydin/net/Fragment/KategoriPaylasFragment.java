package hsmnzaydn.serkanozaydin.net.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.gturedi.views.StatefulLayout;

import java.util.ArrayList;
import java.util.List;

import hsmnzaydn.serkanozaydin.net.CreatePdf;
import hsmnzaydn.serkanozaydin.net.JsonParse;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Komut;
import hsmnzaydn.serkanozaydin.net.R;

/**
 * Created by hsmnzaydn on 24.07.2017.
 */

public class KategoriPaylasFragment extends Fragment {
    CheckBox dosya, arama, sikistirma, ftp, ag, izin, sistem, git, apt, pacman, milis, fux, benim;
    List<Komut> komutList;
    List<String> secilenler = new ArrayList<>();
    Button button;
    String stringBuilder = "";
    Boolean language;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.paylas_kategori, container, false);
        dosya = (CheckBox) root.findViewById(R.id.paylas_DosyaKomutlari);
        arama = (CheckBox) root.findViewById(R.id.paylas_AramaKomutlari);
        sikistirma = (CheckBox) root.findViewById(R.id.paylas_SikistirmaKomutlari);
        ftp = (CheckBox) root.findViewById(R.id.paylas_ftpKomutlari);
        ag = (CheckBox) root.findViewById(R.id.paylas_agKomutlari);
        izin = (CheckBox) root.findViewById(R.id.paylas_izinKomutlari);
        sistem = (CheckBox) root.findViewById(R.id.paylas_sistemKomutlari);
        git = (CheckBox) root.findViewById(R.id.paylas_gitKomutlari);
        apt = (CheckBox) root.findViewById(R.id.paylas_aptKomutlari);
        pacman = (CheckBox) root.findViewById(R.id.paylas_pacmanKomutlari);
        milis = (CheckBox) root.findViewById(R.id.paylas_milisKomutlari);
        fux = (CheckBox) root.findViewById(R.id.paylas_fuxKomutlari);
        SharedPreferences app_preferences= PreferenceManager
                .getDefaultSharedPreferences(getContext());
        language = app_preferences.getBoolean("language", false);
        if(!language){
            milis.setVisibility(View.INVISIBLE);
            fux.setVisibility(View.INVISIBLE);
        }
        button = (Button) root.findViewById(R.id.paylas_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (language) {


                    if (dosya.isChecked()) {
                        secilenler.add("Dosya Komutları");
                    }
                    if (arama.isChecked()) {
                        secilenler.add("Arama Komutları");
                    }
                    if (sikistirma.isChecked()) {
                        secilenler.add("Sıkıştırma Komutları");
                    }
                    if (ftp.isChecked()) {
                        secilenler.add("FTP Komutları");
                    }
                    if (ag.isChecked()) {
                        secilenler.add("Ağ Komutları");
                    }
                    if (izin.isChecked()) {
                        secilenler.add("İzin Komutları");
                    }
                    if (sistem.isChecked()) {
                        secilenler.add("Sistem Komutları");
                    }
                    if (git.isChecked()) {
                        secilenler.add("Git Komutları");
                    }
                    if (apt.isChecked()) {
                        secilenler.add("APT Komutları");
                    }
                    if (pacman.isChecked()) {
                        secilenler.add("Pacman Komutları");
                    }
                    if (milis.isChecked()) {
                        secilenler.add("Milis Linux Komutları");
                    }
                    if (fux.isChecked()) {
                        secilenler.add("Fux Project Komutları");
                    }


                    for (int i = 0; i < secilenler.size(); i++) {
                        JsonParse parse = new JsonParse(getContext(), secilenler.get(i).toString());
                        komutList = parse.KomutlariCek();
                        for (Komut komut : komutList) {
                            String komutBasligi = "<b>" + komut.getKomutBasligi() + "</b>";
                            stringBuilder = stringBuilder + Html.fromHtml(komutBasligi) + ":" + komut.getKomutIslevi() + "\n";
                        }

                    }
                    try {
                        Runnable runnable=new Runnable() {
                            @Override
                            public void run() {
                                CreatePdf pdf = new CreatePdf(getContext());
                                pdf.createPDF(stringBuilder);

                                pdf.shareWithmail();
                            }
                        };
                        runnable.run();

                    } catch (Exception e) {

                    }

                } else {


                    if (dosya.isChecked()) {
                        secilenler.add("File Commands");
                    }
                    if (arama.isChecked()) {
                        secilenler.add("Search Commands");
                    }
                    if (sikistirma.isChecked()) {
                        secilenler.add("Compression Commands");
                    }
                    if (ftp.isChecked()) {
                        secilenler.add("FTP Commands");
                    }
                    if (ag.isChecked()) {
                        secilenler.add("Network Commands");
                    }
                    if (izin.isChecked()) {
                        secilenler.add("Permission Commands");
                    }
                    if (sistem.isChecked()) {
                        secilenler.add("System Commands");
                    }
                    if (git.isChecked()) {
                        secilenler.add("Git Commands");
                    }
                    if (apt.isChecked()) {
                        secilenler.add("APT Commands");
                    }
                    if (pacman.isChecked()) {
                        secilenler.add("Pacman Commands");
                    }


                    for (int i = 0; i < secilenler.size(); i++) {
                        JsonParse parse = new JsonParse(getContext(), secilenler.get(i).toString());
                        komutList = parse.komutlariCekIngilizce();
                        for (Komut komut : komutList) {

                            String komutBasligi = "<b>" + komut.getKomutBasligi() + "</b>";
                            stringBuilder = stringBuilder + Html.fromHtml(komutBasligi) + ":" + komut.getKomutIslevi() + "\n";
                        }

                    }
                    try {
Runnable runnable=new Runnable() {
    @Override
    public void run() {
        CreatePdf pdf = new CreatePdf(getContext());
        pdf.createPDF(stringBuilder);

        pdf.shareWithmail();
    }
};
runnable.run();




                    } catch (Exception e) {

                    }
                }


            }


        });


        return root;
    }


}
