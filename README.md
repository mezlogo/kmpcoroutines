Sample kmp-coroutines project with jvm and js target.

Build: `gradle clean build`
Run nodejs: `node main.js`

Output sample:
```
I> node main.js
nodejs: imported common code: [object Object]
kmp: before create coroutine
kmp: after create coroutine
nodejs: after call explicitDeferred: DeferredCoroutine{Active}@1
nodejs: after call explicitPromise: [object Promise]
nodejs: before await asyncWorksToo
kmp: coroutine with name: Bill before delay: 100
kmp: call explicitSuspend is already in coroutine scope
kmp: coroutine with name: Bob before delay: 100
kmp: call explicitSuspend is already in coroutine scope
kmp: coroutine with name: Joe before delay: 100
kmp: coroutine with name: Bill after delay
kmp: coroutine with name: Bob after delay
kmp: explicitSuspend after call suspended function
nodejs: then of explicitPromise: Hello, Bob!
kmp: coroutine with name: Joe after delay
kmp: explicitSuspend after call suspended function
nodejs: after await asyncWorksTooHello, Joe!
nodejs: explicitDeferred after timeout 200: Hello, Bill!
```

coroutineskmp.d.ts:
```
declare namespace coroutineskmp {
    type Nullable<T> = T | null | undefined
    namespace mezlogo {
        function explicitDeferred(name: string): kotlinx.coroutines.Deferred<string>
        /* ErrorDeclaration: Suspend function */
    }
    namespace mezlogo {
        function explicitPromise(name: string): kotlin.js.Promise<string>
    }
}
```

upd 2020.06.25.01:
- upgrade KMP, kotlin, coroutines from stable `1.3.72` to eap `1.4-M2`
- use `IR` js compiler which generates `.d.ts` file for each `@JsExport` annotation