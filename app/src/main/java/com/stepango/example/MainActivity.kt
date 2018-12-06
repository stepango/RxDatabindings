@file:SuppressLint("ParcelCreator")

package com.stepango.example

import android.annotation.SuppressLint
import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ObservableInt
import android.os.Bundle
import android.os.Parcelable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.util.Log
import com.stepango.example.databinding.ActivityMainBinding
import com.stepango.rxdatabindings.ObservableSpanned
import com.stepango.rxdatabindings.ObservableString
import com.stepango.rxdatabindings.observe
import com.stepango.rxdatabindings.setTo
import io.mironov.smuggler.AutoParcelable
import kotlin.properties.Delegates


class MainActivity : Activity() {

    private var viewModel by Delegates.notNull<ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        viewModel = ViewModel(savedInstanceState.extract { ViewModelStateImpl() })
        binding.viewModel = viewModel
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putState(viewModel.state)
    }

}

interface ViewModelState : Parcelable {
    val text: ObservableString
    val counter: ObservableInt
    val styledText: ObservableSpanned
}

data class ViewModelStateImpl(
        override val text: ObservableString = ObservableString(),
        override val counter: ObservableInt = ObservableInt(),
        override val styledText: ObservableSpanned = ObservableSpanned()
) : ViewModelState, AutoParcelable

class ViewModel(val state: ViewModelState) : ViewModelState by state {

    init {
        counter.observe(fireInitialValue = true)
                .setTo(text) { "Wow! You counted till $it" }
                .setTo(styledText) {
                    SpannableString("Now that's... awesome!").apply {
                        setSpan(AbsoluteSizeSpan(it, true), 14, 22, 0)
                    }
                }
                .doOnNext { Log.d("THREAD", Thread.currentThread().name) }
                .subscribe()
    }

    fun incCounter() = counter.set(counter.get().inc())
    fun decCounter() = counter.set(counter.get().dec())

}

inline fun <reified T : Parcelable> Bundle?.extract(defaultValueProducer: () -> T): T {
    this ?: return defaultValueProducer()
    val key = T::class.java.name
    return if (containsKey(key)) {
        Log.d("State::", "restored $key")
        getParcelable(key) ?: throw IllegalStateException("null Parcelable")
    } else {
        defaultValueProducer()
    }
}

fun <T : Parcelable> Bundle.putState(value: T) {
    val name = value::class.java.name
    putParcelable(name, value)
    Log.d("State::", "saved $name")
}
