package rmipkg.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceRMIImpl extends UnicastRemoteObject implements ServiceRMI {

    public ServiceRMIImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() throws RemoteException {
        return " Hello from server";
    }

    @Override
    public SimpleObj getSimplObj() throws RemoteException {
        return new SimpleObj(1, 2, "VBNMmdddddddss");
    }

    public static void main(String[] args) {
        try {
            ServiceRMI serviceRMI = new ServiceRMIImpl();
            Naming.rebind("Remote", serviceRMI);
        } catch (Exception ex) {
            System.out.println("naming error ");
            ex.printStackTrace();
        }
    }
}
