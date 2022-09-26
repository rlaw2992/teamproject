package dip.clever.service;

import java.util.List;
import java.util.Map;

import dip.clever.model.Choice;
import dip.clever.model.Quest;
import dip.clever.model.Round;
import dip.clever.model.User;

public interface QuestService {
	public List<Quest> selectQuestList(Round round);	

	public List<Map<String, Object>> selectSolvedList (User user);
	
	public List<Map<String, Object>> selectUploadList(User user);
	
	public Quest selectQuest(Quest quest);
	
	public Choice selectChoice(Quest quest);
	
	public Map<String, Object> selectQuestInfo(Quest quest);
	
	public Integer selectNextQuest(Quest quest);
	
	public Integer[] checkAnswer(List<Map<String, Object>> answerList);
}
