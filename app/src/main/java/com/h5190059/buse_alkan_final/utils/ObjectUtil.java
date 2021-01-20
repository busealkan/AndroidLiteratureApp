package com.h5190059.buse_alkan_final.utils;

import com.google.gson.Gson;
import com.h5190059.buse_alkan_final.model.YazarModel;

public class ObjectUtil {

    public  static String yazarToJsonString(YazarModel yazarModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(yazarModel);
    }

    public  static YazarModel jsonStringToYazar(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,YazarModel.class);
    }
}
