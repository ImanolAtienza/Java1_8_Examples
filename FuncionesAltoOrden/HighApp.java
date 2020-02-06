package FuncionesAltoOrden;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HighApp {
	
	private Function <String, String> convertirMayusculas = x -> x.toUpperCase();
	private Function <String, String> convertirMinusculas = x -> x.toLowerCase();
	
	public void imprimir(Function <String, String> funcion, String valor) {
		System.out.println(funcion.apply(valor) );
	}
	
	public Function<String, String> mostrar(String mensaje) {
		return (String x) -> mensaje + x;
	}
	
	public void filtrar(List<String> lista, Consumer<String> consumidor, int longitud) {
		lista.stream().filter(this.establecerLogicaFiltro(longitud)).forEach(consumidor);
	}
	
	public Predicate<String> establecerLogicaFiltro(int longitud) {
		return texto -> texto.length() < longitud;
	}
	
	public Predicate<String> establecerLogicaFiltro(String cadena) {
		return texto -> texto.contains(cadena);
	}
	
	public static void main(String[] args) {
		HighApp app = new HighApp();
		
		System.out.println("Convertir en mayusculas:");
		app.imprimir(app.convertirMayusculas, "mitocode");
		System.out.println("\nConvertir en minisculas:");
		app.imprimir(app.convertirMinusculas, "MITOCODE");
		System.out.println("\nConcatenar:");
		System.out.println(app.mostrar("Hola ").apply("MitoCode"));
		
		List<String> lista = new ArrayList<>();
		lista.add("Mito");
		lista.add("Code");
		lista.add("MitoCode");
		
		System.out.println("\nFiltrar:");
		app.filtrar(lista, System.out :: println, 5);
	}
}
