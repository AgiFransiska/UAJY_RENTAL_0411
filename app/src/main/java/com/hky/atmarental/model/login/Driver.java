package com.hky.atmarental.model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Driver {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama_driver")
    @Expose
    private String namaDriver;
    @SerializedName("alamat_driver")
    @Expose
    private String alamatDriver;
    @SerializedName("tgl_lahir_driver")
    @Expose
    private String tglLahirDriver;
    @SerializedName("jenis_kelamin_driver")
    @Expose
    private String jenisKelaminDriver;
    @SerializedName("no_telp_driver")
    @Expose
    private String noTelpDriver;
    @SerializedName("email_driver")
    @Expose
    private String emailDriver;
    @SerializedName("password_driver")
    @Expose
    private String passwordDriver;
    @SerializedName("status_tersedia_driver")
    @Expose
    private String statusTersediaDriver;
    @SerializedName("bahasa")
    @Expose
    private String bahasa;
    @SerializedName("file_pdf")
    @Expose
    private String filePdf;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Driver(String id, String namaDriver, String alamatDriver, String tglLahirDriver, String jenisKelaminDriver, String noTelpDriver, String emailDriver, String passwordDriver, String statusTersediaDriver, String bahasa, String filePdf, String createdAt, String updatedAt) {
        this.id = id;
        this.namaDriver = namaDriver;
        this.alamatDriver = alamatDriver;
        this.tglLahirDriver = tglLahirDriver;
        this.jenisKelaminDriver = jenisKelaminDriver;
        this.noTelpDriver = noTelpDriver;
        this.emailDriver = emailDriver;
        this.passwordDriver = passwordDriver;
        this.statusTersediaDriver = statusTersediaDriver;
        this.bahasa = bahasa;
        this.filePdf = filePdf;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaDriver() {
        return namaDriver;
    }

    public void setNamaDriver(String namaDriver) {
        this.namaDriver = namaDriver;
    }

    public String getAlamatDriver() {
        return alamatDriver;
    }

    public void setAlamatDriver(String alamatDriver) {
        this.alamatDriver = alamatDriver;
    }

    public String getTglLahirDriver() {
        return tglLahirDriver;
    }

    public void setTglLahirDriver(String tglLahirDriver) {
        this.tglLahirDriver = tglLahirDriver;
    }

    public String getJenisKelaminDriver() {
        return jenisKelaminDriver;
    }

    public void setJenisKelaminDriver(String jenisKelaminDriver) {
        this.jenisKelaminDriver = jenisKelaminDriver;
    }

    public String getNoTelpDriver() {
        return noTelpDriver;
    }

    public void setNoTelpDriver(String noTelpDriver) {
        this.noTelpDriver = noTelpDriver;
    }

    public String getEmailDriver() {
        return emailDriver;
    }

    public void setEmailDriver(String emailDriver) {
        this.emailDriver = emailDriver;
    }

    public String getPasswordDriver() {
        return passwordDriver;
    }

    public void setPasswordDriver(String passwordDriver) {
        this.passwordDriver = passwordDriver;
    }

    public String getStatusTersediaDriver() {
        return statusTersediaDriver;
    }

    public void setStatusTersediaDriver(String statusTersediaDriver) {
        this.statusTersediaDriver = statusTersediaDriver;
    }

    public String getBahasa() {
        return bahasa;
    }

    public void setBahasa(String bahasa) {
        this.bahasa = bahasa;
    }

    public String getFilePdf() {
        return filePdf;
    }

    public void setFilePdf(String filePdf) {
        this.filePdf = filePdf;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
