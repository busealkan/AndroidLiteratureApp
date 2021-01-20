package com.h5190059.buse_alkan_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YazarModel {

    @SerializedName("YazarAdi")
    @Expose
    private String yazarAdi;
    @SerializedName("YazarDogumTarihi")
    @Expose
    private String yazarDogumTarihi;
    @SerializedName("YazarAciklama")
    @Expose
    private String yazarAciklama;
    @SerializedName("YazarEserleri")
    @Expose
    private String yazarEserleri;
    @SerializedName("KapakFotoUrl")
    @Expose
    private String kapakFotoUrl;
    @SerializedName("KucukLogoUrl")
    @Expose
    private String kucukLogoUrl;
    @SerializedName("DetayHayati")
    @Expose
    private String detayHayati;
    @SerializedName("DetayEdebiKisiligi")
    @Expose
    private String detayEdebiKisiligi;
    @SerializedName("DetayEserleri")
    @Expose
    private String detayEserleri;

    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    public String getYazarDogumTarihi() {
        return yazarDogumTarihi;
    }

    public void setYazarDogumTarihi(String yazarDogumTarihi) {
        this.yazarDogumTarihi = yazarDogumTarihi;
    }

    public String getYazarAciklama() {
        return yazarAciklama;
    }

    public void setYazarAciklama(String yazarAciklama) {
        this.yazarAciklama = yazarAciklama;
    }

    public String getYazarEserleri() {
        return yazarEserleri;
    }

    public void setYazarEserleri(String yazarEserleri) {
        this.yazarEserleri = yazarEserleri;
    }

    public String getKapakFotoUrl() {
        return kapakFotoUrl;
    }

    public void setKapakFotoUrl(String kapakFotoUrl) {
        this.kapakFotoUrl = kapakFotoUrl;
    }

    public String getKucukLogoUrl() {
        return kucukLogoUrl;
    }

    public void setKucukLogoUrl(String kucukLogoUrl) {
        this.kucukLogoUrl = kucukLogoUrl;
    }

    public String getDetayHayati() {
        return detayHayati;
    }

    public void setDetayHayati(String detayHayati) {
        this.detayHayati = detayHayati;
    }

    public String getDetayEdebiKisiligi() {
        return detayEdebiKisiligi;
    }

    public void setDetayEdebiKisiligi(String detayEdebiKisiligi) {
        this.detayEdebiKisiligi = detayEdebiKisiligi;
    }

    public String getDetayEserleri() {
        return detayEserleri;
    }

    public void setDetayEserleri(String detayEserleri) {
        this.detayEserleri = detayEserleri;
    }

}
