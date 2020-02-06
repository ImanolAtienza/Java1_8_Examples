package AnotacionesRepeticion;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class App {

	// Las anotaciones customizables valen para indicar metadatos (colocar informacion en lugar de comentarios en codigo)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Lenguajes {
		Lenguaje[] value() default {};	
	}
	
	// Para poder crear más de una anotación
	@Repeatable(value = Lenguajes.class)
	public @interface Lenguaje {
		String value();
	}
	
	/*
	 * 1.7
	 * @Lenguajes ({
	 * 		@Lenguaje("Java"),
	 * 		@Lenguaje("Python")
	 * })
	 */
	@Lenguaje("Java")
	@Lenguaje("Python")
	public interface LenguajeProgramacion {}
	
	@AnotacionCustom("Pedro")
	public interface UsuarioAnotado {}
	
	public static void main(String[] args) {
		Lenguaje[] lenguajeArray = LenguajeProgramacion.class.getAnnotationsByType(Lenguaje.class);
		Lenguajes len = LenguajeProgramacion.class.getAnnotation(Lenguajes.class);
		AnotacionCustom aCustom = LenguajeProgramacion.class.getAnnotation(AnotacionCustom.class);
		
		System.out.println("Tienen " + lenguajeArray.length + " anotaciones.");
		for(Lenguaje l : len.value())
			System.out.println(l.value());
		
		System.out.println("\nAnotacion Custom\n[" + aCustom.value() + " y " + aCustom.predeterminado() + "]");
	}

}
