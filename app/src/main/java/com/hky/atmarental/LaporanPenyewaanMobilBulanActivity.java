package com.hky.atmarental;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hky.atmarental.adapter.BrosurAdapter;
import com.hky.atmarental.adapter.LaporanPenyewaanMobilBulananAdapter;
import com.hky.atmarental.model.brosur.AsetKendaraan;
import com.hky.atmarental.model.brosur.BrosurModel;
import com.hky.atmarental.model.laporanmobilbulanan.LaporanMobilBulananModel;
import com.hky.atmarental.model.laporanmobilbulanan.Laporanpenyewaanmobilbulanan;
import com.hky.atmarental.network.ApiHelper;
import com.hky.atmarental.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LaporanPenyewaanMobilBulanActivity extends AppCompatActivity {
    TextView txtKembali, txtCari, txtKalimat;
    EditText edtBulan;
    private LaporanPenyewaanMobilBulananAdapter laporanPenyewaanMobilBulananAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporanpenyewaanmobilbulan);
        txtKembali = findViewById(R.id.txtKembali);
        txtKalimat = findViewById(R.id.txtKalimat);
        mRecyclerView = findViewById(R.id.rvBulan);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        txtCari = findViewById(R.id.txtCari);
        edtBulan = findViewById(R.id.edtBulan);
        getLaporanPenyewaanMobilBulanan();
        txtCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edtBulan.getText().toString().equals("")){
                    txtKalimat.setText("Daftar Semua Pemesanan Mobil");
                    getLaporanPenyewaanMobilBulanan();
                }else{
                    int month = Integer.parseInt(edtBulan.getText().toString());
                    if(month<1 || month >12){

                        Toast.makeText(LaporanPenyewaanMobilBulanActivity.this, "Bulan Tidak Valid", Toast.LENGTH_SHORT).show();
                    }else{
                        if(month == 1){
                            txtKalimat.setText("Daftar Semua Pemesanan Mobil Bulan Januari");
                        }else if(month == 2){
                            txtKalimat.setText("Daftar Semua Pemesanan Mobil Bulan Februari");
                        }else if(month == 3){
                            txtKalimat.setText("Daftar Semua Pemesanan Mobil Bulan Maret");
                        }else if(month == 4){
                            txtKalimat.setText("Daftar Semua Pemesanan Mobil Bulan April");
                        }else if(month == 5){
                            txtKalimat.setText("Daftar Semua Pemesanan Mobil Bulan Mei");
                        }else if(month == 6){
                            txtKalimat.setText("Daftar Semua Pemesanan Mobil Bulan Juni");
                        }else if(month == 7){
                            txtKalimat.setText("Daftar Semua Pemesanan Mobil Bulan Juli");
                        }else if(month == 8){
                            txtKalimat.setText("Daftar Semua Pemesanan Mobil Bulan Agustus");
                        }else if(month == 9){
                            txtKalimat.setText("Daftar Semua Pemesanan Mobil Bulan September");
                        }else if(month == 10){
                            txtKalimat.setText("Daftar Semua Pemesanan Mobil Bulan Oktober");
                        }else if(month == 11){
                            txtKalimat.setText("Daftar Semua Pemesanan Mobil Bulan November");
                        }else if(month == 12){
                            txtKalimat.setText("Daftar Semua Pemesanan Mobil Bulan Desember");
                        }else{
                            txtKalimat.setText("Daftar Semua Pemesanan Mobil");
                        }
                        getCariLaporanPenyewaanBulanan(edtBulan.getText().toString());
                    }
                }

            }
        });
        txtKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LaporanPenyewaanMobilBulanActivity.this, ManagerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getCariLaporanPenyewaanBulanan(String bulan) {
        ApiInterface apiInterface = ApiHelper.getClient().create(ApiInterface.class);
        Call<LaporanMobilBulananModel> laporanMobilBulananModelCall = apiInterface.getcarilaporanpenyewaanmobilperbulan(bulan);
        laporanMobilBulananModelCall.enqueue(new Callback<LaporanMobilBulananModel>() {
            @Override
            public void onResponse(Call<LaporanMobilBulananModel> call, Response<LaporanMobilBulananModel> response) {

                if(response.isSuccessful()){
                    List<Laporanpenyewaanmobilbulanan> laporanpenyewaanmobilbulanan = response.body().getLaporanpenyewaanmobilbulanan();
                    laporanPenyewaanMobilBulananAdapter = new LaporanPenyewaanMobilBulananAdapter(laporanpenyewaanmobilbulanan);
                    mRecyclerView.setAdapter(laporanPenyewaanMobilBulananAdapter);
                }else{
                    Toast.makeText(LaporanPenyewaanMobilBulanActivity.this, "Gagal "+response.message().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LaporanMobilBulananModel> call, Throwable t) {
                Toast.makeText(LaporanPenyewaanMobilBulanActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getLaporanPenyewaanMobilBulanan() {
        ApiInterface apiInterface = ApiHelper.getClient().create(ApiInterface.class);
        Call<LaporanMobilBulananModel> laporanMobilBulananModelCall = apiInterface.gettampillaporanpenyewaanmobilperbulan();
        laporanMobilBulananModelCall.enqueue(new Callback<LaporanMobilBulananModel>() {
            @Override
            public void onResponse(Call<LaporanMobilBulananModel> call, Response<LaporanMobilBulananModel> response) {

                if(response.isSuccessful()){
                    List<Laporanpenyewaanmobilbulanan> laporanpenyewaanmobilbulanan = response.body().getLaporanpenyewaanmobilbulanan();
                    laporanPenyewaanMobilBulananAdapter = new LaporanPenyewaanMobilBulananAdapter(laporanpenyewaanmobilbulanan);
                    mRecyclerView.setAdapter(laporanPenyewaanMobilBulananAdapter);
                }else{
                    Toast.makeText(LaporanPenyewaanMobilBulanActivity.this, "Gagal "+response.message().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LaporanMobilBulananModel> call, Throwable t) {
                Toast.makeText(LaporanPenyewaanMobilBulanActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}