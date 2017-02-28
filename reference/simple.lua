print("love is blue")

local str = "sad$sdfsdfsdf"


function stringAfterDollar(str)
  local dollarPos = string.find( str,"%$")
  return string.sub( str, dollarPos )
end


local dollarPos = string.find( str,"%$")
print(string.sub( str, dollarPos ))
print(stringAfterDollar( str, dollarPos ))