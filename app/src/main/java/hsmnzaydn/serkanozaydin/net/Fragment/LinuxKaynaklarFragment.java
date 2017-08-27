package hsmnzaydn.serkanozaydin.net.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import hsmnzaydn.serkanozaydin.net.R;

/**
 * Created by hsmnzaydn on 27.07.2017.
 */

public class LinuxKaynaklarFragment extends Fragment {
    private ListView linuxKaynaklar;
    private View root;
    private String[] basliklar;
    private Intent browserIntent;
    private String url="";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         root=inflater.inflate(R.layout.fragment_kaynaklar_linux,container,false);
        init();
        basliklar= new String[]{"Linux Komut Satırı", "RPM Paket Yöneticisi","Kali İle Linuxa Giriş","ODTU Linux Eğitimi","Temel Linux Eğitimi","Linux Sistem Yönetimi","Terminal Komutları Özet","Konsol Komutlari","Linux Kitapçığı","Linux Komutları","Linux Bash"};

        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                (getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, basliklar);
linuxKaynaklar.setAdapter(veriAdaptoru);

        linuxKaynaklar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String baslik=basliklar[position].toString();
                switch (baslik){
                    case "Linux Komut Satırı":
                        url="http://serkanozaydin.net/LinuxKaynaklar/LinuxKomutSatiri.pdf";
                        break;
                    case "RPM Paket Yöneticisi":
                        url="http://serkanozaydin.net/LinuxKaynaklar/RpmPaketYoneticisi.pdf";
                        break;
                    case "Kali İle Linuxa Giriş":
                        url="http://serkanozaydin.net/LinuxKaynaklar/KaliLinuxileLinuxaGiris.pdf";
                        break;
                    case "ODTU Linux Eğitimi":
                        url="http://serkanozaydin.net/LinuxKaynaklar/OdtuLinuxEgitim.pdf";
                        break;
                    case "Temel Linux Eğitimi":
                        url="http://serkanozaydin.net/LinuxKaynaklar/TemelLinuxEgitimi.pdf";
                        break;
                    case "Linux Sistem Yönetimi":
                        url="http://serkanozaydin.net/LinuxKaynaklar/LinuxSistemYonetimi.pdf";
                        break;
                    case "Terminal Komutları Özet":
                        url="http://serkanozaydin.net/LinuxKaynaklar/KomutlarOnizle.pdf";
                        break;
                    case "Konsol Komutlari":
                        url="http://serkanozaydin.net/LinuxKaynaklar/KonsolKomutlari.pdf";
                        break;
                    case "Linux Kitapçığı":
                        url="http://serkanozaydin.net/LinuxKaynaklar/linuxkitapcigi.pdf";
                        break;
                    case "Linux Komutları":
                        url="http://serkanozaydin.net/LinuxKaynaklar/linuxKomutlari.pdf";
                        break;
                    case "Linux Bash":
                        url="http://serkanozaydin.net/LinuxKaynaklar/linux-bash.pdf";
                        break;

                    default:
                        return;

                }
                browserIntent= new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                LinuxKaynaklarFragment.this.startActivity(browserIntent);
            }
        });




    return root;
    }
    public void init(){
        linuxKaynaklar= (ListView) root.findViewById(R.id.fragment_kaynaklar_linux);
    }
}
