package com.hky.atmarental.model.brosur;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AsetKendaraan {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("id_mitra")
    @Expose
    private Object idMitra;
    @SerializedName("nama_mobil")
    @Expose
    private String namaMobil;
    @SerializedName("tipe_mobil")
    @Expose
    private String tipeMobil;
    @SerializedName("jenis_transmisi")
    @Expose
    private String jenisTransmisi;
    @SerializedName("jenis_bahan_bakar")
    @Expose
    private String jenisBahanBakar;
    @SerializedName("volume_bahan_bakar")
    @Expose
    private String volumeBahanBakar;
    @SerializedName("warna_mobil")
    @Expose
    private String warnaMobil;
    @SerializedName("kapasitas_mobil")
    @Expose
    private String kapasitasMobil;
    @SerializedName("fasilitas_mobil")
    @Expose
    private String fasilitasMobil;
    @SerializedName("plat_nomor")
    @Expose
    private String platNomor;
    @SerializedName("no_stnk")
    @Expose
    private String noStnk;
    @SerializedName("kategori_aset")
    @Expose
    private String kategoriAset;
    @SerializedName("tgl_service_terakhir")
    @Expose
    private String tglServiceTerakhir;
    @SerializedName("status_ketersediaan_mobil")
    @Expose
    private String statusKetersediaanMobil;
    @SerializedName("biaya_sewa")
    @Expose
    private String biayaSewa;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public AsetKendaraan(String id, Object idMitra, String namaMobil, String tipeMobil, String jenisTransmisi, String jenisBahanBakar, String volumeBahanBakar, String warnaMobil, String kapasitasMobil, String fasilitasMobil, String platNomor, String noStnk, String kategoriAset, String tglServiceTerakhir, String statusKetersediaanMobil, String biayaSewa, String createdAt, String updatedAt) {
        this.id = id;
        this.idMitra = idMitra;
        this.namaMobil = namaMobil;
        this.tipeMobil = tipeMobil;
        this.jenisTransmisi = jenisTransmisi;
        this.jenisBahanBakar = jenisBahanBakar;
        this.volumeBahanBakar = volumeBahanBakar;
        this.warnaMobil = warnaMobil;
        this.kapasitasMobil = kapasitasMobil;
        this.fasilitasMobil = fasilitasMobil;
        this.platNomor = platNomor;
        this.noStnk = noStnk;
        this.kategoriAset = kategoriAset;
        this.tglServiceTerakhir = tglServiceTerakhir;
        this.statusKetersediaanMobil = statusKetersediaanMobil;
        this.biayaSewa = biayaSewa;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getIdMitra() {
        return idMitra;
    }

    public void setIdMitra(Object idMitra) {
        this.idMitra = idMitra;
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public void setNamaMobil(String namaMobil) {
        this.namaMobil = namaMobil;
    }

    public String getTipeMobil() {
        return tipeMobil;
    }

    public void setTipeMobil(String tipeMobil) {
        this.tipeMobil = tipeMobil;
    }

    public String getJenisTransmisi() {
        return jenisTransmisi;
    }

    public void setJenisTransmisi(String jenisTransmisi) {
        this.jenisTransmisi = jenisTransmisi;
    }

    public String getJenisBahanBakar() {
        return jenisBahanBakar;
    }

    public void setJenisBahanBakar(String jenisBahanBakar) {
        this.jenisBahanBakar = jenisBahanBakar;
    }

    public String getVolumeBahanBakar() {
        return volumeBahanBakar;
    }

    public void setVolumeBahanBakar(String volumeBahanBakar) {
        this.volumeBahanBakar = volumeBahanBakar;
    }

    public String getWarnaMobil() {
        return warnaMobil;
    }

    public void setWarnaMobil(String warnaMobil) {
        this.warnaMobil = warnaMobil;
    }

    public String getKapasitasMobil() {
        return kapasitasMobil;
    }

    public void setKapasitasMobil(String kapasitasMobil) {
        this.kapasitasMobil = kapasitasMobil;
    }

    public String getFasilitasMobil() {
        return fasilitasMobil;
    }

    public void setFasilitasMobil(String fasilitasMobil) {
        this.fasilitasMobil = fasilitasMobil;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public String getNoStnk() {
        return noStnk;
    }

    public void setNoStnk(String noStnk) {
        this.noStnk = noStnk;
    }

    public String getKategoriAset() {
        return kategoriAset;
    }

    public void setKategoriAset(String kategoriAset) {
        this.kategoriAset = kategoriAset;
    }

    public String getTglServiceTerakhir() {
        return tglServiceTerakhir;
    }

    public void setTglServiceTerakhir(String tglServiceTerakhir) {
        this.tglServiceTerakhir = tglServiceTerakhir;
    }

    public String getStatusKetersediaanMobil() {
        return statusKetersediaanMobil;
    }

    public void setStatusKetersediaanMobil(String statusKetersediaanMobil) {
        this.statusKetersediaanMobil = statusKetersediaanMobil;
    }

    public String getBiayaSewa() {
        return biayaSewa;
    }

    public void setBiayaSewa(String biayaSewa) {
        this.biayaSewa = biayaSewa;
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
