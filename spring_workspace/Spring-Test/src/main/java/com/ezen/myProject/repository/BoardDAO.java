package com.ezen.myProject.repository;

import java.util.List;

import com.ezen.myProject.domain.BoardVO;
import com.ezen.myProject.domain.PagingVO;

public interface BoardDAO {

	int insertBoard(BoardVO bvo);

	List<BoardVO> selectBoardList();

	BoardVO selectBoardDetail(int bno);

	int updateReadCount(int bno);

	int updateBoard(BoardVO bvo);

	int deleteBoard(int bno);

	List<BoardVO> selectBoardListPaing(PagingVO pvo);

	int selectListCount();

	int selectSeachCount(PagingVO pgvo);

	int selectOneBno();

}
