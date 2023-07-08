package com.example.android.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.databinding.FragmentDashboardpageBinding
import com.example.android.databinding.FragmentLinkeventBinding
import com.example.android.util.Preft
import com.inyongtisto.myhelper.extension.logs

class DashboardpageFragment : Fragment() {

    private var _binding: FragmentDashboardpageBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
            ViewModelProvider(this).get(DashboardpageViewModel::class.java)

        _binding = FragmentDashboardpageBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnLogout.setOnClickListener {
            Preft.isLogin=false
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}