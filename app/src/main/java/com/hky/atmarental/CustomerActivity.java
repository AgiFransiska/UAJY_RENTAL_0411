package com.hky.atmarental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hky.atmarental.adapter.BrosurAdapter;
import com.hky.atmarental.adapter.PromoAdapter;
import com.hky.atmarental.adapter.RiwayatTrxCustomerAdapter;
import com.hky.atmarental.model.brosur.AsetKendaraan;
import com.hky.atmarental.model.brosur.BrosurModel;
import com.hky.atmarental.model.promo.Promo;
import com.hky.atmarental.model.promo.PromoModel;
import com.hky.atmarental.model.riwayattransaksi;
import com.hky.atmarental.model.riwayattransaksimodel;
import com.hky.atmarental.network.ApiHelper;
import com.hky.atmarental.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerActivity extends AppCompatActivity {
    Button btnCariPromo, btnCekRatingDriver;
    EditText edtSearchPromo;
    TextView txtLogout;
    private RiwayatTrxCustomerAdapter mAdapter;
    private PromoAdapter promoAdapter;
    private BrosurAdapter brosurAdapter;
    private RecyclerView pRecyclerView;
    private RecyclerView.LayoutManager pLayoutManager;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView bRecyclerView;
    private RecyclerView.LayoutManager bLayoutManager;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_ID = "id";
    String id = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCariPromo = findViewById(R.id.btnCariPromo);
        edtSearchPromo = findViewById(R.id.edtSearchPromo);
        mRecyclerView = findViewById(R.id.rvRiwayatTransaksiCustomer);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        pRecyclerView = findViewById(R.id.rvPromo);
        pLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        pRecyclerView.setLayoutManager(pLayoutManager);
        btnCekRatingDriver = findViewById(R.id.btnCekRatingDriver);
        bRecyclerView = findViewById(R.id.rvBrosur);
        bLayoutManager = new GridLayoutManager(this, 2);
        bRecyclerView.setLayoutManager(bLayoutManager);
        txtLogout = findViewById(R.id.txtLogout);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        id = sharedPreferences.getString(KEY_ID,null);
        txtLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnCekRatingDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerActivity.this, TampilPerfomaDriverActivity.class);
                startActivity(intent);
            }
        });
        btnCariPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtSearchPromo.getText().toString().equals("")){
                    getPromo();
                }else{
                    searchPromo(edtSearchPromo.getText().toString());
                }

            }
        });
        getPromo();
        getRiwayatTrxCustomer();
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

    private void searchPromo(String kode) {
        ApiInterface apiInterface = ApiHelper.getClient().create(ApiInterface.class);
        Call<PromoModel> promoCall = apiInterface.getpromosearch("aktif", kode);
        promoCall.enqueue(new Callback<PromoModel>() {
            @Override
            public void onResponse(Call<PromoModel> call, Response<PromoModel> response) {
                List<Promo> promos = response.body().getPromo();
                promoAdapter = new PromoAdapter(promos);
                pRecyclerView.setAdapter(promoAdapter);
            }

            @Override
            public void onFailure(Call<PromoModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getPromo() {
        ApiInterface apiInterface = ApiHelper.getClient().create(ApiInterface.class);
        Call<PromoModel> promoCall = apiInterface.getpromo("aktif");
        promoCall.enqueue(new Callback<PromoModel>() {
            @Override
            public void onResponse(Call<PromoModel> call, Response<PromoModel> response) {
                List<Promo> promos = response.body().getPromo();
                promoAdapter = new PromoAdapter(promos);
                pRecyclerView.setAdapter(promoAdapter);
            }

            @Override
            public void onFailure(Call<PromoModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getRiwayatTrxCustomer() {
        ApiInterface apiInterface = ApiHelper.getClient().create(ApiInterface.class);
        Call<riwayattransaksimodel> riwayattransaksimodelCall = apiInterface.getriwayatcustomer(id);
        riwayattransaksimodelCall.enqueue(new Callback<riwayattransaksimodel>() {
            @Override
            public void onResponse(Call<riwayattransaksimodel> call, Response<riwayattransaksimodel> response) {
                List<riwayattransaksi> riwayattransaksis = response.body().getRiwayattransaksi();
                mAdapter = new RiwayatTrxCustomerAdapter(riwayattransaksis);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<riwayattransaksimodel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}