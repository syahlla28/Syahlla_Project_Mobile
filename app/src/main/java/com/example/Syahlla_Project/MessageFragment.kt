package com.example.syahlla_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.syahlla_project.databinding.FragmentMessageBinding
import com.google.android.material.snackbar.Snackbar

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Mama", "085227984932", "https://i.pravatar.cc/150?img=47"),
        MessageModel("Papa", "081293570824", "https://i.pravatar.cc/150?img=12"),
        MessageModel("Adik", "0812208510874", "https://i.pravatar.cc/150?img=44"),
        MessageModel("Polisi Terdekat", "110", "https://i.pravatar.cc/150?img=13"),
        MessageModel("Ambulans Darurat", "118", "https://i.pravatar.cc/150?img=49")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgBackMessage.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.txtTambahKontak.setOnClickListener {
            Snackbar.make(view, "Fitur tambah kontak darurat", Snackbar.LENGTH_SHORT).show()
        }

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        (activity as? MainActivity)?.setMainNavigationVisible(false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as? MainActivity)?.setMainNavigationVisible(true)
        _binding = null
    }
}
