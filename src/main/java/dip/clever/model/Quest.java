package dip.clever.model;


import lombok.Data;

@Data
public class Quest {
	private int questNo;
	private int roundNo;
	private int questSeq;
	private String questContent;
	private String answer;
	private String regUser;
	private Choice choice;
}
