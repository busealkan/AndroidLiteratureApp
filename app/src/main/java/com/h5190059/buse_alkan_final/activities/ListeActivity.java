package com.h5190059.buse_alkan_final.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import com.h5190059.buse_alkan_final.R;
import com.h5190059.buse_alkan_final.adaptor.YazarAdaptor;
import com.h5190059.buse_alkan_final.model.YazarModel;
import com.h5190059.buse_alkan_final.network.Service;
import com.h5190059.buse_alkan_final.utils.AlertUtil;
import com.h5190059.buse_alkan_final.utils.Constants;
import com.h5190059.buse_alkan_final.utils.ObjectUtil;
import com.h5190059.buse_alkan_final.utils.PrefUtil;
import com.h5190059.buse_alkan_final.utils.ProgressUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        init();
    }

    private void init() {
        progressDialog = ProgressUtil.progressDialogOlustur(ListeActivity.this,getResources().getString(R.string.progressMessage));
        yazarlariGetir();
    }


    void yazarlariGetir() {
        new Service().getServiceApi().yazarlariGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<YazarModel>>() {

                    List<YazarModel> yazarlar=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(getResources().getString(R.string.logRetrofit),getResources().getString(R.string.logOnComplete));
                    }

                    @Override
                    public void onNext(List<YazarModel> yazarlarList) {
                        Log.e(getResources().getString(R.string.logRetrofit),getResources().getString(R.string.logOnNext));
                        yazarlar=yazarlarList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e(getResources().getString(R.string.logRetrofit),getResources().getString(R.string.logOnError) + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e(getResources().getString(R.string.logRetrofit),getResources().getString(R.string.logOnComplete));

                        if(yazarlar.size()>0) {

                            initRecycleView(yazarlar);
                        }
                    }
                });
    }

    private  void  initRecycleView(List<YazarModel> yazarlarList) {
        ProgressUtil.progressDialogKapat(progressDialog);
        recyclerView =findViewById(R.id.rcvYazarlar);
        YazarAdaptor yazarAdaptor =new YazarAdaptor(yazarlarList, getApplicationContext(), new YazarAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {
                YazarModel tiklananYazar = yazarlarList.get(position);
                detayEkraniniAc(tiklananYazar);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(yazarAdaptor);
    }

    private void detayEkraniniAc(YazarModel tiklananYazar){
        Intent detayIntent = new Intent(getApplicationContext(), DetayActivity.class);
        String tiklananYazarString = ObjectUtil.yazarToJsonString(tiklananYazar);
        detayIntent.putExtra(Constants.TASINAN_YAZAR_BASLIGI,tiklananYazarString);
        startActivity(detayIntent);
    }

    @Override
    public void onBackPressed() {
        cikisAlert();
    }


    private void cikisAlert(){
        PrefUtil.setStringPref(getApplicationContext(), Constants.PREF_ALERT_SECILEN,Constants.PREF_ALERT_CIKIS);
        AlertUtil.alertGoster(ListeActivity.this, R.style.AlertDialogTheme,getResources().getDrawable(R.drawable.exiticon), getResources().getString(R.string.alertCikisTitle), getResources().getString(R.string.alertCikisMessage), getResources().getString(R.string.alertCikisNegativeButon), getResources().getString(R.string.alertCikisPozitifButon));

    }
}