package co.id.kasrt

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class BayarKasActivity : AppCompatActivity() {

    private lateinit var etJumlah: EditText
    private lateinit var rgMetodeTransfer: RadioGroup
    private lateinit var rbBank: RadioButton
    private lateinit var rbEWallet: RadioButton
    private lateinit var tvRekeningBank: TextView
    private lateinit var tvEWallet: TextView
    private lateinit var ivBuktiTransfer: ImageView
    private lateinit var btnUploadBukti: Button
    private lateinit var etKeterangan: EditText
    private lateinit var btnSimpan: Button

    private val PICK_IMAGE = 1
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bayar_kas)

        etJumlah = findViewById(R.id.etJumlah)
        rgMetodeTransfer = findViewById(R.id.rgMetodeTransfer)
        rbBank = findViewById(R.id.rbBank)
        rbEWallet = findViewById(R.id.rbEWallet)
        tvRekeningBank = findViewById(R.id.tvRekeningBank)
        tvEWallet = findViewById(R.id.tvEWallet)
        ivBuktiTransfer = findViewById(R.id.ivBuktiTransfer)
        btnUploadBukti = findViewById(R.id.btnUploadBukti)
        etKeterangan = findViewById(R.id.etKeterangan)
        btnSimpan = findViewById(R.id.btnSimpan)

        rgMetodeTransfer.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rbBank -> {
                    tvRekeningBank.visibility = TextView.VISIBLE
                    tvEWallet.visibility = TextView.GONE
                }
                R.id.rbEWallet -> {
                    tvRekeningBank.visibility = TextView.GONE
                    tvEWallet.visibility = TextView.VISIBLE
                }
            }
        }

        btnUploadBukti.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE)
        }

        btnSimpan.setOnClickListener {
            simpanData()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            imageUri = data?.data
            ivBuktiTransfer.setImageURI(imageUri)
        }
    }

    private fun simpanData() {
        val jumlah = etJumlah.text.toString()
        val metodeTransfer = when (rgMetodeTransfer.checkedRadioButtonId) {
            R.id.rbBank -> "Transfer Bank"
            R.id.rbEWallet -> "E-Wallet"
            else -> ""
        }
        val keterangan = etKeterangan.text.toString()

        if (jumlah.isEmpty() || metodeTransfer.isEmpty() || imageUri == null || keterangan.isEmpty()) {
            Toast.makeText(this, "Mohon lengkapi semua data", Toast.LENGTH_SHORT).show()
        } else {
            // Implementasi penyimpanan data, misalnya mengirim data ke server atau menyimpannya dalam database lokal.
            // Contoh: Mengirim data ke server (menggunakan Retrofit atau library lainnya)

            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show()
        }
    }
}
