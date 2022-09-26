package dip.clever.util;

public class String2 {
	private String string;
	private String json;
	
	public String2(String string) {
		this.string = string;
	}
	
	public String get() {
		return string;
	}
	
	public String2 remove(String s) {
		string = string.replace(s, "");
		
		return this;
	}
	
	public String2 removeLast() {
		string = string.substring(0, last());
		
		return this;
	}
	
	public String2 removefirst() {
		string = string.substring(1);
		
		return this;
	}
	
	public String2 removeSide() {
		string = string.substring(1, last());
		
		return this;
	}
	
	public String2 divide(int index) {
		String2 str = new String2(string.substring(0, index));
				
		string = index < string.length() ? string.substring(index + 1) : "";
		
		return str;
	}
	
	public String2[] split(String s) {
		String[] str = string.split(s);
		String2[] str2 = new String2[str.length];
		
		for(int a = 0; a < str.length; a++) {
			str2[a] = new String2(str[a]);
		}
		
		return str2;
	}
	
	public int find(String str) {
		return string.indexOf(str);		
	}
	
	public boolean isFirst(char c) {
		return string.length() != 0 && string.charAt(0) == c;
	}
	
	public boolean isLast(char c) {
		return string.charAt(string.length() - 1) == c;
	}
	
	@Override
	public String toString() {		
		return string;
	}
	
	@Override
	public boolean equals(Object obj) {
		//System.out.println(obj);
		return string.equals(obj);
	}
	
	private int last() {
		return string.length() - 1;
	}
}
