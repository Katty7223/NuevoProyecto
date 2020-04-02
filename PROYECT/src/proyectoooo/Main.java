package proyectoooo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner entrada= new Scanner(System.in);
		ListaP miLista= new ListaP();
		int opcion=0;
		String nombreNew="";
        String placaNew="";		
		do {
			System.out.println("|--------------------------|");
			System.out.println("|     MENÚ PRINCIPAL.      |");
            System.out.println("|1.Registro de clientes.   |");
			System.out.println("|2.Salida de clientes.     |");
			System.out.println("|3.Visualización de parqueo|");
			System.out.println("|4.Búsqueda de cliente.    |");
			System.out.println("|--------------------------|");
			opcion=entrada.nextInt();
			
			switch(opcion) {
			  case 1:
			  int op=0;
			  do {
              System.out.println("Ingrese un nuevo cliente");
              System.out.println("Ingrese el nombre");
              String nombre=entrada.next();
              System.out.println("Ingrese el NIT");
              String nit=entrada.next();
              System.out.println("Ingrese la fecha de nacimiento");
              int fechaN=entrada.nextInt();
              System.out.println("Ingrese el Teléfono");
              String tel=entrada.next();
              System.out.println("Ingrese la hora de entrada del cliente");
              int horaEnt=entrada.nextInt();
              System.out.println("Ingrese la placa");
              String placa=entrada.next();
              System.out.println("Ingrese el DPI");
              String dpi=entrada.next();
              System.out.println("Ingrese el modelo");
              String modelo =entrada.next();
              int edad=2020-fechaN;
              ClienteP nuevoCli= new ClienteP(nombre, nit, fechaN, tel, horaEnt, placa, dpi, modelo);
             if(edad<=50) {
              miLista.agregarClienteFIFO(nuevoCli);
              System.out.println("El cliente se ha ingresado al final del parqueo porque no es de la tercera edad");
             }else {
            
             
            	 miLista.agregarNodoLIFO(nuevoCli);
            	 System.out.println("El cliente se ha ingresado al inicio del parqueo porque es de la tercera edad");
             }
             
              System.out.println("¿Desea ingresar otro cliente? 1.Si  2.No");
              op=entrada.nextInt();
			  }while(op==1);
             
				break;
			  
			  case 2:
				   System.out.println("Ingrese la placa del cliente que saldrá del parqueo");
				    placaNew=entrada.next();
				   
				   miLista.salidaCliente(placaNew);
				   miLista.eliminarCliente(placaNew);
					
					
				   
				   System.out.println("¿Desea volver al menú principal?  1.Si  2.No");
				   opcion=entrada.nextInt();
				  break;
			  
			  case 3:
				  miLista.Grafo();
				  miLista.desdeJava();
				  break;
			  
			  case 4:
				  System.out.println("Ingrese el nombre del cliente que desea buscar");
				    nombreNew=entrada.next();
				   System.out.println("Ingrese la placa del vehículo");
				    placaNew=entrada.next();
				   miLista.buscarCliente(nombreNew, placaNew);
				   System.out.println("¿Desea volver al menú principal?  1.Si  2.No");
				   opcion=entrada.nextInt();
				  break;
			      default:
					break;
			}
			
			
			
		}while(opcion!=4);
	}

	}


