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

import com.hky.atmarental.adapter.LaporanPendapatanTransaksiBulananAdapter;
import com.hky.atmarental.adapter.LaporanTop5DriverTransaksiAdapter;
import com.hky.atmarental.model.laporanpendapatanbulanan.LaporanPendapatanBulan;
import com.hky.atmarental.model.laporanpendapatanbulanan.LaporanPendapatanBulananModel;
import com.hky.atmarental.model.laporantop5driver.LaporanTop5Driver;
import com.hky.atmarental.model.laporantop5driver.LaporanTop5DriverModel;
import com.hky.atmarental.network.ApiHelper;
import com.hky.atmarental.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LaporanTop5DriverTransaksiBulanActivity extends AppCompatActivity {
    TextView txtKembali, txtCari, txtKalimat;
    EditText edtBulan;
    private LaporanTop5DriverTransaksiAdapter laporanTop5DriverTransaksiAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporantop5drivertransaksi);
        txtKembali = findViewById(R.id.txtKembali);
        txtKalimat = findViewById(R.id.txtKalimat2);
        mRecyclerView = findViewById(R.id.rvDriver);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        txtCari = findViewById(R.id.txtCari);
        edtBulan = findViewById(R.id.edtBulan);
        getTop5DriverTransaksi();
        txtKalimat.setText("Daftar Semua Driver");
        txtCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtBulan.getText().toString().equals("")){
                    txtKalimat.setText("Daftar Semua Driver");
                    getTop5DriverTransaksi();
                }else{
                    int month = Integer.parseInt(edtBulan.getText().toString());
                    if(month<1 || month >12){

                        Toast.makeText(LaporanTop5DriverTransaksiBulanActivity.this, "Bulan Tidak Valid", Toast.LENGTH_SHORT).show();
                    }else{
                        if(month == 1){
                            txtKalimat.setText("Daftar Semua Driver Bulan Januari");
                        }else if(month == 2){
                            txtKalimat.setText("Daftar Semua Driver Bulan Februari");
                        }else if(month == 3){
                            txtKalimat.setText("Daftar Semua Driver Bulan Maret");
                        }else if(month == 4){
                            txtKalimat.setText("Daftar Semua Driver Bulan April");
                        }else if(month == 5){
                            txtKalimat.setText("Daftar Semua Driver Bulan Mei");
                        }else if(month == 6){
                            txtKalimat.setText("Daftar Semua Driver Bulan Juni");
                        }else if(month == 7){
                            txtKalimat.setText("Daftar Semua Driver Bulan Juli");
                        }else if(month == 8){
                            txtKalimat.setText("Daftar Semua Driver Bulan Agustus");
                        }else if(month == 9){
                            txtKalimat.setText("Daftar Semua Driver Bulan September");
                        }else if(month == 10){
                            txtKalimat.setText("Daftar Semua Driver Bulan Oktober");
                        }else if(month == 11){
                            txtKalimat.setText("Daftar Semua Driver Bulan November");
                        }else if(month == 12){
                            txtKalimat.setText("Daftar Semua Driver Bulan Desember");
                        }else{
                            txtKalimat.setText("Daftar Semua Driver");
                        }
                        getCariTop5DriverTransaksi(edtBulan.getText().toString());
                    }
                }

            }
        });
        txtKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LaporanTop5DriverTransaksiBulanActivity.this, ManagerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getCariTop5DriverTransaksi(String bulan) {
        ApiInterface apiInterface = ApiHelper.getClient().create(ApiInterface.class);
        Call<LaporanTop5DriverModel> laporanTop5DriverModelCall = apiInterface.getcarilaporantop5drivertransaksi(bulan);
        laporanTop5DriverModelCall.enqueue(new Callback<LaporanTop5DriverModel>() {
            @Override
            public void onResponse(Call<LaporanTop5DriverModel> call, Response<LaporanTop5DriverModel> response) {

                if(response.isSuccessful()){
                    List<LaporanTop5Driver> laporantop5driver = response.body().getLaporantop5driver();

                    laporanTop5DriverTransaksiAdapter = new LaporanTop5DriverTransaksiAdapter(laporantop5driver);
                    mRecyclerView.setAdapter(laporanTop5DriverTransaksiAdapter);
                }else{
                    Toast.makeText(LaporanTop5DriverTransaksiBulanActivity.this, "Gagal "+response.message().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LaporanTop5DriverModel> call, Throwable t) {
                Toast.makeText(LaporanTop5DriverTransaksiBulanActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void getTop5DriverTransaksi() {
        ApiInterface apiInterface = ApiHelper.getClient().create(ApiInterface.class);
        Call<LaporanTop5DriverModel> laporanTop5DriverModelCall = apiInterface.gettampiltop5drivertransaksi();
        laporanTop5DriverModelCall.enqueue(new Callback<LaporanTop5DriverModel>() {
            @Override
            public void onResponse(Call<LaporanTop5DriverModel> call, Response<LaporanTop5DriverModel> response) {

                if(response.isSuccessful()){
                    List<LaporanTop5Driver> laporantop5driver = response.body().getLaporantop5driver();

                    laporanTop5DriverTransaksiAdapter = new LaporanTop5DriverTransaksiAdapter(laporantop5driver);
                    mRecyclerView.setAdapter(laporanTop5DriverTransaksiAdapter);
                }else{
                    Toast.makeText(LaporanTop5DriverTransaksiBulanActivity.this, "Gagal "+response.message().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LaporanTop5DriverModel> call, Throwable t) {
                Toast.makeText(LaporanTop5DriverTransaksiBulanActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

}