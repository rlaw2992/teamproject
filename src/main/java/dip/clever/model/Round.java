package dip.clever.model;

import java.util.Date;

import lombok.Data;

@Data
public class Round {
	private int roundNo;
	private int testNo;
	private String regUser;
	private String roundName;
	private String testDate;
	private Date regTime;
}
