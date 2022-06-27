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

import com.hky.atmarental.adapter.LaporanTop5CustomerTransaksiAdapter;
import com.hky.atmarental.adapter.LaporanTop5DriverTransaksiAdapter;
import com.hky.atmarental.model.laporantop5customer.LaporanTop5Customer;
import com.hky.atmarental.model.laporantop5customer.LaporanTop5CustomerModel;
import com.hky.atmarental.model.laporantop5driver.LaporanTop5Driver;
import com.hky.atmarental.model.laporantop5driver.LaporanTop5DriverModel;
import com.hky.atmarental.network.ApiHelper;
import com.hky.atmarental.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LaporanTop5CustomerTransaksiBulanActivity extends AppCompatActivity {
    TextView txtKembali, txtCari, txtKalimat;
    EditText edtBulan;
    private LaporanTop5CustomerTransaksiAdapter laporanTop5CustomerTransaksiAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporantop5customertransaksi);
        txtKembali = findViewById(R.id.txtKembali);
        txtKalimat = findViewById(R.id.txtKalimat2);
        mRecyclerView = findViewById(R.id.rvCustomer);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        txtCari = findViewById(R.id.txtCari);
        edtBulan = findViewById(R.id.edtBulan);
        getTop5CustomerTransaksi();
        txtKalimat.setText("Daftar Semua Customer");
        txtCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtBulan.getText().toString().equals("")){
                    txtKalimat.setText("Daftar Semua Customer");
                    getTop5CustomerTransaksi();
                }else{
                    int month = Integer.parseInt(edtBulan.getText().toString());
                    if(month<1 || month >12){

                        Toast.makeText(LaporanTop5CustomerTransaksiBulanActivity.this, "Bulan Tidak Valid", Toast.LENGTH_SHORT).show();
                    }else{
                        if(month == 1){
                            txtKalimat.setText("Daftar Semua Customer Bulan Januari");
                        }else if(month == 2){
                            txtKalimat.setText("Daftar Semua Customer Bulan Februari");
                        }else if(month == 3){
                            txtKalimat.setText("Daftar Semua Customer Bulan Maret");
                        }else if(month == 4){
                            txtKalimat.setText("Daftar Semua Customer Bulan April");
                        }else if(month == 5){
                            txtKalimat.setText("Daftar Semua Customer Bulan Mei");
                        }else if(month == 6){
                            txtKalimat.setText("Daftar Semua Customer Bulan Juni");
                        }else if(month == 7){
                            txtKalimat.setText("Daftar Semua Customer Bulan Juli");
                        }else if(month == 8){
                            txtKalimat.setText("Daftar Semua Customer Bulan Agustus");
                        }else if(month == 9){
                            txtKalimat.setText("Daftar Semua Customer Bulan September");
                        }else if(month == 10){
                            txtKalimat.setText("Daftar Semua Customer Bulan Oktober");
                        }else if(month == 11){
                            txtKalimat.setText("Daftar Semua Customer Bulan November");
                        }else if(month == 12){
                            txtKalimat.setText("Daftar Semua Customer Bulan Desember");
                        }else{
                            txtKalimat.setText("Daftar Semua Customer");
                        }
                        getCariTop5CustomerTransaksi(edtBulan.getText().toString());
                    }
                }

            }
        });
        txtKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LaporanTop5CustomerTransaksiBulanActivity.this, ManagerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getCariTop5CustomerTransaksi(String bulan) {
        ApiInterface apiInterface = ApiHelper.getClient().create(ApiInterface.class);
        Call<LaporanTop5CustomerModel> laporanTop5CustomerModelCall = apiInterface.getcaritop5customer(bulan);
        laporanTop5CustomerModelCall.enqueue(new Callback<LaporanTop5CustomerModel>() {
            @Override
            public void onResponse(Call<LaporanTop5CustomerModel> call, Response<LaporanTop5CustomerModel> response) {

                if(response.isSuccessful()){
                    List<LaporanTop5Customer> laporanTop5Customers = response.body().getLaporantop5customer();
                    laporanTop5CustomerTransaksiAdapter = new LaporanTop5CustomerTransaksiAdapter(laporanTop5Customers);
                    mRecyclerView.setAdapter(laporanTop5CustomerTransaksiAdapter);
                }else{
                    Toast.makeText(LaporanTop5CustomerTransaksiBulanActivity.this, "Gagal "+response.message().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LaporanTop5CustomerModel> call, Throwable t) {
                Toast.makeText(LaporanTop5CustomerTransaksiBulanActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void getTop5CustomerTransaksi() {
        ApiInterface apiInterface = ApiHelper.getClient().create(ApiInterface.class);
        Call<LaporanTop5CustomerModel> laporanTop5CustomerModelCall = apiInterface.gettampiltop5customer();
        laporanTop5CustomerModelCall.enqueue(new Callback<LaporanTop5CustomerModel>() {
            @Override
            public void onResponse(Call<LaporanTop5CustomerModel> call, Response<LaporanTop5CustomerModel> response) {

                if(response.isSuccessful()){
                    List<LaporanTop5Customer> laporanTop5Customers = response.body().getLaporantop5customer();
                    laporanTop5CustomerTransaksiAdapter = new LaporanTop5CustomerTransaksiAdapter(laporanTop5Customers);
                    mRecyclerView.setAdapter(laporanTop5CustomerTransaksiAdapter);
                }else{
                    Toast.makeText(LaporanTop5CustomerTransaksiBulanActivity.this, "Gagal "+response.message().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LaporanTop5CustomerModel> call, Throwable t) {
                Toast.makeText(LaporanTop5CustomerTransaksiBulanActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

}