package com.example.android.ui.management_event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.databinding.FragmentManagementeventBinding
import com.inyongtisto.myhelper.extension.visible

class Management_EventFragment : Fragment() {

    private var _binding: FragmentManagementeventBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentManagementeventBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.tbTambah.setOnClickListener {
            binding.txtTambahEvent.visible(true)
            binding.formEvent.visible(true)
            binding.tbShowEvent.visible(false)
        }
        binding
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}