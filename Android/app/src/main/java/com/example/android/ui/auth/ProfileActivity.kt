package com.example.android.ui.auth

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.android.R
import com.example.android.core.data.resourch.network.State
import com.example.android.core.data.resourch.request.UpdateProfileRequest
import com.example.android.databinding.ActivityProfileBinding
import com.example.android.ui.base.Myactivity
import com.example.android.util.Preft
import com.github.drjacky.imagepicker.ImagePicker
import com.github.drjacky.imagepicker.constant.ImageProvider
import com.inyongtisto.myhelper.extension.int
import com.inyongtisto.myhelper.extension.isEmpty
import com.inyongtisto.myhelper.extension.setToolbar
import com.inyongtisto.myhelper.extension.showToast
import com.inyongtisto.myhelper.extension.toastError
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileActivity : Myactivity() {

    private var _binding: ActivityProfileBinding? = null
    private val viewModel: ProfileViewModel by viewModel()

    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        _binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.toolbar,"Profile")

        buttonHendeler()
        setUser()
    }

    private fun setUser(){
        val user= Preft.getUser()
        if (user !=null){
            binding.apply {
                tbName.setText(user.name)
                tbEmail.setText(user.email)
            }
        }
    }
    private fun buttonHendeler(){
        binding.btnUpdate.setOnClickListener {
            update()
        }

        binding.imageProfile.setOnClickListener {
            picimage()
        }
    }

    private fun picimage(){
        ImagePicker.with(this)
            //...
            .cropSquare()    //Crop square image, its same as crop(1f, 1f)
            .maxResultSize(1080, 1080, true) //true: Keep Ratio
            .provider(ImageProvider.BOTH) //Or bothCameraGallery()
            .createIntentFromDialog { launcher.launch(it) }
    }

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val uri = it.data?.data!!
                // Use the uri to load the image
                // Only if you are not using crop feature:
                Picasso.get().load(uri).into(binding.imageProfile)
            }
        }

    private fun update(){
        if (binding.tbEmail.isEmpty()) return
        if (binding.tbEmail.isEmpty()) return

        val id=Preft.getUser()?.id
        val body= UpdateProfileRequest(id.int(),binding.tbName.text.toString(),binding.tbEmail.text.toString())
        viewModel.updateUser(body).observe(this){
            when (it.state){
                State.SUCCESS->{
                    progress.dismiss()
                    showToast("Berhasil Update Profile " + it?.body?.name)
//                    pushActivity(DashboardActivity::class.java)
                }
                State.ERROR->{
                    progress.dismiss()
                    toastError(it.message?:"terjadi kesalahan")
                }
                State.LOADING->{
                    progress.show()
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Beralih")
        builder.setMessage("Apakah Anda yakin ingin keluar ?")
        builder.setPositiveButton("Ya", DialogInterface.OnClickListener { dialog, which ->
            onBackPressed()
        })
        builder.setNegativeButton("Tidak",
            DialogInterface.OnClickListener { dialog, which ->
                // Tambahkan kode yang ingin Anda jalankan saat pengguna menekan "Tidak"
                dialog.dismiss() // Menutup dialog
            })
        builder.show()
        return super.onSupportNavigateUp()
    }
}