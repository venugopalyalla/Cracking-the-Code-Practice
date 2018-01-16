import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateBwDates {

	static boolean compDates(String s1, String s2, String s3) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Date a1 = sdf.parse(s1);
		Date a2 = sdf.parse(s2);
		Date a3 = sdf.parse(s3);
		System.out.println("Output of comp dates with getTime() mehtod  -  " + compTimeDates(a1,a2,a3));
		//System.out.println(daysBetween(a1,a2));
		//int days = Days.daysBetween(a1, a2).getDays();
		if(a3.compareTo(a1)* a3.compareTo(a2) <= 0) {
			return true;
		}
		return false;
	}

	static boolean compTimeDates(Date d1, Date d2, Date d3) {
		if((d3.getTime()-d1.getTime())*(d3.getTime()-d2.getTime()) <= 0) {
			return true;
		}
		return false;
	}

	static int daysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	public static void main(String[] args) throws ParseException {
		String s1 = "21-Nov-2017";
		String s2 = "21-Dec-2017";
		String s3 = "25-Nov-2017";
		System.out.println(compDates(s1,s2,s3));
	}
}
