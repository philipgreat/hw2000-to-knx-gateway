require("CommonLib")
local C4 = require("Control4")
local crcUtil = require("CRCUtil")
C4.init("COM8")
--

print "...end..."
function ReceivedFromSerial(idBinding, strData)
   --print("Data received on serial port")
   hexdump(strData)
   --print("strData = " .. )
end
require "socket"

function sleep(sec)
    socket.select(nil, nil, sec)
end
function sendMobBusCommand(hexstr)
  local value=tohex(hexstr);
  C4:SendToSerial(1,value)
  local lenth=string.len(value);
  local crc=crcUtil:crc16(tohex(hexstr),lenth)
  C4:SendToSerial(1,crc)
  sleep(0.1)
end



function encodeWord(value)
  local low=value%256
  local high=value/256
  return string.format("%02X %02X",high, low)
end

function decodeWord(high, low)
  return low+high*256;
end




function constructCommand(slaveId,functionCode,parameter1, paramter2,paramter3)
  local ret="";
  ret = ret..string.format("%02X ",slaveId)
  ret = ret..string.format("%02X ",functionCode)
  ret = ret..encodeWord(parameter1).." "
  ret = ret..encodeWord(paramter2)
  
  
  
  if paramter3 ~= nil then
    -- this is for write multiple input registers, coils, holding registers
    local value=tohex(paramter3)
    local length=string.len(value)
    ret = ret.." "..string.format("%02X",length)
    ret = ret.." "..paramter3
  end
  return ret
  
  
end


function testWriteSingleCoils()
  --print(string.format('%04X ',10001))
  
  sendMobBusCommand("10 05 27 11 FF 00")
  --C4:SendToSerial(1,"teststring"..counter.."\r\n")
  C4:ProcessSerial(1,ReceivedFromSerial)

  sendMobBusCommand("10 05 27 11 00 00")
  --C4:SendToSerial(1,"teststring"..counter.."\r\n")
  C4:ProcessSerial(1,ReceivedFromSerial)
  
end 


local counter=10;

local commands={}


--write single coils
commands[1]=constructCommand(16,5,10001,0xff00)
commands[2]=constructCommand(16,5,10001,0x0000)
commands[3]=constructCommand(16,5,10114,0xff00)
commands[4]=constructCommand(16,5,10114,0x0000)

commands[5]=constructCommand(16,5,10116,0xff00) --should fail
commands[6]=constructCommand(16,5,10116,0x0000) --shold fail

--read coils
commands[7]=constructCommand(16,1,10001,51)
commands[8]=constructCommand(16,1,10001,51)
commands[9]=constructCommand(16,1,10114,11) --should fail
commands[10]=constructCommand(16,1,10114,11) --shold fail

commands[11]=constructCommand(16,1,10116,11) --should fail
commands[12]=constructCommand(16,1,10116,11) --shold fail


--read discrete inputs
commands[13]=constructCommand(16,2,20001,51)
commands[14]=constructCommand(16,2,20001,51)
commands[15]=constructCommand(16,2,20114,11) --should ok
commands[16]=constructCommand(16,2,20114,11) --shold ok

commands[17]=constructCommand(16,2,20116,11) --should ok
commands[18]=constructCommand(16,2,20116,11) --should ok

--write multi-coils 

commands[19]=constructCommand(16,15,10002,39,"FF BB CC 00 55") 
--should ok 39 this number can be replaced byte 33-40, but not other numbers
commands[20]=constructCommand(16,1,10002,6)

for i,command in ipairs(commands) do
   --print(i)
   print(i..": " .. command)
   
   sendMobBusCommand(command)
   --print(i)
   C4:ProcessSerial(1,ReceivedFromSerial)
end

