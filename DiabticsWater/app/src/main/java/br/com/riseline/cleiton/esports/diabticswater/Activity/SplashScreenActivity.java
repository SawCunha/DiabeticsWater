package br.com.riseline.cleiton.esports.diabticswater.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import br.com.riseline.cleiton.esports.diabticswater.R;
import br.com.riseline.cleiton.esports.diabticswater.Util.SharedDiabtics;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        _initApp();

    }

    private void _initApp() {
        new Handler().postDelayed(() -> {
            if(SharedDiabtics.getApresentacao(this)){
                startActivity(new Intent(this,MainActivity.class));
            }else{
                startActivity(new Intent(this,IntroActivity.class));
            }
        },1000);
    }

}
