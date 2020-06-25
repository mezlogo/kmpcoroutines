package mezlogo

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlin.js.JsExport

fun p(msg: String) = println("kmp: $msg")

suspend fun callGreetService(name: String): String {
    val timeout: Long = 100
    p("coroutine with name: $name before delay: $timeout")
    delay(timeout)
    p("coroutine with name: $name after delay")
    return "Hello, $name!"
}

@JsExport
fun explicitDeferred(name: String): Deferred<String> {
    p("before create coroutine")
    val deferred = GlobalScope.async {
        callGreetService(name)
    }
    p("after create coroutine")
    return deferred
}

@JsExport
suspend fun explicitSuspend(name: String): String {
    p("call explicitSuspend is already in coroutine scope")
    val greet = callGreetService(name)
    p("explicitSuspend after call suspended function")
    return greet
}

@JsExport
interface SomeApi {
    fun syncCall(msg: String): String
    suspend fun asyncCall(msg: String): String
}

