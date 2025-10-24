package ej5;

import java.io.File;

public class directory {
	public static void main(String[] args) {
		try {
			/*
			 * Ejecuta pwd desde un directorio distinto al actual (por ejemplo, /tmp).
			 * Indicaciones para resolverlo new
			 * ProcessBuilder("bash","-lc","pwd").directory(new File("/tmp")).start();
			 */
			ProcessBuilder pb = new ProcessBuilder("bash", "-lc", "pwd").directory(new File("/tmp"));
			Process proceso = pb.start();
			
			String err = new String(proceso.getErrorStream().readAllBytes());
			String out = new String(proceso.getInputStream().readAllBytes());
			System.out.println("STDOUT:" + out);
			System.out.println("STDERR:" + err);
			
			int code = proceso.waitFor();
			
			
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
}
