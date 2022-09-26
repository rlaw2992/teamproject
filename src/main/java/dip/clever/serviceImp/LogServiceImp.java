package dip.clever.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dip.clever.mapper.LogMapper;
import dip.clever.model.Log;
import dip.clever.service.LogService;

@Service
public class LogServiceImp implements LogService{
	@Autowired
	private LogMapper logMapper;
	
	@Override
	public void insertLog(Log log) {
		logMapper.insertLog(log);
	}
}
