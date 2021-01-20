package com.h5190059.buse_alkan_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190059.buse_alkan_final.R;
import com.h5190059.buse_alkan_final.model.YazarModel;
import com.h5190059.buse_alkan_final.utils.Constants;
import com.h5190059.buse_alkan_final.utils.GlideUtil;
import com.h5190059.buse_alkan_final.utils.ObjectUtil;

public class DetayActivity extends AppCompatActivity {
    ImageView imgKapak;
    TextView txtBaslik,txtHayatIcerik,txtEdebiIcerik,txtEserIcerik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        init();
    }

    private void init() {
        imgKapak=findViewById(R.id.imgKapak);
        txtBaslik=findViewById(R.id.txtBaslik);
        txtHayatIcerik=findViewById(R.id.txtHayatIcrk);
        txtEdebiIcerik=findViewById(R.id.txtEdebiIcrk);
        txtEserIcerik=findViewById(R.id.txtEserIcrk);
        yazarBilgileriGetir();
    }

    private void yazarBilgileriGetir() {
        String tasinanYazarString = getIntent().getStringExtra(Constants.TASINAN_YAZAR_BASLIGI);
        YazarModel yazarModel = ObjectUtil.jsonStringToYazar(tasinanYazarString);

        txtBaslik.setText(yazarModel.getYazarAdi());
        txtHayatIcerik.setText(yazarModel.getDetayHayati());
        txtEserIcerik.setText(yazarModel.getYazarEserleri());

        GlideUtil.resmiIndiripGoster(getApplicationContext(),yazarModel.getKapakFotoUrl(),imgKapak);
        htmlDataGetir(yazarModel);
    }


    private void htmlDataGetir(YazarModel yazarModel) {
        String data = yazarModel.getDetayEdebiKisiligi();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {

            txtEdebiIcerik.setText(Html.fromHtml(data,Html.FROM_HTML_MODE_LEGACY));

        } else{

            txtEdebiIcerik.setText(Html.fromHtml(data));
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent listeIntent = new Intent(DetayActivity.this, ListeActivity.class);
        startActivity(listeIntent);
        finish();
    }

}