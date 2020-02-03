package ReferenciasMetodos;

import java.util.Arrays;

public class MeReffApp {

	public static void referenciarMetodoStatic() {
		System.out.println("Metodo referido static");
	}
	
	public void referenciarMetodoInstanciaObjetoArbitrario() {
		String nombres[] = {"Mito", "Code", "Su nombre"};
		
		//Arrays.sort(nombres, (nombre1, nombre2) -> nombre1.compareToIgnoreCase(nombre2)); // 2º Parametro --> Comparator
		Arrays.sort(nombres, String :: compareToIgnoreCase);
		System.out.println("Metodo referido arbitrario " + Arrays.toString(nombres));
	}
	
	public void referenciarMetodoInstanciaObjetoParticular() {
		System.out.println("Metodo referido instancia de un objeto en particular");
	}
	
	public void referenciarConstructor() {
		Persona p = null;
		//IPersona iper = (id, nombre) -> new Persona(id, nombre);
		IPersona iper = Persona :: new;
		
		p = iper.crear(1, "Mito");
		System.out.println(p.toString());
	}
	
	public static void main(String[] args) {
		MeReffApp app = new MeReffApp();
		
		Operacion op = MeReffApp :: referenciarMetodoStatic; // Esta forma de invocacion no permite enviar parametros
		op.saludar();
		app.referenciarMetodoInstanciaObjetoArbitrario();
		op = app :: referenciarMetodoInstanciaObjetoParticular;
		op.saludar();
		op = app :: referenciarConstructor;
		op.saludar();
	}
}
