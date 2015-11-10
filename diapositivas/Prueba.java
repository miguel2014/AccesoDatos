package diapositivas;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Prueba {
	public static void main(String[] args) {
		System.out.format("%1$04d - the year of %2$f%n",1951,Math.PI);
		
		LocalDate fecha=LocalDate.now();
		
		//System.out.printf("Today is %1$d %1$td %1$tY%n",fecha.getDayOfMonth(),fecha.getMonth(),fecha.getYear());
	}
}
