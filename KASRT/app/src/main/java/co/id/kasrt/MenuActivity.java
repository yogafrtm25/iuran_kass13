package co.id.kasrt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    LinearLayout tombolSatu;
    LinearLayout tombolDua;
    LinearLayout tombolTiga;
    LinearLayout tombolEmpat;
    LinearLayout tombolLima;
    LinearLayout tombolEnam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Inisialisasi LinearLayout dengan findViewById setelah setContentView
        tombolSatu = findViewById(R.id.btnLaporanKas);
        tombolDua = findViewById(R.id.btnDaftarWarga);
        tombolTiga = findViewById(R.id.btnTambahDokument);
        tombolEmpat = findViewById(R.id.btnBayarKas);
        tombolLima = findViewById(R.id.btnTambahDokument);
        tombolEnam = findViewById(R.id.btnInformasi);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        tombolSatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, LaporanActivity.class);
                startActivity(intent);
            }
        });

        tombolDua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        tombolTiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, SecurityActivity.class);
                startActivity(intent);
            }
        });

        tombolEmpat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, BayarKasActivity.class);
                startActivity(intent);
            }
        });

        tombolLima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,   SecurityActivity.class);
                startActivity(intent);
            }
        });

        tombolEnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, InformasiActivity.class);
                startActivity(intent);
            }
        });
    }
}
