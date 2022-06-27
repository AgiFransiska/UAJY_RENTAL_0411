package com.hky.atmarental.model.laporanmobilbulanan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Laporanpenyewaanmobilbulanan {
    @SerializedName("tipe_mobil")
    @Expose
    private String tipeMobil;
    @SerializedName("nama_mobil")
    @Expose
    private String namaMobil;
    @SerializedName("jumlah_peminjaman")
    @Expose
    private String jumlahPeminjaman;
    @SerializedName("pendapatan")
    @Expose
    private String pendapatan;

    public Laporanpenyewaanmobilbulanan(String tipeMobil, String namaMobil, String jumlahPeminjaman, String pendapatan) {
        this.tipeMobil = tipeMobil;
        this.namaMobil = namaMobil;
        this.jumlahPeminjaman = jumlahPeminjaman;
        this.pendapatan = pendapatan;
    }

    public String getTipeMobil() {
        return tipeMobil;
    }

    public void setTipeMobil(String tipeMobil) {
        this.tipeMobil = tipeMobil;
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public void setNamaMobil(String namaMobil) {
        this.namaMobil = namaMobil;
    }

    public String getJumlahPeminjaman() {
        return jumlahPeminjaman;
    }

    public void setJumlahPeminjaman(String jumlahPeminjaman) {
        this.jumlahPeminjaman = jumlahPeminjaman;
    }

    public String getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(String pendapatan) {
        this.pendapatan = pendapatan;
    }
}
