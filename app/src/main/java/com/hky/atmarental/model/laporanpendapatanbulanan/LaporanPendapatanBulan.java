package com.hky.atmarental.model.laporanpendapatanbulanan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LaporanPendapatanBulan {
    @SerializedName("nama_customer")
    @Expose
    private String namaCustomer;
    @SerializedName("nama_mobil")
    @Expose
    private String namaMobil;
    @SerializedName("jenis_trx")
    @Expose
    private String jenisTrx;
    @SerializedName("jumlah_transaksi")
    @Expose
    private String jumlahTransaksi;
    @SerializedName("pendapatan")
    @Expose
    private String pendapatan;

    public LaporanPendapatanBulan(String namaCustomer, String namaMobil, String jenisTrx, String jumlahTransaksi, String pendapatan) {
        this.namaCustomer = namaCustomer;
        this.namaMobil = namaMobil;
        this.jenisTrx = jenisTrx;
        this.jumlahTransaksi = jumlahTransaksi;
        this.pendapatan = pendapatan;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public void setNamaMobil(String namaMobil) {
        this.namaMobil = namaMobil;
    }

    public String getJenisTrx() {
        return jenisTrx;
    }

    public void setJenisTrx(String jenisTrx) {
        this.jenisTrx = jenisTrx;
    }

    public String getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    public void setJumlahTransaksi(String jumlahTransaksi) {
        this.jumlahTransaksi = jumlahTransaksi;
    }

    public String getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(String pendapatan) {
        this.pendapatan = pendapatan;
    }
}
