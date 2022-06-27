package com.hky.atmarental.model.laporantop5customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LaporanTop5CustomerModel {
    @SerializedName("laporantop5customer")
    @Expose
    private List<LaporanTop5Customer> laporantop5customer = null;
    @SerializedName("0")
    @Expose
    private Integer _0;

    public LaporanTop5CustomerModel(List<LaporanTop5Customer> laporantop5customer, Integer _0) {
        this.laporantop5customer = laporantop5customer;
        this._0 = _0;
    }

    public List<LaporanTop5Customer> getLaporantop5customer() {
        return laporantop5customer;
    }

    public void setLaporantop5customer(List<LaporanTop5Customer> laporantop5customer) {
        this.laporantop5customer = laporantop5customer;
    }

    public Integer get_0() {
        return _0;
    }

    public void set_0(Integer _0) {
        this._0 = _0;
    }
}
