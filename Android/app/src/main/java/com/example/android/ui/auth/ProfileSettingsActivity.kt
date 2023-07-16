package com.example.android.ui.auth

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.android.MainActivity
import com.example.android.R
import com.example.android.databinding.ActivityLoginBinding
import com.example.android.databinding.ActivityProfileBinding
import com.example.android.databinding.ActivityProfileSettingsBinding
import com.example.android.util.BASE_API
import com.example.android.util.Preft
import com.squareup.picasso.Picasso

class ProfileSettingsActivity : AppCompatActivity() {
    private var _binding: ActivityProfileSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_settings)

        _binding = ActivityProfileSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        callfun()

    }
    private fun callfun(){
        setUser()
        hendelerButton()
    }

    private fun hendelerButton(){
        binding.btnToChangeAccunt.setOnClickListener {
            startActivity(Intent(this,ProfileActivity::class.java))
        }
        binding.btnChangeData.setOnClickListener {
            startActivity(Intent(this,ChangePersonalDataActivity::class.java))
        }
        binding.btnLogout.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setTitle("Keluar")
            builder.setMessage("Apakah Anda yakin ingin Logout ?")
            builder.setPositiveButton("Ya", DialogInterface.OnClickListener { dialog, which ->
                Preft.isLogin=false
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
    }
    private fun setUser(){
        val users=Preft.getUser()
        if (users!=null){
            binding.textEmail.text=users.email
        }
        Picasso.get().load(BASE_API.USER_URL+users?.image).into(binding.imageProfile)
    }
}