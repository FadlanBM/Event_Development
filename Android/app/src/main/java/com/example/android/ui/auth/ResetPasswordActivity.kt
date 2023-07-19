package com.example.android.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.R
import com.example.android.core.data.resourch.network.State
import com.example.android.core.data.resourch.request.PersonalRequest
import com.example.android.core.data.resourch.request.UpdateProfileRequest
import com.example.android.core.data.resourch.request.getPassRequest
import com.example.android.databinding.ActivityChangePersonalDataBinding
import com.example.android.databinding.ActivityResetPasswordBinding
import com.example.android.util.Preft
import com.inyongtisto.myhelper.extension.dismisLoading
import com.inyongtisto.myhelper.extension.int
import com.inyongtisto.myhelper.extension.isEmpty
import com.inyongtisto.myhelper.extension.showLoading
import com.inyongtisto.myhelper.extension.showToast
import com.inyongtisto.myhelper.extension.toastError
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

    private fun hendelerButton(){
        binding.btnUpdatePass.setOnClickListener {
            verifyInput()
        }
    }

    private fun getPassOld(){
        val getid=Preft.getUser()?.id;
        val body= getPassRequest(binding.tbPasswordOld.text.toString())
        viewModel.getPass(getid,body).observe(this){
            when (it.state){
                State.SUCCESS->{
                    dismisLoading()
                    showToast("Data Berhasil Di Perbarui")
                    updatePassword()
                }
                State.ERROR->{
                    dismisLoading()
                    toastError(it.message?:"terjadi kesalahan")
                }
                State.LOADING->{
                    showLoading()
                }
            }
        }
    }

    private fun updatePassword(){

        val id=Preft.getUser()?.id
        val body= UpdateProfileRequest(id.int(), password = binding.tbNewPassword.text.toString())
        viewModeledt.updateUser(body).observe(this){
            when (it.state){
                State.SUCCESS->{
                    showToast("Berhasil Update Profile " + it?.body?.name)
                    startActivity(Intent(this,ProfileSettingsActivity::class.java))
                }
                State.ERROR->{
                    toastError(it.message?:"terjadi kesalahan")
                }
                State.LOADING->{
                }
            }
        }
    }
}