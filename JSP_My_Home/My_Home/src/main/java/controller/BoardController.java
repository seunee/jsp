package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.MemberVO;
import domain.PagingVO;
import handler.FileHandler;
import handler.PagingHandler;
import net.coobird.thumbnailator.Thumbnails;
import service.BoardService;
import service.BoardServiceImpl;


@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log=LoggerFactory.getLogger(BoardController.class);
	private RequestDispatcher rdp;
	private String destPage;
	private int isOk;
	private BoardService bsv;
	private String savePath;
	private final String UTF8="utf-8";
       
  
    public BoardController() {
        bsv=new BoardServiceImpl();
    }

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding(UTF8);
		res.setCharacterEncoding(UTF8);
		res.setContentType("text/html; charset=UTF-8");
		
		String uri=req.getRequestURI();
		String path=uri.substring(uri.lastIndexOf("/")+1);
		
		switch(path) {
			case "guest":
				try {
					List<BoardVO> list=bsv.getList();
					log.info("방명록 리스트 불러오기 성공");
					req.setAttribute("list", list);
					destPage="/board/guestList.jsp";
					log.info("방명록 페이지로 이동");
				} catch (Exception e) {
					log.info("방명록 이동 실패");
					e.printStackTrace();
				}
				break;
			case "write":
				try {
					HttpSession ses=req.getSession();
					MemberVO mvo=(MemberVO) ses.getAttribute("ses");
					req.setAttribute("ses", mvo);
					log.info("글쓰기 페이지 이동");
					destPage="/board/register.jsp";
				} catch (Exception e) {
					log.info("글쓰기 페이지 이동 실패");
					e.printStackTrace();
				}
				break;
			case "register":
				try {
//					BoardVO bvo=new BoardVO(req.getParameter("title"), req.getParameter("writer"), req.getParameter("content"), req.getParameter("image_file"));
//					isOk=bsv.register(bvo);
//					log.info(isOk>0?"글쓰기 성공":"글쓰기 실패");
					savePath=getServletContext().getRealPath("/file_uploaded");
					
					File fileDir=new File(savePath);
					
					DiskFileItemFactory fileItemFactory=new DiskFileItemFactory();
					fileItemFactory.setRepository(fileDir);
					fileItemFactory.setSizeThreshold(2*1024*1024);
					
					BoardVO bvo=new BoardVO();
					
					ServletFileUpload fileUpload=new ServletFileUpload(fileItemFactory);
					
					List<FileItem> itemList=fileUpload.parseRequest(req);
					for(FileItem item:itemList) {
						switch(item.getFieldName()) {
						case "title":
							bvo.setTitle(item.getString(UTF8));
							break;
						case "writer":
							bvo.setWriter(item.getString(UTF8));
							break;
						case "content":
							bvo.setContent(item.getString(UTF8));
							break;
						case "image_file":
							if(item.getSize()>0) {
								String fileName=item.getName().substring(item.getName().lastIndexOf("/")+1);
								fileName=System.currentTimeMillis()+"_"+fileName;
								File UploadFilePath=new File(fileDir+File.separator+fileName);
								
								try {
									item.write(UploadFilePath);
									bvo.setImage_file(fileName);
									
									Thumbnails.of(UploadFilePath).size(60, 60).toFile(new File(fileDir+File.separator+"th_"+fileName));
									log.info("파일 업로드 성공");
								} catch (Exception e) {
									log.info("파일 업로드 실패");
									e.printStackTrace();
								}
							}
							break;
						}
					}
					isOk=bsv.register(bvo);
					destPage="/brd/guest";
				} catch (Exception e) {
					log.info("글쓰기 실패");
					e.printStackTrace();
				}
				break;
			case "detail":
				try {
					int bno=Integer.parseInt(req.getParameter("bno"));
					isOk=bsv.readCount(bno);
					log.info("조회수 업데이트 성공");
					BoardVO bvo=bsv.getDetail(bno);
					req.setAttribute("bvo", bvo);
					destPage="/board/detail.jsp";
				} catch (Exception e) {
					log.info("디테일 실패");
					e.printStackTrace();
				}
				break;
			case "edit":
				try {
					BoardVO bvo=bsv.getDetail(Integer.parseInt(req.getParameter("bno")));
					req.setAttribute("bvo", bvo);
					log.info("수정 페이지 이동");
					destPage="/board/modify.jsp";
				} catch (Exception e) {
					log.info("수정 페이지 이동 실패");
					e.printStackTrace();
				}
				break;
			case "modify":
				try {
//					BoardVO bvo=new BoardVO(Integer.parseInt(req.getParameter("bno")), req.getParameter("title"), req.getParameter("content"), req.getParameter("image_file"));
//					isOk=bsv.modify(bvo);
//					log.info("수정 성공");
					savePath=getServletContext().getRealPath("/file_upload");
					File fileDir=new File(savePath);
					
					DiskFileItemFactory fileItemFactory=new DiskFileItemFactory();
					fileItemFactory.setRepository(fileDir);
					fileItemFactory.setSizeThreshold(2*1024*1024);
					
					BoardVO bvo=new BoardVO();
					
					ServletFileUpload fileUpload=new ServletFileUpload(fileItemFactory);
					
					List<FileItem> itemList=fileUpload.parseRequest(req);
					
					String old_file=null;
					
					for(FileItem item:itemList) {
						switch(item.getFieldName()) {
						case "bno":
							bvo.setBno(Integer.parseInt(item.getString(UTF8)));
							break;
						case "title":
							bvo.setTitle(item.getString(UTF8));
							break;
						case "content":
							bvo.setContent(item.getString(UTF8));
							break;
						case "image_file":
							old_file=item.getString(UTF8);
							break;
						case "new_file":
							if(item.getSize()>0) {
								if(old_file!=null) {
									FileHandler fileHandler=new FileHandler();
									isOk=fileHandler.deleteFile(old_file, savePath);
								}
								String fileName=item.getName().substring(item.getName().lastIndexOf("/")+1);
								fileName=System.currentTimeMillis()+"_"+fileName;
								File UploadFilePath=new File(fileDir+File.separator+fileName);
								
								try {
									item.write(UploadFilePath);
									bvo.setImage_file(fileName);
									
									Thumbnails.of(UploadFilePath).size(60, 60).toFile(new File(fileDir+File.separator+"th_"+fileName));
									log.info("이미지 수정 성공");
								} catch (Exception e) {
									log.info("이미지 수정 실패");
									e.printStackTrace();
								}
							}else {
								bvo.setImage_file(old_file);
							}
							break;
						}
					}
					isOk=bsv.modify(bvo);
					destPage="/brd/guest";
				} catch (Exception e) {
					log.info("수정 실패");
					e.printStackTrace();
				}
				break;
			case "delete":
				try {
					int bno=Integer.parseInt(req.getParameter("bno"));
					String imageFileName=bsv.getFileName(bno);
					
					FileHandler fileHandler = new FileHandler();
					savePath=getServletContext().getRealPath("/file_upload");
					isOk=fileHandler.deleteFile(imageFileName, savePath);
					
					isOk=bsv.delete(bno);
					log.info("삭제 성공");
					destPage="/brd/guest";
				} catch (Exception e) {
					log.info("삭제 실패");
					e.printStackTrace();
				}
				break;
			case "myList":
				try {
					HttpSession ses=req.getSession();
					MemberVO mvo=(MemberVO)ses.getAttribute("ses");
					String nick_name=mvo.getNick_name();
					List<BoardVO> list=bsv.getList(nick_name);
					
					req.setAttribute("list", list);
					log.info("내 글 리스트 성공");
					destPage="/board/guestList.jsp";
				} catch (Exception e) {
					log.info("내 글 리스트 실패");
					e.printStackTrace();
				}
				break;
			case "pageList":
				try {
					PagingVO pgvo=new PagingVO();
					int totalCount=bsv.getPageCnt();
					List<BoardVO> list=bsv.getList(pgvo);
					PagingHandler pgh=new PagingHandler(pgvo, totalCount);
					req.setAttribute("list", list);
					req.setAttribute("pgh", pgh);
					log.info("페이징 리스트 성공");
					destPage="/board/guestList.jsp";
				} catch (Exception e) {
					log.info("페이징 리스트 실패");
					e.printStackTrace();
				}
				break;
			case "page":
				try {
					int pageNo=Integer.parseInt(req.getParameter("pageNo"));
					int qty=Integer.parseInt(req.getParameter("qty"));
					
					PagingVO pgvo=new PagingVO(pageNo, qty);
					int totalCount=bsv.getPageCnt();
					List<BoardVO> list=bsv.getList(pgvo);
					PagingHandler pgh=new PagingHandler(pgvo, totalCount);
					req.setAttribute("list", list);
					req.setAttribute("pgh", pgh);
					log.info("페이지 성공");
					destPage="/board/guestList.jsp";
				} catch (Exception e) {
					log.info("페이지 실패");
					e.printStackTrace();
				}
				break;
			
		}
		
		rdp=req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
