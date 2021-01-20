package com.h5190059.buse_alkan_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.widget.ImageView;

import com.h5190059.buse_alkan_final.R;
import com.h5190059.buse_alkan_final.utils.AlertUtil;
import com.h5190059.buse_alkan_final.utils.NetworkUtil;

public class SplashActivity extends AppCompatActivity {

    ImageView imgBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    private void init() {
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
        DialogInterface.OnClickListener negativeButtonClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();

            }
        };

        DialogInterface.OnClickListener positiveButtonClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                ayarlaraGit();
            }
        };

        AlertUtil.alertGoster(SplashActivity.this,R.style.AlertDialogTheme, getResources().getDrawable(R.drawable.interneticon), getResources().getString(R.string.alertTitle), getResources().getString(R.string.alertMessage), getResources().getString(R.string.alertNegativeButon), getResources().getString(R.string.alertPozitiveButon), positiveButtonClickListener, negativeButtonClickListener);


    }
    private void ayarlaraGit() {
        Intent ayarlarIntent = new Intent(Settings.ACTION_SETTINGS);
        startActivity(ayarlarIntent);
        finish();
    }

    private void secondActivity() {
        Intent listeIntent = new Intent(SplashActivity.this, ListeActivity.class);
        startActivity(listeIntent);
        finish();
    }
}