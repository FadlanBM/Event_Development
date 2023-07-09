package com.example.android

import android.R.id
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.android.databinding.ActivityDashboardBinding
import com.example.android.databinding.NavHeaderDashboardBinding
import com.example.android.ui.auth.ProfileActivity
import com.example.android.util.Preft
import com.inyongtisto.myhelper.extension.showLoading

class DashboardActivity : AppCompatActivity() {

    //    private lateinit var binding2: NavHeaderDashboardBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDashboardBinding


    override fun onBackPressed() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Keluar")
        builder.setMessage("Apakah Anda yakin ingin kembali ?")
        builder.setPositiveButton("Ya", DialogInterface.OnClickListener { dialog, which ->
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        })
        builder.setNegativeButton("Tidak",
            DialogInterface.OnClickListener { dialog, which ->
                // Tambahkan kode yang ingin Anda jalankan saat pengguna menekan "Tidak"
                dialog.dismiss() // Menutup dialog
            })
        builder.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding2 = NavHeaderDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarDashboard.toolbar)

        binding.appBarDashboard.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_dashboard)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_dashboardpage, R.id.nav_management_Event, R.id.nav_linkevent,R.id.nav_participant_event
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
//        setUser()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.dashboard, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_account->{
                startActivity(Intent(this,ProfileActivity::class.java))
            }
        }
        when(item.itemId){
            R.id.action_logout->{
                val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                builder.setTitle("Keluar")
                builder.setMessage("Apakah Anda yakin ingin Logout ?")
                builder.setPositiveButton("Ya", DialogInterface.OnClickListener { dialog, which ->
                    Preft.isLogin=false
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                })
                builder.setNegativeButton("Tidak",
                    DialogInterface.OnClickListener { dialog, which ->
                        // Tambahkan kode yang ingin Anda jalankan saat pengguna menekan "Tidak"
                        dialog.dismiss() // Menutup dialog
                    })
                builder.show()
            }
        }

        val users=Preft.getUser()
        if (users!=null){
        val username=findViewById<TextView>(R.id.txt_username)
        username.text=users.name
        val email=findViewById<TextView>(R.id.txt_email)
        email.text=users.email
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_dashboard)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

//    private fun setUser(){
//        val user= Preft.getUser()
//        if (user !=null){
//            binding2.apply {
//                txtUser.text="dasdasd"
//                txtEmail.text=user.email
//            }
//        }
//    }

}