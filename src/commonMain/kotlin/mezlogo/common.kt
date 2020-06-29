package mezlogo

import kotlinx.coroutines.delay

fun p(msg: String) = println("kmp: $msg")

interface SomeApi {
    fun syncCall(name: String): String
    suspend fun asyncCall(name: String): String
}

class SomeApiImpl: SomeApi {
    private suspend fun suspendFunction(name: String): String {
        val timeout: Long = 100
        p("suspendFunction: name: $name before delay: $timeout")
        delay(timeout)
        p("suspendFunction: name: $name after delay")
        return "Hello, $name!"
    }

    override fun syncCall(name: String) = "Hello, $name!"

    override suspend fun asyncCall(name: String): String {
        p("asyncCall: coroutine: before call suspend function")
        val greet = suspendFunction(name)
        p("asyncCall: coroutine: after call suspend function")
        greet
        return greet
    }
}

