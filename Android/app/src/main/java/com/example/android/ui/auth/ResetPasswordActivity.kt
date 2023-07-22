package com.example.android.ui.auth

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android.MainActivity
import com.example.android.R
import com.example.android.core.data.resourch.network.State
import com.example.android.core.data.resourch.request.PersonalRequest
import com.example.android.core.data.resourch.request.UpdateProfileRequest
import com.example.android.core.data.resourch.request.getPassRequest
import com.example.android.core.data.resourch.response.PersonalResponse
import com.example.android.databinding.ActivityChangePersonalDataBinding
import com.example.android.databinding.ActivityResetPasswordBinding
import com.example.android.util.Preft
import com.inyongtisto.myhelper.extension.dismisLoading
import com.inyongtisto.myhelper.extension.int
import com.inyongtisto.myhelper.extension.isEmpty
import com.inyongtisto.myhelper.extension.showLoading
import com.inyongtisto.myhelper.extension.showToast
import com.inyongtisto.myhelper.extension.toastError
import com.inyongtisto.myhelper.extension.visible
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResetPasswordActivity : AppCompatActivity() {
    private val viewModel: ChangePersonalViewModel by viewModel()
    private var _binding: ActivityResetPasswordBinding? = null
    private val viewModeledt: ProfileViewModel by viewModel()

    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        _binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //fun
        hendelerFun()
    }

    private fun  hendelerFun(){
        hendelerButton()
    }
    private fun verifyInput(){
        if (binding.tbPasswordOld.isEmpty())return
        if (binding.tbNewPassword.isEmpty())return
        if (binding.tbComfirmPassword.isEmpty())return

        if (binding.tbComfirmPassword.text.toString()!=binding.tbNewPassword.text.toString()){
            showToast("Passoword Tidak sama")
        }else{
            getPassOld()
        }
    }

    override fun onBackPressed() {
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
    }

    private fun hendelerButton(){
        binding.btnUpdatePass.setOnClickListener {
            verifyInput()
        }
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun getPassOld(){
        val getid=Preft.getUser()?.id;
        val body= getPassRequest(binding.tbPasswordOld.text.toString())
        viewModel.getPass(getid,body).observe(this){
            when (it.state){
                State.SUCCESS->{
//                    dismisLoading()
//                    showToast("Data Berhasil Di Perbarui")
                    updatePassword()
                }
                State.ERROR->{
                    binding.loading.visible(false)
                    alert.showAlert(this,"Error",it.message?:"Terjadi Kesalahan")
//                    dismisLoading()
//                    toastError(it.message?:"terjadi kesalahan")
                }
                State.LOADING->{
                    binding.loading.visible(true)
//                    showLoading()
                }
            }
        }
    }

    private fun notif(){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Beralih")
        builder.setMessage("Anda Telah merubah password akun anda anda harus Login lagi!")
        builder.setPositiveButton("Ya", DialogInterface.OnClickListener { dialog, which ->
            Preft.isLogin=false
            Preft.setPerson(PersonalResponse("","",null,null,0,"","",null,null))
            startActivity(Intent(this,MainActivity::class.java))
        })
        builder.show()
    }

    private fun updatePassword(){

        val id=Preft.getUser()?.id
        val body= UpdateProfileRequest(id.int(), password = binding.tbNewPassword.text.toString())
        viewModeledt.updateUser(body).observe(this){
            when (it.state){
                State.SUCCESS->{
                    binding.loading.visible(false)
//                    showToast("Berhasil Update Profile " + it?.body?.name)
                    notif()
                }
                State.ERROR->{
                    binding.loading.visible(false)
                    alert.showAlert(this,"Error",it.message?:"Terjadi Kesalahan")
//                    toastError(it.message?:"terjadi kesalahan")
                }
                State.LOADING->{
                    binding.loading.visible(true)
                }
            }
        }
    }
}