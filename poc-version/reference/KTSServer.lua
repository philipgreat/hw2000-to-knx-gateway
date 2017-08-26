
require("HexTool")
local socket = require("socket")
local server = assert(socket.tcp())

server:settimeout(3)


function handleReq(client) 
    local org ="23 06 00 0D 00 01 14 0D"
    local sentData = tohex(org)
    while true do
        local s, status, partial = client:receive(8)
     --print(s)
        local  value = s or partial
        if value ~= nil then
            print(hexdump(value))
            client:send(sentData);
        end
        
     --print(s or partial)
        if status == "closed" then 
            break
        end
    end

end


assert(server:bind("0.0.0.0", 8888))
--note the newline below
assert(server:listen(5))
--23 06 00 0D 00 01 14 0D



while true do
    local client = server:accept()
    if client ~= nil then
        client:settimeout(100)
        handleReq(client)
    end
    print("next client..")
end

server:close()
