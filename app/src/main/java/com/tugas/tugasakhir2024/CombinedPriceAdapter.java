package com.tugas.tugasakhir2024;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

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
// Format prices as currency
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        currencyFormat.setMinimumFractionDigits(0);
        currencyFormat.setMaximumFractionDigits(0);


        double indodaxPrice = combine.getIndodaxPrice() != null ? Double.parseDouble(combine.getIndodaxPrice()) : 0.0;
        double tokocryptoPrice = combine.getTokocryptoPrice() != null ? Double.parseDouble(combine.getTokocryptoPrice()) : 0.0;
        double upbitPrice = combine.getUpbitPrice() != null ? Double.parseDouble(combine.getUpbitPrice()) : 0.0;
        double lunoPrice = combine.getLunoPrice() != null ? Double.parseDouble(combine.getLunoPrice()) : 0.0;
        double rekuPrice = combine.getRekuPrice() != null ? Double.parseDouble(combine.getRekuPrice()) : 0.0;

        String indodaxPriceStr = indodaxPrice != 0.0 ? currencyFormat.format(indodaxPrice) : "N/A";
        String tokocryptoPriceStr = tokocryptoPrice != 0.0 ? currencyFormat.format(tokocryptoPrice) : "N/A";
        String upbitPriceStr = upbitPrice != 0.0 ? currencyFormat.format(upbitPrice) : "N/A";
        String lunoPriceStr = lunoPrice != 0.0 ? currencyFormat.format(lunoPrice) : "N/A";
        String rekuPriceStr = rekuPrice != 0.0 ? currencyFormat.format(rekuPrice) : "N/A";

        holder.primeryMarketTextView.setText("Indodax");
        holder.primeryPriceTextView.setText(indodaxPriceStr);

        holder.scmarketTextView.setText("Tokocrypto");
        holder.scmarketPriceTextView.setText(tokocryptoPriceStr);

        holder.trmarketTextView.setText("Upbit");
        holder.trmarketPriceTextView.setText(upbitPriceStr);

        holder.frmarketTextView.setText("Luno");
        holder.frmarketPriceTextView.setText(lunoPriceStr);

        holder.fevmarketTextView.setText("Reku");
        holder.fevmarketPriceTextView.setText(rekuPriceStr);

        holder.ivBackground.setImageResource(combine.getLogoResId());

        // Compare prices and set text color
        setTextViewColor(holder.scmarketPriceTextView, tokocryptoPrice, indodaxPrice);
        setTextViewColor(holder.trmarketPriceTextView, upbitPrice, indodaxPrice);
        setTextViewColor(holder.frmarketPriceTextView, lunoPrice, indodaxPrice);
        setTextViewColor(holder.fevmarketPriceTextView, rekuPrice, indodaxPrice);
    }
    private void setTextViewColor(TextView textView, double price, double primaryPrice) {
        if (price == 0.0 || primaryPrice == 0.2) {
            textView.setTextColor(Color.BLACK); // Default color if price is not available
            return;
        }
        double percentageDifference = ((price - primaryPrice) / primaryPrice) * 100;
        if (percentageDifference > 1) {
            textView.setTextColor(Color.RED); // Higher price
        } else if (percentageDifference < -1) {
            textView.setTextColor(Color.GREEN); // Lower price
        } else {
            textView.setTextColor(Color.BLACK); // Similar price
        }
    }
    @Override
    public int getItemCount() {
        return combinedPriceList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView pairTextView, primeryMarketTextView, primeryPriceTextView;
        TextView scmarketTextView, scmarketPriceTextView;
        TextView trmarketTextView, trmarketPriceTextView;
        TextView frmarketTextView, frmarketPriceTextView;
        TextView fevmarketTextView, fevmarketPriceTextView;
        ImageView ivBackground;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pairTextView = itemView.findViewById(R.id.pairTextView);
            primeryMarketTextView = itemView.findViewById(R.id.primeryMarketTextView);
            primeryPriceTextView = itemView.findViewById(R.id.primeryPriceTextView);
            scmarketTextView = itemView.findViewById(R.id.scmarketTextView);
            scmarketPriceTextView = itemView.findViewById(R.id.scmarketPriceTextView);
            trmarketTextView = itemView.findViewById(R.id.trmarketTextView);
            trmarketPriceTextView = itemView.findViewById(R.id.trmarketPriceTextView);
            frmarketTextView = itemView.findViewById(R.id.frmarketTextView);
            frmarketPriceTextView = itemView.findViewById(R.id.frmarketPriceTextView);
            fevmarketTextView = itemView.findViewById(R.id.fevmarketTextView);
            fevmarketPriceTextView = itemView.findViewById(R.id.fevmarketPriceTextView);
            ivBackground = itemView.findViewById(R.id.ivBackground);
        }
    }
}
