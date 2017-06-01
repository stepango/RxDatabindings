package com.stepango.example

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ObservableInt
import android.os.Bundle
import android.util.Log
import com.stepango.example.databinding.ActivityMainBinding
import com.stepango.rxdatabindings.ObservableString
import com.stepango.rxdatabindings.dec
import com.stepango.rxdatabindings.inc
import com.stepango.rxdatabindings.observe
import com.stepango.rxdatabindings.setTo

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = ViewModel()
    }

}

class ViewModel {
    val text = ObservableString("")
    val counter = ObservableInt(0)

    init {
        counter.observe(fireInitialValue = true)
                .setTo(text) { "Wow! You count till $it" }
                .doOnNext { Log.d("THREAD", Thread.currentThread().name) }
                .subscribe()
    }

    fun incCounter() = counter.inc(10)
    fun decCounter() = counter.dec(0)

}
