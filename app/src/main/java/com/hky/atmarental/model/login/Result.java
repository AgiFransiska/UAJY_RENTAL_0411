package com.hky.atmarental.model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("id_role")
    @Expose
    private String idRole;
    @SerializedName("nama_pegawai")
    @Expose
    private String namaPegawai;
    @SerializedName("alamat_pegawai")
    @Expose
    private String alamatPegawai;
    @SerializedName("tgl_lahir_pegawai")
    @Expose
    private String tglLahirPegawai;
    @SerializedName("jenis_kelamin_pegawai")
    @Expose
    private String jenisKelaminPegawai;
    @SerializedName("email_pegawai")
    @Expose
    private String emailPegawai;
    @SerializedName("no_telp_pegawai")
    @Expose
    private String noTelpPegawai;
    @SerializedName("password_pegawai")
    @Expose
    private String passwordPegawai;
    @SerializedName("foto_pegawai")
    @Expose
    private String fotoPegawai;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Result(String id, String idRole, String namaPegawai, String alamatPegawai, String tglLahirPegawai, String jenisKelaminPegawai, String emailPegawai, String noTelpPegawai, String passwordPegawai, String fotoPegawai, String createdAt, String updatedAt) {
        this.id = id;
        this.idRole = idRole;
        this.namaPegawai = namaPegawai;
        this.alamatPegawai = alamatPegawai;
        this.tglLahirPegawai = tglLahirPegawai;
        this.jenisKelaminPegawai = jenisKelaminPegawai;
        this.emailPegawai = emailPegawai;
        this.noTelpPegawai = noTelpPegawai;
        this.passwordPegawai = passwordPegawai;
        this.fotoPegawai = fotoPegawai;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public String getNamaPegawai() {
        return namaPegawai;
    }

    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }

    public String getAlamatPegawai() {
        return alamatPegawai;
    }

    public void setAlamatPegawai(String alamatPegawai) {
        this.alamatPegawai = alamatPegawai;
    }

    public String getTglLahirPegawai() {
        return tglLahirPegawai;
    }

    public void setTglLahirPegawai(String tglLahirPegawai) {
        this.tglLahirPegawai = tglLahirPegawai;
    }

    public String getJenisKelaminPegawai() {
        return jenisKelaminPegawai;
    }

    public void setJenisKelaminPegawai(String jenisKelaminPegawai) {
        this.jenisKelaminPegawai = jenisKelaminPegawai;
    }

    public String getEmailPegawai() {
        return emailPegawai;
    }

    public void setEmailPegawai(String emailPegawai) {
        this.emailPegawai = emailPegawai;
    }

    public String getNoTelpPegawai() {
        return noTelpPegawai;
    }

    public void setNoTelpPegawai(String noTelpPegawai) {
        this.noTelpPegawai = noTelpPegawai;
    }

    public String getPasswordPegawai() {
        return passwordPegawai;
    }

    public void setPasswordPegawai(String passwordPegawai) {
        this.passwordPegawai = passwordPegawai;
    }

    public String getFotoPegawai() {
        return fotoPegawai;
    }

    public void setFotoPegawai(String fotoPegawai) {
        this.fotoPegawai = fotoPegawai;
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
