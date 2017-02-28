-----------------------------------------------------------------------------
-- UDP sample: echo protocol server
-- LuaSocket sample files
-- Author: Diego Nehab
-----------------------------------------------------------------------------

local UDPServerFramework = {}



local coreServer = require("CoreGateway")
local socket = require("socket")

function trim(s)
  return (s:gsub("^%s*(.-)%s*$", "%1"))
end
function UDPServerFramework.run(host, port, proccessorFunction,ktsClient)
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
       print("get '" .. trim(dgram) .. "' from " .. ip .. ":" .. port)
      local response = proccessorFunction(trim(dgram),ktsClient);
      udp:sendto(response.."\n", ip, port)
      
      print(" and sent "..response)
      
    else
      --print(ip)
    end
  end
    
    
end


return UDPServerFramework


