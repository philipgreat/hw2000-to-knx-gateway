local serverFramework = require("UDPServerFramework")
local coreGateway = require("CoreGateway")
local processorFunction = coreGateway.process
local run = serverFramework.run


local socket = require("socket")

local ktsClient = assert(socket.tcp())

ktsClient:settimeout(0.1)

assert(ktsClient:connect("127.0.0.1", 8888))

run("0.0.0.0",10099,processorFunction,ktsClient)






