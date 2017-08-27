package hsmnzaydn.serkanozaydin.net;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DilSec extends AppCompatActivity {
    private ImageButton turkey,eng;
    public Boolean turkish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dil_sec);

        init();


        SharedPreferences app_preferences = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        final SharedPreferences.Editor editor = app_preferences.edit();

        turkish = app_preferences.getBoolean("language", true);
        turkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("language", true);
                editor.commit();
                Intent intent=new Intent(DilSec.this,DrawerActivity.class);
                startActivity(intent);

            }
        });

        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("language", false);
                editor.commit();
                Intent intent=new Intent(DilSec.this,DrawerActivity.class);
                startActivity(intent);

            }
        });


        editor.commit();


    }

    public void init(){
        turkey= (ImageButton) findViewById(R.id.fragment_dil_secimi_turkey_flag_IMGBUTTON);
        eng= (ImageButton) findViewById(R.id.fragment_dil_secimi_eng_flag_IMGBUTTON);

    }
}
