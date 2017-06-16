package hsmnzaydn.serkanozaydin.net.KurucuClasslar;

/**
 * Created by hsmnzaydn on 16.06.2017.
 */

public class Komut {

    private String komutBasligi;
    private String komutIslevi;


    public Komut(String komutBasligi,String komutIslevi){
        this.setKomutBasligi(komutBasligi);
        this.setKomutIslevi(komutIslevi);
    }

    public String getKomutBasligi() {
        return komutBasligi;
    }

    public void setKomutBasligi(String komutBasligi) {
        this.komutBasligi = komutBasligi;
    }

    public String getKomutIslevi() {
        return komutIslevi;
    }

    public void setKomutIslevi(String komutIslevi) {
        this.komutIslevi = komutIslevi;
    }
}
