package com.example.syahlla_project

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.syahlla_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        // Message button in Toolbar
        binding.imgMessage.setOnClickListener {
            loadFragment(MessageFragment(), addToBackStack = true)
        }

        // Load default fragment (Home)
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }

        // Navbar sekarang berfungsi sepenuhnya
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_peta -> {
                    loadFragment(PetaFragment())
                    true
                }
                R.id.nav_panduan -> {
                    loadFragment(PanduanFragment())
                    true
                }
                R.id.nav_akun -> {
                    loadFragment(AkunFragment())
                    true
                }
                else -> false
            }
        }
    }

    fun setMainNavigationVisible(visible: Boolean) {
        binding.toolbar.visibility = if (visible) View.VISIBLE else View.GONE
        binding.bottomNavigationView.visibility = if (visible) View.VISIBLE else View.GONE
    }

    private fun loadFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }
}
