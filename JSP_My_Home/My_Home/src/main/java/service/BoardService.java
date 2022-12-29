package service;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardService {

	List<BoardVO> getList();

	int register(BoardVO bvo);

	int readCount(int bno);

	BoardVO getDetail(int bno);

	int modify(BoardVO bvo);

	int delete(int bno);

	List<BoardVO> getList(String nick_name);

	String getFileName(int bno);

	int getPageCnt();

	List<BoardVO> getList(PagingVO pgvo);

}
