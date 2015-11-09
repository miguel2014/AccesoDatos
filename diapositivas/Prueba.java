package diapositivas;

import java.util.Calendar;
import java.util.Date;

public class Prueba {
	public static void main(String[] args) {
		System.out.format("%1$04d - the year of %2$f%n",1951,Math.PI);
		
		Date today=Calendar.getInstance().getTime();
		System.out.printf("Today is %1$tB %1$td %1$tY%n",today);
	}
}
