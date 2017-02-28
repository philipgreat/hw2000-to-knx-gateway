print ("Loading CrcUtil...")

local CRCUtil= {}

require("bit")

--unsigned short CRC16(unsigned char buf[], int n)
--{
--   unsigned short crc = 0xffff ;
--   for(int i = 0; i < n; i++)
--   {
--        crc ^= buf[i] ;
--        for(int b = 0; b < 8; b++)
--        {
--            bool f = crc & 1 ;
--            crc >>= 1 ;
--            if(f)
--                crc ^= 0xa001 ;
--        }
--    }
--    return(crc) ;
--}
function CRCUtil:crc16(buf, len)
  local crc = 0x0000ffff;
  for byte=1, len, 1 do
    local curByte = string.byte(buf,byte,byte)
    crc = bit.band(bit.bxor(crc, curByte), 0xFFFF)
    for j=1,8,1 do
      local f = bit.band(crc, 1)
      crc = bit.band(bit.rshift(crc, 1), 0x7FFF)
      if (f > 0) then
        crc = bit.bxor(crc, 0xa001)
      end
    end
  end
  -- 485 CRC is low-byte first, high-byte then
  return string.char(CRCUtil:byte0(crc))..string.char(CRCUtil:byte1(crc))
end

function CRCUtil:crc16str(buf, len)
 local crc = 0x0000ffff;
  for byte=1, len, 1 do
    local curByte = string.byte(buf,byte,byte)
    crc = bit.band(bit.bxor(crc, curByte), 0xFFFF)
    for j=1,8,1 do
      local f = bit.band(crc, 1)
      crc = bit.band(bit.rshift(crc, 1), 0x7FFF)
      if (f > 0) then
        crc = bit.bxor(crc, 0xa001)
      end
    end
  end
  return string.format("%02X %02X",CRCUtil:byte0(crc),CRCUtil:byte1(crc))
end

function CRCUtil:crc16Check(buf, len)
  local calcCrc = CrcUtil:crc16(buf, len-2)
  local recvCrc = string.sub(buf,len-1,len)
  return calcCrc == recvCrc
end

function CRCUtil:byte0(data)
  return bit.band(data, 0xFF)
end

function CRCUtil:byte1(data)
  return bit.band(bit.rshift(data, 8), 0xFF)
end

function CRCUtil:byte2(data)
  return bit.band(bit.rshift(data, 16), 0xFF)
end

function CRCUtil:byte3(data)
  return bit.band(bit.rshift(data, 24), 0xFF)
end

return CRCUtil