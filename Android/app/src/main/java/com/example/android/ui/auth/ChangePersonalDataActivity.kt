package com.example.android.ui.auth

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android.R
import com.example.android.core.data.resourch.network.State
import com.example.android.core.data.resourch.request.PersonalRequest
import com.example.android.databinding.ActivityChangePersonalDataBinding
import com.example.android.util.Preft
import com.inyongtisto.myhelper.extension.dismisLoading
import com.inyongtisto.myhelper.extension.int
import com.inyongtisto.myhelper.extension.isEmpty
import com.inyongtisto.myhelper.extension.pushActivity
import com.inyongtisto.myhelper.extension.showLoading
import com.inyongtisto.myhelper.extension.showToast
import com.inyongtisto.myhelper.extension.toastError
import com.inyongtisto.myhelper.extension.visible
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChangePersonalDataActivity : AppCompatActivity() {
    private val viewModel: ChangePersonalViewModel by viewModel()
    private var _binding: ActivityChangePersonalDataBinding? = null
    private val binding get() = _binding!!
    private var getradio:String=""
    private val person= Preft.getPerson()

    override fun onBackPressed() {
        if (person?.fullname.toString()!=binding.tbFullname.text.toString()||person?.birth.toString()!=binding.tbBirth.text.toString()||person?.address.toString()!=binding.tbAddress.text.toString()||person?.phone.toString()!=binding.tbPhone.text.toString()||person?.sex.toString()!=getradio){
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setTitle("Beralih")
            builder.setMessage("Jika anda keluar perubahan di hapus")
            builder.setPositiveButton("Ya", DialogInterface.OnClickListener { dialog, which ->
                startActivity(Intent(this,ProfileSettingsActivity::class.java))
            })
            builder.setNegativeButton("Tidak",
                DialogInterface.OnClickListener { dialog, which ->
                    // Tambahkan kode yang ingin Anda jalankan saat pengguna menekan "Tidak"
                    dialog.dismiss() // Menutup dialog
                })
            builder.show()
        }else{
            startActivity(Intent(this,ProfileSettingsActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_personal_data)
        _binding = ActivityChangePersonalDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //functions
        hendelerFun()
    }

    private fun hendelerButton(){
        binding.btnSubmit.setOnClickListener {
            setPersonal()
        }
        binding.btnBackSettings.setOnClickListener {
         onBackPressed()
        }
    }


    private fun hendelerFun(){
        setUser()
        hendelerButton()
        hendelerRadio()
    }
    private fun setUser(){
        if (person !=null){
            binding.apply {
                tbFullname.setText(person.fullname)
                tbBirth.setText(person.birth)
                tbPhone.setText(person.phone)
                tbAddress.setText(person.address)
                if (person.sex=="M"){
                    rdMale.isChecked=true
                    getradio="M"
                }else if (person.sex=="F"){
                    rdFemale.isChecked=true
                    getradio="F"
                }
            }
        }
    }

    private fun setPersonal(){
        val getid=Preft.getUser()?.id;
        if (binding.tbFullname.isEmpty()) return
        if (binding.tbPhone.isEmpty()) return
        if (binding.tbBirth.isEmpty()) return
        if (binding.tbAddress.isEmpty()) return
        val body= PersonalRequest(getid.int(),binding.tbFullname.text.toString(),binding.tbBirth.text.toString(),binding.tbAddress.text.toString(),binding.tbPhone.text.toString(),getradio)
        viewModel.postPersonal(body).observe(this){
            when (it.state){
                State.SUCCESS->{
                        binding.loading.visible(false)
//                    dismisLoading()
//                    showToast("Data Berhasil Di Perbarui")
                    startActivity(Intent(this,ProfileSettingsActivity::class.java))
                    Toast.makeText(this,"Berhasil Update Data Personal!",Toast.LENGTH_SHORT).show()
                }
                State.ERROR->{
                    binding.loading.visible(false)
//                    dismisLoading()
//                    toastError(it.message?:"terjadi kesalahan")
                    alert.showAlert(this,"Erorr",it.message?:"Terjadi Kesalahan")
                }
                State.LOADING->{
                    binding.loading.visible(true)
//                    showLoading()
                }
            }
        }
    }


    private fun getPersonal(){
        val getid=Preft.getUser()?.id;
        viewModel.getPersonal(getid).observe(this){
        }
    }
    private fun hendelerRadio(){

        binding.rdMale.setOnClickListener {
            binding.rdFemale.isChecked=false
            getradio="M"
        }
        binding.rdFemale.setOnClickListener {
            binding.rdMale.isChecked=false
            getradio="F"
        }
    }
}