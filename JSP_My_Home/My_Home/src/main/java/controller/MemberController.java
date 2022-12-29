package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;


@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log=LoggerFactory.getLogger(MemberController.class);
	private final String UTF8="utf-8";
	private RequestDispatcher rdp;
	private String destPage;
	private int isOk;
	private MemberService msv;
   
    public MemberController() {
        msv=new MemberServiceImpl();
    }

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding(UTF8);
		res.setCharacterEncoding(UTF8);
		res.setContentType("text/html; charset=UTF-8");
		
		String uri=req.getRequestURI();
		String path=uri.substring(uri.lastIndexOf("/")+1);
		
		switch(path) {
		case "join":
			destPage="/member/register.jsp";
			log.info("회원가입 페이지 이동");
			break;
		case "register":
			try {
				String email=req.getParameter("email");
				String pwd=req.getParameter("pwd");
				String nick_name=req.getParameter("nick_name");
				List<MemberVO> list=msv.getList();
				if(list.size()==0) {
					isOk=msv.register(new MemberVO(email, pwd, nick_name));
					log.info("회원가입 성공");
					destPage="/";
				}else {
					for(int i=0;i<list.size();i++) {
						if(list.get(i).getEmail().equals(email)) {
							req.setAttribute("msg_reg", 0);
							destPage="/member/register.jsp";
							break;
						}else if(list.get(i).getNick_name().equals(nick_name)) {
							req.setAttribute("msg_reg", 1);
							destPage="/member/register.jsp";
							break;
						}else {
							isOk=msv.register(new MemberVO(email, pwd, nick_name));
							log.info("회원가입 성공");
							destPage="/";
						}
					}
				}
			} catch (Exception e) {
				log.info("회원가입 실패");
				e.printStackTrace();
			}
			break;
		case "signin":
			log.info("로그인 페이지 이동");
			destPage="/member/login.jsp";
			break;
		case "login":
			try {
				MemberVO mvo=msv.getDetail(new MemberVO(req.getParameter("email"), req.getParameter("pwd")));
				if(mvo!=null) {
					HttpSession ses=req.getSession();
					ses.setAttribute("ses", mvo);
					ses.setMaxInactiveInterval(10*60);
					log.info("로그인 성공");
					String email=mvo.getEmail();
					log.info("마지막 로그인 시간 업데이트");
					isOk=msv.lastLogin(email);
					destPage="/";
				}else {
					req.setAttribute("msg_login", 0);
					destPage="/member/login.jsp";
				}
			} catch (Exception e) {
				log.info("로그인 실패");
				e.printStackTrace();
			}
			break;
		case "logout":
			try {
				HttpSession ses=req.getSession();
				MemberVO mvo=(MemberVO) ses.getAttribute("ses");
				String email=mvo.getEmail();
				ses.invalidate();
				log.info("로그아웃 성공");
				destPage="/";
			} catch (Exception e) {
				log.info("로그아웃 실패");
				e.printStackTrace();
			}
			break;
		case "list":
			try {
				List<MemberVO> list=msv.getList();
				req.setAttribute("list", list);
				log.info("회원 리스트 성공");
				destPage="/member/list.jsp";
			} catch (Exception e) {
				log.info("회원 리스트 실패");
				e.printStackTrace();
			}
			break;
		case "edit":
			try {
				String email=req.getParameter("email");
				MemberVO mvo=msv.getDetail(email);
				req.setAttribute("mvo", mvo);
				log.info("멤버 디테일 성공");
				destPage="/member/modify.jsp";
			} catch (Exception e) {
				log.info("멤버 디테일 실패");
				e.printStackTrace();
			}
			break;
		case "modify":
			try {
				MemberVO mvo=new MemberVO(req.getParameter("email"), req.getParameter("pwd"), req.getParameter("nick_name"), req.getParameter("reg_at"), req.getParameter("last_login"));
				isOk=msv.modify(mvo);
				log.info("정보 수정 성공");
				if(isOk>0) {
					HttpSession ses=req.getSession();
					ses.setAttribute("ses", mvo);
					ses.setMaxInactiveInterval(10*60);
				}
				destPage="/";
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case "remove":
			try {
				isOk=msv.remove(req.getParameter("email"));
				log.info("계정 삭제 성공");
				HttpSession ses=req.getSession();
				ses.invalidate();
				destPage="/";
			} catch (Exception e) {
				log.info("계정 삭제 실패");
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
