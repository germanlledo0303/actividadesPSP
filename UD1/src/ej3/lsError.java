package ej3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class lsError {
	public static void main(String[] args) {

		/*
		 * Lanza ls /ruta/que/no/existe y muestra el mensaje de error de stderr.
		 * Indicaciones para resolverlo Usa p.getErrorStream(). No mezcles con
		 * redirectErrorStream(true) para verlos por separado
		 */

		try {
			// Crear ProcessBuilder para ejecutar ls sobre una ruta que no existe
			ProcessBuilder pb = new ProcessBuilder("ls", "hgfhgchgjv");

			// Iniciar el proceso
			Process p = pb.start();

			// Leer la salida estándar (stdout) del proceso
			BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			// Leer la salida de error (stderr) del proceso 
			BufferedReader stderrReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));

			System.out.println("=== SALIDA ESTÁNDAR (stdout) ===");
			String linea;
			boolean haySalida = false;
			while ((linea = stdoutReader.readLine()) != null) { //mientras haya líneas de salida se imprimen
				System.out.println(linea);
				haySalida = true;
			}
			if (!haySalida) {
				System.out.println("(No hay salida estándar)");
			}

			System.out.println("=== SALIDA DE ERROR (stderr) ===");
			boolean hayErrores = false;
			String errorLinea;
			while ((errorLinea = stderrReader.readLine()) != null) { //mientras haya líneas de error se imprimen
				System.err.println(errorLinea);
				hayErrores = true;
			}
			if (!hayErrores) {
				System.out.println("(No hay errores)");
			}

			// Cerrar los readers
			stdoutReader.close();
			stderrReader.close();

			// Esperar a que el proceso termine y obtener el código de salida
			int codigoSalida = p.waitFor();
			System.out.println("CÓDIGO DE SALIDA: " + codigoSalida);

		} catch (Exception ex) {
		    System.err.println(ex);
		}
	}
}
