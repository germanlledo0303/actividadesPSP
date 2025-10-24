package ej7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pipe {
	public static void main(String[] args) {
		/*
		 * Crea dos procesos y conecta la salida del primero con la entrada del segundo
		 * desde Java. Indicaciones para resolverlo Lanza p1 = new
		 * ProcessBuilder("bash","-lc","echo 'hola mundo'").start() y p2 = new
		 * ProcessBuilder("bash","-lc","wc -w").start(). Pasa bytes de
		 * p1.getInputStream() a p2.getOutputStream() con un buffer y cierra out de p2.
		 */

		try {
			Process p1 = new ProcessBuilder("bash", "-lc", "echo 'hola mundo'").start();
			Process p2 = new ProcessBuilder("bash", "-lc", "wc -w").start();

			BufferedReader stdoutReader1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
			BufferedReader stdoutReader2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
			
			String linea;
			StringBuilder output1 = new StringBuilder();
			while ((linea = stdoutReader1.readLine()) != null) {
				output1.append(linea).append("\n");
			}
			stdoutReader1.close();
			
			p2.getOutputStream().write(output1.toString().getBytes());
			p2.getOutputStream().close();
			
			StringBuilder output2 = new StringBuilder();
			while ((linea = stdoutReader2.readLine()) != null) {
				output2.append(linea).append("\n");
			}
			stdoutReader2.close();
			
			int code1 = p1.waitFor();
			int code2 = p2.waitFor();
			
			System.out.println("Salida del primer proceso (echo):");
			System.out.println(output1.toString());
			System.out.println("Salida del segundo proceso (wc -w):");
			System.out.println(output2.toString());
			
			

		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

}
