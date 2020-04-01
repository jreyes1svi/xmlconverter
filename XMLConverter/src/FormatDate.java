import java.text.*;
import java.util.*;

public class FormatDate {

	public String convertDate(String date) {
		DateFormat yf = new SimpleDateFormat("yyy-mm-dd");
		DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		Date tempDate = null;
		String outputDate = null;
		try {
			tempDate = yf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		outputDate = dateFormat.format(tempDate);
		return outputDate;
	}

}
