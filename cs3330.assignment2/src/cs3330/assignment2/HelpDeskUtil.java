package cs3330.assignment2;

import java.util.List;
public class HelpDeskUtil {
	private HelpDeskUtil() {
		
	}
	
	public static <T> void printAll(List<T> items) {
        if (items == null) {
            throw new IllegalArgumentException("Items list cannot be null.");
        }
        for (T item : items) {
            System.out.println(item);
        }
    }
	
	public static int sumPoints(List<? extends Technician> technicians) {
        if (technicians == null) {
            throw new IllegalArgumentException("Technicians list cannot be null.");
        }

        int total = 0;
        for (Technician tech : technicians) {
            if (tech != null) {
                total += tech.getServicePoints();
            }
        }
        return total;
    }

}
