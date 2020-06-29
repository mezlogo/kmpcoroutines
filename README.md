Sample kmp-coroutines project with jvm and js target.

Build: `gradle clean build`
Run nodejs: `node main.js`

Output sample:
```
I> node main.js
nodejs: sync call: Hello, Bob!
nodejs: promiseVersion: Jane before call
nodejs: promiseVersion: Jane before await
nodejs: promiseVersion: Jane asyncResultPromise is: [object Promise]
nodejs: awaitVersion: Bill before call
nodejs: awaitVersion: Bill before await
kmp: asyncCall: coroutine: before call suspend function
kmp: suspendFunction: name: Jane before delay: 100
kmp: asyncCall: coroutine: before call suspend function
kmp: suspendFunction: name: Bill before delay: 100
kmp: suspendFunction: name: Jane after delay
kmp: asyncCall: coroutine: after call suspend function
nodejs: promiseVersion: Jane after await. result: Hello, Jane!
kmp: suspendFunction: name: Bill after delay
kmp: asyncCall: coroutine: after call suspend function
nodejs: awaitVersion: Bill after await. result: Hello, Bill!
```

coroutineskmp.d.ts:
```
declare namespace coroutineskmp {
    type Nullable<T> = T | null | undefined
    namespace mezlogo {
        interface JsAdoptedSomeApi {
            syncCall(name: string): string
            asyncCall(name: string): kotlin.js.Promise<string>
        }
        class JsAdoptedSomeApiImpl implements mezlogo.JsAdoptedSomeApi {
            constructor()
            syncCall(name: string): string
            asyncCall(name: string): kotlin.js.Promise<string>
        }
    }
}
```

upd 2020.06.29.01:
- make platform specific js impl

upd 2020.06.29.01:
- make generic-less wrapper for result of async call

upd 2020.06.26.01:
- declare `expect` for platform specific future-like types

upd 2020.06.25.01:
- upgrade KMP, kotlin, coroutines from stable `1.3.72` to eap `1.4-M2`
- use `IR` js compiler which generates `.d.ts` file for each `@JsExport` annotation