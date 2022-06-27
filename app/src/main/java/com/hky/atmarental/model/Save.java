package com.hky.atmarental.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Save {
    @SerializedName("driver")
    @Expose
    private Boolean driver;
    @SerializedName("0")
    @Expose
    private Integer _0;

    public Save(Boolean driver, Integer _0) {
        this.driver = driver;
        this._0 = _0;
    }

    public Boolean getDriver() {
        return driver;
    }

    public void setDriver(Boolean driver) {
        this.driver = driver;
    }

    public Integer get_0() {
        return _0;
    }

    public void set_0(Integer _0) {
        this._0 = _0;
    }
}
