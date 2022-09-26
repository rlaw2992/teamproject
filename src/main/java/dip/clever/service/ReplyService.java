package dip.clever.service;

import java.util.HashMap;
import java.util.List;

import dip.clever.model.Reply;
import dip.clever.model.User;

public interface ReplyService {

	public List<Reply> findAll();

	// 회원가입
	public void insertReply(Reply reply);

	public Reply findReplyById(String id);
	
	// 유저삭제
	public void deleteReply(String id);
	
	// 댓글리스트 조회
	public List<HashMap<String, Object>> joinUser(int bno);
	
	// 댓글 수정
	public void modifyReply(Reply reply);
	
	public List<HashMap<String, Object>> selectMyReply(String userId);
}