package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

public class Servidor {
    public static void main(String[] args){
        String host;
        int puerto=5055;
        try{
            host= InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        try{
            Registry registro= LocateRegistry.createRegistry(puerto);
            ClinicaRMI clinicaRMI= new ClinicaRMI();
            registro.rebind("Mi Clinica",clinicaRMI);
            System.out.println("Servidor iniciado en "+host+":"+puerto);
        } catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
