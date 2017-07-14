package hsmnzaydn.serkanozaydin.net;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;

import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import hsmnzaydn.serkanozaydin.net.Fragment.KategoriReycliviewFragment;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.Komut;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
private FragmentManager fragmentManager;
    private AdView mAdView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        KategoriReycliviewFragment fragment=new KategoriReycliviewFragment();
        transaction.replace(R.id.container,fragment,"deneme");
        transaction.commit();


        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.setDrawerIndicatorEnabled(false);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.navigatorapp, getApplicationContext().getTheme());
        toggle.setHomeAsUpIndicator(drawable);

        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });



        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {

            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.drawer,menu);


        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.other) {
            final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=hüseyin serkan özaydin&hl=tr")));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=h%C3%BCseyin%20serkan%20%C3%B6zaydin&hl=tr")));
            }        } else if (id == R.id.bana_ulas) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/html");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "serkan.zaydn@gmail.com" });
            intent.putExtra(Intent.EXTRA_SUBJECT, "Terminal Komutları Mail");
            intent.putExtra(Intent.EXTRA_TEXT, "");
            startActivity(Intent.createChooser(intent, "Send Email"));

        }else if (id == R.id.nav_share) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);

            shareIntent.setType("text/plain");

            shareIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=hsmnzaydn.serkanozaydin.net");

            startActivity(Intent.createChooser(shareIntent, "Terminal komutları"));

        }
        else if (id == R.id.ekle) {
            AlertDialog.Builder yerelKomut=new AlertDialog.Builder(DrawerActivity.this);
            View mView=getLayoutInflater().inflate(R.layout.dialog_yerel_komut_ekle,null);
            final EditText yerelBaslik= (EditText) mView.findViewById(R.id.dialog_yerel_komut_ekle_baslik);
            final EditText yerelAciklama= (EditText) mView.findViewById(R.id.dialog_yerel_komut_ekle_aciklama);
            Button yerelEkle= (Button) mView.findViewById(R.id.dialog_yerel_komut_ekle);

            yerelKomut.setView(mView);
            final AlertDialog dialog=yerelKomut.create();
            dialog.show();
            yerelEkle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String baslik=yerelBaslik.getText().toString();
                    String icerik=yerelAciklama.getText().toString();

                    Veritabanı db=new Veritabanı(getApplicationContext());
                    db.KayitEkle(new Komut(baslik,icerik));
                    Toast.makeText(getApplicationContext(),"Komutunuz eklendi",Toast.LENGTH_SHORT).show();

                    dialog.cancel();
                }
            });



        }
        else if (id == R.id.online_ekle) {
            AlertDialog.Builder yerelOnlineKomut=new AlertDialog.Builder(DrawerActivity.this);
            View mViewOnline=getLayoutInflater().inflate(R.layout.dialog_online_komut_ekle,null);
            final EditText onlineBaslik= (EditText) mViewOnline.findViewById(R.id.dialog_online_komut_ekle_baslik);
            final EditText onlineAciklama= (EditText) mViewOnline.findViewById(R.id.dialog_online_komut_ekle_aciklama);
            final EditText onlineKategori= (EditText) mViewOnline.findViewById(R.id.dialog_online_komut_ekle_kategori);

            Button onlineEkle= (Button) mViewOnline.findViewById(R.id.dialog_online_komut_ekle);

            yerelOnlineKomut.setView(mViewOnline);
            final AlertDialog dialogOnline=yerelOnlineKomut.create();
            dialogOnline.show();
            onlineEkle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MysqlConnect connect=new MysqlConnect(getApplicationContext());
                    String komut=onlineBaslik.getText().toString();
                    String aciklama=onlineAciklama.getText().toString();
                    String kategori=onlineKategori.getText().toString();

                    if(!komut.trim().equals("") && !aciklama.trim().equals("") && !kategori.trim().equals("")){
                        connect.VeriKaydet(komut,aciklama,kategori);
                        Toast.makeText(getApplicationContext(),"Komutunuz gönderildi",Toast.LENGTH_SHORT).show();

                        dialogOnline.cancel();


                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Lütfen tüm alanları doldurun",Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        else if (id == R.id.oyla) {
            Uri uri = Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);

            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + getApplication().getPackageName())));
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }







}
