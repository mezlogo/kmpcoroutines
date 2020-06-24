var common = require("./build/js/packages/coroutineskmp/kotlin/coroutineskmp.js");

function log(msg) { console.log("nodejs: " + msg) }

log("imported common code: " + common.mezlogo)

var explicitDeferred = common.mezlogo.explicitDeferred("Bill")

log("after call explicitDeferred: " + explicitDeferred)

setTimeout(() =>
    log("explicitDeferred after timeout 200: " + explicitDeferred.getCompleted())
    , 200);

var explicitSuspend = common.mezlogo.explicitDeferred("Bob")
log("after call explicitSuspend: " + explicitSuspend)