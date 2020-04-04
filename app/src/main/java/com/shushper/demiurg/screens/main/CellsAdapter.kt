package com.shushper.demiurg.screens.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shushper.demiurg.cell.Cell
import com.shushper.demiurg.databinding.ItemCellBinding

class CellsAdapter : RecyclerView.Adapter<CellViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Cell>() {

        override fun areItemsTheSame(oldItem: Cell, newItem: Cell): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Cell, newItem: Cell): Boolean {
            return oldItem.type == newItem.type
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(cells: List<Cell>) {
        differ.submitList(cells)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
        val binding = ItemCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CellViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
        holder.bindCell(differ.currentList[position])
    }

}

class CellViewHolder(private val binding: ItemCellBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindCell(cell: Cell) {
        binding.cellIcon.setBackgroundResource(cell.getIconBackgroundRes())
        binding.cellIconEmoji.setText(cell.getIconEmojiRes())
        binding.cellTitle.setText(cell.getTitleRes())
        binding.cellSubtitle.setText(cell.getSubtitleRes())
    }
}