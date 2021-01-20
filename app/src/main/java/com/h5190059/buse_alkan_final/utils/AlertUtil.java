package com.h5190059.buse_alkan_final.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;


import androidx.appcompat.app.AlertDialog;

public class AlertUtil {
    public static void alertGoster(Context context, int style, Drawable icon, CharSequence title, CharSequence message, CharSequence negativeButton, CharSequence positiveButton, DialogInterface.OnClickListener positiveButtonClickListener, DialogInterface.OnClickListener negativeButtonClickListener){

        AlertDialog.Builder builder = new AlertDialog.Builder(context,style);
        builder.setIcon(icon);
        builder.setTitle(title);
        builder.setMessage(message);

        builder.setNegativeButton(negativeButton, negativeButtonClickListener);
        builder.setPositiveButton(positiveButton, positiveButtonClickListener);
        builder.show();


    }

}
