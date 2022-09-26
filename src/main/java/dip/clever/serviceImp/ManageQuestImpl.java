package dip.clever.serviceImp;

import dip.clever.mapper.ManageQuestMapper;
import dip.clever.model.Choice;
import dip.clever.model.Quest;
import dip.clever.model.Test;
import dip.clever.model.Round;
import dip.clever.service.MangeQuestService;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageQuestImpl implements MangeQuestService {
	
	@Autowired
    ManageQuestMapper manageQuestMapper;

	// 문제정보입력
	@Override
	public void insertQuest(Quest quest) {
		manageQuestMapper.insertQuest(quest);
	}
	
	// 선지등록
	@Override
	public void insertChoice(Choice choice) {
		manageQuestMapper.insertChoice(choice);
	}
	
	// 선지번호 선택
	@Override
	public int selectQuestNo() {
		return manageQuestMapper.selectQuestNo();
	}

	
	
	// 회차선택
	@Override
	public Round selectRound(Round Round) {
		return manageQuestMapper.selectRound(Round);
	}
	
	
	// 문제정보수정
	@Override
	public void modifyQuest(long questNo, Quest quest) {
		// TODO Auto-generated method stub
		
	}
	// 문제정보삭제
	@Override
	public void deleteQuest(long questNo) {
		// TODO Auto-generated method stub
		
	}
	// 문제출력
	@Override
	public List<HashMap<String, Object>> joinQuest(int bno) {
		return manageQuestMapper.joinQuest(bno);
	}

}
