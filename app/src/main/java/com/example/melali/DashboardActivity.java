package com.example.melali;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    // Metode untuk logout
    public void logout(View view) {
        // Hapus status login dari penyimpanan preferensi bersama
        SharedPreferences preferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isLoggedIn", false);
        editor.apply();

        // Arahkan pengguna kembali ke halaman login
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Menghapus semua aktivitas sebelumnya
        startActivity(intent);
        finish(); // Tutup aktivitas saat ini
    }
}
