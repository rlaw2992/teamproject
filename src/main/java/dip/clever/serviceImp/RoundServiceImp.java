package dip.clever.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dip.clever.mapper.RoundMapper;
import dip.clever.mapper.TestMapper;
import dip.clever.model.Category;
import dip.clever.model.Round;
import dip.clever.model.Test;
import dip.clever.service.RoundService;

@Service
public class RoundServiceImp implements RoundService{
	@Autowired
	private RoundMapper roundMapper;

	// 시험의 회차 목록 반환
	@Override
	public List<Round> selectRoundList(Test test) {
		return roundMapper.selectRoundList(test.getTestNo());			
	}
	
	@Override
	public Round selectRound(Round round) {
		return roundMapper.selectRound(round.getRoundNo());
	}
	
	public int selectLastInsert() {
		return roundMapper.selectLastInsert();
	}
	
	// 회차등록
	@Override
	public void insertRound(Round round) {
		roundMapper.insertRound(round);
	}

	@Override
	public List<Round> selectNewRound() {
		return roundMapper.selectNewRound();
	}
}