# RxDatabindings
[![Download](https://api.bintray.com/packages/step-89-g/stepango/rxDataBindings/images/download.svg) ](https://bintray.com/step-89-g/stepango/rxDataBindings/_latestVersion)

RxJava2 extensions for Android Databindings library

Add RxDataBindings to your build.gradle
```
compile "com.stepango.rxdatabindings:rxdatabindings:1.0.0"
```

Basic example of usage:
```
class ViewModel {
    val text = ObservableString("")
    val counter = ObservableInt(0)

    init {
        counter.observe()
                .setTo(text) { "Wow! You count till $it" }
                .subscribe()
    }

    fun incCounter() = counter.inc(10)
    fun decCounter() = counter.dec(0)

}
```
This library depends on [kOptional](https://github.com/stepango/kOptional) at the moment. This dependency will be removed in upcoming release
