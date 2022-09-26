package dip.clever.model;

import lombok.Data;

@Data
public class Test {
	private int testNo;
	private int categoryNo;
	private String managerId;
	private String testName;
	private String testInfo;
	private int questCnt;
	private int passScore;
}
