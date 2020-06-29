package mezlogo

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

private val real = CommonApiImpl()

@JsExport
class JsAdoptedApi: CommonSyncApi by real {
    @JsName("asyncCall")
    fun asyncCall(name: String) = GlobalScope.promise { real.asyncCall(name) }
}