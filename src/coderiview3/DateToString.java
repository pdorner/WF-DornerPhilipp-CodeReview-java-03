package coderiview3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public interface DateToString {

	// Interface for converting a Date into a String for my Company and Station Class
	public static String getDateTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd' T 'HH:mm:ss", Locale.getDefault());
		return format.format(new Date().getTime());
	}

}
