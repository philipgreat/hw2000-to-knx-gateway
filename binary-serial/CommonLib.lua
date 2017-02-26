

function hexdump(buf, printFunc)
  local outtable = {}
  for byte=1, #buf, 16 do
    local chunk = buf:sub(byte, byte+15)
    table.insert(outtable, string.format('%08X  ',byte-1))
    local chunkleft = chunk:sub(1, 8)
    local chunkright = chunk:sub(9)
    chunkleft:gsub('.', function (c) table.insert(outtable, string.format('%02X ',string.byte(c))) end)
  table.insert(outtable, ' ')
    chunkright:gsub('.', function (c) table.insert(outtable, string.format('%02X ',string.byte(c))) end)
    table.insert(outtable, string.rep(' ',3*(16-#chunk)))
    table.insert(outtable, ' ' .. chunk:gsub('%W','.') .. '\r\n')
  end

  -- Print out to Print Function if exists... use print otherwise...
  if (nil ~= printFunc) then
    printFunc(table.concat(outtable))
  else
    print(table.concat(outtable))
  end
end

function tohex(str)
  local offset,dif = string.byte("0"), string.byte("A") - string.byte("9") - 1
  local hex = ""
  str = str:upper()
  for a,b in str:gfind "(%S)(%S)%s*" do
  a,b = a:upper():byte() - offset, b:upper():byte()-offset
  a,b = a>10 and a - dif or a, b>10 and b - dif or b
  local code = a*16+b
  hex = hex .. string.char(code)
  end
  return hex
end


