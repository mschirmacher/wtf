import com.soywiz.klock.DateTime
import kotlin.js.JsName
import kotlin.test.Test
import kotlin.test.assertTrue


class Foo {
    @Test
    @JsName("test1")
    fun `nowUnixLong is Long`() {
        brk()
        assertTrue(com.soywiz.klock.DateTime.nowUnixLong() is Long)
    }

    @Test
    @JsName("test2")
    fun `nowUnix is Double`() {
        brk()
        val now = DateTime.nowUnix()

        assertTrue(now is Double)
    }


    @Test
    @JsName("test3")
    fun `Double to Long is Long`() {
        brk()
        val now = DateTime.nowUnix()

        assertTrue(now.toLong() is Long)
    }
}
