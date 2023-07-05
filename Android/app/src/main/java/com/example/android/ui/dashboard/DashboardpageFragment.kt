package com.example.android.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.R
import com.example.android.databinding.FragmentDashboardpageBinding
import com.example.android.util.Preft

class DashboardpageFragment : AppCompatActivity() {

    private var _binding: FragmentDashboardpageBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        _binding = FragmentDashboardpageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val s=Preft(this)
        binding.btnLogout.setOnClickListener {
            s.setIsLogin(true)
        }
    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val homeViewModel =
//            ViewModelProvider(this).get(DashboardpageViewModel::class.java)
//
//        _binding = FragmentDashboardpageBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//
//        val textView: TextView = binding.textDashboardpage
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
//        return root
//        val s=Preft(this)
//        binding.btnLogout.setOnClickListener {
//            s.setIsLogin(true)
//        }
//
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}