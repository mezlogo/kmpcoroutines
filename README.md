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
kmp: before create coroutine
kmp: after create coroutine
nodejs: after call explicitSuspend: DeferredCoroutine{Active}@2
kmp: coroutine with name: Bill before delay: 100
kmp: coroutine with name: Bob before delay: 100
kmp: coroutine with name: Bill after delay
kmp: coroutine with name: Bob after delay
nodejs: explicitDeferred after timeout 200: Hello, Bill!
```
