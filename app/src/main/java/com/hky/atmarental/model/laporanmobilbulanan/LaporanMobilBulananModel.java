package com.hky.atmarental.model.laporanmobilbulanan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LaporanMobilBulananModel {
    @SerializedName("laporanpenyewaanmobilbulanan")
    @Expose
    private List<Laporanpenyewaanmobilbulanan> laporanpenyewaanmobilbulanan = null;
    @SerializedName("0")
    @Expose
    private Integer _0;

    public LaporanMobilBulananModel(List<Laporanpenyewaanmobilbulanan> laporanpenyewaanmobilbulanan, Integer _0) {
        this.laporanpenyewaanmobilbulanan = laporanpenyewaanmobilbulanan;
        this._0 = _0;
    }

    public List<Laporanpenyewaanmobilbulanan> getLaporanpenyewaanmobilbulanan() {
        return laporanpenyewaanmobilbulanan;
    }

    public void setLaporanpenyewaanmobilbulanan(List<Laporanpenyewaanmobilbulanan> laporanpenyewaanmobilbulanan) {
        this.laporanpenyewaanmobilbulanan = laporanpenyewaanmobilbulanan;
    }

    public Integer get_0() {
        return _0;
    }

    public void set_0(Integer _0) {
        this._0 = _0;
    }
}
