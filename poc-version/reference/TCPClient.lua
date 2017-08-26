
--I am trying to create TCP client in lua

local host, port = HOST, PORT
local socket = require("socket")
client = socket.tcp();
socket.settimeout(0)
client:connect(host, port);
client:send("Hello User");


while true do
    local s, status, partial = client:receive(8)
    print(s or partial)
    if status == "closed" then break end
end

--18012623585,孙工，89167541


