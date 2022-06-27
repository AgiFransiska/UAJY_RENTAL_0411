package com.hky.atmarental.model.promo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Promo {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("kode_promo")
    @Expose
    private String kodePromo;
    @SerializedName("jenis_promo")
    @Expose
    private String jenisPromo;
    @SerializedName("diskon")
    @Expose
    private String diskon;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
    @SerializedName("status_promo")
    @Expose
    private String statusPromo;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;

    public Promo(String id, String kodePromo, String jenisPromo, String diskon, String keterangan, String statusPromo, Object createdAt, Object updatedAt) {
        this.id = id;
        this.kodePromo = kodePromo;
        this.jenisPromo = jenisPromo;
        this.diskon = diskon;
        this.keterangan = keterangan;
        this.statusPromo = statusPromo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKodePromo() {
        return kodePromo;
    }

    public void setKodePromo(String kodePromo) {
        this.kodePromo = kodePromo;
    }

    public String getJenisPromo() {
        return jenisPromo;
    }

    public void setJenisPromo(String jenisPromo) {
        this.jenisPromo = jenisPromo;
    }

    public String getDiskon() {
        return diskon;
    }

    public void setDiskon(String diskon) {
        this.diskon = diskon;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getStatusPromo() {
        return statusPromo;
    }

    public void setStatusPromo(String statusPromo) {
        this.statusPromo = statusPromo;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }
}
