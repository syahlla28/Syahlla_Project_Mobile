package com.example.syahlla_project

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.syahlla_project.MainActivity
import com.example.syahlla_project.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences(
            "user_pref",
            MODE_PRIVATE
        )

        binding.btnLogin.setOnClickListener {
            val email = binding.edtUsername.text.toString().trim()
            val pass = binding.edtPassword.text.toString()

            if (email.isNotEmpty() && email == pass) {

                sharedPref.edit()
                    .putBoolean("isLogin", true)
                    .putString("email", email)
                    .apply()

                startActivity(
                    Intent(this, MainActivity::class.java)
                )

                finish()

            } else {
                AlertDialog.Builder(this)
                    .setTitle("Login Gagal")
                    .setMessage(
                        "Silakan periksa username dan password."
                    )
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            }
        }
    }
}