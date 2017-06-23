package hsmnzaydn.serkanozaydin.net.KurucuClasslar;

/**
 * Created by hsmnzaydn on 22.06.2017.
 */

public class onlineKomutlar {
    private String Komut;
    private String komutIcerigi;
    private String tarih;
    private String kategori;


    public onlineKomutlar(String Komut,String komutIcerigi,String tarih,String kategori){
        this.setKomut(Komut);
        this.setKomutIcerigi(komutIcerigi);
        this.setTarih(tarih);
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

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
