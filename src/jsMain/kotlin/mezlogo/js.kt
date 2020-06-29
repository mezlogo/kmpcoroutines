package mezlogo

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlin.js.Promise

@JsExport
interface JsAdoptedSomeApi {
    fun syncCall(name: String): String
    fun asyncCall(name: String): Promise<String>
}

@JsExport
class JsAdoptedSomeApiImpl: JsAdoptedSomeApi {
    private val real: SomeApi = SomeApiImpl()
    override fun syncCall(name: String) = real.syncCall(name)

    override fun asyncCall(name: String) = GlobalScope.promise { real.asyncCall(name) }
}