package ej2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class lsSalida {

	/*
	 * Ejecuta ls -l, lee stdout del proceso y muéstralo por consola Java.
	 */

	public static void main(String[] args) {

		try {
			// Crear ProcessBuilder para ejecutar echo con el mensaje
			ProcessBuilder pb = new ProcessBuilder("ls", "-l");

			// Iniciar el proceso
			Process p = pb.start();

			// Esperar a que el proceso termine y obtener el código de salida
			int codigoSalida = p.waitFor();

			// Leer la salida estándar del proceso
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream())); //p.getInputStream() para leer la salida del proceso
																								//p.getErrorStream() para leer errores

			System.out.println("Salida del comando 'ls -l':");

			String linea;
			while ((linea = reader.readLine()) != null) { //mientras haya líneas de salida se imprimen
				System.out.println(linea);
			}
			

		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

}
