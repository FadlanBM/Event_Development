package com.example.android.ui.auth

import android.app.AlertDialog
import android.content.Context

class alert {
    companion object{
            fun showAlert(context: Context, title: String, message: String) {
                val alertDialog = AlertDialog.Builder(context)
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton("OK", null)
                    .create()
                alertDialog.show()
            }
    }

}