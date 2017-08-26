local socket = require "socket"
local udp = socket.udp()

function serial()
  wserial=io.open("/dev/ttyUSB0","w")
  wserial:write("Serial Port OK")
  wserial:flush()
  rserial=io.open("/dev/ttyUSB0","r")
  while chaine==nil do
    chaine=rserial:read()
    rserial:flush()
  end
  print(chaine)
end



udp:settimeout(0)
udp:setsockname('*', 12345)
local running = true
local clienttable={}
print "Beginning server loop."
while running do

  data, msg_or_ip, port_or_nil = udp:receivefrom()
  if data then
    local client={host=msg_or_ip,port=port_or_nil,failcount=0}
    table.insert(clienttable,client)
    udp:sendto("ok",msg_or_ip,port_or_nil)
    print("udp://"..msg_or_ip..":"..port_or_nil.."/"..data)
  else
  --print("nothing")
  end

  socket.sleep(1)
end
