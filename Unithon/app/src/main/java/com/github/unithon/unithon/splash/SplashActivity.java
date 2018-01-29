package com.github.unithon.unithon.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int DELAY = 1000;

    private static final boolean DEBUG_MAIN = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {
            if(DEBUG_MAIN) {
                final Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, DELAY);
    }
}
