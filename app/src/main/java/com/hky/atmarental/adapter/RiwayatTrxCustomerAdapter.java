package com.hky.atmarental.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.hky.atmarental.R;
import com.hky.atmarental.model.riwayattransaksi;

import java.util.ArrayList;
import java.util.List;

public class RiwayatTrxCustomerAdapter extends RecyclerView.Adapter<RiwayatTrxCustomerAdapter.MyViewHolder> {
    private List<riwayattransaksi> riwayattransaksiList;
    private Context context;

    public RiwayatTrxCustomerAdapter(List<riwayattransaksi> riwayattransaksis) {
        this.riwayattransaksiList = riwayattransaksis;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTanggalTransaksi, txtTotalBiayaSewa,txtStatusTransaksi, txtAkhirSewa, txtMulaiSewa;
        LinearLayout linear;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtTanggalTransaksi = (TextView) itemView.findViewById(R.id.txtTanggalTransaksi);
            txtTotalBiayaSewa = (TextView) itemView.findViewById(R.id.txtTotalBiayaSewa);
            txtStatusTransaksi= (TextView) itemView.findViewById(R.id.txtStatusTransaksi);
            txtAkhirSewa = (TextView) itemView.findViewById(R.id.txtAkhirSewa);
            txtMulaiSewa= (TextView) itemView.findViewById(R.id.txtMulaiSewa);
            linear = (LinearLayout) itemView.findViewById(R.id.expandedLayout);
            txtTanggalTransaksi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    riwayattransaksi riwayattransaksi = riwayattransaksiList.get(getAdapterPosition());
                    riwayattransaksi.setVisibility(!riwayattransaksi.isVisibility());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }

    @Override
    public RiwayatTrxCustomerAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_riwayattrxcustomer, parent, false);
        RiwayatTrxCustomerAdapter.MyViewHolder mViewHolder = new RiwayatTrxCustomerAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RiwayatTrxCustomerAdapter.MyViewHolder holder, int position) {
        final riwayattransaksi riwayattransaksi = riwayattransaksiList.get(position);
        holder.txtTanggalTransaksi.setText(riwayattransaksi.getTanggalTransaksi());
        holder.txtTotalBiayaSewa.setText(riwayattransaksi.getTotalBiayaSewa());
        holder.txtStatusTransaksi.setText(riwayattransaksi.getStatusTransaksi());
        holder.txtAkhirSewa.setText(riwayattransaksi.getTanggalAkhirSewa());
        holder.txtMulaiSewa.setText(riwayattransaksi.getTanggalMulaiSewa());
        boolean isVisible = riwayattransaksiList.get(position).isVisibility();
        holder.linear.setVisibility(isVisible? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return riwayattransaksiList.size();
    }
}
