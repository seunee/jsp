package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	List<MemberVO> selectList();

	int insert(MemberVO mvo);

	MemberVO selectOne(MemberVO mvo);

	int updateLogin(String email);

	MemberVO selectOne(String email);

	int updateInfo(MemberVO mvo);

	int delete(String email);

}
