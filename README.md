# RxDatabindings
[![Download](https://api.bintray.com/packages/step-89-g/stepango/rxDataBindings/images/download.svg) ](https://bintray.com/step-89-g/stepango/rxDataBindings/_latestVersion)
![Android CI](https://github.com/stepango/RxDatabindings/workflows/Android%20CI/badge.svg?branch=master)

RxJava 2 & 3 extensions for Android Databindings library

Add RxDataBindings to your build.gradle
```groovy
implementation "com.stepango.rxdatabindings:rxdatabindings:3.0.0"
```

Basic example of usage:
```kotlin
interface ViewModelState : Parcelable {
    val text: ObservableString
    val counter: ObservableInt
}

@Parcelize
data class ViewModelStateImpl(
        override val text: ObservableString = ObservableString(),
        override val counter: ObservableInt = ObservableInt()
) : ViewModelState

class ViewModel(val state: ViewModelState) : ViewModelState by state {

    init {
        counter.observe()
                .setTo(text) { "Wow! You count till $it" }
                .doOnNext { Log.d("THREAD", Thread.currentThread().name) }
                .subscribe()
    }

    fun incCounter() = counter.inc(10)
    fun decCounter() = counter.dec(0)

}
```
