const common = require("./build/js/packages/coroutineskmp/kotlin/coroutineskmp.js");

function log(msg) { console.log("nodejs: " + msg) }

const someApi = new common.mezlogo.JsAdoptedApi()

log(`sync call: ${someApi.syncCall("Bob")}`)

async function awaitVersion(name) {
    log(`awaitVersion: ${name} before call`);
    const asyncResultWrapper = someApi.asyncCall(name);
    log(`awaitVersion: ${name} before await`);
    const asyncResult = await asyncResultWrapper;
    log(`awaitVersion: ${name} after await. result: ${asyncResult}`);
}

function promiseVersion(name) {
    log(`promiseVersion: ${name} before call`);
    const asyncResultWrapper = someApi.asyncCall(name);
    log(`promiseVersion: ${name} before await`);
    const asyncResultPromise = asyncResultWrapper;
    log(`promiseVersion: ${name} asyncResultPromise is: ${asyncResultPromise}`);
    asyncResultPromise.then(result =>
        log(`promiseVersion: ${name} after await. result: ${result}`)
    )

}

promiseVersion("Jane");

awaitVersion("Bill");