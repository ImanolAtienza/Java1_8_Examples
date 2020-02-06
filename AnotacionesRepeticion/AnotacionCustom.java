package AnotacionesRepeticion;

public @interface AnotacionCustom {
	String value() default "";
	boolean predeterminado() default true;
	
}