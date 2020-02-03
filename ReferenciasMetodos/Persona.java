package ReferenciasMetodos;

public class Persona {

	private int id;
	private String nombre;
	
	public Persona(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "[[id = " + id + "], [nombre = " + nombre + "]]";
	}
}
