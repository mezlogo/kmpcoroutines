package mezlogo

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlin.js.JsExport

fun p(msg: String) = println("kmp: $msg")

expect fun <T> suspendToAsyncResult(deferred: Deferred<T>): AsyncResultWrapper

@JsExport
data class AsyncResultWrapper(val future: Any)

@JsExport
interface SomeApi {
    fun syncCall(name: String): String
    fun asyncCall(name: String): AsyncResultWrapper
}

@JsExport
class SomeApiImpl: SomeApi {
    private suspend fun suspendFunction(name: String): String {
        val timeout: Long = 100
        p("suspendFunction: name: $name before delay: $timeout")
        delay(timeout)
        p("suspendFunction: name: $name after delay")
        return "Hello, $name!"
    }

    override fun syncCall(name: String) = "Hello, $name!"

    override fun asyncCall(name: String): AsyncResultWrapper {
        p("asyncCall: before create coroutine")
        val deferred = GlobalScope.async {
            p("asyncCall: coroutine: before call suspend function")
            val greet = suspendFunction(name)
            p("asyncCall: coroutine: after call suspend function")
            greet
        }
        p("asyncCall: after create coroutine")
        return suspendToAsyncResult(deferred)
    }

}

