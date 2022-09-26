package dip.clever.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dip.clever.model.Reply;
import dip.clever.model.User;

@Mapper
public interface ReplyMapper {

	// 전체 데이터 가져오기
	public List<Reply> findAll();

	// 댓글등록
	public void insertReply(Reply reply);
	
	//아이디로 댓글찾기
	public Reply findReplyById(String replyNo);
	
	public void deleteReply(String id);

	// 댓글리스트 출력
	public List<HashMap<String, Object>> joinUser(int bno);
	
	// 댓글 수정
	public void modifyReply(Reply reply);
	
	public List<HashMap<String, Object>> selectMyReply(String userId);
}
