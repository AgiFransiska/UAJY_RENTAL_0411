package com.hky.atmarental.model.brosur;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BrosurModel {
    @SerializedName("asetkendaraan")
    @Expose
    private List<AsetKendaraan> asetkendaraan = null;
    @SerializedName("0")
    @Expose
    private Integer _0;

    public BrosurModel(List<AsetKendaraan> asetkendaraan, Integer _0) {
        this.asetkendaraan = asetkendaraan;
        this._0 = _0;
    }

    public List<AsetKendaraan> getAsetkendaraan() {
        return asetkendaraan;
    }

    public void setAsetkendaraan(List<AsetKendaraan> asetkendaraan) {
        this.asetkendaraan = asetkendaraan;
    }

    public Integer get_0() {
        return _0;
    }

    public void set_0(Integer _0) {
        this._0 = _0;
    }
}
