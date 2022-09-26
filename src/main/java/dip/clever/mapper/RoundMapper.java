package dip.clever.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import dip.clever.model.Category;
import dip.clever.model.Round;

@Mapper
public interface RoundMapper{	
	public List<Round> selectRoundList(int testNo);
	
	public Round selectRound(int roundNo);
	
	public int selectLastInsert();
	
	// 회차등록
	public void insertRound(Round round);
	
	public List<Round> selectNewRound();
}