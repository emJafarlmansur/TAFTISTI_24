package com.tugas.tugasakhir2024;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.tugas.tugasakhir2024.INDODAX.ApiClientIDX;
import com.tugas.tugasakhir2024.INDODAX.InterfaceIDX;
import com.tugas.tugasakhir2024.LUNO.ApiClientLUNO;
import com.tugas.tugasakhir2024.LUNO.InterfaceLUNO;
import com.tugas.tugasakhir2024.LUNO.OrderbookLN;
import com.tugas.tugasakhir2024.REKU.ApiClientREKU;
import com.tugas.tugasakhir2024.REKU.InterfaceREKU;
import com.tugas.tugasakhir2024.REKU.OrderbookRK;
import com.tugas.tugasakhir2024.TOKOCRYPTO.ApiClientTKO;
import com.tugas.tugasakhir2024.TOKOCRYPTO.InterfaceTKO;
import com.tugas.tugasakhir2024.TOKOCRYPTO.OrderbookTKO;
import com.tugas.tugasakhir2024.UPBIT.ApiClientUPBIT;
import com.tugas.tugasakhir2024.UPBIT.InterfaceUPBIT;
import com.tugas.tugasakhir2024.UPBIT.Orderbook;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String[] INDODAX_PAIRS = {"btcidr", "ethidr", "solidr"};
    private static final String[] UPBIT_PAIRS = {"IDR-BTC", "IDR-ETH", "IDR-SOL"};
    private static final String[] LUNO_PAIRS = {"XBTIDR", "ETHIDR", "SOLIDR"};
    private static final String[] TOKOCRYPTO_PAIRS = {"BTC_IDR","ETH_IDR","SOL_IDR"};
    private static final String[] REKU_PAIRS = {"1","51","4"};

    private static InterfaceTKO interfaceTKO= ApiClientTKO.getClient().create(InterfaceTKO.class);
    private static InterfaceREKU interfaceRKU= ApiClientREKU.getClient().create(InterfaceREKU.class);
    private static InterfaceIDX interfaceIDX = ApiClientIDX.getClient().create(InterfaceIDX.class);
    private static InterfaceUPBIT interfaceUPBIT = ApiClientUPBIT.getClient().create(InterfaceUPBIT.class);
    private static InterfaceLUNO interfaceLUNO = ApiClientLUNO.getClient().create(InterfaceLUNO.class);
    private TextView tx1, tx2, tx3, tx4,tx5,tx6,tx7,tx8,tx9,tx10,tx11,tx12,tx13;
    private CombinedPriceAdapter  adapterss;
    private List<Combine> combinedPriceList;
    RecyclerView recyclerView;
    private Button scanButton;
    private Button settingsButton;
    private SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.risaikelKoin);
        sharedPreferences = getSharedPreferences("CoinPreferences", MODE_PRIVATE);
        combinedPriceList = new ArrayList<>();
        adapterss = new CombinedPriceAdapter(combinedPriceList);
        recyclerView.setAdapter(adapterss);
        scanButton = findViewById(R.id.scan_button);
        settingsButton = findViewById(R.id.settings_button);
        scanButton.setOnClickListener(v -> fetchPrices());

        settingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Pengaturan.class);
            startActivity(intent);
        });
//        tx1 = findViewById(R.id.tx1);
//        tx2 = findViewById(R.id.tx2);
//        tx3 = findViewById(R.id.tx3);
//        tx4=findViewById(R.id.tx4);
//        tx5=findViewById(R.id.txt5);
//        tx6=findViewById(R.id.txt6);
//        tx7=findViewById(R.id.txt7);
//        tx8=findViewById(R.id.txt8);
//        tx9=findViewById(R.id.txt9);
//        tx10=findViewById(R.id.txt10);
//        tx11=findViewById(R.id.txt11);
//        tx12=findViewById(R.id.txt12);
//        tx13=findViewById(R.id.txt13);

//
//        getTKOPrices();
 //     getUPBprc();
 //    getIDXprc();
//     getLUNOprc();
//     getREKUprc();

        //TRIAL SCETION


    }
    private void fetchPrices() {

        combinedPriceList.clear();
   //     adapterss.notifyDataSetChanged();  // Notify adapter that data set has changed
        for (int i = 0; i < UPBIT_PAIRS.length; i++) {
            String upbitPair = UPBIT_PAIRS[i];
            String tokocryptoPair = TOKOCRYPTO_PAIRS[i];
            boolean isEnabled = sharedPreferences.getBoolean(tokocryptoPair, true);

            if (isEnabled) {
                fetchPriceForPair(upbitPair, tokocryptoPair);
            }
        }
    }
    private void fetchPriceForPair(String upbitPair, String tokocryptoPair) {
        Call<ArrayList<Orderbook>> upbitCall = interfaceUPBIT.getUPB(upbitPair);
        Call<OrderbookTKO> tokocryptoCall = interfaceTKO.getTKO(tokocryptoPair, 5);

        upbitCall.enqueue(new Callback<ArrayList<Orderbook>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Orderbook>> call, @NonNull Response<ArrayList<Orderbook>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    String upbitPrice = String.valueOf(response.body().get(0).getOrderbookUnits().get(0).getAskPrice());

                    tokocryptoCall.enqueue(new Callback<OrderbookTKO>() {
                        @Override
                        public void onResponse(@NonNull Call<OrderbookTKO> call, @NonNull Response<OrderbookTKO> response) {
                            if (response.isSuccessful() && response.body() != null && response.body().getData() != null) {
                                String tokocryptoPrice = response.body().getData().getBids().get(0).get(0);
                                combinedPriceList.add(new Combine(upbitPair,upbitPrice,tokocryptoPrice));
                                adapterss.notifyDataSetChanged();
                            } else {
                                Toast.makeText(MainActivity.this, "Failed to load Tokocrypto data for " + tokocryptoPair, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(@NonNull Call<OrderbookTKO> call, @NonNull Throwable t) {
                            Toast.makeText(MainActivity.this, "Tokocrypto API error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Failed to load UPBIT data for " + upbitPair, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Orderbook>> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "UPBIT API error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
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
                                tx7.setText("LUNO BTC: " + askPrice); // Update specific TextView
                            }
                            if ( lunoCryptoPair.equals("ETHIDR")) {
                                String askPrice = orderbookLN.getAsk();
                                tx8.setText("LUNO ETH: " + askPrice);
                            }
                            if (lunoCryptoPair.equals("SOLIDR")) {
                                String askPrice = orderbookLN.getAsk();
                                tx9.setText("LUNO SOL: " + askPrice);
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
                                    tx10.setText("TKO BTC: " + askPrice); // Update specific TextView
                                }
                                if ( tkoCryptoPair.equals("ETH_IDR")) {
                                    String askPrice = orderbookTKO.getData().getBids().get(0).get(0);
                                    tx11.setText("TKO ETH: " + askPrice);
                                }
                                if (tkoCryptoPair.equals("SOL_IDR")) {
                                    String askPrice = orderbookTKO.getData().getBids().get(0).get(0);
                                    tx12.setText("TKO SOL: " + askPrice);
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

    //---REKU
    private void getREKUprc() {
        for (String rekuCryptoPair : REKU_PAIRS) {
            getHrgREKU(rekuCryptoPair);
        }
    }
    private void getHrgREKU(String rekuCryptoPair) {
        interfaceRKU.getPriceRKu(rekuCryptoPair).enqueue(new Callback<OrderbookRK>() {

            @Override
            public void onResponse(@NonNull Call<OrderbookRK> call, Response<OrderbookRK> response) {
                if (response.isSuccessful()) {
                    try {
                        OrderbookRK orderbookRK = response.body();

                        // Check for data availability
                        if (orderbookRK != null && orderbookRK.getS()!=null){
                            if (rekuCryptoPair.equals("1")) {
                                String askPrice = orderbookRK.getS().get(0).get(1);
                                tx13.setText("REKU BTC: " + askPrice); // Update specific TextView
                            }
//                            if ( lunoCryptoPair.equals("ETHIDR")) {
//                                String askPrice = orderbookLN.getAsk();
//                                tx8.setText("LUNO ETH: " + askPrice);
//                            }
//                            if (lunoCryptoPair.equals("SOLIDR")) {
//                                String askPrice = orderbookLN.getAsk();
//                                tx9.setText("LUNO SOL: " + askPrice);
//                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Data Kosong untuk " + rekuCryptoPair, LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Error parsing data", LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Gagal memuat data untuk " + rekuCryptoPair, LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OrderbookRK> call, Throwable t) {
                tx5.setText("error" + t.getMessage());
            }
        });
    }
}
