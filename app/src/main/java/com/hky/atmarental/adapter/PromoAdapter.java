package com.hky.atmarental.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hky.atmarental.R;
import com.hky.atmarental.model.promo.Promo;
import com.hky.atmarental.model.riwayattransaksi;

import java.util.List;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.MyViewHolder> {
    private List<Promo> promoList;
    private Context context;

    public PromoAdapter(List<Promo> promos) {
        this.promoList = promos;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtKodePromo, txtDiskon;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtKodePromo = (TextView) itemView.findViewById(R.id.txtKodePromo);
            txtDiskon = (TextView) itemView.findViewById(R.id.txtDiskon);
        }
    }

    @Override
    public PromoAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_promo, parent, false);
        PromoAdapter.MyViewHolder mViewHolder = new PromoAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PromoAdapter.MyViewHolder holder, int position) {
        final Promo promo = promoList.get(position);
        holder.txtKodePromo.setText(promo.getKodePromo());
        double result = Double.parseDouble(promo.getDiskon());
        double diskon = result*100;
        holder.txtDiskon.setText(diskon +" %");
    }

    @Override
    public int getItemCount() {
        return promoList.size();
    }
}
