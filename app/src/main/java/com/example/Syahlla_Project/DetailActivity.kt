package com.example.syahlla_project

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.syahlla_project.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailBinding.inflate(layoutInflater)
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

        setSupportActionBar(binding.detailToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.imgBack.setOnClickListener {
            finish()
        }

        val title = intent.getStringExtra("title") ?: "Detail Darurat"
        val desc = intent.getStringExtra("desc") ?: "Informasi darurat terkait layanan ini."
        val imageRes = intent.getIntExtra("image", R.drawable.ambulance)

        binding.txtDetailToolbarTitle.text = title
        binding.txtDetailTitle.text = title
        binding.txtDetailDesc.text = desc
        binding.imgDetail.setImageResource(imageRes)

        binding.btnActionDetail.setOnClickListener {
            Toast.makeText(this, "Menghubungi $title...", Toast.LENGTH_SHORT).show()
        }
    }
}
