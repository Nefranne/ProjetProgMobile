package com.example.a4aprojetahratina.Presentation.Main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.a4aprojetahratina.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity () {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.loginLiveData.observe(this, Observer {
            when (it) {
                is LoginSuccess -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Bienvenue")
                        .setMessage("Compte Valide")
                        .setPositiveButton("ok") { dialog, which -> dialog.dismiss() }
                        .show()
                }
                is LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Erreur")
                        .setMessage("Compte Inconnu")
                        .setPositiveButton("ok") { dialog, which -> dialog.dismiss() }
                        .show()
                }
            }
        })
        login_button.setOnClickListener {
            mainViewModel.onClickedLogin(
                login_edit.text.toString().trim(),
                password_edit.text.toString()
            )
        }
    }
}
