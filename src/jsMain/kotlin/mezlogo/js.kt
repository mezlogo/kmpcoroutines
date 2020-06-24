package mezlogo

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise


@JsName("explicitPromise")
fun explicitPromise(name: String) = GlobalScope.promise { explicitSuspend(name) }