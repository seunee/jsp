package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	private static final Logger log=LoggerFactory.getLogger(MemberServiceImpl.class);
	private MemberDAO mdao;
	
	public MemberServiceImpl() {
		mdao=new MemberDAOImpl();
	}

	@Override
	public List<MemberVO> getList() {
		log.info("멤버 리스트 서비스");
		return mdao.selectList();
	}

	@Override
	public int register(MemberVO mvo) {
		log.info("회원가입 서비스");
		return mdao.insert(mvo);
	}

	@Override
	public MemberVO getDetail(MemberVO mvo) {
		log.info("로그인 서비스");
		return mdao.selectOne(mvo);
	}

	@Override
	public int lastLogin(String email) {
		log.info("마지막 로그인 시간 서비스");
		return mdao.updateLogin(email);
	}

	@Override
	public MemberVO getDetail(String email) {
		log.info("디테일 서비스");
		return mdao.selectOne(email);
	}

	@Override
	public int modify(MemberVO mvo) {
		log.info("정보수정 서비스");
		return mdao.updateInfo(mvo);
	}

	@Override
	public int remove(String email) {
		log.info("계정 삭제 서비스");
		return mdao.delete(email);
	}
}
