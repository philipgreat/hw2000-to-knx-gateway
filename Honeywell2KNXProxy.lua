local serverFramework = require("UDPServerFramework")
local coreGateway = require("CoreGateway")
local processorFunction = coreGateway.process
local run = serverFramework.run

run("127.0.0.1",10099,processorFunction)






