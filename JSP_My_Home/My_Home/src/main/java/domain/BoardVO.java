package domain;

public class BoardVO {
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String image_file;
	private String regdate;
	private int read_count;
	
	public BoardVO() {}
	
	//글등록: 제목, 작성자, 글, 이미지
	public BoardVO(String title, String writer, String content, String image_file) {
		this.title=title;
		this.writer=writer;
		this.content=content;
		this.image_file=image_file;
	}
	
	//글수정: 글번호, 제목, 글, 이미지
	public BoardVO(int bno, String title, String content, String image_file) {
		this.bno=bno;
		this.title=title;
		this.content=content;
		this.image_file=image_file;
	}
	
	//글목록: 글번호, 제목, 이미지, 작성일, 조회수
	public BoardVO(int bno, String title, String image_file, String regdate, int read_count) {
		this.bno=bno;
		this.title=title;
		this.image_file=image_file;
		this.regdate=regdate;
		this.read_count=read_count;
	}
	
	//글상세
	public BoardVO(int bno, String title, String writer, String content, String image_file, String regdate, int read_count) {
		this(bno, title, image_file, regdate, read_count);
		this.writer=writer;
		this.content=content;
	}
	
	//readcount
	public BoardVO(int bno, int read_count) {
		this.bno=bno;
		this.read_count=read_count;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage_file() {
		return image_file;
	}

	public void setImage_file(String image_file) {
		this.image_file = image_file;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getRead_count() {
		return read_count;
	}

	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	
	
}
