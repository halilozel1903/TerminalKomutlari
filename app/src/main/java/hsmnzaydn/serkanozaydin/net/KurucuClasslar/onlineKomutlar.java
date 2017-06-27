package hsmnzaydn.serkanozaydin.net.KurucuClasslar;

/**
 * Created by hsmnzaydn on 22.06.2017.
 */

public class onlineKomutlar {
    private String Komut;
    private String komutIcerigi;
    private String kategori;


    public onlineKomutlar(String Komut,String komutIcerigi,String kategori){
        this.setKomut(Komut);
        this.setKomutIcerigi(komutIcerigi);
        this.setKategori(kategori);
    }

    public String getKomut() {
        return Komut;
    }

    public void setKomut(String komut) {
        Komut = komut;
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
