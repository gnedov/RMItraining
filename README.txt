 It is a study case with simple RMI application + Ant.

how to setup server and test client.
WARN: all java files should be compiled before!

out\production\RMItraining\rmipkg\server:
     ServiceRMI.class
     ServiceRMIImpl.class
     ServiceRMIImpl_Skel.class   ( using rmic -vcompat <package_path>.ServiceRMIImpl )
     ServiceRMIImpl_Stub.class   (-''-)
     SimpleObj.class

out\production\RMItraining\rmipkg\client:
    RemoteClient.class
    ServiceRMI.class             (copied from server folder)
    ServiceRMIImpl_Stub.class    (-''-)
    SimpleObj.class              (-''-)

run 3 console:
1.start registry
  H:\IDEA\RMItraining\out\production\RMItraining>rmiregistry
2. start server
  H:\IDEA\RMItraining\out\production\RMItraining>java rmipkg.server.ServiceRMIImpl
3. start client
 H:\IDEA\RMItraining\out\production\RMItraining>java rmipkg.client.RemoteClient

show the result:
   [Ljava.lang.String;@1a7789c
    Hello from server

========================================================================================
    please see bat-file    ../out/startALL.bat

