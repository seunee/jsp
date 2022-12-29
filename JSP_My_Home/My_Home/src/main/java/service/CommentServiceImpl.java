package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import repository.CommentDAO;
import repository.CommentDAOImpl;

public class CommentServiceImpl implements CommentService {
	private static final Logger log=LoggerFactory.getLogger(CommentServiceImpl.class);
	private CommentDAO cdao;
	
	public CommentServiceImpl() {
		cdao=new CommentDAOImpl();
	}

	@Override
	public int post(CommentVO cvo) {
		log.info("댓글 등록 서비스");
		return cdao.insert(cvo);
	}

	@Override
	public List<CommentVO> getList(int bno) {
		log.info("댓글 리스트 서비스");
		return cdao.selectList(bno);
	}

	@Override
	public int remove(int cno) {
		log.info("댓글 삭제 서비스");
		return cdao.delete(cno);
	}

	@Override
	public int modify(CommentVO cvo) {
		log.info("댓글 수정 서비스");
		return cdao.update(cvo);
	}
}
