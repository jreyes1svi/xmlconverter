
import java.io.*;

import java.text.*;

import java.util.*;

import org.apache.poi.ss.usermodel.*;

public class XMLConverter {

	public static void main(String[] args) {
		FileWriter fostream;
		String inputFile1 = "TimeAndAttendance_";
		String inputFile2 = "2020-03-21";
		String strOutputPath = "C:\\Users\\Administrator\\Desktop\\JAVA";
		String strFilePrefix = "03-21-2020";
		String tempDate = "";

		try {
			InputStream inputStream = new FileInputStream(
					new File(strOutputPath + "\\" + inputFile1 + inputFile2 + ".xlsx"));
			Workbook wb = WorkbookFactory.create(inputStream);
			Sheet sheet = wb.getSheet("Sheet1");

			FormatDate formatDate = new FormatDate();
			tempDate = formatDate.convertDate(inputFile2);
			FormatTime formatTime = new FormatTime();
			fostream = new FileWriter(strOutputPath + "\\" + strFilePrefix + ".xml");
			PrintWriter out = new PrintWriter(new BufferedWriter(fostream));

			out.println("<Root>");
			out.println("\t<Uploads>");

			FormatCell formatCell = new FormatCell();
			FormatElement formatElement = new FormatElement();
			boolean firstRow = true;
			for (Row row : sheet) {

				if (firstRow == true) {
					firstRow = false;
					continue;
				}

				for (int i = 0; i < 2; i++) {
					out.println("\t\t<upload>");
					out.print("\t\t\t<file_name>");
					out.println("</file_name>");
					if (i == 0) {
						out.println(formatElement.convertElement("\t\t\t", "timestamp",
								tempDate + " " + formatTime.convertTime(formatCell.convert(row.getCell(4)))));
					} else {
						out.println(formatElement.convertElement("\t\t\t", "timestamp",
								tempDate + " " + formatTime.convertTime(formatCell.convert(row.getCell(5)))));
					}
					out.print("\t\t\t<latitude>");
					out.println("</latitude>");
					out.print("\t\t\t<longitude>");
					out.println("</longitude>");
					out.println("\t\t\t<metadata>");
					out.println(formatElement.convertElement("\t\t\t\t", "name", formatCell.convert(row.getCell(0))));
					out.println(formatElement.convertElement("\t\t\t\t", "emp_id", formatCell.convert(row.getCell(1))));
					out.print("\t\t\t\t<biometric_id>");
					out.println("</biometric_id>");
					out.print("\t\t\t\t<action_type>");
					if (i == 0) {
						out.print("0");
					} else {
						out.print("1");
					}
					out.println("</action_type>");
					out.print("\t\t\t\t<capture_type>");
					out.print("2");
					out.println("</capture_type>");
					out.println("\t\t\t</metadata>");
					out.println("\t\t</upload>");
				}
			}
			out.println("\t</Uploads>");
			out.println("</Root>");

			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}