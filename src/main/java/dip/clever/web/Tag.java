package dip.clever.web;

import java.lang.reflect.Field;

public abstract class Tag {
	public final String name;
	protected final String PRE_TAG;
	protected final String END_TAG;
	
	public static final String BR = "<br>";
	
	public Head head;
	public String body = "";
	
	public class Head {
		public String id;
		public String value;
		
		@Override
		public final String toString() {
			String str = "";		
			
			for(Field field: getClass().getFields()) {
				try {
					if (field.get(this) == null)	continue;				
					str += " " + field.getName() + "='" + field.get(this) + "'";				
				} catch (Exception e) {
				}			
			}
			return str;
		}
	}
	
	public Tag() {
		name = getClass().getSimpleName().toLowerCase();
		PRE_TAG = "<" + name + ">";
		END_TAG = "</" + name + ">";
		
		head = new Head();
	}	
	
	public final Tag append(Tag tag) {
		body += tag;
		
		return this;
	}
	
	public final Tag append(String text) {
		body += text;
		
		return this;
	}
	
	@Override
	public final String toString() {
		return PRE_TAG.replace(">", head + ">") + body + END_TAG;
	}
}