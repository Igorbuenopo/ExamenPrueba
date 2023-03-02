package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Monte;

public class Metodos {
	Connection conexion;
	String cadena;
	String nombre, provincia, coord, macizo, ruta;

	public Monte[] cargarBBDD() {
		Monte montes[] = new Monte[0];

		try {
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bdmontess", "root", "");
			Statement comando = conexion.createStatement();
			ResultSet registro = comando.executeQuery("select * from montes");

			while (registro.next()) {
				String nombre = registro.getString("Nombre");
				String provincia = registro.getString("Provincia");
				Double altura = registro.getDouble("Altura");
				String coordenadas = registro.getString("Coordenadas");
				String macizo = registro.getString("Cordillera");
				String ruta = registro.getString("Ruta");

				Monte monte = new Monte(nombre, provincia, altura, coordenadas, macizo, ruta);

				Monte[] arrayNuevo = new Monte[montes.length + 1];
				for (int i = 0; i < montes.length; i++) {
					arrayNuevo[i] = montes[i];
				}
				arrayNuevo[montes.length] = monte;
				montes = arrayNuevo;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return montes;
	}

	public Monte[] cargartxt() {
		Monte montes[] = new Monte[0];

		File file = new File("Mendiak.txt");
		BufferedReader fichero;
		try {
			fichero = new BufferedReader(new FileReader(file));
			String linea;

			int altura = 0;
			while ((linea = fichero.readLine()) != null) {
				if (!linea.equals("----------------")) {
					String valor = linea.split(":")[1];
					if (linea.contains("Nombre:")) {
						nombre = valor;
					} else if (linea.contains("Provincia:")) {
						provincia = valor;
					} else if (linea.contains("Altura:")) {
						altura = Integer.valueOf(valor);
					} else if (linea.contains("Coordenadas:")) {
						coord = valor;
					} else if (linea.contains("Macizo:")) {
						macizo = valor;
					} else if (linea.contains("RutaHabitual:")) {
						ruta = valor;
					}

				} else {
						Monte monte = new Monte(nombre, provincia, altura, coord, macizo, ruta);

						Monte[] arrayNuevo = new Monte[montes.length + 1];
						for (int i = 0; i < montes.length; i++) {
							arrayNuevo[i] = montes[i];
						}
						arrayNuevo[montes.length] = monte;
						montes = arrayNuevo;
						ruta = "";
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println(montes.length);
		return montes;
	}

	public void mostrarmontes(Monte[] montes) {
		System.out.println("Listado de montes");
		System.out.println("Nombre\tProvincia\tAltura\tCoor\tMacizo\tRuta\t");
		System.out.println(montes.length);
		for (int i = 0; i < montes.length; i++) {
			String rutaN = montes[i].getRuta();
			if (rutaN != null || rutaN.equals("null")) {
				System.out.println(montes[i].getNombre() + "\t" + montes[i].getProvincia() + "\t"
						+ montes[i].getAltura() + "\t" + montes[i].getCoordenadas() + "\t" + montes[i].getMacizo()
						+ "\t" + montes[i].getRuta());

			} else {

				System.out.println(montes[i].getNombre() + "\t" + montes[i].getProvincia() + "\t"
						+ montes[i].getAltura() + "\t" + montes[i].getCoordenadas() + "\t" + montes[i].getMacizo());

			}

		}
	}
}
