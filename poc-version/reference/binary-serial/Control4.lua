
local Control4={}

local SERIALPORT=nil

local rs232 = require("luars232")


function Control4:ProcessSerial(idBinding,func)

  assert( type(idBinding)=="number","the parameter func can not be nil and it must be a function")
  assert( type(func)=="function","the parameter func can not be nil and it must be a function")
  
  assert(SERIALPORT ~= nil, "port should be initialized")

  local read_len = 256 -- read one byte
  local timeout = 100 -- in miliseconds
  local err, data_read, size = SERIALPORT:read(read_len, timeout)
    -- print(rs232.RS232_ERR_NOERROR==0)
    --assert(e == rs232.RS232_ERR_NOERROR)
  if data_read ~= nil then
    func(idBinding,data_read)
     --return
  end


end
function Control4:ProcessSerialLoop(idBinding,func)

  --print(type(func))
  
  assert( type(idBinding)=="number","the parameter func can not be nil and it must be a function")
  assert( type(func)=="function","the parameter func can not be nil and it must be a function")
  
  assert(SERIALPORT ~= nil, "port should be initialized")
  
  
  while true do
    local read_len = 6 -- read one byte
    local timeout = 1 -- in miliseconds
    local err, data_read, size = SERIALPORT:read(read_len, timeout)
    -- print(rs232.RS232_ERR_NOERROR==0)
    --assert(e == rs232.RS232_ERR_NOERROR)
    if data_read ~= nil then
      func(idBinding,data_read)
      --return
    end
    
  end

end

function Control4:SendToSerial(id,content)
  assert(type(id) == "number", "id should be a bumber")
  assert(SERIALPORT ~= nil, "port should be initialized")
  SERIALPORT:write(content)
  
end

local function serialInit(port_name)

  
  local e, serialPort = rs232.open(port_name)
  if e ~= rs232.RS232_ERR_NOERROR then
  -- handle error
    print(string.format("can't open serial port '%s', error: '%s'\n",port_name, rs232.error_tostring(e)))
    return
  end
  assert(serialPort:set_baud_rate(rs232.RS232_BAUD_9600) == rs232.RS232_ERR_NOERROR)
  assert(serialPort:set_data_bits(rs232.RS232_DATA_8) == rs232.RS232_ERR_NOERROR)
  assert(serialPort:set_parity(rs232.RS232_PARITY_NONE) == rs232.RS232_ERR_NOERROR)
  assert(serialPort:set_stop_bits(rs232.RS232_STOP_1) == rs232.RS232_ERR_NOERROR)
  assert(serialPort:set_flow_control(rs232.RS232_FLOW_OFF)  == rs232.RS232_ERR_NOERROR)
  SERIALPORT=serialPort
end

function Control4.init(portName)
  serialInit(portName)
end




return Control4