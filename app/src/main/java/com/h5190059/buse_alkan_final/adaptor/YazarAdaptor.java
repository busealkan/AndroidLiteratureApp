package com.h5190059.buse_alkan_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190059.buse_alkan_final.R;
import com.h5190059.buse_alkan_final.model.YazarModel;
import com.h5190059.buse_alkan_final.utils.GlideUtil;

import java.util.List;

public class YazarAdaptor extends RecyclerView.Adapter<YazarViewHolder> {


    List<YazarModel> yazarlar;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClik(int position);
    }


    public YazarAdaptor(List<YazarModel> yazarlar, Context context, OnItemClickListener listener) {
        this.yazarlar = yazarlar;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public YazarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_yazar,parent,false);
        return new YazarViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull YazarViewHolder viewHolder, int position) {

        viewHolder.txtYazarAdi.setText(yazarlar.get(position).getYazarAdi());
        viewHolder.txtYazarDogumTarihi.setText(yazarlar.get(position).getYazarDogumTarihi());
        viewHolder.txtYazarAciklama.setText(yazarlar.get(position).getYazarAciklama());
        viewHolder.txtYazarEser.setText(yazarlar.get(position).getYazarEserleri());
        GlideUtil.resmiIndiripGoster(context,yazarlar.get(position).getKucukLogoUrl(),viewHolder.imgYazar);

    }

    @Override
    public int getItemCount() {
        return yazarlar.size();
    }
}
