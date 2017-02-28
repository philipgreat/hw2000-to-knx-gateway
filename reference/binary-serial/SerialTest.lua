-- to fix luars232 issue
-- luadist remove rs232
-- luadis install rs232
--require("xopen")
local function main()

  local rs232 = require("luars232")
  
  --local pop3 = require("pop3")
  
  --rs232.init()
  
  local port_name="COM9"
  local e, p = rs232.open(port_name)
  if e ~= rs232.RS232_ERR_NOERROR then
  -- handle error
    print(string.format("can't open serial port '%s', error: '%s'\n",
        port_name, rs232.error_tostring(e)))
    return
  end
  assert(p:set_baud_rate(rs232.RS232_BAUD_9600) == rs232.RS232_ERR_NOERROR)
  assert(p:set_data_bits(rs232.RS232_DATA_8) == rs232.RS232_ERR_NOERROR)
  assert(p:set_parity(rs232.RS232_PARITY_NONE) == rs232.RS232_ERR_NOERROR)
  assert(p:set_stop_bits(rs232.RS232_STOP_1) == rs232.RS232_ERR_NOERROR)
  assert(p:set_flow_control(rs232.RS232_FLOW_OFF)  == rs232.RS232_ERR_NOERROR)

  while true do
    local read_len = 10 -- read one byte
    local timeout = 1100 -- in miliseconds
    local err, data_read, size = p:read(read_len, timeout)
    assert(e == rs232.RS232_ERR_NOERROR)
    if data_read~=nil then
      print(data_read)
    end
  end
  
 
  print("hello world")
  --print(package.path..'\n'..package.cpath)
end



main()
