package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AuthenticRemote extends UnicastRemoteObject implements  AuthenticInterf{
    protected AuthenticRemote() throws RemoteException {
    }

    @Override
    public String authenticUser(String username, String password) throws RemoteException {
        if(username!=null && password!=null){
            if(username.equals("sairam") && password.equals("pass")){
                return "Welcome"+username;
            }
        }

        return null;
    }
}
