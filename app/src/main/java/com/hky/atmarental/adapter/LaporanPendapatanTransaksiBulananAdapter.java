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
import com.hky.atmarental.model.laporanpendapatanbulanan.LaporanPendapatanBulan;

import java.util.List;

public class LaporanPendapatanTransaksiBulananAdapter extends RecyclerView.Adapter<LaporanPendapatanTransaksiBulananAdapter.MyViewHolder> {
    private List<LaporanPendapatanBulan> laporanPendapatanBulans;
    private Context context;

    public LaporanPendapatanTransaksiBulananAdapter(List<LaporanPendapatanBulan> laporanPendapatanBulanList) {
        this.laporanPendapatanBulans = laporanPendapatanBulanList;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNamaCustomer, txtNamaMobil, txtJumlahTransaksi, txtPendapatan, txtJenisTransaksi;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtPendapatan = (TextView) itemView.findViewById(R.id.txtPendapatan);
            txtJumlahTransaksi = (TextView) itemView.findViewById(R.id.txtJumlahTransaksi);
            txtNamaCustomer = (TextView) itemView.findViewById(R.id.txtNamaCustomer);
            txtNamaMobil = (TextView) itemView.findViewById(R.id.txtNamaMobil);
            txtJenisTransaksi = (TextView) itemView.findViewById(R.id.txtJenisTransaksi);

        }
    }

    @Override
    public LaporanPendapatanTransaksiBulananAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_laporan2, parent, false);
        LaporanPendapatanTransaksiBulananAdapter.MyViewHolder mViewHolder = new LaporanPendapatanTransaksiBulananAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LaporanPendapatanTransaksiBulananAdapter.MyViewHolder holder, int position) {
        final LaporanPendapatanBulan laporanPendapatanBulan = laporanPendapatanBulans.get(position);
        holder.txtNamaMobil.setText(laporanPendapatanBulan.getNamaMobil());
        holder.txtJumlahTransaksi.setText(laporanPendapatanBulan.getJumlahTransaksi());
        holder.txtPendapatan.setText("Rp "+laporanPendapatanBulan.getPendapatan());
        if(laporanPendapatanBulan.getJenisTrx().equals("Peminjaman Mobil")){
            holder.txtJenisTransaksi.setText("Peminjaman Mobil");
        }else{
            holder.txtJenisTransaksi.setText("Peminjaman Mobil + Driver");
        }

    }

    @Override
    public int getItemCount() {
        return laporanPendapatanBulans.size();
    }
}
