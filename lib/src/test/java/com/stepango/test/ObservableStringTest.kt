package com.stepango.test

import com.stepango.rxdatabindings.ObservableString
import com.stepango.rxdatabindings.observe
import io.reactivex.schedulers.Schedulers
import org.junit.Test


class ObservableStringTest {

    @Test(expected = IllegalStateException::class)
    fun testNullValueInObservableString() {
        val testString = ObservableString()
        testString.set(NullStringGetter.getNull())
    }

    @Test
    fun observeObservableString() {
        val testString = ObservableString()
        val testObserver = testString.observe(Schedulers.trampoline()).test()

        val fakeString = "fakeString"
        testString.set(fakeString)

        testObserver.assertValues("", fakeString)
    }

}
