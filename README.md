# RxDatabindings
[![Download](https://api.bintray.com/packages/step-89-g/stepango/rxDataBindings/images/download.svg) ](https://bintray.com/step-89-g/stepango/rxDataBindings/_latestVersion)

RxJava2 extensions for Android Databindings library

Add RxDataBindings to your build.gradle
```
compile "com.stepango.rxdatabindings:rxdatabindings:1.4.0"
```

Basic example of usage:
```
interface ViewModelState : Parcelable {
    val text: ObservableString
    val counter: ObservableInt
}

data class ViewModelStateImpl(
        override val text: ObservableString = ObservableString(),
        override val counter: ObservableInt = ObservableInt()
) : ViewModelState, AutoParcelable

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
