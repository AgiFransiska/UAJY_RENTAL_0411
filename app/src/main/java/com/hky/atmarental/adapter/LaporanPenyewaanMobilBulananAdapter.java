package com.hky.atmarental.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hky.atmarental.R;
import com.hky.atmarental.model.brosur.AsetKendaraan;
import com.hky.atmarental.model.laporanmobilbulanan.Laporanpenyewaanmobilbulanan;

import java.util.List;

public class LaporanPenyewaanMobilBulananAdapter extends RecyclerView.Adapter<LaporanPenyewaanMobilBulananAdapter.MyViewHolder> {
    private List<Laporanpenyewaanmobilbulanan> laporanpenyewaanmobilbulananList;
    private Context context;

    public LaporanPenyewaanMobilBulananAdapter(List<Laporanpenyewaanmobilbulanan> laporanpenyewaanmobilbulanans) {
        this.laporanpenyewaanmobilbulananList = laporanpenyewaanmobilbulanans;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTipeMobil, txtNamaMobil, txtJumlahPeminjaman, txtPendapatan;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtPendapatan = (TextView) itemView.findViewById(R.id.txtPendapatan);
            txtJumlahPeminjaman = (TextView) itemView.findViewById(R.id.txtJumlahPeminjaman);
            txtTipeMobil = (TextView) itemView.findViewById(R.id.txtTipeMobil);
            txtNamaMobil = (TextView) itemView.findViewById(R.id.txtNamaMobil);

        }
    }

    @Override
    public LaporanPenyewaanMobilBulananAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_laporan1, parent, false);
        LaporanPenyewaanMobilBulananAdapter.MyViewHolder mViewHolder = new LaporanPenyewaanMobilBulananAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LaporanPenyewaanMobilBulananAdapter.MyViewHolder holder, int position) {
        final Laporanpenyewaanmobilbulanan laporanpenyewaanmobilbulanan = laporanpenyewaanmobilbulananList.get(position);
        holder.txtNamaMobil.setText(laporanpenyewaanmobilbulanan.getNamaMobil());
        holder.txtJumlahPeminjaman.setText(laporanpenyewaanmobilbulanan.getJumlahPeminjaman());
        holder.txtPendapatan.setText("Rp "+laporanpenyewaanmobilbulanan.getPendapatan());
        holder.txtTipeMobil.setText(laporanpenyewaanmobilbulanan.getNamaMobil());
    }

    @Override
    public int getItemCount() {
        return laporanpenyewaanmobilbulananList.size();
    }
}
