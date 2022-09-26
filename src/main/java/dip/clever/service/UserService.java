package dip.clever.service;

import java.util.List;

import dip.clever.model.User;

public interface UserService {
	// 아이디로 유저 찾기
	public boolean findUserId(User user);

	// 이름으로 유저 찾기
	public boolean findUserNickname(User user);

	// 메일로 유저 찾기
	public boolean findUserEmail(User user);
	// 회원가입
	public void insertUser(User user);

	// 회원조회
	public User selectUser(User user);

	// 유저리스트 반환
	public List<User> findAll();

	// 유저서치
	List<User> findSearchResult(String keyword);

	// 유저삭제
	public void deleteUser(String id);

	// 유저 > 매니저로 만들기
	public void updateManager(String id);

	// 매니저 >
	public void updateUser(String id);

	// ** mypage **
	// 아이디로 유저 찾기
	public User findUserById(String id);

	// 개인정보 수정
	// 이름 수정
	public void editUserName(User user);
	
	// 이메일 수정
	public void editUserEmail(User user);
	
	// 비밀번호 수정
	public void editUserPwd(User user);
	
	// 회원탈퇴
	public void deleteAccount(User user);
}
