
local CommandTable = {}

local commandTable={
    -- honeywell text command to binary KTS command
    -- the 
    ["$cfg,curtain,1,1,1,1,0"]="7e 06 00 0d 00 01 14 0d",
    ["$cfg,curtain,1,1,1,1,1"]="7e 06 00 0d 00 01 14 0d",
    ["$cfg,hbuslig,1,1,1,1,1,0"]="7e 06 00 0d 00 01 14 0d",
    ["$cfg,hbuscurtain,1,1,1,1,1,0"]="7e 06 00 0d 00 01 14 0d"
    
}

function CommandTable:get(hw2000Command) 
    if hw2000Command == nil then
        print("hw2000Command is nil")
        return "7e 06 00 0d 00 01 14 0c"
    end

    local ktsCommand = commandTable[hw2000Command]

    if ktsCommand == nil then
        return "7e 06 00 0d 00 01 14 0e"
    end
    return ktsCommand

end

--print(CommandTable:get("$cfg,1,1,1,"))

return CommandTable


