package com.h5190059.buse_alkan_final.network;

import com.h5190059.buse_alkan_final.model.YazarModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //
    @GET("ServetiFununDonemi.json")
    Observable<List<YazarModel>> yazarlariGetir();
}
