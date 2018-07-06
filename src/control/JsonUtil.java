package control;

import java.util.Vector;

public class JsonUtil {

	private Vector<String> keys;
	private Vector<String> values;

	public JsonUtil() {
		keys = new Vector<String>();
		values = new Vector<String>();

	}

	public void put(String key, String v) {
		keys.add(key);
		values.add(v);
	}

	public String toString() {
		if(keys.isEmpty()) {
			return "{}";
		}
		String str = "[{";
		
		for (int i = 0; i < keys.size(); i++) {

			if (i > 0) {
				str += ",";
			}

			str += "\"" + keys.get(i) + "\"" + ":" + "\"" + values.get(i) + "\"";

		}
		str += "}]";

		return str;
	}

}
