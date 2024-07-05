package co.id.kasrt

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import co.id.kasrt.R

class LaporanKasActivity : AppCompatActivity() {
    private lateinit var tvPemasukan: TextView
    private lateinit var tvPengeluaran: TextView
    private lateinit var btnTambahPengeluaran: Button
    private var pemasukan = 0
    private var pengeluaran = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan_kas)

        tvPemasukan = findViewById(R.id.tvPemasukan)
        tvPengeluaran = findViewById(R.id.tvPengeluaran)
        btnTambahPengeluaran = findViewById(R.id.btnTambahPengeluaran)

        // Dapatkan nilai pemasukan dan pengeluaran dari SharedPreferences
        val sharedPreferences = getSharedPreferences("LaporanKas", MODE_PRIVATE)
        pemasukan = sharedPreferences.getInt("Pemasukan", 0)
        pengeluaran = sharedPreferences.getInt("Pengeluaran", 0)
        updateLaporanKas()

        btnTambahPengeluaran.setOnClickListener {
            // Tambahkan pengeluaran
            pengeluaran += 100 // Contoh menambah pengeluaran sebesar 100
            val editor = sharedPreferences.edit()
            editor.putInt("Pengeluaran", pengeluaran)
            editor.apply()
            updateLaporanKas()
        }
    }

    private fun updateLaporanKas() {
        tvPemasukan.text = "Pemasukan: $pemasukan"
        tvPengeluaran.text = "Pengeluaran: $pengeluaran"
    }
}
