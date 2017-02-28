@echo off

set PATH=%PATH%;c:\lua\bin
set PATH=%PATH%;c:\lua\nodejs

cd C:\lua\nodejs

node lineproxy.js >> webproxy.log

@echo on 