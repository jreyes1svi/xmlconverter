
public class FormatElement {
	public String convertElement(String prefix, String tag, String value) {
		StringBuilder xml = new StringBuilder(prefix);
		xml.append("<");
		xml.append(tag);
		if (value != null && value.length() > 0) {
			xml.append(">");
			// asddsa
			xml.append(value);
			xml.append("</");
			xml.append(tag);
			xml.append(">");
		} else {
			xml.append(">");
			xml.append("</");
			xml.append(tag);
			xml.append(">");
		}
		return xml.toString();
	}
}
