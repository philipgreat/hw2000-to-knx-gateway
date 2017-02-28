require("HexTool")
local socket = require("socket")

local tcp = assert(socket.tcp())

tcp:settimeout(10)

assert(tcp:connect("127.0.0.1", 8888))
--note the newline below
local org ="7e06000d0001140d"
local sentData = tohex(org);
tcp:send(sentData);
print("sent: "..sentData)
while true do
    local s, status, partial = tcp:receive(8)
    --print(s)
    local  value = s or partial
    if value ~= nil then
        print(hexdump(value))
    end
    tcp:send(sentData);
    --print(s or partial)
    if status == "closed" then break end
end

tcp:close()
