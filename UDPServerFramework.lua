-----------------------------------------------------------------------------
-- UDP sample: echo protocol server
-- LuaSocket sample files
-- Author: Diego Nehab
-----------------------------------------------------------------------------

local UDPServerFramework = {}



local coreServer = require("CoreGateway")
local socket = require("socket")


function UDPServerFramework.run(host, port, proccessorFunction)
  if type(proccessorFunction) ~= "function" then
    print("The input parameter proccessorFunction is not a function, it is a "..type(proccessorFunction))
      return
  end
    
 
  print("Binding to host '" ..host.. "' and port " ..port.. "...")
  udp = assert(socket.udp())
  assert(udp:setsockname(host, port))
  assert(udp:settimeout(5))
  ip, port = udp:getsockname()
  assert(ip, port)
  print("Waiting packets on " .. ip .. ":" .. port .. "...")
  while 1 do
    dgram, ip, port = udp:receivefrom()
    if dgram then
      print("Echoing '" .. dgram .. "' to " .. ip .. ":" .. port)
      local response = proccessorFunction(dgram);
      udp:sendto(response.."\n", ip, port)
    else
      print(ip)
    end
  end
    
    
end


return UDPServerFramework


