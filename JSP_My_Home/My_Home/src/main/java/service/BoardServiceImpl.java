package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	private static final Logger log=LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao=new BoardDAOImpl();
	}

	@Override
	public List<BoardVO> getList() {
		log.info("방명록 서비스 진입");
		return bdao.selectList();
	}

	@Override
	public int register(BoardVO bvo) {
		log.info("글쓰기 서비스 진입");
		return bdao.insert(bvo);
	}

	@Override
	public int readCount(int bno) {
		log.info("조회수 서비스 진입");
		return bdao.updateRCount(bno);
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info("디테일 서비스 진입");
		return bdao.selectOne(bno);
	}

	@Override
	public int modify(BoardVO bvo) {
		log.info("수정 서비스 진입");
		return bdao.update(bvo);
	}

	@Override
	public int delete(int bno) {
		log.info("삭제 서비스 진입");
		return bdao.delete(bno);
	}

	@Override
	public List<BoardVO> getList(String nick_name) {
		log.info("내 글 리스트 서비스 진입");
		return bdao.selectList(nick_name);
	}

	@Override
	public String getFileName(int bno) {
		log.info("파일이미지 삭제 서비스 진입");
		return bdao.selectFile(bno);
	}

	@Override
	public int getPageCnt() {
		log.info("페이징 서비스 진입");
		return bdao.getPageCnt();
	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		log.info("페이징 서비스 진입");
		return bdao.selectList(pgvo);
	}
}
