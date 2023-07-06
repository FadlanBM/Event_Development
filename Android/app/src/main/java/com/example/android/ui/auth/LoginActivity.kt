package com.example.android.ui.auth

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.R
import com.example.android.core.data.resourch.request.LoginRequest
import com.example.android.databinding.ActivityAuthBinding
import com.example.android.databinding.ActivityLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModel()
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
        setData()
    }

    fun setData(){
        viewModel.text.observe(this){
            binding.tbEmail.setText(it)
        }
        binding.btnLogin.setOnClickListener {
            val body=LoginRequest(binding.tbEmail.text.toString(),binding.tbPassword.text.toString())
            viewModel.login(body).observe(this,{

            })
        }
    }

}