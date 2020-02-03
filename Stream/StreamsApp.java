package Stream;

import java.util.ArrayList;
import java.util.List;

public class StreamsApp {
	
	private List<String> lista;
	private List<String> numeros;
	
	public StreamsApp() {
		lista = new ArrayList<>();
		lista.add("Mito");
		lista.add("Code");
		lista.add("El mismo");
		lista.add("MitoCode");
		
		numeros = new ArrayList<>();
		numeros.add("1");
		numeros.add("2");
		numeros.add("3");
		numeros.add("4");
	}

	private void filtrar() {
		lista.stream().filter(x -> x.startsWith("M")).forEach(System.out :: println);
	}
	
	public void ordenar() {
		System.out.println("\nOrdenar ascendentemente");
		lista.stream().sorted().forEach(System.out :: println);
		System.out.println("Ordenar descendentemente");
		lista.stream().sorted((x, y) -> y.compareTo(x)).forEach(System.out :: println);
	}
	
	public void transformar() {
		System.out.println("\nTransformar string");
		// Cada elemento de la lista va a ser transformado con la expresion que se indique
		lista.stream().map(String::toUpperCase).forEach(System.out :: println);;
		System.out.println("Transformar enteros");
		numeros.stream().map(x -> (Integer.parseInt(x) + 1)).forEach(System.out :: println);
	}
	
	public void limitar() {
		System.out.println("\nLimitar string");
		lista.stream().limit(2).forEach(System.out :: println);
	}
	
	public void contar() {
		System.out.println("\nContar string");
		System.out.println(lista.stream().count());
	}
	
	public static void main(String[] args) {
		StreamsApp app = new StreamsApp();
		
		app.filtrar();
		app.ordenar();
		app.transformar();
		app.limitar();
		app.contar();
	}


}
