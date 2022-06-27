package com.hky.atmarental.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hky.atmarental.R;
import com.hky.atmarental.model.laporanmobilbulanan.Laporanpenyewaanmobilbulanan;
import com.hky.atmarental.model.laporantop5driver.LaporanTop5Driver;
import com.hky.atmarental.model.laporantop5driver.LaporanTop5DriverModel;

import java.util.List;

public class LaporanTop5DriverTransaksiAdapter extends RecyclerView.Adapter<LaporanTop5DriverTransaksiAdapter.MyViewHolder> {
    private List<LaporanTop5Driver> laporanTop5DriverModelList;
    private Context context;

    public LaporanTop5DriverTransaksiAdapter(List<LaporanTop5Driver> laporanTop5DriverModels) {
        this.laporanTop5DriverModelList = laporanTop5DriverModels;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNamaDriver, txtIdDriver, txtJumlahTransaksi;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtNamaDriver = (TextView) itemView.findViewById(R.id.txtNamaDriver);
            txtIdDriver = (TextView) itemView.findViewById(R.id.txtIdDriver);
            txtJumlahTransaksi = (TextView) itemView.findViewById(R.id.txtJumlahTransaksi);

        }
    }

    @Override
    public LaporanTop5DriverTransaksiAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_laporan3, parent, false);
        LaporanTop5DriverTransaksiAdapter.MyViewHolder mViewHolder = new LaporanTop5DriverTransaksiAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LaporanTop5DriverTransaksiAdapter.MyViewHolder holder, int position) {
        final LaporanTop5Driver laporanTop5Driver = laporanTop5DriverModelList.get(position);
        holder.txtNamaDriver.setText(laporanTop5Driver.getNamaDriver());
        holder.txtIdDriver.setText(laporanTop5Driver.getIdDriver());
        holder.txtJumlahTransaksi.setText(laporanTop5Driver.getJumlahTransaksi());
    }

    @Override
    public int getItemCount() {
        return laporanTop5DriverModelList.size();
    }
}
