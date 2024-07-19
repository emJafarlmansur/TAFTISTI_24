package com.tugas.tugasakhir2024;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_combine, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Combine combine = combinedPriceList.get(position);
        holder.pairTextView.setText(combine.getPair());
        holder.primeryPriceTextView.setText("INDODAX: " + combine.getUpbitPrice());
        holder.scmarketPriceTextView.setText("TOKOCRYPTO: " + combine.getTokocryptoPrice());
        holder.trmarketPriceTextView.setText("UPBIT: " + combine.getIndodaxPrice());
        holder.frmarketPriceTextView.setText("LUNO: " + combine.getLunoPrice());
        holder.fevmarketPriceTextView.setText("REKU: " + combine.getRekuPrice());
        holder.ivBackground.setImageResource(combine.getLogoResId());
    }

    @Override
    public int getItemCount() {
        return combinedPriceList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView pairTextView, primeryPriceTextView, scmarketPriceTextView, trmarketPriceTextView, frmarketPriceTextView, fevmarketPriceTextView;
        ImageView ivBackground;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pairTextView = itemView.findViewById(R.id.pairTextView);
            primeryPriceTextView = itemView.findViewById(R.id.upbitPriceTextView);
            scmarketPriceTextView = itemView.findViewById(R.id.tokocryptoPriceTextView);
            trmarketPriceTextView = itemView.findViewById(R.id.indodaxPriceTextView);
            frmarketPriceTextView = itemView.findViewById(R.id.lunoPriceTextView);
            fevmarketPriceTextView = itemView.findViewById(R.id.rekuPriceTextView);
            ivBackground = itemView.findViewById(R.id.ivBackground);
        }
    }
}
