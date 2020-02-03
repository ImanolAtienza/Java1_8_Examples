package Colecciones;

import java.util.ArrayList;
import java.util.List;

public class ColeccionApp {

	private List<String> lista;
	
	public void llenarLista() {
		lista = new ArrayList<>();
		
		lista.add("Mito Code");
		lista.add("Mito");
		lista.add("Code");
	}
	
	public void usarForEach() {
		//lista.forEach(l -> System.out.print(l + " "));
		lista.forEach(System.out :: println);
	}
	
	public void userRemoveIf() {
		lista.removeIf(i -> i.equalsIgnoreCase("Code"));
	}
	
	public void usarSort() {
		lista.sort((x, y) -> x.compareTo(y));
	}
	
	public static void main(String[] args) {
		ColeccionApp app = new ColeccionApp();
		
		app.llenarLista();
		app.usarForEach();
		app.usarSort();
		app.userRemoveIf();
	}



}
