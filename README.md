Sample kmp-coroutines project with jvm and js target.

Build: `gradle clean build`
Run nodejs: `node main.js`

Output sample:
```
I> node main.js
nodejs: sync call: Hello, Bob!
kmp: asyncCall: before create coroutine
kmp: asyncCall: after create coroutine
/tmp/kmpcoroutines/build/js/packages/coroutineskmp/kotlin/coroutineskmp.js:8114
    Promise.call(this, executor);
            ^

TypeError: undefined is not a promise
    at AsyncResult.Promise (<anonymous>)
    at new AsyncResult (/tmp/kmpcoroutines/build/js/packages/coroutineskmp/kotlin/coroutineskmp.js:8114:13)
    at asAsyncResult (/tmp/kmpcoroutines/build/js/packages/coroutineskmp/kotlin/coroutineskmp.js:8106:19)
    at asyncResult (/tmp/kmpcoroutines/build/js/packages/coroutineskmp/kotlin/coroutineskmp.js:8098:12)
    at asyncResult$default (/tmp/kmpcoroutines/build/js/packages/coroutineskmp/kotlin/coroutineskmp.js:8103:12)
    at suspendToAsyncResult (/tmp/kmpcoroutines/build/js/packages/coroutineskmp/kotlin/coroutineskmp.js:8111:12)
    at SomeApiImpl.asyncCall_0 (/tmp/kmpcoroutines/build/js/packages/coroutineskmp/kotlin/coroutineskmp.js:7977:12)
    at Object.<anonymous> (/tmp/kmpcoroutines/main.js:9:29)
    at Module._compile (internal/modules/cjs/loader.js:1200:30)
    at Object.Module._extensions..js (internal/modules/cjs/loader.js:1220:10)
```

coroutineskmp.d.ts:
```
declare namespace coroutineskmp {
    type Nullable<T> = T | null | undefined
    namespace mezlogo {
        interface SomeApi {
            syncCall(name: string): string
            asyncCall(name: string): mezlogo.AsyncResult<string>
        }
        class SomeApiImpl implements mezlogo.SomeApi {
            constructor()
            syncCall(name: string): string
            asyncCall(name: string): mezlogo.AsyncResult<string>
        }
    }
    namespace mezlogo {
        class AsyncResult<T> extends kotlin.js.Promise<T> {
            constructor(executor: (p0: (p0: T) => void, p1: (p0: Error) => void) => void)
        }
    }
}
```

upd 2020.06.26.01:
- declare `expect` for platform specific future-like types

upd 2020.06.25.01:
- upgrade KMP, kotlin, coroutines from stable `1.3.72` to eap `1.4-M2`
- use `IR` js compiler which generates `.d.ts` file for each `@JsExport` annotation