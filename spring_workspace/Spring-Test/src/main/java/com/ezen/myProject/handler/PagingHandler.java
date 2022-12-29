package com.ezen.myProject.handler;

import com.ezen.myProject.domain.PagingVO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PagingHandler {
	private int startPage; //현재 화면에서 보여줄 시작 페이지네이션 번호
	private int endPage;  //현재 화면에서 보여줄 마지막 페이지네이션 번호
	private boolean prev;
	private boolean next;
	//총 10개씩 보이도록
	// 1 2 3 4 5 6 7 8 9 10 next
	// prev 11 12 ... 20 next
	// prev 21 22
	private int totalCount; //전체 게시글 수
	private PagingVO pgvo;
	
	public PagingHandler(PagingVO pgvo, int totalCount) {
		this.pgvo=pgvo;
		this.totalCount=totalCount;
		this.endPage=(int)Math.ceil(pgvo.getPageNo()/(pgvo.getQty()*1.0))*pgvo.getQty();
		// -> pageNo이 1~10일때: endPage=10
		this.startPage=endPage-9;
		int realEndPage=(int)Math.ceil(totalCount/(pgvo.getQty()*1.0));
		if(realEndPage<this.endPage) {
			this.endPage=realEndPage;
		}
		this.prev=this.startPage>1;
		this.next=this.endPage<realEndPage;
	}
}
