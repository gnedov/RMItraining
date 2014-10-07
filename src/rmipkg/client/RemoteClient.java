package rmipkg.client;

import rmipkg.server.ServiceRMI;
import rmipkg.server.SimpleObj;

import java.rmi.Naming;

public class RemoteClient {

    public static void main(String[] args) {
        new RemoteClient().go();
    }

    public void go() {
        try {
            System.out.println(Naming.list("rmi://127.0.0.1/"));
            ServiceRMI service = (ServiceRMI) Naming.lookup("rmi://127.0.0.1/Remote");

            String s = service.sayHello();
            System.out.println(s);

            SimpleObj simpleObj = new SimpleObj(2, 4, "new simpleO");
            System.out.println("local SimpleObject name: " + simpleObj.getName());

            SimpleObj sObj = service.getSimplObj();
            System.out.println("remote SimpleObj name: " + sObj.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
