rem 
echo off
set sReg=startRegistry
set sServer=startServer
set sClient=startClient

if "%1" EQU "%sReg%" (
 cd %~dp0\production
  ping 192.0.2.2 -n 1 -w 3000 > nul
 echo "curr dir is %CD%"
  ping ya.ru
  pause)
  
if "%1" EQU "%sServer%" (
 cd %~dp0\production\RMItraining
 dir
 ping 192.0.2.2 -n 1 -w 3000 > nul
 echo "curr dir is %CD%  %~dp0"
  ping mail.ru
  pause)  
  
if "%1" EQU "" (
rem %~dp0
  start "rmiregistry is started" %~dp0%~nx0   %sReg%
  ping 192.0.2.2 -n 1 -w 500 > nul
 start "RMI Server is started" %0  %sServer%
  ping 192.0.2.2 -n 1 -w 500 > nul

  )

rem start /D %~dp0 ping ya.ru
rem clean environment variables
set sReg=
set sServer=
set sClient=