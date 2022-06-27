package com.hky.atmarental.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hky.atmarental.R;
import com.hky.atmarental.model.laporantop5driver.LaporanTop5Driver;

import java.util.List;

public class TampilPerfomaDriverTransaksiAdapter extends RecyclerView.Adapter<TampilPerfomaDriverTransaksiAdapter.MyViewHolder> {
    private List<LaporanTop5Driver> laporanTop5DriverModelList;
    private Context context;

    public TampilPerfomaDriverTransaksiAdapter(List<LaporanTop5Driver> laporanTop5DriverModels) {
        this.laporanTop5DriverModelList = laporanTop5DriverModels;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNamaDriver, txtIdDriver, txtJumlahTransaksi, txtRating;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtNamaDriver = (TextView) itemView.findViewById(R.id.txtNamaDriver);
            txtIdDriver = (TextView) itemView.findViewById(R.id.txtIdDriver);
            txtJumlahTransaksi = (TextView) itemView.findViewById(R.id.txtJumlahTransaksi);
            txtRating = (TextView) itemView.findViewById(R.id.txtRating);

        }
    }

    @Override
    public TampilPerfomaDriverTransaksiAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_driver, parent, false);
        TampilPerfomaDriverTransaksiAdapter.MyViewHolder mViewHolder = new TampilPerfomaDriverTransaksiAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TampilPerfomaDriverTransaksiAdapter.MyViewHolder holder, int position) {
        final LaporanTop5Driver laporanTop5Driver = laporanTop5DriverModelList.get(position);
        holder.txtNamaDriver.setText(laporanTop5Driver.getNamaDriver());
        holder.txtIdDriver.setText(laporanTop5Driver.getIdDriver());
        holder.txtJumlahTransaksi.setText(laporanTop5Driver.getJumlahTransaksi());
        holder.txtRating.setText(laporanTop5Driver.getRerataRating());
    }

    @Override
    public int getItemCount() {
        return laporanTop5DriverModelList.size();
    }
}
