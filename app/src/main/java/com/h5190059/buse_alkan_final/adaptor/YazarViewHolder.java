package com.h5190059.buse_alkan_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190059.buse_alkan_final.R;

public class YazarViewHolder extends RecyclerView.ViewHolder {

    ImageView imgYazar;
    TextView txtYazarAdi;
    TextView txtYazarDogumTarihi;
    TextView txtYazarAciklama;
    TextView txtYazarEser;

    public YazarViewHolder(@NonNull View cardView, YazarAdaptor.OnItemClickListener listener) {
        super(cardView);

        imgYazar =cardView.findViewById(R.id.imgYazarLogo);
        txtYazarAdi =cardView.findViewById(R.id.txtYazarAdi);
        txtYazarDogumTarihi =cardView.findViewById(R.id.txtYazarDogumTarihi);
        txtYazarAciklama =cardView.findViewById(R.id.txtYazarAciklama);
        txtYazarEser =cardView.findViewById(R.id.txtYazarEserler);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClik(getAdapterPosition());
            }
        });
    }
}
