package com.h5190059.buse_alkan_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;

import com.h5190059.buse_alkan_final.R;
import com.h5190059.buse_alkan_final.utils.AlertUtil;
import com.h5190059.buse_alkan_final.utils.Constants;
import com.h5190059.buse_alkan_final.utils.NetworkUtil;
import com.h5190059.buse_alkan_final.utils.PrefUtil;

public class SplashActivity extends AppCompatActivity {

    ImageView imgBackground;
    View viewTrsprnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    private void init() {
        imgBackground= findViewById(R.id.imgLogo);
        viewTrsprnt = findViewById(R.id.viewTrsprnt);
        zamanlayici();
    }

    private void zamanlayici(){
        CountDownTimer countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                internetKontrolEt();
            }
        };
        countDownTimer.start();
    }

    private void internetKontrolEt() {
        if(NetworkUtil.internetVarMi(getApplicationContext()))
        {
            secondActivity();
        }
        else
        {
            internetAlert();
        }
    }

    private void internetAlert(){
        PrefUtil.setStringPref(getApplicationContext(), Constants.PREF_ALERT_SECILEN,Constants.PREF_ALERT_INTERNET);
        AlertUtil.alertGoster(SplashActivity.this,R.style.AlertDialogTheme, getResources().getDrawable(R.drawable.interneticon), getResources().getString(R.string.alertTitle), getResources().getString(R.string.alertMessage), getResources().getString(R.string.alertNegativeButon), getResources().getString(R.string.alertPozitiveButon));
    }

    private void secondActivity() {
        Intent listeIntent = new Intent(SplashActivity.this, ListeActivity.class);
        startActivity(listeIntent);
        finish();
    }
}