# RxDatabindings
[ ![Download](https://api.bintray.com/packages/step-89-g/stepango/rxDataBindings/images/download.svg) ](https://bintray.com/step-89-g/stepango/rxDataBindings/_latestVersion)

RxJava2 extensions for Android Databindings library

Add RxDataBindings to your build.gradle
```
"com.stepango.rxdatabindings:rxdatabindings:0.2"
```

Basic example of usage:
```
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
```
