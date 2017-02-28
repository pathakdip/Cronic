package pathak.com.cronic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Dip on 2/20/2017.
 */

public class SplashActivity extends Activity {

   private static  int Splash_time_out=3000;

   @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent=new Intent(SplashActivity.this,MainActivity.class);
               startActivity(intent);
               finish();
           }
       },Splash_time_out);
    }
}
