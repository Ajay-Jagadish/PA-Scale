package app.quiz.thecreator.com.samplequiz.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import app.quiz.thecreator.com.samplequiz.R;

/**
 * Created by Darshan on 09-05-2016.
 */
public class SplashScreenActivity extends Activity {

    // Duration for the splashscreen to display
    private static int TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashScreenActivity.this, GuestActivity.class);
                startActivity(i);

                finish();
            }
        }, TIME);

    }
}
