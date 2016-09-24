package common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonMaps {

	/**
	 * 将json对象转换成Map
	 * 
	 * @param jsonObject
	 *            json对象
	 * @return Map对象
	 */
	public static Map<String, String> toMap(JSONObject jsonObject) {
		Map<String, String> result = new HashMap<String, String>();
		@SuppressWarnings("unchecked")
		Iterator<String> iterator = jsonObject.keys();
		String key = null;
		String value = null;
		while (iterator.hasNext()) {
			key = iterator.next();
			value = jsonObject.getString(key);
			result.put(key, value);
		}
		return result;
	}

	public static Map<String, Object> parseJSON2Map(String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		// �?��层解�?
		JSONObject json = JSONObject.fromObject(jsonStr);
		@SuppressWarnings("unused")
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			// 如果内层还是数组的话，继续解�?
			if (v instanceof JSONArray) {
				// List<Map<String, Object>> list = new
				// ArrayList<Map<String,Object>>();
				@SuppressWarnings("unchecked")
				Iterator<JSONObject> it = ((JSONArray) v).iterator();
				while (it.hasNext()) {
					JSONObject json2 = it.next();
					map.putAll(parseJSON2Map(json2.toString()));
					// list.add(parseJSON2Map(json2.toString()));
				}
				// map.put(k.toString(), list);
			} else {
				map.put(k.toString(), v);
			}
		}
		return map;
	}

	public static Map<String, String> parseJSON2Map2(String jsonStr) {
		Map<String, String> map = new HashMap<String, String>();
		// 
		JSONObject json = JSONObject.fromObject(jsonStr);
		@SuppressWarnings("unused")
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			// 如果内层还是数组的话，继续解�?
			if (v instanceof JSONArray) {
				// List<Map<String, Object>> list = new
				// ArrayList<Map<String,Object>>();
				@SuppressWarnings("unchecked")
				Iterator<JSONObject> it = ((JSONArray) v).iterator();
				while (it.hasNext()) {
					JSONObject json2 = it.next();
					map.putAll(parseJSON2Map2(json2.toString()));
					// list.add(parseJSON2Map(json2.toString()));
				}
				// map.put(k.toString(), list);
			} else {
				map.put(k.toString(), (String) v);
			}
		}
		return map;
	}

	// map转json
	@SuppressWarnings("static-access")
	public static JSONObject toJSON(Map<String, String> map) {
		return new JSONObject().fromObject(map);
	}

	// map转json
	@SuppressWarnings("static-access")
	public static JSONObject toJSONs(Map<String, Map<String, String>> map) {
		return new JSONObject().fromObject(map);
	}

	public static Map<String, Map<String, String>> parseTxtMap(String txtStr) {
		Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
		// String jsonStr=txtStr.substring(16, txtStr.length());
		JSONObject jsonObject = JSONObject.fromObject(txtStr); // 第一层json
		@SuppressWarnings("unchecked")
		Iterator<String> iterator = jsonObject.keys();
		String key = null;
		String value = null;
		while (iterator.hasNext()) {
			key = iterator.next();
			value = jsonObject.getString(key);
			map.put(key, parseJSON2Map2(value)); // �?层json
		}
		return map;
	}

	public static String asciiToString(String s) {// ASCII转换为字符串
		StringBuffer sbu = new StringBuffer();
		sbu.append((char) Integer.parseInt(String.valueOf(s)));
		System.out.println(sbu.toString());
		return sbu.toString();
	}

	public static String StringToAscii(String s) {// 字符串转换为ASCII
		char[] ss = s.toCharArray();
		StringBuffer sbu = new StringBuffer();
		for (int i = 0; i < ss.length; i++) {
			String aa = String.valueOf((int) ss[i]);
			sbu.append(aa);
		}

		System.out.println(sbu.toString());
		return sbu.toString();
	}

	public static Map<String, Map<String, String>> parseTxtMaps(String txtStr) {
		Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
		JSONObject jsonObject = JSONObject.fromObject(txtStr); // ��һ��json
		@SuppressWarnings("unchecked")
		Iterator<String> iterator = jsonObject.keys();
		String key = null;
		String value = null;
		while (iterator.hasNext()) {
			key = iterator.next();
			value = jsonObject.getString(key);
			map.put(key, parseJSON2Map2(value)); // �ڶ���json
		}
		Map<String, String> head = map.get("head");
		Map<String, String> txn = map.get("txn");
		head.put("txnType", txn.get("txnType"));
		txn.remove("txnType");
		// head.put("version", txn.get("version"));
		// txn.remove("version");
		// head.put("txnDate", txn.get("txnDate"));
		// txn.remove("txnDate");
		// head.put("txnTime", txn.get("txnTime"));
		// txn.remove("txnTime");
		// head.put("errCode", txn.get("errCode"));
		// txn.remove("errCode");
		// head.put("errDisp", txn.get("errDisp"));
		// txn.remove("errDisp");
		return map;
	}

	public static void StringToMap(String ss) {
		Map<String, String> map = new HashMap<String, String>();
		String length = ss.substring(0, 8);
		map.put("length", length);
		int len = Integer.valueOf(asciiToString(length));
		if (len == ss.length() - 8) {
			map.put("reqType", asciiToString(ss.substring(8, 9)));
			map.put("reqChannel", asciiToString(ss.substring(9, 25)));
			map.put("resChannel", asciiToString(ss.substring(25, 41)));
			map.put("messageType", asciiToString(ss.substring(41, 42)));
			map.put("mac", asciiToString(ss.substring(ss.length() - 8, ss.length())));

			@SuppressWarnings("unused")
			String jsonString = asciiToString(ss.substring(42, ss.length() - 8));

		}
	}

	// public static String asciiToStrings(String text) {
	// StringBuilder builder = new StringBuilder();
	// for (int i = 0; i < text.length(); i++) {
	// if (text.charAt(i) == '1' && i < text.length() - 2) {
	// int code = Integer.parseInt(text.substring(i, i + 3));
	// builder.append((char) code);
	// i += 2;
	// } else if (i < text.length() - 1) {
	// int code = Integer.parseInt(text.substring(i, i + 2));
	// builder.append((char) code);
	// i += 1;
	// }
	// }
	// System.out.println(builder.toString());
	// return builder.toString();
	// }
	public static void main(String[] args) {}

	/**
	 * 
	 * @Title: parseMapToJson
	 * @Description: 将Map转换为Json
	 * @author yang_df
	 * @since 2014年8月25日
	 * @param map
	 * @return
	 */
	public static String parseMapToJson(Map<String, Object> map) {
		String json = null;
		JSONObject jsonObject = JSONObject.fromObject(map);
		json = jsonObject.toString();
		return json;
	}
	
	// txn转map
	@SuppressWarnings("unchecked")
	public static List<Map<String, String>> parseTxnMap(String txtStr) {
		@SuppressWarnings("unused")
		Map<String, List<Map<String, String>>> map = new HashMap<String, List<Map<String, String>>>();
		// String jsonStr=txtStr.substring(16, txtStr.length());
		JSONObject jsonObject = JSONObject.fromObject(txtStr); //
		Iterator<String> iterator = jsonObject.keys();
		String key = null;
		@SuppressWarnings("unused")
		String value = null;
		@SuppressWarnings("rawtypes")
		List l = null;
		while (iterator.hasNext()) {
			key = iterator.next();
			value = jsonObject.getString(key);
			if (key.equals("txn")) {
				// map.put(key, jsontolist(jsonObject.getString(key)));
				l = jsontolist(jsonObject.getString(key));

			}

		}
		return l;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List jsontolist(String json) {
		// json="[{'name':'huangbiao','age':'15'},{'name':'liumei','age':'14'}]";
		JSONArray jsonarray = JSONArray.fromObject(json);
		// List list = (List)JSONArray.toList(jsonarray,Txn.class);
		List list2 = new ArrayList();

		Iterator it = jsonarray.iterator();
		while (it.hasNext()) {
			Map<String, Object> map = parseJSON2Map3(it.next().toString());
			list2.add(map);
		}
		// listtojson(list2);

		return list2;
	}
	
	public static Map<String, Object> parseJSON2Map3(String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject json = JSONObject.fromObject(jsonStr);
		@SuppressWarnings("unused")
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			if (v instanceof JSONArray) {
				// List<Map<String, Object>> list = new
				// ArrayList<Map<String,Object>>();
				@SuppressWarnings("unchecked")
				Iterator<JSONObject> it = ((JSONArray) v).iterator();
				while (it.hasNext()) {
					JSONObject json2 = it.next();
					if ((k.equals("array_txn"))) {

						map.put("array_txn", jsontolist(v.toString()));
					} else {
						map.putAll(parseJSON2Map2(json2.toString()));
					}

					// Map mapss = (Map) list2.get(0);
					// if(mapss.containsKey("array_txn")){
					// mapss.put("array_txn",
					// jsontolist(mapss.get("array_txn").toString()));
					// }

					// list.add(parseJSON2Map(json2.toString()));
				}
				// map.put(k.toString(), list);
			} else {
				map.put(k.toString(), v + "");
			}
		}
		return map;
	}
}
