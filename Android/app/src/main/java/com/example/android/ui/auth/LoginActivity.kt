package com.example.android.ui.auth

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.R
import com.example.android.databinding.ActivityAuthBinding
import com.example.android.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onBackPressed() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Keluar")
        builder.setMessage("Apakah Anda yakin ingin membatalkan login?")
        builder.setPositiveButton("Ya", DialogInterface.OnClickListener { dialog, which ->
            finish()
        })
        builder.setNegativeButton("Tidak",
            DialogInterface.OnClickListener { dialog, which ->
                // Tambahkan kode yang ingin Anda jalankan saat pengguna menekan "Tidak"
                dialog.dismiss() // Menutup dialog
            })
        builder.show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackLogin.setOnClickListener {
            onBackPressed()
        }
        binding.txtSignUp.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}