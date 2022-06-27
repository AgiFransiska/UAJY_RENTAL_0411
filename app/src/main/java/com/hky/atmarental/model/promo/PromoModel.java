package com.hky.atmarental.model.promo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PromoModel {
    @SerializedName("promo")
    @Expose
    private List<Promo> promo = null;
    @SerializedName("0")
    @Expose
    private Integer _0;

    public PromoModel(List<Promo> promo, Integer _0) {
        this.promo = promo;
        this._0 = _0;
    }

    public List<Promo> getPromo() {
        return promo;
    }

    public void setPromo(List<Promo> promo) {
        this.promo = promo;
    }

    public Integer get_0() {
        return _0;
    }

    public void set_0(Integer _0) {
        this._0 = _0;
    }
}
