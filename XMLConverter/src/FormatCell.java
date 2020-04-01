import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.*;

public class FormatCell {
	
	public String convert(Cell cell) {
		DecimalFormat df = new DecimalFormat("#####0");
		if (cell == null) {
			return null;
		}
		CellType type = cell.getCellType();
		if (type == CellType.STRING) {
			return cell.getStringCellValue();
		} else if (type == CellType.BLANK) {
			return null;
		} else if (type == CellType.ERROR) {
			return "*error*";
		} else if (type == CellType.NUMERIC) {
			return df.format(cell.getNumericCellValue());
		} else
			return "<unknown value>";
	}
}
