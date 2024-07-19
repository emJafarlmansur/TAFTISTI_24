package com.tugas.tugasakhir2024;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CombinedPriceAdapter extends RecyclerView.Adapter<CombinedPriceAdapter.ViewHolder> {
    private List<Combine> combinedPriceList;

    public CombinedPriceAdapter(List<Combine> combinedPriceList) {
        this.combinedPriceList = combinedPriceList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Combine combine = combinedPriceList.get(position);
        holder.pairTextView.setText(combine.getPair());
        holder.upbitPriceTextView.setText("UPBIT: " + combine.getUpbitPrice());
        holder.tokocryptoPriceTextView.setText("TOKOCRYPTO: " + combine.getTokocryptoPrice());
    }

    @Override
    public int getItemCount() {
        return combinedPriceList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView pairTextView;
        private TextView upbitPriceTextView;
        private TextView tokocryptoPriceTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pairTextView = itemView.findViewById(R.id.marketId);
            upbitPriceTextView = itemView.findViewById(R.id.koinId);
            tokocryptoPriceTextView = itemView.findViewById(R.id.hargaId);
        }
    }
}
