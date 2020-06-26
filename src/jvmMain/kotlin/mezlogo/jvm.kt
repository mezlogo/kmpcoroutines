package mezlogo

import kotlinx.coroutines.Deferred

actual fun <T> suspendToAsyncResult(deferred: Deferred<T>): AsyncResult<T> {
    TODO("Not yet implemented")
}

actual class AsyncResult<out T>