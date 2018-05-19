package capitalcryptoworld.capitalworld.com.hajjapp.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import capitalcryptoworld.capitalworld.com.hajjapp.R;

public class SplashActivity extends Activity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    SharedPreferences spref;
    static String filename="my personal file";
    public static final String Value = "could not load data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            /*
             * Showing splashscreen screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
            @Override
            public void run() {

                spref=getSharedPreferences(filename, Context.MODE_PRIVATE);//this file only aceess your app

                int type=spref.getInt("Shared Data",23);
                Log.d("value",type+"");


                if (type == 23 ) {
                    startActivity(new Intent(getApplicationContext(), Login.class));
                    finish();


                }
                else if(type == 32){
                    startActivity(new Intent(getApplicationContext(), AdminDashboard.class));

                }



            }
        }, SPLASH_TIME_OUT);



    }






}
