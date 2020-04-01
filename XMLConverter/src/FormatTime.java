import java.text.*;
import java.util.*;

public class FormatTime {

	public String convertTime(String time) {
		DateFormat xf = new SimpleDateFormat("hh:mm:ss aa");
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		Date tempTime = null;
		String outputTime = null;
		if (time != "") {
			try {
				tempTime = xf.parse(time);
				outputTime = timeFormat.format(tempTime);
				return outputTime;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return outputTime;

		} else {
			return "";

		}
	}

}
