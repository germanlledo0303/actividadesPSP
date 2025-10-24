package ej4;

public class inherit_io {
	public static void main(String[] args) {
		/*
		 * Ejecuta top -b -n1 heredando la salida directamente a tu terminal.
		 * Indicaciones para resolverlo new
		 * ProcessBuilder("bash","-lc","top -b -n1").inheritIO().start().waitFor();
		 */

		try {
			ProcessBuilder pb = new ProcessBuilder("bash", "-lc","top -b -n1");

			pb.inheritIO().start().waitFor();

		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

}
