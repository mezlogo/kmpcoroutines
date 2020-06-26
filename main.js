const common = require("./build/js/packages/coroutineskmp/kotlin/coroutineskmp.js");

function log(msg) { console.log("nodejs: " + msg) }

const someApi = new common.mezlogo.SomeApiImpl()

log(`sync call: ${someApi.syncCall_0("Bob")}`)

const asyncResult = someApi.asyncCall_0("Bill");