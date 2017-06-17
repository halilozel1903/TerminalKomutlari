package hsmnzaydn.serkanozaydin.net.KurucuClasslar;

/**
 * Created by hsmnzaydn on 16.06.2017.
 */

public class Kategori {

    private int kategoriResmi;
    private String kategoriBasligi;


    public Kategori(String kategoriBasligi){
        this.setKategoriBasligi(kategoriBasligi);
    }

    public int getKategoriResmi() {
        return kategoriResmi;
    }

    public void setKategoriResmi(int kategoriResmi) {
        this.kategoriResmi = kategoriResmi;
    }

    public String getKategoriBasligi() {
        return kategoriBasligi;
    }

    public void setKategoriBasligi(String kategoriBasligi) {
        this.kategoriBasligi = kategoriBasligi;
    }
}
