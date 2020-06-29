package mezlogo

import kotlinx.coroutines.Deferred

actual fun <T> suspendToAsyncResult(deferred: Deferred<T>): AsyncResultWrapper {
    throw UnsupportedOperationException("jvm version is not ready")
}