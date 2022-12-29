package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import orm.DataBaseBuilder;

public class CommentDAOImpl implements CommentDAO {
	private static final Logger log=LoggerFactory.getLogger(CommentDAOImpl.class);
	private SqlSession sql;
	private final String NS="CommentMapper.";
	private int isOk;
	
	public CommentDAOImpl() {
		new DataBaseBuilder();
		sql=DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(CommentVO cvo) {
		log.info("댓글 등록 다오");
		isOk=sql.insert(NS+"reg", cvo);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public List<CommentVO> selectList(int bno) {
		log.info("댓글 리스트 다오");
		return sql.selectList(NS+"list", bno);
	}

	@Override
	public int delete(int cno) {
		log.info("댓글 삭제 다오");
		isOk=sql.delete(NS+"remove", cno);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public int update(CommentVO cvo) {
		log.info("댓글 수정 다오");
		isOk=sql.update(NS+"mod", cvo);
		if(isOk>0) sql.commit();
		return isOk;
	}
}
