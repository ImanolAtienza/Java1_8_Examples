package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class App {

	private Map<Integer, String> map;
	
	public void poblar() {
		map = new HashMap<>();
		
		map.put(1, "Mito");
		map.put(2, "Code");
		map.put(3, "MitoCode");
	}
	
	public void imprimir_v7() {
		System.out.println("\nImprimir v7");
		for(Entry<Integer, String> e : map.entrySet()) // EntrySet es el conjunto de valores de la lista
			System.out.println("[[Key = "+ e.getKey() + "] [Value = " + e.getValue() + "]]");
	}
	
	public void imprimir_v8() {
		System.out.println("\nImprimir v8");
		//map.forEach((k, v) -> System.out.println("[[Key = "+ k + "] [Value = " + v + "]]"));
		map.entrySet().stream().forEach(System.out :: println);
	}
	
	public void recolectar() {
		System.out.println("\nRecolectar");
		Map<Integer, String> mapaRecolectado = map.entrySet().stream()
				.filter(e -> e.getValue().contains("Code"))
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		
		mapaRecolectado.forEach((k, v) -> System.out.println("[[Key = "+ k + "] [Value = " + v + "]]"));
	}
	
	public void operarSiAusente() {
		// Si usamos un Map.put sobreescribe el indice que se le pase como argumento
		System.out.println("\nOperar si ausente");
		map.putIfAbsent(4, "Youtube");
		map.putIfAbsent(4, "Ejemplo");
		this.imprimir_v8();
	}
	
	public void operarSiPresente() {
		System.out.println("\nOperar si presente");
		map.computeIfPresent(4, (k, v) -> { return (v.equals("Youtube") ? "Youtube de Jaime" : v);});
		this.imprimir_v8();
	}
	
	public void obtenerOrPredeterminado(int k) {
		System.out.println("\nObtener or predeterminado");
		// Si no puede obtener el valor de un indice X, devuelve el string que le pongas a la izquierda del metodo
		System.out.println("[[Key = "+ k + "] [Value = " + map.getOrDefault(k, "Valor por defecto") + "]]");
	}
	
	public static void main(String[] args) {
		App a = new App();
		
		a.poblar();
		a.imprimir_v7();
		a.imprimir_v8();
		a.operarSiAusente();
		a.operarSiPresente();
		a.obtenerOrPredeterminado(5);
		a.recolectar();
	}

}
