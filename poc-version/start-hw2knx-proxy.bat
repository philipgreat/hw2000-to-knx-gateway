@echo off

set PATH=%PATH%;c:\lua\bin
set PATH=%PATH%;c:\lua\nodejs

cd C:\lua\hw2000-to-knx-gateway-master

lua Honeywell2KNXProxy.lua >> knx.log

@echo on 