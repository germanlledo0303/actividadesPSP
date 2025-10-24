package ej1;

public class Echo {

	/*
	 * Crea un programa que ejecute echo con un mensaje y verifica que el proceso
	 * termina con código 0.
	 */
	public static void main(String[] args) {

		try {
			// Crear ProcessBuilder para ejecutar echo con el mensaje
			ProcessBuilder pb = new ProcessBuilder("echo", "Hola Mundo");
			
			// Iniciar el proceso
			Process p = pb.start();

			// Esperar a que el proceso termine y obtener el código de salida
			int codigoSalida = p.waitFor();

			// Verificar que el proceso terminó con código 0
			if (codigoSalida == 0) {
				System.out.println("✅ VERIFICACIÓN EXITOSA: El proceso 'echo' terminó con código " + codigoSalida);
			} else {
				System.out.println("❌ ERROR: El proceso 'echo' terminó con código " + codigoSalida);
			}

		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
}