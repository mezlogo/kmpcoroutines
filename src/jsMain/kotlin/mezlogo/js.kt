package mezlogo

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

actual fun <T> suspendToAsyncResult(deferred: Deferred<T>): AsyncResultWrapper {
    p("kmp/js: suspendToAsyncResult: before create promise")
    val promise = GlobalScope.promise {
        p("kmp/js: suspendToAsyncResult: promise: before await")
        val result = deferred.await()
        p("kmp/js: suspendToAsyncResult: promise: after await")
        result
    }
    p("kmp/js: suspendToAsyncResult: after create promise")
    val asyncResultWrapper = AsyncResultWrapper(promise)
    return asyncResultWrapper
}