package com.tugas.tugasakhir2024;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class Pengaturan extends AppCompatActivity {

    private CheckBox btcCheckBox;
    private CheckBox ethCheckBox;
    private CheckBox solCheckBox;
    private SharedPreferences sharedPreferences;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);

        btcCheckBox = findViewById(R.id.btcCheckBox);
        ethCheckBox = findViewById(R.id.ethCheckBox);
        solCheckBox = findViewById(R.id.solCheckBox);
        saveButton = findViewById(R.id.saveButton);

        sharedPreferences = getSharedPreferences("CoinPreferences", MODE_PRIVATE);

        btcCheckBox.setChecked(sharedPreferences.getBoolean("BTC_IDR", true));
        ethCheckBox.setChecked(sharedPreferences.getBoolean("ETH_IDR", true));
        solCheckBox.setChecked(sharedPreferences.getBoolean("SOL_IDR", true));

        saveButton.setOnClickListener(v -> {
            savePreference("BTC_IDR", btcCheckBox.isChecked());
            savePreference("ETH_IDR", ethCheckBox.isChecked());
            savePreference("SOL_IDR", solCheckBox.isChecked());
            finish();  // Close the SettingsActivity and return to MainActivity
        });
    }

    private void savePreference(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
}