package hsmnzaydn.serkanozaydin.net;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashScreenActivity extends AwesomeSplash {
    public Boolean first;


    @Override
    public void initSplash(ConfigSplash configSplash) {
       /* you don't have to override every property */

        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.strokeColor); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(2000); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        configSplash.setLogoSplash(R.drawable.icon); //or any other drawable
        configSplash.setAnimLogoSplashDuration(2000); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.ZoomIn); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)


        //Customize Path
        configSplash.setPathSplash(""); //set path String
        configSplash.setOriginalHeight(400); //in relation to your svg (path) resource
        configSplash.setOriginalWidth(400); //in relation to your svg (path) resource
        configSplash.setAnimPathStrokeDrawingDuration(3000);
        configSplash.setPathSplashStrokeSize(3); //I advise value be <5
        configSplash.setPathSplashStrokeColor(R.color.colorAccent); //any color you want form colors.xml
        configSplash.setAnimPathFillingDuration(3000);
        configSplash.setPathSplashFillColor(R.color.colorPrimaryDark); //path object filling color


        //Customize Title
        configSplash.setTitleSplash(getString(R.string.app_name));
        configSplash.setTitleTextColor(R.color.colorPrimaryDark);
        configSplash.setTitleTextSize(30f); //float value
        configSplash.setAnimTitleDuration(3000);
        configSplash.setAnimTitleTechnique(Techniques.RotateInUpRight);
        //   configSplash.setTitleFont("fonts/slimjim.ttf"); //provide string to your font located in assets/fonts/
    }

    @Override
    public void animationsFinished() {
        SharedPreferences app_preferences = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = app_preferences.edit();

        first= app_preferences.getBoolean("first", true);
        if(first) {
            editor.putBoolean("first", false);
            editor.commit();
            Intent intent = new Intent(getApplicationContext(), DilSec.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(getApplicationContext(), DrawerActivity.class);
            startActivity(intent);
        }
        this.finish();
    }
}
