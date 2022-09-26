package dip.clever.model;

public enum SearchCondition {
	//상수("연관시킬 문자")
	ALL("전체"),
	CATEGORY("카테고리"),
	TEST("시험"),
	ROUND("회차");
	
	final public String name;
	
	private SearchCondition(String name) {
		this.name = name;
	}
	
	public String getName() { 
		return name; 
	}
}
