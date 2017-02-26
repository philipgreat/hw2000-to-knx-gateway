local serverFramework = require("UDPServerFramework")
local coreGateway = require("CoreGateway")
local processorFunction = coreGateway.process
local run = serverFramework.run

run("0.0.0.0",10099,processorFunction)






