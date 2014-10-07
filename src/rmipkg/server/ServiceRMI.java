package rmipkg.server;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceRMI extends Remote {
    public String sayHello() throws RemoteException;

    public SimpleObj getSimplObj() throws RemoteException;
}
