package com.tugas.tugasakhir2024;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


    public class MarketPriceAdapter extends RecyclerView.Adapter<MarketPriceViewHolder> {

        private List<MarketPrice> marketPrices;

        public MarketPriceAdapter(List<MarketPrice> marketPrices) {
            this.marketPrices = marketPrices;
        }

        @Override
        public MarketPriceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_note, parent, false);
            return new MarketPriceViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MarketPriceViewHolder holder, int position) {
            MarketPrice marketPrice = marketPrices.get(position);
            holder.marketTextView.setText(marketPrice.getMarket());
            holder.coinTextView.setText(marketPrice.getCoin());
            holder.priceTextView.setText(marketPrice.getPrice());
        }

        @Override
        public int getItemCount() {
            return marketPrices.size();
        }

        public void setData(List<MarketPrice> marketPrices) {
            this.marketPrices = marketPrices;
            notifyDataSetChanged();
        }
    }

    class MarketPriceViewHolder extends RecyclerView.ViewHolder {

        public TextView marketTextView;
        public TextView coinTextView;
        public TextView priceTextView;

        public MarketPriceViewHolder(View itemView) {
            super(itemView);
            marketTextView = itemView.findViewById(R.id.marketId);
            coinTextView = itemView.findViewById(R.id.koinId);
            priceTextView = itemView.findViewById(R.id.hargaId);
        }
    }


