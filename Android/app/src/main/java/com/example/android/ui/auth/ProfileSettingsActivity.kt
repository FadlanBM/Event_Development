package com.example.android.ui.auth

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.android.DashboardActivity
import com.example.android.MainActivity
import com.example.android.R
import com.example.android.core.data.resourch.request.PersonalRequest
import com.example.android.core.data.resourch.response.PersonalResponse
import com.example.android.databinding.ActivityLoginBinding
import com.example.android.databinding.ActivityProfileBinding
import com.example.android.databinding.ActivityProfileSettingsBinding
import com.example.android.util.BASE_API
import com.example.android.util.Preft
import com.inyongtisto.myhelper.extension.int
import com.inyongtisto.myhelper.extension.pushActivity
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileSettingsActivity : AppCompatActivity() {
    private var _binding: ActivityProfileSettingsBinding? = null
    private val viewModel: ChangePersonalViewModel by viewModel()
    private val binding get() = _binding!!
    override fun onBackPressed() {
        pushActivity(DashboardActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_settings)

        _binding = ActivityProfileSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        callfun()

    }
    private fun callfun(){
        hendelerButton()
        setUser()
    }

    private fun hendelerButton(){
        binding.btnToChangeAccunt.setOnClickListener {
            startActivity(Intent(this,ProfileActivity::class.java))
            finish()
        }
        binding.btnChangeData.setOnClickListener {
            startActivity(Intent(this,ChangePersonalDataActivity::class.java))
            finish()
        }
        binding.btnLogout.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setTitle("Keluar")
            builder.setMessage("Apakah Anda yakin ingin Logout ?")
            builder.setPositiveButton("Ya", DialogInterface.OnClickListener { dialog, which ->
                Preft.isLogin=false
                Preft.setPerson(PersonalResponse("","",null,null,0,"","",null,null))
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            })
            builder.setNegativeButton("Tidak",
                DialogInterface.OnClickListener { dialog, which ->
                    // Tambahkan kode yang ingin Anda jalankan saat pengguna menekan "Tidak"
                    dialog.dismiss() // Menutup dialog
                })
            builder.show()
        }
        binding.btnDeleteAccount.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setTitle("Keluar")
            builder.setMessage("Apakah Anda yakin ingin menghapus Accunt ?")
            builder.setPositiveButton("Ya", DialogInterface.OnClickListener { dialog, which ->
               delete_akun()
            })
            builder.setNegativeButton("Tidak",
                DialogInterface.OnClickListener { dialog, which ->
                    // Tambahkan kode yang ingin Anda jalankan saat pengguna menekan "Tidak"
                    dialog.dismiss() // Menutup dialog
                })
            builder.show()
        }

        binding.btnReset.setOnClickListener {
            pushActivity(ResetPasswordActivity::class.java)
        }
    }

    private fun delete_akun(){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Information")
        builder.setMessage("Anda Telah Menghapus Account Anda Harus Login/Register! ")
        builder.setPositiveButton("OK") { dialog, which ->
            Preft.isLogin=false
            val getid=Preft.getUser()?.id;
            viewModel.delete_account(getid).observe(this){
            }
            Preft.setPerson(PersonalResponse("","",null,null,0,"","",null,null))
            startActivity(Intent(this, MainActivity::class.java))
        }
        builder.show()
    }

    private fun setUser(){
        val users=Preft.getUser()
        if (users!=null){
            binding.textEmail.text=users.email
            binding.textName.text=users.name
        }
        Picasso.get().load(BASE_API.USER_URL+users?.image).into(binding.imageProfile)
    }
}