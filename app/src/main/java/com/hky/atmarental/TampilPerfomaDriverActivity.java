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

import com.hky.atmarental.adapter.LaporanPerfomaDriverTransaksiAdapter;
import com.hky.atmarental.adapter.TampilPerfomaDriverTransaksiAdapter;
import com.hky.atmarental.model.laporantop5driver.LaporanTop5Driver;
import com.hky.atmarental.model.laporantop5driver.LaporanTop5DriverModel;
import com.hky.atmarental.network.ApiHelper;
import com.hky.atmarental.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TampilPerfomaDriverActivity extends AppCompatActivity {
    TextView txtKembali;
    private TampilPerfomaDriverTransaksiAdapter tampilPerfomaDriverTransaksiAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporanperfomadriver);
        txtKembali = findViewById(R.id.txtKembali);

        mRecyclerView = findViewById(R.id.rvDriver);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        getperfomadriver();

        txtKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TampilPerfomaDriverActivity.this, CustomerActivity.class);
                startActivity(intent);
            }
        });
    }


    private void getperfomadriver() {
        ApiInterface apiInterface = ApiHelper.getClient().create(ApiInterface.class);
        Call<LaporanTop5DriverModel> laporanTop5DriverModelCall = apiInterface.gettampilperfomadriver();
        laporanTop5DriverModelCall.enqueue(new Callback<LaporanTop5DriverModel>() {
            @Override
            public void onResponse(Call<LaporanTop5DriverModel> call, Response<LaporanTop5DriverModel> response) {

                if(response.isSuccessful()){
                    List<LaporanTop5Driver> laporantop5driver = response.body().getLaporantop5driver();

                    tampilPerfomaDriverTransaksiAdapter = new TampilPerfomaDriverTransaksiAdapter(laporantop5driver);
                    mRecyclerView.setAdapter(tampilPerfomaDriverTransaksiAdapter);
                }else{
                    Toast.makeText(TampilPerfomaDriverActivity.this, "Gagal "+response.message().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LaporanTop5DriverModel> call, Throwable t) {
                Toast.makeText(TampilPerfomaDriverActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

}