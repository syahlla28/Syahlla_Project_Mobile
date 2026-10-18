package com.example.syahlla_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.syahlla_project.databinding.ItemPanduanBinding

class PanduanAdapter(
    context: Context,
    private val items: List<PanduanModel>
) : ArrayAdapter<PanduanModel>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = if (convertView == null) {
            ItemPanduanBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            ItemPanduanBinding.bind(convertView)
        }

        val item = items[position]
        binding.txtItemTitle.text = item.title
        binding.txtItemDesc.text = item.desc
        binding.imgPanduanIcon.setImageResource(item.iconRes)

        return binding.root
    }
}
