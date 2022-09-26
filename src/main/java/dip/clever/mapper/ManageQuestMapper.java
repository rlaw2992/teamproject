package dip.clever.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dip.clever.model.Choice;
import dip.clever.model.Quest;
import dip.clever.model.Round;
import dip.clever.model.Test;

@Mapper
public interface ManageQuestMapper {
	
    // 문제등록
    public void insertQuest(Quest quest);
    
    // 선지등록
    public void insertChoice(Choice choice);
    
    // 선지번호 선택
    public int selectQuestNo();
    
    // 회차선택
    public Round selectRound(Round Round);
    
    // 회차등록
    public void insertRound(Round round);
    
    // 시험선택
    public Test selectRound(Test test);
    
    // 문제출력
    public List<HashMap<String, Object>> joinQuest(int bno);
    
    // 문제수정
    public void modifyQuest(long questNo, Quest quest);
    
    // 문제삭제
    public void deleteQuest(long questNo);

}
