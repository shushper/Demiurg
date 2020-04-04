package com.shushper.demiurg.screens.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.shushper.demiurg.databinding.ActivityMainBinding
import com.shushper.demiurg.extensions.observe
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val cellsAdapter: CellsAdapter by inject()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = cellsAdapter

        initOutputs()
        initInputs()
    }

    private fun initOutputs() {
        binding.button.setOnClickListener { viewModel.onCrateBtnClick() }
    }

    private fun initInputs() {

        observe(viewModel.cells) { cells ->
            cellsAdapter.submitList(cells)
            binding.recycler.smoothScrollToPosition(cells.size)
        }
    }
}
