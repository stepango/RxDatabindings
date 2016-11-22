package com.stepango.example

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ObservableInt
import android.os.Bundle
import com.stepango.example.databinding.ActivityMainBinding

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
        counter.observe()
                .subscribe { text.set("Wow! You count till ${counter()}") }
    }

    fun incCounter() = counter.inc(10)
    fun decCounter() = counter.dec(0)

}
