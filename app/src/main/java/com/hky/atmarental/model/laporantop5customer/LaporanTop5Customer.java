package com.hky.atmarental.model.laporantop5customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LaporanTop5Customer {
    @SerializedName("id_customer")
    @Expose
    private String idCustomer;
    @SerializedName("nama_lengkap")
    @Expose
    private String namaLengkap;
    @SerializedName("jumlah_transaksi")
    @Expose
    private String jumlahTransaksi;

    public LaporanTop5Customer(String idCustomer, String namaLengkap, String jumlahTransaksi) {
        this.idCustomer = idCustomer;
        this.namaLengkap = namaLengkap;
        this.jumlahTransaksi = jumlahTransaksi;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    public void setJumlahTransaksi(String jumlahTransaksi) {
        this.jumlahTransaksi = jumlahTransaksi;
    }
}
