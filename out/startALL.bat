 @echo off
rem Simple recursive launch registry, server and client for RMItrainig project.
rem Tested on Microsoft Windows XP [Version 5.1.2600].
rem !!!Server and client are on the one local machine.!!!
rem Precondition:
rem This startALL.bat file should locate in the project output directory 
rem like ..\RMItraining\out\startALL.bat
rem WARN: all java files should be compiled before! Use Ant script rmitrainingAnt.xml please.
rem	The folder structure has next view
rem ..\out\production\RMItraining\rmipkg\server:
rem      ServiceRMI.class
rem      ServiceRMIImpl.class
rem      ServiceRMIImpl_Skel.class   ( using rmic -vcompat <package_path>.ServiceRMIImpl )
rem      ServiceRMIImpl_Stub.class   (-''-)
rem      SimpleObj.class
rem 
rem ..\out\production\RMItraining\rmipkg\client:
rem      RemoteClient.class
rem      ServiceRMI.class             (copied from server folder)
rem      ServiceRMIImpl_Stub.class    (-''-)
rem      SimpleObj.class			  (-''-)	

cd %~dp0\production\RMItraining

if "%1" EQU "startRegistry" (
  echo rmiregisty is running under %CD%.
  echo Press [Ctrl+C] to break.
  rmiregistry
  )
  
if "%1" EQU "startServer" (
  echo ServiceRMIImpl server is running under %CD%.
  echo Press [Ctrl+C] to break.
  java rmipkg.server.ServiceRMIImpl 
  )  
  
if "%1" EQU "" (
  start "rmiregistry " %~dp0%~nx0 startRegistry
  ping 192.0.2.2 -n 1 -w 500 > nul
  
  start "RMI Server" %~dp0%~nx0   startServer
  ping 192.0.2.2 -n 1 -w 500 > nul
  
  echo RemoteClient is running.
  echo Press [Ctrl+C] to break.
  java rmipkg.client.RemoteClient
  
  pause "Client has completed execution. Press any button to exit."
  )
  
cd ..\..


