package com.stepango.test

import com.stepango.rxdatabindings.ObservableString
import org.junit.Test
import java.lang.IllegalStateException


class ObservableStringTest {

    @Test(expected = IllegalStateException::class)
    fun testNullValueInObservableString() {
        val testString = ObservableString()
        testString.set(NullStringGetter.getNull())
    }
}
