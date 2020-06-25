package mezlogo

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise


@JsExport
fun explicitPromise(name: String) = GlobalScope.promise { explicitSuspend(name) }