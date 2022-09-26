package dip.clever.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dip.clever.mapper.UserMapper;
import dip.clever.model.User;
import dip.clever.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

  // ** 로그인/회원가입 ** 
	// 회원가입
	@Override
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	// 회원조회
	@Override
	public User selectUser(User user) {
		return userMapper.selectUser(user);
	}

	// 아이디 중복 체크
	@Override
	public boolean findUserId(User user) {
		return userMapper.findUserId(user.getUserId()) != null;
	}

	// 닉네임 중복 체크
	@Override
	public boolean findUserNickname(User user) {
		return userMapper.findUserNickname(user.getUserNickname()) != null;
	}

	@Override
	public boolean findUserEmail(User user) {
		return userMapper.findUserEmail(user.getUserEmail()) != null;
	}

  // ** 유저 관리 ** 
  //
	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}
	
  //
	@Override
	public List<User> findSearchResult(String keyword) {
 		return userMapper.findSearchResult(keyword);
	}

	//유저삭제
	@Override
	public void deleteUser(String id) {
		userMapper.deleteUser(id);
		
	}
	//매니저 등급주기
	@Override
	public void updateManager(String id) {
		userMapper.updateManager(id);
		
	}
	//유저로 강등
	@Override
	public void updateUser(String id) {
		userMapper.updateUser(id);
		
	}
	
  // ** 마이페이지 ** 
	// 아이디로 유저 찾기
	@Override
	public User findUserById(String userId) {
		return userMapper.findUserById(userId);
	}

  // 이름 수정
	@Override
	public void editUserName(User user) {
		userMapper.editUserName(user);
	}

	// 이메일 수정
	@Override
	public void editUserEmail(User user) {
		userMapper.editUserEmail(user);
	}
	
	// 비밀번호 수정
	@Override
	public void editUserPwd(User user) {
		userMapper.editUserPwd(user);
	}
	
	// 회원 탈퇴
	@Override
	public void deleteAccount(User user) {
		userMapper.deleteAccount(user);
	}


}
