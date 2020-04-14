package proyectoooo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ListaP {
	public NodoP inicio=null;
	public int tamanio = 0;

	public boolean isVacia() {
		return tamanio == 0;

}
	public void agregarClienteFIFO(ClienteP info) {
		NodoP nodoTmp = new NodoP(info, null);
		if (isVacia()) {
			inicio = nodoTmp;
		} else {
			NodoP nodoTmp2 = inicio;
			while (nodoTmp2.siguiente != null) {
				nodoTmp2 = nodoTmp2.siguiente;

			}

			nodoTmp2.siguiente = nodoTmp;

		}

		tamanio++;
		if(tamanio<=100) {
			int parking=100-tamanio;
			System.out.println("Quedan " + parking + " parqueaderos disponibles de 100");
		}
	}
	
	public void agregarNodoLIFO(ClienteP info) {
		NodoP nodoTmp = new NodoP( info, null);
		if (isVacia()) {
			inicio = nodoTmp;
		} else {
			nodoTmp.siguiente = inicio;
			inicio = nodoTmp;

		}

		tamanio++;
		if(tamanio<=100) {
			int parking=100-tamanio;
			System.out.println("Quedan " + parking + " parqueaderos disponibles de 100");
		}
	}
				
			
	public void salidaCliente(String placaNew) {
		Scanner entrada= new Scanner(System.in);
		ListaP lista= new ListaP();
		NodoP nodoTmp = inicio;
		int contador = 0;
		boolean encontrado = false;
		while (nodoTmp.siguiente != null) {
			if (nodoTmp.info.placa.contains(placaNew)  ) {
				System.out.println("se encontró el Cliente ");
				System.out.println("---------------------------------");
				System.out.println("| Datos del Cliente encontrado:");
				System.out.println("| Nombre: " + nodoTmp.info.nombre);
				System.out.println("| NIT: " + nodoTmp.info.nit);
				System.out.println("| Fecha de Nacimiento: " + nodoTmp.info.fechaN);
				System.out.println("| Telefono: " + nodoTmp.info.tel);
				System.out.println("| Hora de Entrada: " + nodoTmp.info.horaEnt);
				System.out.println("| Placa: " + nodoTmp.info.placa);
				System.out.println("| DPI: " + nodoTmp.info.dpi);
				System.out.println("| Modelo: " + nodoTmp.info.modelo);
				System.out.println("---------------------------------");
				System.out.println("Ingrese la hora de salida del cliente");
				int horaSal= entrada.nextInt();
				int total=(horaSal-nodoTmp.info.horaEnt) * (15);
				System.out.println("El total a pagar es de: Q"+total);
				System.out.println("Ingrese el efectivo a pagar");
				double efectivo= entrada.nextDouble();
				double vuelto= efectivo-total;
				System.out.println("Su cambio es de: Q"+vuelto);
				encontrado = true;
				System.out.println("La salida del cliente se ha realizado con exito");
				System.out.println("El cliente se ha eliminado");
				
				

			}

			nodoTmp = nodoTmp.siguiente;
			contador++;
		}

		if (!encontrado) {
			System.out.println("No encontrado");
		}
	}
	
	public void buscarCliente(String nombreNew, String placaNew) {
		NodoP nodoTmp = inicio;
		int contador = 0;
		boolean encontrado = false;
		while (nodoTmp.siguiente != null ) {
			

			if (nodoTmp.info.nombre.contains(nombreNew) || nodoTmp.info.placa.contains(placaNew) ) {
				System.out.println("se encontró el elemento en el indice:" + contador);
				encontrado = true;
				
			}

			nodoTmp = nodoTmp.siguiente;
			contador++;
		
			
		}
		
		

		if (!encontrado) {
			System.out.println("No encontrado");
		}
	}

	public void imprimirLista() {
		NodoP nodoTmp = inicio;
		System.out.println("");
		System.out.println("");
		System.out.println("|-------- IMPRESIÓN DE LA LISTA------|");
		System.out.println("| Nombre: " + nodoTmp.info.nombre + "| NIT: "  + nodoTmp.info.nit + "| Fecha de nacimiento: "  + nodoTmp.info.fechaN + " | Teléfono: " + nodoTmp.info.tel + "| Hora de entrada: " + nodoTmp.info.horaEnt + "| Placa:" + nodoTmp.info.placa + "| DPI: " + nodoTmp.info.dpi + "| Modelo: " + nodoTmp.info.modelo );
		while (nodoTmp.siguiente != null) {
			nodoTmp = nodoTmp.siguiente;
			System.out.println("| Nombre: " + nodoTmp.info.nombre + "| NIT: "  + nodoTmp.info.nit + "| Fecha de nacimiento: "  + nodoTmp.info.fechaN + " | Teléfono: " + nodoTmp.info.tel + "| Hora de entrada: " + nodoTmp.info.horaEnt + "| Placa:" + nodoTmp.info.placa + "| DPI: " + nodoTmp.info.dpi + "| Modelo: " + nodoTmp.info.modelo  );
            
		}

	}
	
public void eliminarCliente(String placaNew) {
		
		NodoP nodoTmp = inicio;
		NodoP nodoAnterior= null;
		int contador = 0;
		boolean encontrado = false;
		while(nodoTmp.siguiente!=null) {
		if (nodoTmp.info.placa.contains(placaNew)) {
			System.out.println("se encontró el elemento en el indice:" + contador);
			if(contador==0) {
				NodoP eliminado=null;
				eliminado=inicio;
				inicio= inicio.siguiente;
				eliminado.siguiente=null;
				encontrado=true;
				break;
			}else {
				nodoAnterior.siguiente=nodoTmp.siguiente;
				encontrado=true;
				break;
			}
			
			
		}

		

		nodoAnterior= nodoTmp;
		nodoTmp=nodoTmp.siguiente;
		
		contador++;
	}

	if (!encontrado) {
		System.out.println("No encontrado");
	}
  }

public void Grafo(){
	
	try{
		NodoP nodoTmp = inicio;
		tamanio=0;
		
		
		
		BufferedWriter escritura = new BufferedWriter(new FileWriter("C:\\Users\\Usuario\\git\\repositoryOther\\PROYECT\\src\\proyectoooo\\grafo.gv"));
		
		escritura.write("digraph G {\n");
		escritura.write("  rankdir=LR;\n");
		escritura.write("  node [shape=Mrecord,style=filled,fillcolor=gray];\n");

		String lineaGraph= "  ";
		lineaGraph = lineaGraph + "\""  + "Nombre: " +  nodoTmp.info.nombre +  "\n" + "Nit: " +  nodoTmp.info.nit +  "\n" + "Fecha de Nacimiento: " +  nodoTmp.info.fechaN +  "\n"  + "Teléfono: " +  nodoTmp.info.tel +   "\n" + "Hora de entrada: " +  nodoTmp.info.horaEnt +  "\n" + "Placa: " +  nodoTmp.info.placa +  "\n" + "DPI: " +  nodoTmp.info.dpi + "\n" + "Modelo: " +  nodoTmp.info.modelo +  "\" -> ";
		
		
		while(nodoTmp.siguiente!=null){
			nodoTmp = nodoTmp.siguiente;
			
			if((tamanio==0) || (tamanio%2)==0) {
				escritura.write("  node [shape=Mrecord];\n");
                lineaGraph= lineaGraph + "\"" + "Nombre: " +  nodoTmp.info.nombre +  "\n" + "Nit: " +  nodoTmp.info.nit +  "\n" + "Fecha de Nacimiento: " +  nodoTmp.info.fechaN +  "\n"  + "Teléfono: " +  nodoTmp.info.tel +  "\n" + "Hora de entrada: " +  nodoTmp.info.horaEnt + "\n" + "Placa: " +  nodoTmp.info.placa + "\n" + "DPI: " +  nodoTmp.info.dpi + "\n" + "Modelo: " +  nodoTmp.info.modelo +  "\" -> ";
			  
		}else {
			escritura.write("  node [shape=Mrecord,style=filled,fillcolor=gray];\n");
            lineaGraph= lineaGraph + "\"" + "Nombre: " +  nodoTmp.info.nombre +  "\n" + "Nit: " +  nodoTmp.info.nit +  "\n" + "Fecha de Nacimiento: " +  nodoTmp.info.fechaN +  "\n"  + "Teléfono: " +  nodoTmp.info.tel +  "\n" + "Hora de entrada: " +  nodoTmp.info.horaEnt + "\n" + "Placa: " + nodoTmp.info.placa + "\n" + "DPI: " + nodoTmp.info.dpi + "\n" + "Modelo: " + nodoTmp.info.modelo +  "\" -> ";

			
		}
			tamanio++;
	}
		
        lineaGraph = lineaGraph + "\"null \";\n";
        escritura.write(lineaGraph);
		escritura.write("}\n");
		escritura.close();
		System.out.println("Ya escribio lo solicitado en el archivo: C:\\Users\\Usuario\\git\\repositoryOther\\PROYECT\\src\\proyectoooo\\grafo.gv");
		
	
	}catch(Exception e){
		e.printStackTrace();
	}
	
}
	public void desdeJava() {
		try {
			        //Código para que se ejecute el grafo desde java, pero no funcionó ya que dice que el directorio es inválido
			        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\Users\\Usuario\\git\\repositoryOther\\PROYECT\\src\\proyectoooo\\grafo.gv");
			        builder.redirectErrorStream(true);
			        Process p = builder.start();
			        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			        String line;
			        while (true) {
			            line = r.readLine();
			            if (line == null) { break; }
			            System.out.println(line);
			        }
			    
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

   }
}
