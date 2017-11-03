package codewars

import java.nio.ByteBuffer
import java.util.*
import kotlin.properties.Delegates


//import kotlin.test.assertFailsWith

/**
 * Created by ice1000 on 17-6-16.
 *
 * @author ice1000
 */
class ThrowWithoutThrowingTest {

    @org.junit.Test
    fun tests() {
/*        assertFailsWith(ArithmeticException::class, ::arithmetic)
        assertFailsWith(NoSuchElementException::class, ::noSuchElement)
        assertFailsWith(ArrayIndexOutOfBoundsException::class, ::arrayIndexOutOfBound)
        assertFailsWith(ClassCastException::class, ::classCast)
        assertFailsWith(StackOverflowError::class, ::stackOverflow)
        assertFailsWith(NullPointerException::class, ::nullPointer)
        assertFailsWith(NumberFormatException::class, ::numberFormat)
        assertFailsWith(IllegalArgumentException::class, ::illegalArgument)
        assertFailsWith(NegativeArraySizeException::class, ::negativeArraySize)
        assertFailsWith(EmptyStackException::class, ::emptyStack)
        assertFailsWith(BufferOverflowException::class, ::bufferOverflow)
        assertFailsWith(ArrayStoreException::class, ::arrayStore)
        assertFailsWith(UnsupportedOperationException::class, ::unsupportedOperation)
        assertFailsWith(IllegalStateException::class, ::illegalState)*/
        classCast()
    }
}

fun arrayIndexOutOfBound() {
    val x: IntArray = intArrayOf(1, 2, 3)
    print(x[5])
}

fun negativeArraySize() {
    val x = arrayOfNulls<Int>(-1)
    print(x[-1])
}

fun noSuchElement() {
    intArrayOf(1, 2).last { i -> i>3 }
}

fun arithmetic() {
    print(2/0)
}

fun classCast() {
    val s = "test"
    val y: Int = s as Int
}

fun stackOverflow() {
    stackOverflow()
}

fun nullPointer() {
    val x: String? = null
    print(x!!.length)
}

fun numberFormat() {
    val x: Int = "as".toInt()
}

fun illegalArgument() {
    Character.toChars(-1)
}

fun emptyStack() {
    val stack = Stack<String>()
    stack.peek()
}

fun bufferOverflow() {
    val bf = ByteBuffer.allocate(1)
    bf.putInt(8)
}

fun arrayStore() {
    val a = doubleArrayOf(2.0, 3.4, 3.6, 2.7, 5.6)
    val b = intArrayOf(2, 3, 4, 5)
    System.arraycopy(b, 0, a, 1, 4)
}

fun unsupportedOperation() {
    var initialValue = listOf<Int>(10) as MutableList<Int>
    initialValue.add(1, 1)
}

fun illegalState() {
    val user = User()
     user.name
}

class User {
    var name: String by Delegates.notNull()

    fun init(name: String) {
        this.name = name
    }
}

