package mezlogo

import kotlinx.coroutines.delay

fun p(msg: String) = println("kmp: $msg")

interface CommonSyncApi {
    fun syncCall(name: String): String
}

class CommonApiImpl: CommonSyncApi {
    override fun syncCall(name: String) = "Hello, $name!"

    suspend fun asyncCall(name: String): String {
        val timeout: Long = 100
        p("asyncCall: name: $name before delay: $timeout")
        delay(timeout)
        p("asyncCall: name: $name after delay")
        return "Hello, $name!"
    }
}

