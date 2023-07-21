package com.example.android.ui.management_event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.DashboardActivity
import com.example.android.core.data.resourch.network.State
import com.example.android.core.data.resourch.request.EventsRequest
import com.example.android.core.data.resourch.request.RegisterRequest
import com.example.android.databinding.FragmentManagementeventBinding
import com.example.android.ui.auth.RegisterViewModel
import com.example.android.ui.base.Myactivity
import com.example.android.util.Preft
import com.inyongtisto.myhelper.extension.dismisLoading
import com.inyongtisto.myhelper.extension.int
import com.inyongtisto.myhelper.extension.isEmpty
import com.inyongtisto.myhelper.extension.pushActivity
import com.inyongtisto.myhelper.extension.showLoading
import com.inyongtisto.myhelper.extension.showToast
import com.inyongtisto.myhelper.extension.toastError
import com.inyongtisto.myhelper.extension.toastInfo
import com.inyongtisto.myhelper.extension.visible
import org.koin.androidx.viewmodel.ext.android.viewModel

class Management_EventFragment : Fragment() {

    private val viewModel: Management_ViewModel by viewModel()
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


        buttonHendller()

        binding
        return root
    }

    private fun clearData(){
        binding.tbName.setText("")
        binding.tbUraian.setText("")
        binding.tbTujuan.setText("")
        binding.tbTanggal.setText("")
        binding.tbWaktu.setText("")
    }

    private  fun hendelerFromEvent(){
            binding.txtTambahEvent.visible(true)
            binding.formEvent.visible(true)
            binding.tbShowEvent.visible(false)
        binding.tbTambah.visible(false)
        binding.linerShowData.visible(false)
    }
    private fun hendelerListEvent(){
            binding.tbShowEvent.visible(true)
            binding.txtTambahEvent.visible(false)
            binding.formEvent.visible(false)
        binding.tbTambah.visible(true)
        binding.linerShowData.visible(true)
    }
    private fun buttonHendller(){
        binding.btnSubmitEvent.setOnClickListener {
            register()
            hendelerListEvent()
        }
        binding.tbTambah.setOnClickListener {
            hendelerFromEvent()
        }
        binding.tbnCancelEvent.setOnClickListener {
            hendelerListEvent()
        }
    }
    private fun register(){
        if (binding.tbName.isEmpty()) return
        if (binding.tbUraian.isEmpty()) return
        if (binding.tbTujuan.isEmpty()) return
        if (binding.tbTanggal.isEmpty()) return
        if (binding.tbWaktu.isEmpty()) return

        var id=Preft.getUser()?.id
        val body= EventsRequest(id.int(),binding.tbName.text.toString(),binding.tbUraian.text.toString(),binding.tbTujuan.text.toString(),binding.tbTanggal.text.toString(),binding.tbWaktu.text.toString())
        viewModel.events(body).observe(viewLifecycleOwner){
            when (it.state){
                State.SUCCESS->{
                    binding.progressBarrEvent.visible(false)
                    toastInfo("Berhasi Menambahkan data")
                    clearData()
                }
                State.ERROR->{
                    binding.progressBarrEvent.visible(false)
                    toastError(it.message.toString())
                }
                State.LOADING->{
                    binding.progressBarrEvent.visible(true)
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}