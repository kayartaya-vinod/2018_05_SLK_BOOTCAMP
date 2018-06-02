package spring.training.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {

	// do not let anyone instantiate this class
	private DateUtil() {
	}

	private static SimpleDateFormat sdf;

	static {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
	}

	public static String toString(Date date) {
		if (date == null)
			return null;
		return sdf.format(date);
	}

	public static Date toDate(String date) {
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
}
