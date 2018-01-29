package com.github.unithon.unithon.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.github.unithon.unithon.R;
import com.github.unithon.unithon.main.MainActivity;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;

public class LoginActivity extends AppCompatActivity {

    //naver object
    private OAuthLogin mOAuthLoginModule;
    private TextView txt;

    private String OAUTH_CLIENT_ID = "_53BfKoZbCkF93nnHWe9";
    private String OAUTH_CLIENT_SECRET = "BOB67y3xb1";

    // have to change letters
    private String OAUTH_CLIENT_NAME = "LLogingggggggt";

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
          //      WindowManager.LayoutParams.FLAG_FULLSCREEN);



        setContentView(R.layout.activity_login);

        mOAuthLoginModule = OAuthLogin.getInstance();
        mOAuthLoginModule.init(
                LoginActivity.this
                , OAUTH_CLIENT_ID
                , OAUTH_CLIENT_SECRET
                , OAUTH_CLIENT_NAME
        );

        OAuthLoginButton mOAuthLoginButton = (OAuthLoginButton) findViewById(R.id.buttonOAuthLogin);
        mOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);

        //txt = (TextView)findViewById(R.id.textView);
        //OAuthLogin.logoutAndDeleteToken();
    }


    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if(success) {
                Intent goMain = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(goMain);

                //Toast.makeText(MainActivity.this, "login success", Toast.LENGTH_SHORT).show();
                //로그인 성공시 처리해야 할것들
                //intent
                //json or xml파싱
                //
            }

        };
    };
}
