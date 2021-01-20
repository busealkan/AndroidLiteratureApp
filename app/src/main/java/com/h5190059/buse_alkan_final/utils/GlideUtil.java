package com.h5190059.buse_alkan_final.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.h5190059.buse_alkan_final.R;

public class GlideUtil {

    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .error(R.drawable.banner)
                .centerCrop()
                .into(img);
    }
}
