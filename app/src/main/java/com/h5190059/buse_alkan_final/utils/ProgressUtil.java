package com.h5190059.buse_alkan_final.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressUtil {
    public static ProgressDialog progressDialogOlustur(Context context, CharSequence message){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.show();
        return progressDialog;
    }

    public static void progressDialogKapat(ProgressDialog progressDialog){
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
