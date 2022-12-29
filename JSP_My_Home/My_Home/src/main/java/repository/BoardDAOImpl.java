package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import orm.DataBaseBuilder;
import service.BoardServiceImpl;

public class BoardDAOImpl implements BoardDAO {
	private static final Logger log=LoggerFactory.getLogger(BoardServiceImpl.class);
	private SqlSession sql;
	private String NS="BoardMapper.";
	
	public BoardDAOImpl() {
		new DataBaseBuilder();
		sql=DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public List<BoardVO> selectList() {
		log.info("방명록 다오 진입");
		return sql.selectList(NS+"list");
	}

	@Override
	public int insert(BoardVO bvo) {
		log.info("글쓰기 다오 진입");
		int isOk=sql.insert(NS+"reg", bvo);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public int updateRCount(int bno) {
		log.info("조회수 다오 진입");
		int isOk=sql.update(NS+"read", bno);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public BoardVO selectOne(int bno) {
		log.info("디테일 다오 진입");
		return sql.selectOne(NS+"detail", bno);
	}

	@Override
	public int update(BoardVO bvo) {
		log.info("수정 다오 진입");
		int isOk=sql.update(NS+"modify", bvo);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public int delete(int bno) {
		log.info("삭제 다오 진입");
		int isOk=sql.delete(NS+"remove", bno);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public List<BoardVO> selectList(String nick_name) {
		log.info("내 글 리스트 다오 진입");
		return sql.selectList(NS+"mylist", nick_name);
	}

	@Override
	public String selectFile(int bno) {
		log.info("파일이름 다오 진입");
		return sql.selectOne(NS+"file", bno);
	}

	@Override
	public int getPageCnt() {
		log.info("페이징 다오 진입");
		return sql.selectOne(NS+"pcnt");
	}

	@Override
	public List<BoardVO> selectList(PagingVO pgvo) {
		log.info("페이징 다오 진입");
		return sql.selectList(NS+"paging", pgvo);
	}
	

}
