package hsmnzaydn.serkanozaydin.net.KurucuClasslar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hsmnzaydn on 22.06.2017.
 */

public class onlineKomutlar {
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("komut")
    @Expose
    public String komut;
    @SerializedName("komut_icerigi")
    @Expose
    public String komutIcerigi;
    @SerializedName("tarih")
    @Expose
    public String tarih;
    @SerializedName("kategori")
    @Expose
    public String kategori;
    @SerializedName("kabul")
    @Expose
    public String kabul;

    public onlineKomutlar(String Komut,String komutIcerigi,String kategori){
        this.setKomut(Komut);
        this.setKomutIcerigi(komutIcerigi);
        this.setKategori(kategori);
    }


    public String getKomut() {
        return komut;
    }

    public void setKomut(String komut) {
        komut = komut;
    }

    public String getKomutIcerigi() {
        return komutIcerigi;
    }

    public void setKomutIcerigi(String komutIcerigi) {
        this.komutIcerigi = komutIcerigi;
    }



    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
