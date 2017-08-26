Using username "root".


BusyBox v1.22.1 (2014-09-20 22:31:09 CEST) built-in shell (ash)
Enter 'help' for a list of built-in commands.

  _______                     ________        __
 |       |.-----.-----.-----.|  |  |  |.----.|  |_
 |   -   ||  _  |  -__|     ||  |  |  ||   _||   _|
 |_______||   __|_____|__|__||________||__|  |____|
          |__| W I R E L E S S   F R E E D O M
 -----------------------------------------------------
 BARRIER BREAKER (14.07, r42625)
 -----------------------------------------------------
  * 1/2 oz Galliano         Pour all ingredients into
  * 4 oz cold Coffee        an irish coffee mug filled
  * 1 1/2 oz Dark Rum       with crushed ice. Stir.
  * 2 tsp. Creme de Cacao
 -----------------------------------------------------
root@OpenWrt:~# cd /var/
.uci/       extroot/    lock/       overlay/    state/
dnsmasq.d/  hosts/      log/        run/        sysinfo/
etc/        lib/        nmbd/       spool/
root@OpenWrt:~# cd /var/
.uci/       extroot/    lock/       overlay/    state/
dnsmasq.d/  hosts/      log/        run/        sysinfo/
etc/        lib/        nmbd/       spool/
root@OpenWrt:~# cd /var/www/
-ash: cd: can't cd to /var/www/
root@OpenWrt:~# cd /var
root@OpenWrt:/tmp# ll
-rw-r--r--    1 root     root           6 Feb 18 22:17 TZ
-rw-r--r--    1 root     root         661 Feb 20 09:23 dhcp.leases
drwxr-xr-x    2 root     root          40 Feb 18 22:17 dnsmasq.d
drwxr-xr-x    2 root     root         100 Feb 18 22:17 etc
drwxr-xr-x    2 root     root          40 Jan  1  1970 extroot
drwxr-xr-x    2 root     root          80 Feb 20 05:23 hosts
drwxr-xr-x    3 root     root          60 Feb 18 22:17 lib
drwxr-xr-x    2 root     root         340 Feb 20 09:25 lock
drwxr-xr-x    3 root     root         140 Feb 18 22:17 log
drwxr-xr-x    2 root     root          60 Feb 18 22:17 nmbd
drwxr-xr-x    2 root     root          40 Jan  1  1970 overlay
-rw-r--r--    1 root     root          44 Feb 18 22:17 resolv.conf
-rw-r--r--    1 root     root          64 Feb 18 22:17 resolv.conf.auto
-rw-r--r--    1 root     root          48 Feb 18 22:17 resolv.conf.ppp
drwxr-xr-x    3 root     root         440 Feb 18 22:17 run
drwxr-xr-x    3 root     root          60 Feb 18 22:17 spool
drwxr-xr-x    2 root     root          60 Feb 18 22:17 state
drwxr-xr-x    2 root     root          80 Jan  1  1970 sysinfo
root@OpenWrt:/tmp# cd /var
root@OpenWrt:/tmp# cd /www
root@OpenWrt:/www# ll
lrwxrwxrwx    1 root     root          15 Feb  5 23:06 bandwidthd -> /tmp/bandwidthd
drwxr-xr-x    1 root     root         416 Oct 18 00:17 cgi-bin
-rw-r--r--    1 root     root         419 Sep 21  2014 index.html
-rw-r--r--    1 root     root        1.6K Sep 23  2014 legend.gif
-rwxr-xr-x    1 root     root       16.5K Sep  5 23:53 lights
-rw-r--r--    1 root     root        7.4K Sep 23  2014 logo.gif
drwxr-xr-x    4 root     root          61 Oct  1  2014 luci-static
-rw-r--r--    1 root     root         404 Oct 13 00:38 socks.pac
root@OpenWrt:/www# cd cgi-bin/
root@OpenWrt:/www/cgi-bin# ll
-rwxr-xr-x    1 root     root         135 Sep 21  2014 luci
-rwxr-xr-x    1 root     root         403 Oct 18 00:08 off
-rwxr-xr-x    1 root     root         381 Oct 18 00:22 on
-rwxr-xr-x    1 root     root         675 Oct 18 01:19 test
-rwxr-xr-x    1 root     root         924 Feb  6 01:58 toggle
root@OpenWrt:/www/cgi-bin# cat toggle
#!/usr/bin/lua

--[[
"Hello Web World"
]]

print ("Content-Type: text/html\n")

--print ("<html><head><title>On</title></head>")


local toggle = function(status)
    if string.find(status,"on") ~= nil then
        return "off"
    end
    return "on"
end

local status='off'
local file = io.open("/root/light-status", "r")
if nil ~= file then
    status = file:read("*a")
    file:close()
    file = io.open("/root/light-status","w")
    --print(status)
    local newstatus = toggle(status)
    file:write(newstatus)
    --print(newstatus)


    file:close()


end



local command = '/root/lights 127.0.0.1 switchOnAllLights'

if string.find(status,"off") ~= nil then
        command = '/root/lights 127.0.0.1 switchOffAllLights'
end


local process = io.popen(command)

local ret = process:read("*all")



print ("<html><head><title>"..status.."</title></head>")

print("<h1>"..status.."</h1>")
print ("</body></html>")

root@OpenWrt:/www/cgi-bin#
