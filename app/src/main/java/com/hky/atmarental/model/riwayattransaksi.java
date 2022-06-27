package com.hky.atmarental.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class riwayattransaksi {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("id_customer")
    @Expose
    private String idCustomer;
    @SerializedName("id_pegawai")
    @Expose
    private String idPegawai;
    @SerializedName("id_aset")
    @Expose
    private Object idAset;
    @SerializedName("id_driver")
    @Expose
    private String idDriver;
    @SerializedName("no_ktp")
    @Expose
    private String noKtp;
    @SerializedName("no_sim")
    @Expose
    private String noSim;
    @SerializedName("tanggal_transaksi")
    @Expose
    private String tanggalTransaksi;
    @SerializedName("tanggal_mulai_sewa")
    @Expose
    private String tanggalMulaiSewa;
    @SerializedName("tanggal_akhir_sewa")
    @Expose
    private String tanggalAkhirSewa;
    @SerializedName("metode_pembayaran")
    @Expose
    private String metodePembayaran;
    @SerializedName("ekstensi_biaya")
    @Expose
    private String ekstensiBiaya;
    @SerializedName("total_biaya_sewa")
    @Expose
    private String totalBiayaSewa;
    @SerializedName("status_transaksi")
    @Expose
    private String statusTransaksi;
    @SerializedName("status_verifikasi")
    @Expose
    private String statusVerifikasi;
    @SerializedName("rating_driver")
    @Expose
    private String ratingDriver;
    @SerializedName("kode_promo")
    @Expose
    private String kodePromo;
    @SerializedName("jenis_transaksi")
    @Expose
    private String jenisTransaksi;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    boolean visibility;

    public riwayattransaksi(String id, String idCustomer, String idPegawai, Object idAset, String idDriver, String noKtp, String noSim, String tanggalTransaksi, String tanggalMulaiSewa, String tanggalAkhirSewa, String metodePembayaran, String ekstensiBiaya, String totalBiayaSewa, String statusTransaksi, String statusVerifikasi, String ratingDriver, String kodePromo, String jenisTransaksi, String createdAt, String updatedAt, boolean visibility) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.idPegawai = idPegawai;
        this.idAset = idAset;
        this.idDriver = idDriver;
        this.noKtp = noKtp;
        this.noSim = noSim;
        this.tanggalTransaksi = tanggalTransaksi;
        this.tanggalMulaiSewa = tanggalMulaiSewa;
        this.tanggalAkhirSewa = tanggalAkhirSewa;
        this.metodePembayaran = metodePembayaran;
        this.ekstensiBiaya = ekstensiBiaya;
        this.totalBiayaSewa = totalBiayaSewa;
        this.statusTransaksi = statusTransaksi;
        this.statusVerifikasi = statusVerifikasi;
        this.ratingDriver = ratingDriver;
        this.kodePromo = kodePromo;
        this.jenisTransaksi = jenisTransaksi;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.visibility = visibility;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public Object getIdAset() {
        return idAset;
    }

    public void setIdAset(Object idAset) {
        this.idAset = idAset;
    }

    public String getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(String idDriver) {
        this.idDriver = idDriver;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public String getNoSim() {
        return noSim;
    }

    public void setNoSim(String noSim) {
        this.noSim = noSim;
    }

    public String getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(String tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public String getTanggalMulaiSewa() {
        return tanggalMulaiSewa;
    }

    public void setTanggalMulaiSewa(String tanggalMulaiSewa) {
        this.tanggalMulaiSewa = tanggalMulaiSewa;
    }

    public String getTanggalAkhirSewa() {
        return tanggalAkhirSewa;
    }

    public void setTanggalAkhirSewa(String tanggalAkhirSewa) {
        this.tanggalAkhirSewa = tanggalAkhirSewa;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public String getEkstensiBiaya() {
        return ekstensiBiaya;
    }

    public void setEkstensiBiaya(String ekstensiBiaya) {
        this.ekstensiBiaya = ekstensiBiaya;
    }

    public String getTotalBiayaSewa() {
        return totalBiayaSewa;
    }

    public void setTotalBiayaSewa(String totalBiayaSewa) {
        this.totalBiayaSewa = totalBiayaSewa;
    }

    public String getStatusTransaksi() {
        return statusTransaksi;
    }

    public void setStatusTransaksi(String statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
    }

    public String getStatusVerifikasi() {
        return statusVerifikasi;
    }

    public void setStatusVerifikasi(String statusVerifikasi) {
        this.statusVerifikasi = statusVerifikasi;
    }

    public String getRatingDriver() {
        return ratingDriver;
    }

    public void setRatingDriver(String ratingDriver) {
        this.ratingDriver = ratingDriver;
    }

    public String getKodePromo() {
        return kodePromo;
    }

    public void setKodePromo(String kodePromo) {
        this.kodePromo = kodePromo;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
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

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}
