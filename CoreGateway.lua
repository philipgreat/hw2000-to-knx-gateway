local CoreGateway = {}


function string.starts(String,Start)
   return string.sub(String,1,string.len(Start))==Start
end

function string.ends(String,End)
   return End=='' or string.sub(String,-string.len(End))==End
end


function string.split(s, p)
    local rt= {}
    string.gsub(s, '[^'..p..']+', function(w) table.insert(rt, w) end )
    return rt
end








function CoreGateway.process(request)
    --print(request)
    if string.starts(request,"$verify") then
        return "$verify,SKdNuu/ijrLx70xk5oAzSTk5LjI1MS44Mw=="
    end
    --other commands
    if string.starts(request,"$") then
        return "$verify,error,103"
    end
    local replaceTable = {}
    

    table.insert(replaceTable,1,{from="cfg",to="ack"})
    table.insert(replaceTable,2,{from="req",to="res"})
    
    local result = request
    for k,v in ipairs(replaceTable) do
      --print(k,v.from)
      result = string.gsub(result,"%$"..v.from,"%$"..v.to)
      
    end
    return result
    
end


function string:split(sep)
        local sep, fields = sep or ":", {}
        local pattern = string.format("([^%s]+)", sep)
        self:gsub(pattern, function(c) fields[#fields+1] = c end)
        return fields
end






return  CoreGateway




--[[ 
Honeywell
verify：命令类型；
token：加密字符串
例如用户验证成功，得到的验证回复为：
$verify,SKdNuu/ijrLx70xk5oAzSTk5LjI1MS44Mw==\n

String Recipes

 lua-users home
	wiki 
Search

Here are proposed solutions for doing various types of common string manipulations in Lua.
Substring matching

Check if string X starts or ends with string Y

function string.starts(String,Start)
   return string.sub(String,1,string.len(Start))==Start
end

function string.ends(String,End)
   return End=='' or string.sub(String,-string.len(End))==End
end
Trim (remove initial/trailing whitespace)

See StringTrim.

Changing case

Change the first character of a word to upper case

str = str:gsub("^%l", string.upper)
Change the first alphabetic character of a word to upper case

str = str:gsub("%a", string.upper, 1)
Put HTML tags in lowercase (but leaves attribute names untouched)

str = str:gsub("<[^%s>]+", string.lower)
Change an entire string to Title Case (i.e. capitalise the first letter of each word)

local function tchelper(first, rest)
  return first:upper()..rest:lower()
end
-- Add extra characters to the pattern if you need to. _ and ' are
--  found in the middle of identifiers and English words.
-- We must also put %w_' into [%w_'] to make it handle normal stuff
-- and extra stuff the same.
-- This also turns hex numbers into, eg. 0Xa7d4
str = str:gsub("(%a)([%w_']*)", tchelper)
Example:

> str = "foo"
> str = str:gsub("^%l", string.upper)
> =str
Foo
> str = "_foo"
> str = str:gsub("^%l", string.upper)
> =str
_foo
> str = str:gsub("%a", string.upper, 1)
> =str
_Foo
Convert words in all upper-case to lower-case

str = string.gsub (str, "%f[%a]%u+%f[%A]", string.lower)
Note the use here of the "frontier" regular expression patter %f. Without it it is hard to match on a word boundary, including where the boundary is at the start or end of the string to be matched. Try it on the string "AAA bbb CCC dddEEE FFFhhh JJJ". For more details read about the FrontierPattern.

Splitting a string into a list of substrings

breaking the original string on occurrences of some separator character, character set, or pattern

See SplitJoin.

Iterate over words in a string (adapted from Lua manual)

-- words and numbers
for word in str:gmatch("%w+") do ... end

-- identifiers in typical programming languages
for id in str:gmatch("[_%a][_%w]*") do ... end

-- whitespace-separated components (without handling quotes)
for id in str:gmatch("%S+") do ... end
Iterate over lines in a buffer, ignoring empty lines

(works for both DOS and Unix line ending conventions)
for line in str:gmatch("[^\r\n]+") do ... end
Any of the above can also be done as a function iterator:

-- call func with each word in a string
str:gsub("%w+", func)
Text Wrapping

Wrap a string at a given margin

This is intended for strings without newlines in them (i.e. after reflowing the text and breaking it into paragraphs.)

function wrap(str, limit, indent, indent1)
  indent = indent or ""
  indent1 = indent1 or indent
  limit = limit or 72
  local here = 1-#indent1
  return indent1..str:gsub("(%s+)()(%S+)()",
                          function(sp, st, word, fi)
                            if fi-here > limit then
                              here = st - #indent
                              return "\n"..indent..word
                            end
                          end)
end
Reflowing text into paragraphs

This builds on wrap to do a quick-and-dirty reflow: paragraphs are defined as lines starting with a space, or having a blank line between them:

function reflow(str, limit, indent, indent1)
  return (str:gsub("%s*\n%s+", "\n")
             :gsub("%s%s+", " ")
             :gsub("[^\n]+",
                   function(line)
                     return wrap(line, limit, indent, indent1)
                   end))
end
Repetition

Check if a string is a repetition of some pattern

"" == str:gsub(pat, "")
Check if a string is a repetition of some pattern separated by whitespace

not str:gsub(pat, ""):find"%S"
Check if a string is a repetition of some pattern and also satisfies some condition

"" == str:gsub(pat, function(s) return ok(s) and "" or "*" end)
Formatting

Interpolating variables into strings (string formatting)

Many languages provide a concise way to format variables into strings. Example:

print( "%-5.5s is %5.2f" % { "pi", math.pi } ) --> pi    is  3.14
See StringInterpolation for ways to do this in Lua.

URL/E-Mail/Web Processing

Note: see also CgiUtils.

Decode an URL-encoded string

(Note that you should only decode a URL string after splitting it; this allows you to correctly process quoted "?" characters in the query string or base part, for instance.)

function url_decode(str)
  str = string.gsub (str, "+", " ")
  str = string.gsub (str, "%%(%x%x)",
      function(h) return string.char(tonumber(h,16)) end)
  str = string.gsub (str, "\r\n", "\n")
  return str
end
URL-encode a string

function url_encode(str)
  if (str) then
    str = string.gsub (str, "\n", "\r\n")
    str = string.gsub (str, "([^%w %-%_%.%~])",
        function (c) return string.format ("%%%02X", string.byte(c)) end)
    str = string.gsub (str, " ", "+")
  end
  return str	
end
Match Email addresses

email="alex@it-rfc.de"
if (email:match("[A-Za-z0-9%.%%%+%-]+@[A-Za-z0-9%.%%%+%-]+%.%w%w%w?%w?")) then
  print(email .. " is a valid email address")
end
CSV (Comma-Separated Value) Parsing

See CsvUtils.

See Also

The string library in CommonFunctions
PenLight? string functions [1][2]


]]