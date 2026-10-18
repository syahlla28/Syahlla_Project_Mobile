package com.example.syahlla_project

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.syahlla_project.LoginActivity
import com.example.syahlla_project.MainActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        lifecycleScope.launch {
            delay(2000)

            val sharedPref = getSharedPreferences(
                "user_pref",
                MODE_PRIVATE
            )

            val isLogin = sharedPref.getBoolean(
                "isLogin",
                false
            )

            val targetActivity = if (isLogin) {
                MainActivity::class.java
            } else {
                LoginActivity::class.java
            }

            startActivity(
                Intent(this@SplashScreenActivity, targetActivity)
            )

            finish()
        }
    }
}