package com.hky.atmarental.model.laporanpendapatanbulanan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LaporanPendapatanBulananModel {
    @SerializedName("laporanpendapatanbulan")
    @Expose
    private List<LaporanPendapatanBulan> laporanpendapatanbulan = null;
    @SerializedName("0")
    @Expose
    private Integer _0;

    public LaporanPendapatanBulananModel(List<LaporanPendapatanBulan> laporanpendapatanbulan, Integer _0) {
        this.laporanpendapatanbulan = laporanpendapatanbulan;
        this._0 = _0;
    }

    public List<LaporanPendapatanBulan> getLaporanpendapatanbulan() {
        return laporanpendapatanbulan;
    }

    public void setLaporanpendapatanbulan(List<LaporanPendapatanBulan> laporanpendapatanbulan) {
        this.laporanpendapatanbulan = laporanpendapatanbulan;
    }

    public Integer get_0() {
        return _0;
    }

    public void set_0(Integer _0) {
        this._0 = _0;
    }
}
