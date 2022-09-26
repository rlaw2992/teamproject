package dip.clever.service;

import java.util.HashMap;
import java.util.List;

import dip.clever.model.Choice;
import dip.clever.model.Quest;
import dip.clever.model.Round;

public interface MangeQuestService {
	
    // 문제등록
    public void insertQuest(Quest quest);
    
    // 선지등록
    public void insertChoice(Choice choice);
    
    // 선지번호 선택
    public int selectQuestNo();
    
    // 회차선택
    public Round selectRound(Round Round);
    
    // 문제수정
    public void modifyQuest(long questNo, Quest quest);
    
    // 문제삭제
    public void deleteQuest(long questNo);
    
    // 문제출력
    public List<HashMap<String, Object>> joinQuest(int bno);

}
