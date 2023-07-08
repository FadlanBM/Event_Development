package com.example.android.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android.R
import com.example.android.databinding.ActivityMainBinding
import com.example.android.databinding.NavHeaderDashboardBinding
import com.example.android.util.Preft

class ProfileActivity : AppCompatActivity() {
    private var _binding: NavHeaderDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _binding = NavHeaderDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun setUser(){
        val user= Preft.getUser()
        if (user !=null){
            binding.apply {
                txtUser.text="dsdasdsa"
                txtEmail.text=user.email
            }
        }
    }

}