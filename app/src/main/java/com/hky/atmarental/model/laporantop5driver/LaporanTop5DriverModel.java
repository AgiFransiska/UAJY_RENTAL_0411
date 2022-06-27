package com.hky.atmarental.model.laporantop5driver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LaporanTop5DriverModel {
    @SerializedName("laporantop5driver")
    @Expose
    private List<LaporanTop5Driver> laporantop5driver = null;
    @SerializedName("0")
    @Expose
    private Integer _0;

    public LaporanTop5DriverModel(List<LaporanTop5Driver> laporantop5driver, Integer _0) {
        this.laporantop5driver = laporantop5driver;
        this._0 = _0;
    }

    public List<LaporanTop5Driver> getLaporantop5driver() {
        return laporantop5driver;
    }

    public void setLaporantop5driver(List<LaporanTop5Driver> laporantop5driver) {
        this.laporantop5driver = laporantop5driver;
    }

    public Integer get_0() {
        return _0;
    }

    public void set_0(Integer _0) {
        this._0 = _0;
    }
}
