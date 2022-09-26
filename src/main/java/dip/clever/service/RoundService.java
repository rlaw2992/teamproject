package dip.clever.service;

import java.util.List;

import dip.clever.model.Category;
import dip.clever.model.Round;
import dip.clever.model.Test;

public interface RoundService {	
	public List<Round> selectRoundList(Test test);
	
	public Round selectRound(Round round);
	
	public int selectLastInsert();
	
	// 회차등록
	public void insertRound(Round round);
	
	public List<Round> selectNewRound();
}
