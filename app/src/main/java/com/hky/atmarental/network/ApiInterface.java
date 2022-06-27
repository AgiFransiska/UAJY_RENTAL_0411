package com.hky.atmarental.network;


import com.hky.atmarental.model.Save;
import com.hky.atmarental.model.brosur.BrosurModel;
import com.hky.atmarental.model.laporanmobilbulanan.LaporanMobilBulananModel;
import com.hky.atmarental.model.laporanpendapatanbulanan.LaporanPendapatanBulananModel;
import com.hky.atmarental.model.laporantop5customer.LaporanTop5CustomerModel;
import com.hky.atmarental.model.laporantop5driver.LaporanTop5DriverModel;
import com.hky.atmarental.model.login.LoginDriverModel;
import com.hky.atmarental.model.login.LoginModel;
import com.hky.atmarental.model.promo.PromoModel;
import com.hky.atmarental.model.riwayattransaksimodel;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {
    //=========================Login=================================//
    @POST("auth/login")
    @FormUrlEncoded
    Call<LoginModel> login(@Field("email") String email,
                           @Field("password") String password);
    //=========================Customer=================================//
    //Get List Riwayat Transaksi
    @POST("customer/tampilriwayatbyid")
    @FormUrlEncoded
    Call<riwayattransaksimodel> getriwayatcustomer(@Field("id_customer") String id_customer);
    //Get List Promo
    @POST("customer/tampilpromo")
    @FormUrlEncoded
    Call<PromoModel> getpromo(@Field("status_promo") String status_promo);
    //Get List Promo Search
    @POST("customer/searchpromo")
    @FormUrlEncoded
    Call<PromoModel> getpromosearch(@Field("status_promo") String status_promo,
                                    @Field("kode_promo") String kode_promo);
    //Get List Brosur
    @POST("customer/tampilbrosur")
    @FormUrlEncoded
    Call<BrosurModel> getbrosur(@Field("status_ketersediaan_mobil") String status_ketersediaan_mobil);
    //Get List Tampil Laporan Top 5 Customer Transaksi Per Bulan
    @GET("customer/tampillaporantop5customer")
    Call<LaporanTop5CustomerModel> gettampiltop5customer();
    //Get List Cari Laporan Top 5 Customer Transaksi Per Bulan
    @POST("customer/carilaporantop5customer")
    @FormUrlEncoded
    Call<LaporanTop5CustomerModel> getcaritop5customer(@Field("bulan") String bulan);
    //=========================Mobil=================================//
    //Get List Tampil Laporan Penyewaan Mobil Per Bulan
    @GET("mobil/tampillaporanpenyewaanmobilperbulan")
    Call<LaporanMobilBulananModel> gettampillaporanpenyewaanmobilperbulan();
    //Get List Cari Laporan Penyewaan Mobil Per Bulan
    @POST("mobil/carilaporanpenyewaanmobilperbulan")
    @FormUrlEncoded
    Call<LaporanMobilBulananModel> getcarilaporanpenyewaanmobilperbulan(@Field("bulan") String bulan);
    //=========================Transaksi=================================//
    //Get List Tampil Laporan Pendapatan Per Bulan
    @GET("transaksi/tampillaporanpendapatanbulan")
    Call<LaporanPendapatanBulananModel> gettampillaporanpendapatanperbulan();
    //Get List Cari Laporan Pendapatan Per Bulan
    @POST("transaksi/carilaporanpendapatanbulan")
    @FormUrlEncoded
    Call<LaporanPendapatanBulananModel> getcarilaporanpendapatanperbulan(@Field("bulan") String bulan);
    //=========================Driver=================================//
    //Get List Tampil  Driver
    @POST("driver/tampildriver")
    @FormUrlEncoded
    Call<LoginDriverModel> gettampildriver(@Field("id") String id);
    //Save  Driver
    @POST("driver/savedriver")
    @FormUrlEncoded
    Call<Save> savedriver(
            @Field("id") String id,
            @Field("nama") String nama,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("notelp") String notelp,
            @Field("status") String status
    );
    //Get List Tampil Laporan Top 5 Driver Transaksi Per Bulan
    @GET("driver/tampillaporantop5driver")
    Call<LaporanTop5DriverModel> gettampiltop5drivertransaksi();
    //Get List Cari Laporan Top 5 Driver Transaksi Per Bulan
    @POST("driver/carilaporantop5driver")
    @FormUrlEncoded
    Call<LaporanTop5DriverModel> getcarilaporantop5drivertransaksi(@Field("bulan") String bulan);
    //Get List Tampil Laporan Perfoma Driver Transaksi Per Bulan
    @GET("driver/tampillaporanperfomadriver")
    Call<LaporanTop5DriverModel> gettampilperfomadriver();
    //Get List Cari Laporan Perfoma Driver Transaksi Per Bulan
    @POST("driver/carilaporanperfomadriver")
    @FormUrlEncoded
    Call<LaporanTop5DriverModel> getcarilaporanperfomadriver(@Field("bulan") String bulan);
}
