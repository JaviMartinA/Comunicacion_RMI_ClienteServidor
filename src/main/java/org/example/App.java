package org.example;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.Scanner;
public class App {
    public static void main( String[] args ) {
        Registry registro;
        Scanner sc1= new Scanner(System.in);
        try{
            registro= LocateRegistry.getRegistry("localhost",5055);
            System.out.println("Hemos obtenido el registro");
            ClinicaInterface clinicaInterface= (ClinicaInterface) registro.lookup("Mi Clinica");
            System.out.println("Hemos obtenido el objeto remoto");
            do{
                System.out.println("Quiere observar pacientes o médicos? Escriba salir para salir");
                String valor= sc1.next();
                if(valor.equalsIgnoreCase("pacientes")){
                    System.out.println("Has seleccionado pacientes");
                    System.out.println("¿Como quieres buscar?");
                    System.out.println("1. Por nombre, 2. Por motivo, 3. Por fecha. Para salir pulse cualquier otra tecla");
                    int opcion= sc1.nextInt();
                    switch(opcion){
                        case 1->{
                            Scanner sc2= new Scanner(System.in);
                            System.out.println("Introduce el nombre del paciente");
                            String nombre= sc2.nextLine();
                            System.out.println(clinicaInterface.getNombreP(nombre));
                        }
                        case 2->{
                            Scanner sc2= new Scanner(System.in);
                            System.out.println("Introduce el motivo de la consulta");
                            String motivo= sc2.nextLine();
                            System.out.println(clinicaInterface.getMotivo(motivo));
                        }
                        case 3->{
                            Scanner sc2= new Scanner(System.in);
                            System.out.println("Introduce la fecha");
                            String fecha= sc2.nextLine();
                            System.out.println(clinicaInterface.getFecha(fecha));
                        }
                        default -> {
                            System.out.println("Se acabo la consulta");
                        }
                    }
                }else if (valor.equalsIgnoreCase("medicos")) {
                    System.out.println("¿Cómo quieres hallar al médico?");
                    System.out.println("1. Por nombre, 2. Por especialidad, 3. Por experiencia. Para salir pulse cualquier otra tecla");
                    int opcion= sc1.nextInt();
                    switch(opcion){
                        case 1->{
                            Scanner sc2= new Scanner(System.in);
                            System.out.println("Introduce el nombre del médico");
                            String nombre= sc2.nextLine();
                            System.out.println(clinicaInterface.getNombreM(nombre));
                        }
                        case 2->{
                            Scanner sc2= new Scanner(System.in);
                            System.out.println("Introduce la especialidad del médico");
                            String especialidad= sc2.nextLine();
                            System.out.println(clinicaInterface.getEspecialidad(especialidad));
                        }
                        case 3->{
                            Scanner sc2= new Scanner(System.in);
                            System.out.println("Introduce los años de experiencia del médico");
                            int experiencia= sc2.nextInt();
                            System.out.println(clinicaInterface.getExperiencia(experiencia));
                        }
                        default -> {
                            System.out.println("Hasta la próxima");
                            System.exit(0);
                        }
                    }
                }else if(valor.equalsIgnoreCase("salir")){
                    System.out.println("Hasta la próxima");
                    System.exit(0);
                }else{
                    System.out.println("Introduzca pacientes o medicos");
                }
            }while(true);
        } catch (RemoteException | NotBoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
