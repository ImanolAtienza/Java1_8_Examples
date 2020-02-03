package InterfazFuncional;

// Una interfaz funcional es aquella que solamente define una unica operacion o un único metodo, si la especificas como
// tal no te compila, debido a que solo debe contener un único metodo
@FunctionalInterface
public interface Operacion {
	
	double calcular(double n1, double n2);
}
