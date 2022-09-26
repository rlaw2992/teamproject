package dip.clever.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dip.clever.mapper.TestMapper;
import dip.clever.model.Category;
import dip.clever.model.Round;
import dip.clever.model.SearchCondition;
import dip.clever.model.Test;
import dip.clever.service.TestService;

@Service
public class TestServiceImp implements TestService{
	@Autowired
	private TestMapper testMapper;

	//카테고리의 시험 목록 반환
	@Override
	public List<Test> selectTestList(Category category) {
		return testMapper.selectTestList(category.getCategoryNo());		
	}

	@Override
	public Test selectTest(Test test) {
		return testMapper.selectTest(test.getTestNo());		
	}

	@Override
	public Test selectTest(Round round) {
		return testMapper.selectTestByRound(round.getRoundNo());
	}
	
	@Override
	public List getResultList(SearchCondition searchCondition, String query) {
		Map<String, String> searchConditionMap = new HashMap<>();

		searchConditionMap.put("searchCondition", searchCondition.toString());
		searchConditionMap.put("query", query);

		return testMapper.getResultList(searchConditionMap);
	}

	@Override
	public List<Test> selectTestRank() {
		return testMapper.selectTestRank();
	}
}