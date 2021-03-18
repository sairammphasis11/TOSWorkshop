package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AuthenticInterf extends Remote {

    public String  authenticUser (String username, String password) throws RemoteException;
}
