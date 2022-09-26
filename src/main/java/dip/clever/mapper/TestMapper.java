package dip.clever.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import dip.clever.model.Category;
import dip.clever.model.SearchCondition;
import dip.clever.model.Test;

@Mapper
public interface TestMapper{	
	public List<Test> selectTestList(int categoryNo);
	
	public Test selectTest(int testNo);
	
	public Test selectTestByRound(int roundNo);
	
	public Category selectCategory(int categoryNo);
	
	public List getResultList(Map<String, String> searchCondition);
	
	public List<Test> selectTestRank();
}