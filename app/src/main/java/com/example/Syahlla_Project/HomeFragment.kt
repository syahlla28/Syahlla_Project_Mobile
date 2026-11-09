package com.example.syahlla_project

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.syahlla_project.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        // SOS
        binding.cardSOS.setOnClickListener {
            openDetail(
                "Panggilan Darurat SOS",
                "Informasi pusat panggilan darurat untuk membantu dalam keadaan mendesak.",
                R.drawable.user
            )
        }

        // Bantuan Medis
        binding.cardMedis.setOnClickListener {
            openDetail(
                "Bantuan Medis",
                "Informasi layanan ambulans dan bantuan medis darurat.",
                R.drawable.ambulance
            )
        }

        // Kebakaran
        binding.cardKebakaran.setOnClickListener {
            openDetail(
                "Kebakaran",
                "Informasi bantuan pemadam kebakaran dan penanganan darurat.",
                R.drawable.bomba
            )
        }

        // Keamanan
        binding.cardKeamanan.setOnClickListener {
            openDetail(
                "Keamanan",
                "Informasi bantuan kepolisian dan keamanan darurat.",
                R.drawable.keamanan
            )
        }

        // Bencana
        binding.cardBencana.setOnClickListener {
            openDetail(
                "Bencana",
                "Informasi kesiapsiagaan dan evakuasi bencana.",
                R.drawable.kecelakaan
            )
        }

        // Pertolongan Pertama Dasar (Web Link)
        val openWebLink = View.OnClickListener {
            val url = "https://hellosehat.com/hidup-sehat/pertolongan-pertama/pertolongan-pertama-dasar/"
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(
                    requireContext(),
                    "Tidak dapat membuka browser",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        binding.cardPertolonganPertama.setOnClickListener(openWebLink)
        binding.btnBacaWeb.setOnClickListener(openWebLink)

        // Menu Cepat Grid Actions
        binding.btnMenuMedis.setOnClickListener {
            openDetail("Bantuan Medis", "Informasi layanan ambulans dan bantuan medis darurat.", R.drawable.ambulance)
        }
        binding.btnMenuKebakaran.setOnClickListener {
            openDetail("Kebakaran", "Informasi bantuan pemadam kebakaran dan penanganan darurat.", R.drawable.bomba)
        }
        binding.btnMenuKeamanan.setOnClickListener {
            openDetail("Keamanan", "Informasi bantuan kepolisian dan keamanan darurat.", R.drawable.keamanan)
        }
        binding.btnMenuBencana.setOnClickListener {
            openDetail("Bencana", "Informasi kesiapsiagaan dan evakuasi bencana.", R.drawable.kecelakaan)
        }
        binding.btnMenuPanduan.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, PanduanFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.btnMenuKontak.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MessageFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun openDetail(
        title: String,
        desc: String,
        image: Int
    ) {
        val intent = Intent(
            requireContext(),
            DetailActivity::class.java
        ).apply {
            putExtra("title", title)
            putExtra("desc", desc)
            putExtra("image", image)
        }

        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
