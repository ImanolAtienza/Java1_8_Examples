package LambdaYPorDefecto;

public interface InterfazXDefecto {
	
	public default void presentar() {
		System.out.println("Metodo por defecto, que esta implementado en la interfaz. Util para implementar un comportamiento por defecto en alguna implementaci�n de una interfaz.");
	}
}
