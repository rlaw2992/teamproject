package dip.clever.serviceImp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dip.clever.mapper.ReplyMapper;
import dip.clever.mapper.UserMapper;
import dip.clever.model.Reply;
import dip.clever.model.User;
import dip.clever.service.ReplyService;

@Service
public class ReplyServiceImp implements ReplyService {

	@Autowired
	private ReplyMapper replyMapper;

	@Override
	public List<Reply> findAll() {
		return replyMapper.findAll();
	}

	@Override
	public void insertReply(Reply reply) {
		replyMapper.insertReply(reply);
		
	}

	@Override
	public List<HashMap<String, Object>> joinUser(int bno) {
		return replyMapper.joinUser(bno);
	}
	
	@Override
	public void deleteReply(String id) {
		replyMapper.deleteReply(id);
		
	}

	@Override
	public void modifyReply(Reply reply) {
		replyMapper.modifyReply(reply);
	}

	@Override
	public Reply findReplyById(String id) {
		return replyMapper.findReplyById(id);		
	}

	@Override
	public List<HashMap<String, Object>> selectMyReply(String userId) {
		return replyMapper.selectMyReply(userId);
	}	
}
