package LambdaYPorDefecto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.print.attribute.standard.PresentationDirection;

public class LambdaApp implements InterfazXDefecto {
	
	private static float probarVariable() {
		final float n3 = 3; // variable constante que no puede alterar su valor

		Operacion operacion = (x, y) -> {return x + y + n3;};
		
		return operacion.calcularPromedio(1, 1);
	}
	
	private static void ordenar() {
		List<String> lista = new ArrayList<>();
		lista.add("MitoCode");
		lista.add("Code");
		lista.add("Mito");
		
		// Definicion de la ordenacion de una lista basada en string mediante expresones lambda
		Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));
		
		for(String s : lista)
			System.out.println(s);
	}
	
	private static void calcular() {
		// Definicion de funcion de una interfaz mediante expresones Lambda
		Operacion operacion = (float x, float y) -> {float n = 2; return ((x + y) / n);};
		
		System.out.println(operacion.calcularPromedio(2, 3));
	}
	
    public static void main(String[] args) {
    	ordenar();
    	calcular();
    	System.out.println(probarVariable());
    	
    	LambdaApp app = new LambdaApp();
    	app.presentar();
    }
}
