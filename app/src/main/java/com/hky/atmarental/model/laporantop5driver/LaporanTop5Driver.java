package com.hky.atmarental.model.laporantop5driver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LaporanTop5Driver {
    @SerializedName("id_driver")
    @Expose
    private String idDriver;
    @SerializedName("nama_driver")
    @Expose
    private String namaDriver;
    @SerializedName("jumlah_transaksi")
    @Expose
    private String jumlahTransaksi;
    @SerializedName("rerata_rating")
    @Expose
    private String rerataRating;

    public LaporanTop5Driver(String idDriver, String namaDriver, String jumlahTransaksi, String rerataRating) {
        this.idDriver = idDriver;
        this.namaDriver = namaDriver;
        this.jumlahTransaksi = jumlahTransaksi;
        this.rerataRating = rerataRating;
    }

    public String getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(String idDriver) {
        this.idDriver = idDriver;
    }

    public String getNamaDriver() {
        return namaDriver;
    }

    public void setNamaDriver(String namaDriver) {
        this.namaDriver = namaDriver;
    }

    public String getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    public void setJumlahTransaksi(String jumlahTransaksi) {
        this.jumlahTransaksi = jumlahTransaksi;
    }

    public String getRerataRating() {
        return rerataRating;
    }

    public void setRerataRating(String rerataRating) {
        this.rerataRating = rerataRating;
    }
}
