package InterfazFuncional;

// Una interfaz funcional es aquella que solamente define una unica operacion o un �nico metodo, si la especificas como
// tal no te compila, debido a que solo debe contener un �nico metodo
@FunctionalInterface
public interface Operacion {
	
	double calcular(double n1, double n2);
}
