package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.databinding.ActivityCodeEventBinding
import com.example.android.databinding.ActivityMainBinding

class Code_Event_Activity : AppCompatActivity() {
    private var _binding: ActivityCodeEventBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_event)

        _binding = ActivityCodeEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackCode.setOnClickListener {
            onBackPressed()
        }
    }
}