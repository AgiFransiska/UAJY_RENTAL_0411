package com.hky.atmarental;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hky.atmarental.adapter.BrosurAdapter;
import com.hky.atmarental.adapter.PromoAdapter;
import com.hky.atmarental.adapter.RiwayatTrxCustomerAdapter;
import com.hky.atmarental.model.Save;
import com.hky.atmarental.model.brosur.AsetKendaraan;
import com.hky.atmarental.model.brosur.BrosurModel;
import com.hky.atmarental.model.login.Driver;
import com.hky.atmarental.model.login.LoginDriverModel;
import com.hky.atmarental.model.login.LoginModel;
import com.hky.atmarental.model.login.Result;
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

public class DriverActivity extends AppCompatActivity {
    Button btnSimpan;
    EditText edtNama, edtAlamat, edtEmail, edtNoTelp;
    AutoCompleteTextView edtStatus;
    TextView txtLogout;
    ArrayAdapter<String> adapterStatus;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_ID = "id";
    String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        btnSimpan = findViewById(R.id.btnSave);
        edtNama = findViewById(R.id.edtNama);
        edtStatus = findViewById(R.id.edtStatus);
        edtAlamat = findViewById(R.id.edtAlamat);
        edtEmail = findViewById(R.id.edtEmail);
        edtNoTelp = findViewById(R.id.edtNoTelp);
        txtLogout = findViewById(R.id.txtLogout);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        id = sharedPreferences.getString(KEY_ID,null);
        String[] spStatus = new String [] {"Tersedia","Sibuk","Tidak Aktif"};
        adapterStatus=new ArrayAdapter<String>(DriverActivity.this, R.layout.spinner_status, spStatus);
        edtStatus.setAdapter(adapterStatus);
        getData();

        txtLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences =getSharedPreferences("mypref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                finish();
                Intent intent = new Intent(DriverActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savedriver();
            }
        });


    }

    public void savedriver() {

        ApiInterface apiInterface = ApiHelper.getClient().create(ApiInterface.class);
        Call<Save> saveCall = apiInterface.savedriver(
                id,
                edtNama.getText().toString(),
                edtAlamat.getText().toString(),
                edtEmail.getText().toString(),
                edtNoTelp.getText().toString(),
                edtStatus.getText().toString());
        saveCall.enqueue(new Callback<Save>() {
            @Override
            public void onResponse(Call<Save> call, Response<Save> response) {
                Log.d("ID", ""+response.body().getDriver().toString());
                if(response.isSuccessful()){
                    SharedPreferences preferences =getSharedPreferences("mypref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.clear();
                    editor.apply();
                    finish();
                    Intent intent = new Intent(DriverActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Gagal "+response.message().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Save> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getData() {
        ApiInterface apiInterface = ApiHelper.getClient().create(ApiInterface.class);
        Call<LoginDriverModel> loginModelCall = apiInterface.gettampildriver(id);
        loginModelCall.enqueue(new Callback<LoginDriverModel>() {
            @Override
            public void onResponse(Call<LoginDriverModel> call, Response<LoginDriverModel> response) {

                if(response.isSuccessful()){
                    List<Driver> drivers = response.body().getDriver();
                    Log.d("ID", ""+response.body().getDriver().get(0).getNamaDriver());
                    edtNama.setText(drivers.get(0).getNamaDriver().toString());
                    edtAlamat.setText(drivers.get(0).getAlamatDriver().toString());
                    edtEmail.setText(drivers.get(0).getEmailDriver().toString());
                    edtNoTelp.setText(drivers.get(0).getNoTelpDriver().toString());
                }else{
                    Toast.makeText(getApplicationContext(), "Gagal "+response.message().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginDriverModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

}