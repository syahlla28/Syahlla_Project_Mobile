package com.example.syahlla_project

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.syahlla_project.databinding.FragmentPanduanBinding

class PanduanFragment : Fragment() {

    private var _binding: FragmentPanduanBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPanduanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Data panduan keadaan darurat
        val panduanList = listOf(
            mapOf("title" to "Pertolongan Pertama", "desc" to "Langkah dasar menangani luka ringan, pendarahan, dan pingsan."),
            mapOf("title" to "Kebakaran", "desc" to "Cara evakuasi gedung, penggunaan APAR, dan menghindari asap tebal."),
            mapOf("title" to "Gempa Bumi", "desc" to "Teknik 'Drop, Cover, and Hold On' serta evakuasi ke tempat aman."),
            mapOf("title" to "Banjir", "desc" to "Langkah penyelamatan dokumen penting dan evakuasi ke dataran tinggi."),
            mapOf("title" to "Keselamatan Sehari-hari", "desc" to "Tips mencegah kecelakaan di rumah dan mengenali nomor darurat SOS.")
        )

        // Mapping data ke kunci yang dibaca SimpleAdapter
        val from = arrayOf("title", "desc")
        val to = intArrayOf(R.id.text1, R.id.text2)

        // Membuat SimpleAdapter menggunakan layout bawaan android.R.layout.simple_list_item_2
        val adapter = SimpleAdapter(
            requireContext(),
            panduanList,
            R.layout.simple_list_item_2,
            from,
            to
        )

        // Menerapkan adapter ke ListView
        binding.listViewItems.adapter = adapter

        // Menambahkan setOnItemClickListener
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = panduanList[position]
            val title = selectedItem["title"]
            val desc = selectedItem["desc"]
            Toast.makeText(requireContext(), "$title: $desc", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
