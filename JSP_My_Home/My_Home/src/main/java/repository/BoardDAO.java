package repository;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardDAO {

	List<BoardVO> selectList();

	int insert(BoardVO bvo);

	int updateRCount(int bno);

	BoardVO selectOne(int bno);

	int update(BoardVO bvo);

	int delete(int bno);

	List<BoardVO> selectList(String nick_name);

	String selectFile(int bno);

	int getPageCnt();

	List<BoardVO> selectList(PagingVO pgvo);

}
