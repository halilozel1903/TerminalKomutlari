package hsmnzaydn.serkanozaydin.net;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Komut;

/**
 * Created by hsmnzaydn on 17.06.2017.
 */

public class Veritabanı extends SQLiteOpenHelper {


    private static final String DATABASE_NAME="komutlar_veritabani";
    private static final String TABLE_NAME="komutlar_tablosu";
    private static final int DATABASE_VERSION=1;

    private static final String BASLIK="komut_basligi";
    private static final String ACIKLAMA="komut_aciklamasi";
    private static final String ID="_id";
    private List<Komut> komutlar =new ArrayList<Komut>();
    private Context context;
    private RecyclerView recyclerView;


    public Veritabanı(Context context,RecyclerView recyclerView) {


        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.setContext(context);
        this.recyclerView=recyclerView;
    }
    public Veritabanı(Context context) {


        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        String tablo_olustur="CREATE TABLE "+TABLE_NAME+
                " ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                BASLIK+" TEXT, "+
                ACIKLAMA+" TEXT);";
        db.execSQL(tablo_olustur);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public void KayitEkle(Komut komut) {

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(BASLIK,komut.getKomutBasligi());
        cv.put(ACIKLAMA,komut.getKomutIslevi());


        db.insert(TABLE_NAME,null,cv);

        db.close();

    }


    public List<Komut> TumKayitlariGetir() {

        SQLiteDatabase db=this.getReadableDatabase();

        String [] sutunlar=new String[]{BASLIK,ACIKLAMA};

        Cursor c=db.query(TABLE_NAME, sutunlar, null, null, null, null, null);
        int basliksirano=c.getColumnIndex(BASLIK);
        int aciklamasirano=c.getColumnIndex(ACIKLAMA);


        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){

            Komut komut=new Komut();

            komut.setKomutBasligi(c.getString(basliksirano));
            komut.setKomutIslevi(c.getString(aciklamasirano));

            komutlar.add(komut);


        }



        db.close();

        return komutlar;


    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
