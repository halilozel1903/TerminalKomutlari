package hsmnzaydn.serkanozaydin.net;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {
    private ImageView Icon;
    private Animation dondurme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        Icon= (ImageView) findViewById(R.id.icon);
        dondurme= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.dondurme);
        Icon.startAnimation(dondurme);

        Thread islem=new Thread(){
            public void run(){
                try{
                    sleep(2000);
                    Intent intent=new Intent(SplashScreenActivity.this,DrawerActivity.class);
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    finish();
                }
            }
        };
        islem.start();




    }
}
