local socket = require("socket")


function trim(s)
  return s:match'^%s*(.*%S)' or ''
end


host = host or "*"
port = port or 8080
if arg then
	host = arg[1] or host
	port = arg[2] or port
end
print("Binding to host '" ..host.. "' and port " ..port.. "...")
s = assert(socket.bind(host, port))
i, p   = s:getsockname()
assert(i, p)
print("Waiting connection from talker on " .. i .. ":" .. p .. "...")


while true do

client = assert(s:accept())
print("Connected. Here is the stuff:")
line, err = client:receive()


while not err do
	print(line)
	line, err = client:receive()
  
  if trim(line) == "" then
    break
  end
  
  
  
end


local headers = [[
HTTP/1.0 200 OK
Content-Type: text/plain; charset=GBK
Connection: Close
]]

local page = [[
<?xml version="1.0"?>
<HTML>
<HEAD>
<TITLE>An HTML Page</TITLE>
</HEAD>
<BODY>
 <A HREF="http://www.lua.org">Lua</A>
</BODY>
</HTML>

]]

local file = io.open("device-list.xml", "r")
if nil ~= file then
    page = file:read("*a")
    file:close()

client:send(headers)
client:send("Content-Length: "..string.len(page).."\n")
client:send("\n")
client:send(page)
client:close()


end

end --while true do


--[[ 

< HTTP/1.1 404 Not Found
< Server: Resin/3.1.12
< Content-Type: text/html; charset=utf-8
< Transfer-Encoding: chunked
< Date: Fri, 24 Feb 2017 03:08:12 GMT


]]



print(e)