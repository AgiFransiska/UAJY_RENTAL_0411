package com.hky.atmarental;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.hky.atmarental.adapter.BrosurAdapter;
import com.hky.atmarental.model.brosur.AsetKendaraan;
import com.hky.atmarental.model.brosur.BrosurModel;
import com.hky.atmarental.model.login.LoginModel;
import com.hky.atmarental.model.login.Result;
import com.hky.atmarental.network.ApiHelper;
import com.hky.atmarental.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    EditText edtEmail, edtPassword;
    Button btnLogin;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        ApiInterface apiInterface = ApiHelper.getClient().create(ApiInterface.class);
        Call<LoginModel> loginModelCall = apiInterface.login(edtEmail.getText().toString(),edtPassword.getText().toString());
        loginModelCall.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if(response.isSuccessful()){
                    String role = response.body().getRole();
                    if(role.toString().equals("customer")){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(KEY_ID,response.body().getResult().get(0).getId());
                        editor.apply();
                        Intent intent = new Intent(LoginActivity.this, CustomerActivity.class);
                        startActivity(intent);
                    }else if(role.toString().equals("pegawai")){
                        List<Result> results = response.body().getResult();
                        int idrole = Integer.parseInt(results.get(0).getIdRole());
                        if(idrole == 1){
                            Intent intent = new Intent(LoginActivity.this, ManagerActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getApplicationContext(), "Gagal Login"+response.message().toString(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    }else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(KEY_ID,response.body().getResult().get(0).getId());
                        editor.apply();
                        Intent intent = new Intent(LoginActivity.this, DriverActivity.class);
                        startActivity(intent);
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "Gagal Login"+response.message().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal Login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}