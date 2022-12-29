package com.ezen.myProject.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PagingVO {
	private int pageNo; //현재 화면에 출력된 페이지 번호
	private int qty; //한 페이지당 보여줄 게시글 수
	
	private String type;
	private String keyword;
	
	public PagingVO() {
		this(1,10);
	}
	
	public PagingVO(int pageNo, int qty) {
		this.pageNo=pageNo;
		this.qty=qty;
	}
	
	public int getPageStart() {	//DB에서 가져와야하는 시작 행 구하는 메서드
		return (this.pageNo -1)*qty;	//DB에서 limit으로 값 가져올 때 첫 시작 값이 0이므로 -1
	}
	
	public String[] getTypeToArray() {
		return this.type == null ? new String[]{} : this.type.split("");
	}
}
