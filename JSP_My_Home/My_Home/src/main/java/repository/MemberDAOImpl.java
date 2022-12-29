package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DataBaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	private static final Logger log=LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	private final String NS="MemberMapper.";
	
	public MemberDAOImpl() {
		new DataBaseBuilder();
		sql=DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public List<MemberVO> selectList() {
		log.info("멤버 리스트 다오 진입");
		return sql.selectList(NS+"list");
	}

	@Override
	public int insert(MemberVO mvo) {
		log.info("회원가입 다오 진입");
		int isOk=sql.insert(NS+"reg", mvo);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public MemberVO selectOne(MemberVO mvo) {
		log.info("로그인 다오 진입");
		return sql.selectOne(NS+"login", mvo);
	}

	@Override
	public int updateLogin(String email) {
		log.info("로그인 시간 다오 진입");
		int isOk=sql.update(NS+"last", email);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public MemberVO selectOne(String email) {
		log.info("디테일 다오 진입");
		return sql.selectOne(NS+"detail", email);
	}

	@Override
	public int updateInfo(MemberVO mvo) {
		log.info("정보수정 다오 진입");
		int isOk=sql.update(NS+"info", mvo);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public int delete(String email) {
		log.info("계정삭제 다오 진입");
		int isOk=sql.delete(NS+"remove", email);
		if(isOk>0) sql.commit();
		return isOk;
	}
}
