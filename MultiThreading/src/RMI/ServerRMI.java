package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ServerRMI {
    public static void main(String[] args) {

        AuthenticRemote authenticService= null;

        try {
            authenticService = new AuthenticRemote();
            Naming.rebind("rmi://192.168.1.172/RemoteAuthentication",authenticService);
            System.out.println("Authenticated from server");


        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
