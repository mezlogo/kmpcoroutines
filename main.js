const common = require("./build/js/packages/coroutineskmp/kotlin/coroutineskmp.js");

function log(msg) { console.log("nodejs: " + msg) }

log("imported common code: " + common.mezlogo)

const explicitDeferred = common.mezlogo.explicitDeferred("Bill")

log("after call explicitDeferred: " + explicitDeferred)

setTimeout(() =>
    log("explicitDeferred after timeout 200: " + explicitDeferred.getCompleted())
    , 200);

    const explicitPromise = common.mezlogo.explicitPromise("Bob")
log("after call explicitPromise: " + explicitPromise)
explicitPromise.then(res => log("then of explicitPromise: " + res))

async function asyncWorksToo(name) {
    log("before await asyncWorksToo")
    const result = await common.mezlogo.explicitPromise(name)
    log("after await asyncWorksToo" + result)
}

asyncWorksToo("Joe")