package com.example.homework_16

import android.os.Bundle
import android.util.Log.d
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.homework_16.adapter.MainAdapter
import com.example.homework_16.databinding.ActivityMainBinding
import com.example.homework_16.viewModel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        loadData()
    }

    private fun setupRecyclerView() {

        mainAdapter = MainAdapter()

        binding.recycleView.apply {
            adapter = mainAdapter
            layoutManager = StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
        }

    }

    private fun loadData() {

        lifecycleScope.launch {
            viewModel.listData.collect {
                d("gaga", "load: $it")
                mainAdapter.submitData(it)
            }

        }
    }
}