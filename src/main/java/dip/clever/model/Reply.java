package dip.clever.model;

import java.util.Date;

import lombok.Data;

@Data
public class Reply {
	private int replyNo;
	private int questNo;
	private String regUser;
	private String content;
	private Date regTime;

}
