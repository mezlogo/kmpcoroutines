package mezlogo

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.js.Promise

fun <T> asyncResult(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> T
): AsyncResult<T> =
    GlobalScope.async(context, start, block).asAsyncResult()

fun <T> Deferred<T>.asAsyncResult(): AsyncResult<T> {
    val promise = AsyncResult<T> { resolve, reject ->
        invokeOnCompletion {
            val e = getCompletionExceptionOrNull()
            if (e != null) {
                reject(e)
            } else {
                resolve(getCompleted())
            }
        }
    }
    promise.asDynamic().deferred = this
    return promise
}

actual fun <T> suspendToAsyncResult(deferred: Deferred<T>) = asyncResult { deferred.await() }


@JsExport
actual class AsyncResult<out T>(executor: (resolve: (T) -> Unit, reject: (Throwable) -> Unit) -> Unit): Promise<T>(executor)