package com.example.currency.myapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.currency.myapplication.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val adapter by lazy { UserAdapter(Glide.with(this)) }
    private val vm: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.adapter = adapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                vm.state
                    .onEach { render(it) }
                    .collect()
            }
        }

        if (savedInstanceState == null) vm.loadUsers()
    }

    private fun render(state: MainState) {

        if (state.error != null) handleError(state.error)
        else adapter.submitList(state.users)
    }

    private fun handleError(error: Throwable) {
        AlertDialog.Builder(this)
            .setTitle(R.string.error)
            .setMessage(error.message ?: getString(R.string.error))
            .setPositiveButton(android.R.string.ok) { _, _ -> vm.resetError() }
            .setCancelable(false)
            .show()
    }
}

