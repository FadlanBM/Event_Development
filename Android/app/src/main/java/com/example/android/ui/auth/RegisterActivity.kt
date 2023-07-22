package com.example.android.ui.auth

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android.AuthActivity
import com.example.android.DashboardActivity
import com.example.android.R
import com.example.android.core.data.resourch.network.State
import com.example.android.core.data.resourch.request.LoginRequest
import com.example.android.core.data.resourch.request.RegisterRequest
import com.example.android.databinding.ActivityLoginBinding
import com.example.android.databinding.ActivityRegisterBinding
import com.inyongtisto.myhelper.extension.dismisLoading
import com.inyongtisto.myhelper.extension.getAlertDialog
import com.inyongtisto.myhelper.extension.isEmpty
import com.inyongtisto.myhelper.extension.pushActivity
import com.inyongtisto.myhelper.extension.showLoading
import com.inyongtisto.myhelper.extension.showToast
import com.inyongtisto.myhelper.extension.toastError
import com.inyongtisto.myhelper.extension.visible
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {
    private val viewModel: RegisterViewModel by viewModel()
    private var _binding: ActivityRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onBackPressed() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Keluar")
        builder.setMessage("Apakah Anda yakin ingin membatalkan Register?")
        builder.setPositiveButton("Ya", DialogInterface.OnClickListener { dialog, which ->
            startActivity(Intent(this, AuthActivity::class.java))
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
        setContentView(R.layout.activity_register)

        _binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackRegister.setOnClickListener {
            onBackPressed()
        }
        binding.btnSignIn.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setTitle("Beralih")
            builder.setMessage("Apakah Anda yakin sudah punya akun ?")
            builder.setPositiveButton("Ya", DialogInterface.OnClickListener { dialog, which ->
                startActivity(Intent(this,LoginActivity::class.java))
            })
            builder.setNegativeButton("Tidak",
                DialogInterface.OnClickListener { dialog, which ->
                    // Tambahkan kode yang ingin Anda jalankan saat pengguna menekan "Tidak"
                    dialog.dismiss() // Menutup dialog
                })
            builder.show()
        }
setData()
    }
    private fun setData(){
        binding.btnSignUp.setOnClickListener {
            if (binding.edtComfirmPassword.text.toString()!=binding.edtPassword.text.toString()){
                toastError("Password comfirm tidak sama")
            }else{
                register()
            }
        }
    }
    private fun register(){
        if (binding.edtName.isEmpty()) return
        if (binding.edtEmail.isEmpty()) return
        if (binding.edtPassword.isEmpty()) return
        if (binding.edtComfirmPassword.isEmpty()) return
        val body= RegisterRequest(binding.edtName.text.toString(),binding.edtEmail.text.toString(),binding.edtPassword.text.toString())
        viewModel.register(body).observe(this){
            when (it.state){
                State.SUCCESS->{
//                    dismisLoading()
                    binding.loading.visible(false)
                    Toast.makeText(this,"Selamat Datang "+it?.body?.name,Toast.LENGTH_SHORT).show()
//                    showToast("Selamat datang " + it?.body?.name)
                    pushActivity(DashboardActivity::class.java)
                }
                State.ERROR->{
                    binding.loading.visible(false)
//                    dismisLoading()
                    alert.showAlert(this,"Ërror",it.message?:"Terjadi Kesalahan")
//                    toastError(it.message?:"terjadi kesalahan")
                }
                State.LOADING->{
                    binding.loading.visible(true)
//                    showLoading()
                }
            }
        }
    }
}