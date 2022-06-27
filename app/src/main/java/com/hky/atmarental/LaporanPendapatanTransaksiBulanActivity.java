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
import com.hky.atmarental.adapter.LaporanPenyewaanMobilBulananAdapter;
import com.hky.atmarental.model.laporanmobilbulanan.LaporanMobilBulananModel;
import com.hky.atmarental.model.laporanmobilbulanan.Laporanpenyewaanmobilbulanan;
import com.hky.atmarental.model.laporanpendapatanbulanan.LaporanPendapatanBulan;
import com.hky.atmarental.model.laporanpendapatanbulanan.LaporanPendapatanBulananModel;
import com.hky.atmarental.network.ApiHelper;
import com.hky.atmarental.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LaporanPendapatanTransaksiBulanActivity extends AppCompatActivity {
    TextView txtKembali, txtCari, txtKalimat;
    EditText edtBulan;
    private LaporanPendapatanTransaksiBulananAdapter laporanPendapatanTransaksiBulananAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporanpendapatantransaksibulan);
        txtKembali = findViewById(R.id.txtKembali);
        txtKalimat = findViewById(R.id.txtKalimat2);
        mRecyclerView = findViewById(R.id.rvBulan);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        txtCari = findViewById(R.id.txtCari);
        edtBulan = findViewById(R.id.edtBulan);
        getPendapatanBulanan();
        txtKalimat.setText("Daftar Semua Pendapatan");
        txtCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtBulan.getText().toString().equals("")){
                    txtKalimat.setText("Daftar Semua Pendapatan");
                    getPendapatanBulanan();
                }else{
                    int month = Integer.parseInt(edtBulan.getText().toString());
                    if(month<1 || month >12){

                        Toast.makeText(LaporanPendapatanTransaksiBulanActivity.this, "Bulan Tidak Valid", Toast.LENGTH_SHORT).show();
                    }else{
                        if(month == 1){
                            txtKalimat.setText("Daftar Semua Pendapatan Bulan Januari");
                        }else if(month == 2){
                            txtKalimat.setText("Daftar Semua Pendapatan Bulan Februari");
                        }else if(month == 3){
                            txtKalimat.setText("Daftar Semua Pendapatan Bulan Maret");
                        }else if(month == 4){
                            txtKalimat.setText("Daftar Semua Pendapatan Bulan April");
                        }else if(month == 5){
                            txtKalimat.setText("Daftar Semua Pendapatan Bulan Mei");
                        }else if(month == 6){
                            txtKalimat.setText("Daftar Semua Pendapatan Bulan Juni");
                        }else if(month == 7){
                            txtKalimat.setText("Daftar Semua Pendapatan Bulan Juli");
                        }else if(month == 8){
                            txtKalimat.setText("Daftar Semua Pendapatan Bulan Agustus");
                        }else if(month == 9){
                            txtKalimat.setText("Daftar Semua Pendapatan Bulan September");
                        }else if(month == 10){
                            txtKalimat.setText("Daftar Semua Pendapatan Bulan Oktober");
                        }else if(month == 11){
                            txtKalimat.setText("Daftar Semua Pendapatan Bulan November");
                        }else if(month == 12){
                            txtKalimat.setText("Daftar Semua Pendapatan Bulan Desember");
                        }else{
                            txtKalimat.setText("Daftar Semua Pendapatan");
                        }
                        getCariLaporanPendapatanPerBulan(edtBulan.getText().toString());
                    }
                }

            }
        });
        txtKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LaporanPendapatanTransaksiBulanActivity.this, ManagerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getCariLaporanPendapatanPerBulan(String bulan) {
        ApiInterface apiInterface = ApiHelper.getClient().create(ApiInterface.class);
        Call<LaporanPendapatanBulananModel> laporanPendapatanBulananModelCall = apiInterface.getcarilaporanpendapatanperbulan(bulan);
        laporanPendapatanBulananModelCall.enqueue(new Callback<LaporanPendapatanBulananModel>() {
            @Override
            public void onResponse(Call<LaporanPendapatanBulananModel> call, Response<LaporanPendapatanBulananModel> response) {

                if(response.isSuccessful()){
                    List<LaporanPendapatanBulan> laporanPendapatanBulans = response.body().getLaporanpendapatanbulan();
                    laporanPendapatanTransaksiBulananAdapter = new LaporanPendapatanTransaksiBulananAdapter(laporanPendapatanBulans);
                    mRecyclerView.setAdapter(laporanPendapatanTransaksiBulananAdapter);
                }else{
                    Toast.makeText(LaporanPendapatanTransaksiBulanActivity.this, "Gagal "+response.message().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LaporanPendapatanBulananModel> call, Throwable t) {
                Toast.makeText(LaporanPendapatanTransaksiBulanActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getPendapatanBulanan() {
        ApiInterface apiInterface = ApiHelper.getClient().create(ApiInterface.class);
        Call<LaporanPendapatanBulananModel> laporanPendapatanBulananModelCall = apiInterface.gettampillaporanpendapatanperbulan();
        laporanPendapatanBulananModelCall.enqueue(new Callback<LaporanPendapatanBulananModel>() {
            @Override
            public void onResponse(Call<LaporanPendapatanBulananModel> call, Response<LaporanPendapatanBulananModel> response) {

                if(response.isSuccessful()){
                    List<LaporanPendapatanBulan> laporanPendapatanBulans = response.body().getLaporanpendapatanbulan();
                    laporanPendapatanTransaksiBulananAdapter = new LaporanPendapatanTransaksiBulananAdapter(laporanPendapatanBulans);
                    mRecyclerView.setAdapter(laporanPendapatanTransaksiBulananAdapter);
                }else{
                    Toast.makeText(LaporanPendapatanTransaksiBulanActivity.this, "Gagal "+response.message().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LaporanPendapatanBulananModel> call, Throwable t) {
                Toast.makeText(LaporanPendapatanTransaksiBulanActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

}