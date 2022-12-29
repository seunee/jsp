package service;

import java.util.List;

import domain.MemberVO;

public interface MemberService {

	List<MemberVO> getList();

	int register(MemberVO mvo);

	MemberVO getDetail(MemberVO mvo);

	int lastLogin(String email);

	MemberVO getDetail(String email);

	int modify(MemberVO mvo);

	int remove(String email);

}
