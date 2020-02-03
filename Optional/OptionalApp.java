package Optional;

import java.util.Optional;

public class OptionalApp {
	// Se puede utilizar la clase Optional para gestionar de forma más correcta todas las posibles situaciones de NullPointerException
	// Para situaciones de alta carga o prioritarias, no se recomienda su uso puesto que es computocionalmente costosa
	public void probar(String valor) {
		System.out.println("\nProbar valor");
		
		try {
			Optional op = Optional.empty();
			op.get();
		} catch (Exception e) {
			System.err.println("No hay elemento");
		}
	}
	
	public void orElse(String valor) {
		System.out.println("\nOrElse");
		
		Optional<String> op = Optional.ofNullable(valor);
		valor = op.orElse("Predeterminado");
		System.out.println(valor);
	}
	
	public void orElseThrow(String valor) {
		Optional<String> op = Optional.ofNullable(valor);
		op.orElseThrow(NumberFormatException :: new);
	}
	
	public void isPresent(String valor) {
		System.out.println("\nIspresent");
		Optional<String> op = Optional.ofNullable(valor);
		System.out.println(op.isPresent());
	}
	
	public static void main(String[] args) {
		OptionalApp app = new OptionalApp();
		
		app.probar("Mito");
		app.orElse("Mito");
		app.orElse(null);
		app.orElseThrow("Code");
		//app.orElseThrow(null);
		app.isPresent("Mito Code");
		app.isPresent(null);
	}

}
