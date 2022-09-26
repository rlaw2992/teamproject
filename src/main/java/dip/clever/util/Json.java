package dip.clever.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import dip.clever.mapper.QuestMapper;
import dip.clever.model.Choice;
import dip.clever.model.Quest;
import dip.clever.serviceImp.QuestServiceImp;

public class Json {
	// JSON.stringify로 받은 문자열 데이터를 해시맵 리스트로 변환
	public static List<Map<String, Object>> parse(String data){
		List<Map<String, Object>> jsonList = new ArrayList<>();
		String2 dat = new String2(data);
		String2 json;
		
		
		if(isList(dat))	dat.removeSide();		

		while(isJson(dat)) {
			json = getJson(dat);
//			System.out.println("json: " + json);
//			System.out.println("data: " + dat);
			
			if(json == null)	break;
			
			jsonList.add(parse(json));
		}		
		
		return jsonList;
	}
	
	// 한 개의 JSON 문자열 데이터를 해시맵으로 변환
	private static Map<String, Object> parse(String2 data){
		Map<String, Object> json = new HashMap<>();
		String key;
		Object value = null;

		data.removeSide();
		while(true) {
			key = getKey(data);
			
			if(key == null)		break;
			if(isJson(data))	value = parse(getJson(data));
			else 				value = getValue(data);
			
			json.put(key, value);
		}
		return json; 
	}
	
	private static String2 getJson(String2 data) {
		final int index = data.find("},");

		if (index == -1)	return data;
		return data.divide(index + 1);
	}

	private static String getKey(String2 data) {
		final int index = data.find(":");
		String2 key;

		if (index == -1)	return null;
		
		key = data.divide(index).removeSide();

		return key.get();
	}
	
	private static Object getValue(String2 data) {
		final int index = data.find(",");
		String2 dat;
		
		if(isString(data))		return getString(data);
		
		if(index >= 0)	dat = data.divide(index);
		else			dat = data;
		
		if(dat.equals("null"))	return null;		
		
		return getInt(dat);
	}

	private static String getString(String2 string) {
		final int index = string.removefirst().find("\"");
		return string.divide(index + 1).removeLast().get();
	}
	
	private static int getInt(String2 number) {
		return Integer.parseInt(number.get());
	}
	
	private static boolean isList(String2 data) {
		return data.isFirst('[');
	}

	private static boolean isJson(String2 data) {
		return data.isFirst('{');
	}
	
	private static boolean isString(String2 data) {
		//System.out.println(data);
		return data.isFirst('"');
	}
	
	public static void main(String[] args) {
		final String str = "[{\"questNo\":90,\"roundNo\":0,\"questSeq\":1,\"questContent\":\"문제입니다.\",\"answer\":null,\"regUser\":null,\"choice\":{\"questNo\":0,\"c1\":\"1\",\"c2\":\"2\",\"c3\":\"3\",\"c4\":\"4\",\"c5\":\"5\"}}]";
		
		System.out.println(parse(str));
	}
}
