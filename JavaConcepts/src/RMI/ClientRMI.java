package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientRMI {

    public static void main(String[] args) {

        try {
            AuthenticInterf remote = (AuthenticInterf) Naming.lookup("rmi://192.168.0.172/RemoteAuthentication");
            System.out.println(remote.authenticUser("sairam","pass"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
