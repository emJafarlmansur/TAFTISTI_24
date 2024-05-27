package com.tugas.tugasakhir2024;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.tugas.tugasakhir2024.INDODAX.ApiClientIDX;
import com.tugas.tugasakhir2024.INDODAX.InterfaceIDX;
import com.tugas.tugasakhir2024.INDODAX.Tiker;
import com.tugas.tugasakhir2024.LUNO.ApiClientLUNO;
import com.tugas.tugasakhir2024.LUNO.InterfaceLUNO;
import com.tugas.tugasakhir2024.LUNO.OrderbookLN;
import com.tugas.tugasakhir2024.TOKOCRYPTO.ApiClientTKO;
import com.tugas.tugasakhir2024.TOKOCRYPTO.InterfaceTKO;
import com.tugas.tugasakhir2024.TOKOCRYPTO.OrderbookTKO;
import com.tugas.tugasakhir2024.UPBIT.ApiClientUPBIT;
import com.tugas.tugasakhir2024.UPBIT.InterfaceUPBIT;
import com.tugas.tugasakhir2024.UPBIT.Orderbook;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String[] INDODAX_PAIRS = {"btcidr", "ethidr", "solidr"};
    private static final String[] UPBIT_PAIRS = {"IDR-BTC", "IDR-ETH", "IDR-SOL"};
    private static final String[] LUNO_PAIRS = {"XBTIDR", "ETHIDR", "SOLIDR"};
    private static final String[] TOKOCRYPTO_PAIRS = {"BTC_IDR","ETH_IDR","SOL_IDR"};

    private static InterfaceTKO interfaceTKO= ApiClientTKO.getClient().create(InterfaceTKO.class);

    private static InterfaceIDX interfaceIDX = ApiClientIDX.getClient().create(InterfaceIDX.class);
    private static InterfaceUPBIT interfaceUPBIT = ApiClientUPBIT.getClient().create(InterfaceUPBIT.class);
    private static InterfaceLUNO interfaceLUNO = ApiClientLUNO.getClient().create(InterfaceLUNO.class);
    private TextView tx1, tx2, tx3, tx4,tx5,tx6,tx7,tx8,tx9,tx10,tx11,tx12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx1 = findViewById(R.id.tx1);
        tx2 = findViewById(R.id.tx2);
        tx3 = findViewById(R.id.tx3);
        tx4=findViewById(R.id.tx4);
        tx5=findViewById(R.id.txt5);
        tx6=findViewById(R.id.txt6);
        tx7=findViewById(R.id.txt7);
        tx8=findViewById(R.id.txt8);
        tx9=findViewById(R.id.txt9);
        tx10=findViewById(R.id.txt10);
        tx11=findViewById(R.id.txt11);
        tx12=findViewById(R.id.txt12);

        getTKOPrices();
      getUPBprc();
     getIDXprc();
     getLUNOprc();

    }

    //---UPBIT
    private void getUPBprc() {
        for (String upbCryptoPair : UPBIT_PAIRS) {
            getHrgUPB(upbCryptoPair);
        }
    }

    private void getHrgUPB(String upbCryptoPair) {
        interfaceUPBIT.getUPB(upbCryptoPair).enqueue(new Callback<ArrayList<Orderbook>>() {

            @Override
            public void onResponse(@NonNull Call<ArrayList<Orderbook>>call, Response<ArrayList<Orderbook>> response) {
                if (response.isSuccessful()) {
                    try {
                        ArrayList<Orderbook> orderbook = response.body();

                        // Check for data availability
                        if (orderbook != null && orderbook.get(0).getOrderbookUnits() != null && !orderbook.isEmpty()){
                            if (upbCryptoPair.equals("IDR-BTC")) {
                                int askPrice = orderbook.get(0).getOrderbookUnits().get(0).getAskPrice();
                                tx1.setText("BTC : " + askPrice); // Update specific TextView
                            }
                            if ( upbCryptoPair.equals("IDR-ETH")) {
                                int askPrice = orderbook.get(0).getOrderbookUnits().get(0).getAskPrice();
                                tx2.setText("ETH : " + askPrice);
                            }
                            if ( upbCryptoPair.equals("IDR-SOL")) {
                                int askPrice = orderbook.get(0).getOrderbookUnits().get(0).getAskPrice();
                                tx3.setText("SOL : " + askPrice);
                            }
//                            if ( upbCryptoPair.equals("IDR-XRP")) {
//                                int askPrice = orderbook.get(0).getOrderbookUnits().get(0).getAskPrice();
//                                tx4.setText("XRP: " + askPrice);
//                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Data Kosong untuk " + upbCryptoPair, LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Error parsing data", LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Gagal memuat data untuk " + upbCryptoPair, LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Orderbook>> call, Throwable t) {
                tx1.setText("error"+t.getMessage());
            }
    });}

    //---INDODAX
    private void getIDXprc() {
        for (String idxCryptoPair : INDODAX_PAIRS) {
            getHrgIDX(idxCryptoPair);
        }
    }
    private void getHrgIDX(String idxCryptoPair) {
        interfaceIDX.getPriceIDX(idxCryptoPair).enqueue(new Callback<Tiker>() {

            @Override
            public void onResponse(@NonNull Call<Tiker>call, Response<Tiker> response) {
                if (response.isSuccessful()) {
                    try {
                        Tiker tiker = response.body();

                        // Check for data availability
                        if (tiker != null && tiker.getTicker() !=null ) {
                            if (idxCryptoPair.equals("btcidr")) {
                                String askPrice = tiker.getTicker().getSell();
                                tx4.setText("btc: " + askPrice); // Update specific TextView
                            }
                            if ( idxCryptoPair.equals("ethidr")) {
                                String askPrice = tiker.getTicker().getSell();
                                tx5.setText("eth: " + askPrice);
                            }
                            if ( idxCryptoPair.equals("solidr")) {
                                String askPrice = tiker.getTicker().getSell();
                                tx6.setText("sol: " + askPrice);
                           }
                        } else {
                            Toast.makeText(MainActivity.this, "Data Kosong untuk " + idxCryptoPair, LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Error parsing data", LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Gagal memuat data untuk " + idxCryptoPair, LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Tiker> call, Throwable t) {
                tx5.setText("error"+t.getMessage());
            }
        });
    }
    //---LUNO
    private void getLUNOprc() {
        for (String lunoCryptoPair : LUNO_PAIRS) {
            getHrgLUNO(lunoCryptoPair);
        }
    }
    private void getHrgLUNO(String lunoCryptoPair) {
        interfaceLUNO.getPriceLUNO(lunoCryptoPair).enqueue(new Callback<OrderbookLN>() {

            @Override
            public void onResponse(@NonNull Call<OrderbookLN>call, Response<OrderbookLN> response) {
                if (response.isSuccessful()) {
                    try {
                        OrderbookLN orderbookLN = response.body();

                        // Check for data availability
                        if (orderbookLN != null && orderbookLN.getStatus().equals("ACTIVE") ) {
                            if (lunoCryptoPair.equals("XBTIDR")) {
                                String askPrice = orderbookLN.getAsk();
                                tx7.setText("btc: " + askPrice); // Update specific TextView
                            }
                            if ( lunoCryptoPair.equals("ETHIDR")) {
                                String askPrice = orderbookLN.getAsk();
                                tx8.setText("eth: " + askPrice);
                            }
                            if (lunoCryptoPair.equals("SOLIDR")) {
                                String askPrice = orderbookLN.getAsk();
                                tx9.setText("sol: " + askPrice);
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Data Kosong untuk " + lunoCryptoPair, LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Error parsing data", LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Gagal memuat data untuk " + lunoCryptoPair, LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OrderbookLN> call, Throwable t) {
                tx5.setText("error"+t.getMessage());
            }
        });
    }
    //---TOKOCRYPTO
    private void getTKOPrices() {
        for (String tkoCryptoPair : TOKOCRYPTO_PAIRS) {
            getHrgTKO(tkoCryptoPair);
        }
    }
        private void getHrgTKO(String tkoCryptoPair) {
            interfaceTKO.getTKO(tkoCryptoPair,5).enqueue(new Callback<OrderbookTKO>() {

                @Override
                public void onResponse(@NonNull Call<OrderbookTKO>call, Response<OrderbookTKO> response) {
                    if (response.isSuccessful()) {
                        try {
                            OrderbookTKO orderbookTKO = response.body();

                            // Check for data availability
                            if (orderbookTKO != null && orderbookTKO.getData() !=null ) {
                                if (tkoCryptoPair.equals("BTC_IDR")) {
                                    String askPrice = orderbookTKO.getData().getBids().get(0).get(0);
                                    tx10.setText("SOL: " + askPrice); // Update specific TextView
                                }
                                if ( tkoCryptoPair.equals("ETH_IDR")) {
                                    String askPrice = orderbookTKO.getData().getBids().get(0).get(0);
                                    tx11.setText("eth: " + askPrice);
                                }
                                if (tkoCryptoPair.equals("SOL_IDR")) {
                                    String askPrice = orderbookTKO.getData().getBids().get(0).get(0);
                                    tx12.setText("sol: " + askPrice);
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "Data Kosong untuk " + tkoCryptoPair, LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "Error parsing data", LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Gagal memuat data untuk " + tkoCryptoPair, LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<OrderbookTKO> call, Throwable t) {
                    tx5.setText("error"+t.getMessage());
                }
            });
        }
}
