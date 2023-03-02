package vista;

import java.util.Scanner;

import controlador.Metodos;
import modelo.Monte;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Metodos m = new Metodos();
		Monte montes[]= null;
		
		int opcion = 0;
		
		do {
			
			boolean error = false;
			
			do {
				System.out.println("Menu principal\r\n"
						+ "1.- Cargar montes (txt)\r\n"
						+ "2.- Cargar montes (bd)\r\n"
						+ "3.- Añadir monte\r\n"
						+ "4.- Mostrar montes\r\n"
						+ "5.- Mostrar monte por nombre\r\n"
						+ "6.- Eliminar monte.\r\n"
						+ "7.- Guardar montes (bd)\r\n"
						+ "0.- Fin");
				System.out.println("Elige una opción");
				
				String opcionS = sc.nextLine();
				
				try {
					opcion = Integer.valueOf(opcionS);
					
					if(opcion<0 || opcion>7) {
						System.out.println("Elige una opción entre 1 y 7");
						error = true;
					}
				}catch(Exception e) {
					System.out.println("Pon un número");
					error = true;
				}
			}while(error);
			
			switch(opcion) {
				
			case 1:montes = m.cargartxt();
				break;
			case 2: montes = m.cargarBBDD();
				break;
			case 3:
				break;
			case 4:m.mostrarmontes(montes);
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			
			}
			
		}while(opcion != 0);
		
		sc.close();
	}

}
