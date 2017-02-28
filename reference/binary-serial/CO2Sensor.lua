
--5.3. 通讯格式（Modbus-RTU）：
--读照度数据，以下数据均为 16 进制。
--发送：0A 04 00 00 00 02 70 B0
--传感器返回：0A 04 04 00 00 01 28 40 CA 示例中返回值为 296lx，
--实际将返回实测值。
--如照度数据小于 65536lx，可以只读一个寄存器，即低位寄存器 01H。
--发送：0A 04 00 01 00 01 61 71 传感器返回：0A 04 02 01 35 DD 76 示例中返回值为 309lx，实
--际将返回实测值。
--更改设备地址或波特率前请确保通讯正常！更改成功后新参数在设备
--重启后生效。
--5.4. 更改设备地址，设备地址保存在保持寄存器 42H：
--命令格式：SS 06 00 42 00 NN HH LL；
--SS 为现设备地址，如 485 总线上只有一个设备，可以用广播地址 00；
--NN 为新设备地址；HH、LL 为 CRC 校验码。
--返回格式：SS 06 00 42 00 NN HH LL；SS 为现设备地址，新地址要
--照度传感器 NHZD210 技术手册
--联系方式：027-5970-1826 150-7141-5010 7
--设备重启后才从生效。
--例：改设备地址为 0AH，命令 00 06 00 42 00 0A A8 08
--改设备地址为 0BH，命令 00 06 00 42 00 0B 69 C8
--改设备地址为 0CH，命令 00 06 00 42 00 0C 28 0A
--改设备地址为 01H，命令 00 06 00 42 00 01 E9 CF
--改设备地址为 02H，命令 00 06 00 42 00 02 A9 CE
--5.5. 更改波特率，波特率设置数保存在保持寄存器 40H

--5.5. 更改波特率，波特率设置数保存在保持寄存器 40H
--设置数——波特率对应表： 0 1200 2 4800 4 19200 6 57600 1 2400 3 9600 5 38400 7 115200
--命令格式：SS 06 00 40 00 NN HH LL；
--SS 为设备地址，如 485 总线上只有一个设备，可以用广播地址 00；
--NN 为新波特率设置数；HH、LL 为 CRC 校验码。
--返回格式：SS 06 00 40 00 NN HH LL；SS 为设备地址，新波特率要
--设备重启后才从生效。
--例：改设备波特率为 1200，命令 00 06 00 40 00 00 89 CF
--改设备波特率为 4800，命令 00 06 00 40 00 02 08 0E
--改设备波特率为 9600，命令 00 06 00 40 00 03 C9 CE





require("CommonLib")
local C4 = require("Control4")

C4.init("COM5")
C4:SendToSerial(1,"test string")




function ReceivedFromSerial(idBinding, strData)
   --print("Data received on serial port")
   hexdump(strData)
   --print("strData = " .. )
end

function readConcentration(address)
  
end

function changeAddress(address,newAddress)
  
end

function queryAddress(address,newAddress)
  
end



while true do
  C4:SendToSerial(1,tohex("FF 0A 01 03 A0 00 AE"))
  C4:ProcessSerial(1,ReceivedFromSerial)
end



