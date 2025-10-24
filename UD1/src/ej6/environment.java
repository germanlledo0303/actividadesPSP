package ej6;

public class environment {

	public static void main(String[] args) {

		/*
		 * Define una variable de entorno (p. ej. MI_VAR=UD1) y verifica su valor con
		 * printenv. Indicaciones para resolverlo ProcessBuilder pb = new
		 * ProcessBuilder("bash","-lc","printenv MI_VAR");
		 * pb.environment().put("MI_VAR","UD1");
		 */

		try {
			ProcessBuilder pb = new ProcessBuilder("bash", "-lc","printenv MI_VAR");
			pb.environment().put("MI_VAR","UD1");
		
			Process proceso = pb.start();
			
			String out = new String(proceso.getInputStream().readAllBytes());
			String err = new String(proceso.getErrorStream().readAllBytes());
			
			System.out.println("STDOUT:" + out);
			System.out.println("STDERR:" + err);
			
			int code = proceso.waitFor();
			

		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

}
