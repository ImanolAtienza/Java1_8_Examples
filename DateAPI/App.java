package DateAPI;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class App {

	public void verificar(int version) {
		if(version == 7) {
			Calendar fecha1 = Calendar.getInstance();
			Calendar fecha2 = Calendar.getInstance();
			
			fecha1.set(1991, 0, 21);
			System.out.println("Comparar fechas " + fecha1.after(fecha2));
		} else {
			LocalDate fecha1 = LocalDate.of(1991, 1, 21);
			LocalDate fecha2 = LocalDate.now();
			LocalTime time1 = LocalTime.of(22, 30, 50);
			LocalTime time2 = LocalTime.now();
			LocalDateTime tDate1 = LocalDateTime.of(1991, 1, 21, 22, 30, 50);
			LocalDateTime tDate2 = LocalDateTime.now();
			
			System.out.println("Comparar fechas " + fecha1.isAfter(fecha2) + " " + fecha1.isBefore(fecha2));
			System.out.println("Comparar tiempo " + time1.isAfter(time2) + " " + time1.isBefore(time2));
			System.out.println("Comprar fecha con unidad de tiempo " + tDate1.isAfter(tDate2) + " " + tDate1.isBefore(tDate2));
		}
		System.out.println("-------------------------------");
	}
	
	public void medirTiempo(int version) {
		if(version == 7) {
			long ini = System.currentTimeMillis();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long fin = System.currentTimeMillis();
			System.out.println("Tiempo transcurrido " + (fin - ini));
		} else {
			Instant ini = Instant.now();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Instant fin = Instant.now();
			System.out.println("Tiempo transcurrido " + Duration.between(ini, fin)); // .toX()
		}
		System.out.println("-------------------------------");
	}
	
	public void periodoEntreFechas(int version) {
		if(version == 7) {
			Calendar nacimiento = Calendar.getInstance();
			Calendar actual = Calendar.getInstance();
			int anios = 0;
			
			nacimiento.set(1991, 0, 21);
			actual.set(2020, 1, 5);
			
			while(nacimiento.before(actual)) {
				nacimiento.add(Calendar.YEAR, 1);
				if(nacimiento.before(actual))
					anios++;
			}
			
			System.out.println("Tiempo entre fechas " + anios);
		} else {
			LocalDate nacimiento = LocalDate.of(1991, 1, 21);
			LocalDate actual = LocalDate.now();
			
			Period periodo = Period.between(nacimiento, actual);
			System.out.println("Tiempo entre fechas, años " + periodo.getYears() + ", meses " + periodo.getMonths() + ", dias " + periodo.getDays()
					+ " desde " + nacimiento + " hasta " + actual);
		}
		System.out.println("-------------------------------");
	}
	
	public void convertir(int version) {
		if(version == 7) {
			DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date fechaConvertida = formateador.parse("21/01/1991");
				System.out.println("Fecha convertida con parse " + fechaConvertida);
				
				Date fechaActual = Calendar.getInstance().getTime();
				formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
				String fechaCadena = formateador.format(fechaActual);
				System.out.println("Fecha convertida con format " + fechaCadena);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaLocal = LocalDate.parse("21/01/1991", formateador);
			
			System.out.println("Fecha convertida " + fechaLocal + " y sin convertir " + formateador.format(fechaLocal));
		}
	}
	
	public static void main(String[] args) {
		App a = new App();
		
		for (int i = 7; i < 9; i++) {
			System.out.println("Prueba date versión 1." + i + ":");
			a.verificar(i);
			a.medirTiempo(i);
			a.periodoEntreFechas(i);
			a.convertir(i);
			System.out.println("\n");
		}
	}
}
