package com.hky.atmarental.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hky.atmarental.R;
import com.hky.atmarental.model.brosur.AsetKendaraan;
import com.hky.atmarental.model.promo.Promo;

import java.util.List;

public class BrosurAdapter extends RecyclerView.Adapter<BrosurAdapter.MyViewHolder> {
    private List<AsetKendaraan> asetKendaraanList;
    private Context context;

    public BrosurAdapter(List<AsetKendaraan> asetKendaraans) {
        this.asetKendaraanList = asetKendaraans;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtBiayaSewa, txtTipeMobil, txtNamaMobil;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtBiayaSewa = (TextView) itemView.findViewById(R.id.txtBiayaSewa);
            txtTipeMobil = (TextView) itemView.findViewById(R.id.txtTipeMobil);
            txtNamaMobil = (TextView) itemView.findViewById(R.id.txtNamaMobil);

        }
    }

    @Override
    public BrosurAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_mobil, parent, false);
        BrosurAdapter.MyViewHolder mViewHolder = new BrosurAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BrosurAdapter.MyViewHolder holder, int position) {
        final AsetKendaraan kendaraan = asetKendaraanList.get(position);
        holder.txtNamaMobil.setText(kendaraan.getNamaMobil());
        holder.txtBiayaSewa.setText("Rp "+kendaraan.getBiayaSewa());
        holder.txtTipeMobil.setText(kendaraan.getTipeMobil());
    }

    @Override
    public int getItemCount() {
        return asetKendaraanList.size();
    }
}
