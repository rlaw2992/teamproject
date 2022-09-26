package dip.clever.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import dip.clever.service.LogService;
import dip.clever.serviceImp.LogServiceImp;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Log {	
	private String userId;
	private Action action;
	private Integer targetId;
}
