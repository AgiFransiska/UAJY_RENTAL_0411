package com.hky.atmarental;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hky.atmarental.adapter.BrosurAdapter;
import com.hky.atmarental.model.brosur.AsetKendaraan;
import com.hky.atmarental.model.brosur.BrosurModel;
import com.hky.atmarental.network.ApiHelper;
import com.hky.atmarental.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ManagerActivity extends AppCompatActivity {
    TextView txtLanjutMobil, txtLogout, txtLanjutPendapatanTransaksi, txtTop5Driver, txtPerfomaDriver, txtTop5Customer;
    private BrosurAdapter brosurAdapter;
    private RecyclerView bRecyclerView;
    private RecyclerView.LayoutManager bLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        bRecyclerView = findViewById(R.id.rvBrosur);
        bLayoutManager = new GridLayoutManager(this, 2);
        bRecyclerView.setLayoutManager(bLayoutManager);
        txtLanjutMobil = findViewById(R.id.txtLanjutMobil);
        txtTop5Driver = findViewById(R.id.txtTop5Driver);
        txtPerfomaDriver = findViewById(R.id.txtPerfomaDriver);
        txtTop5Customer = findViewById(R.id.txtTop5Customer);
        txtLogout = findViewById(R.id.txtLogout);
        txtLanjutPendapatanTransaksi = findViewById(R.id.txtLanjutPendapatanTransaksi);
        txtLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagerActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        txtTop5Customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagerActivity.this, LaporanTop5CustomerTransaksiBulanActivity.class);
                startActivity(intent);
            }
        });
        txtPerfomaDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagerActivity.this, LaporanPerfomaDriverBulanActivity.class);
                startActivity(intent);
            }
        });
        txtTop5Driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagerActivity.this, LaporanTop5DriverTransaksiBulanActivity.class);
                startActivity(intent);
            }
        });
        txtLanjutPendapatanTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagerActivity.this, LaporanPendapatanTransaksiBulanActivity.class);
                startActivity(intent);
            }
        });
        txtLanjutMobil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagerActivity.this, LaporanPenyewaanMobilBulanActivity.class);
                startActivity(intent);
            }
        });
        getBrosur();
    }

    private void getBrosur() {
        ApiInterface apiInterface = ApiHelper.getClient().create(ApiInterface.class);
        Call<BrosurModel> brosurCall = apiInterface.getbrosur("Tersedia");
        brosurCall.enqueue(new Callback<BrosurModel>() {
            @Override
            public void onResponse(Call<BrosurModel> call, Response<BrosurModel> response) {

                if(response.isSuccessful()){
                    List<AsetKendaraan> asetKendaraans = response.body().getAsetkendaraan();
                    brosurAdapter = new BrosurAdapter(asetKendaraans);
                    bRecyclerView.setAdapter(brosurAdapter);
                }else{
                    Toast.makeText(getApplicationContext(), "Gagal "+response.message().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BrosurModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}