package com.hky.atmarental.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class riwayattransaksimodel {
    @SerializedName("riwayattransaksi")
    @Expose
    private List<riwayattransaksi> riwayattransaksi = null;
    @SerializedName("0")
    @Expose
    private Integer _0;

    public riwayattransaksimodel(List<com.hky.atmarental.model.riwayattransaksi> riwayattransaksi, Integer _0) {
        this.riwayattransaksi = riwayattransaksi;
        this._0 = _0;
    }

    public List<com.hky.atmarental.model.riwayattransaksi> getRiwayattransaksi() {
        return riwayattransaksi;
    }

    public void setRiwayattransaksi(List<com.hky.atmarental.model.riwayattransaksi> riwayattransaksi) {
        this.riwayattransaksi = riwayattransaksi;
    }

    public Integer get_0() {
        return _0;
    }

    public void set_0(Integer _0) {
        this._0 = _0;
    }
}
