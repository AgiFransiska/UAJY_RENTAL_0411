package com.hky.atmarental.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hky.atmarental.R;
import com.hky.atmarental.model.laporantop5customer.LaporanTop5Customer;
import com.hky.atmarental.model.laporantop5driver.LaporanTop5Driver;

import java.util.List;

public class LaporanTop5CustomerTransaksiAdapter extends RecyclerView.Adapter<LaporanTop5CustomerTransaksiAdapter.MyViewHolder> {
    private List<LaporanTop5Customer> laporanTop5CustomerList;
    private Context context;

    public LaporanTop5CustomerTransaksiAdapter(List<LaporanTop5Customer> laporanTop5DriverModelList) {
        this.laporanTop5CustomerList = laporanTop5DriverModelList;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNamaCustomer, txtIdCustomer, txtJumlahTransaksi;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtNamaCustomer = (TextView) itemView.findViewById(R.id.txtNamaCustomer);
            txtIdCustomer = (TextView) itemView.findViewById(R.id.txtIdCustomer);
            txtJumlahTransaksi = (TextView) itemView.findViewById(R.id.txtJumlahTransaksi);

        }
    }

    @Override
    public LaporanTop5CustomerTransaksiAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_laporan5, parent, false);
        LaporanTop5CustomerTransaksiAdapter.MyViewHolder mViewHolder = new LaporanTop5CustomerTransaksiAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LaporanTop5CustomerTransaksiAdapter.MyViewHolder holder, int position) {
        final LaporanTop5Customer laporanTop5Customer = laporanTop5CustomerList.get(position);
        holder.txtNamaCustomer.setText(laporanTop5Customer.getNamaLengkap());
        holder.txtIdCustomer.setText(laporanTop5Customer.getIdCustomer());
        holder.txtJumlahTransaksi.setText(laporanTop5Customer.getJumlahTransaksi());
    }

    @Override
    public int getItemCount() {
        return laporanTop5CustomerList.size();
    }
}
