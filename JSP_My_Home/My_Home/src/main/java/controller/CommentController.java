package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import service.CommentService;
import service.CommentServiceImpl;


@WebServlet("/cmt/*")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log=LoggerFactory.getLogger(CommentController.class);
    private RequestDispatcher rdp;
    private int isOk;
    private CommentService csv;
    private String UTF8="utf-8";

    public CommentController() {
        csv=new CommentServiceImpl();
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding(UTF8);
		res.setCharacterEncoding(UTF8);
		
		String uri=req.getRequestURI();
		String pathUri=uri.substring("/cmt/".length());
		String path=pathUri;
		String pathVar="";
		if(pathUri.contains("/")) {
			path=pathUri.substring(0,pathUri.lastIndexOf("/"));
			pathVar=pathUri.substring(pathUri.lastIndexOf("/")+1);
		}
		
		switch(path) {
		case "post":
			try {
				StringBuffer sb=new StringBuffer();
				String line=null;
				BufferedReader br=req.getReader();
				while((line=br.readLine())!=null) {
					sb.append(line);
				}
				
				JSONParser parser=new JSONParser();
				JSONObject jsonObj=(JSONObject) parser.parse(sb.toString());
				
				int bno=Integer.parseInt(jsonObj.get("bno").toString());
				String writer=jsonObj.get("writer").toString();
				String content=jsonObj.get("content").toString();
				isOk=csv.post(new CommentVO(bno, writer, content));
				log.info("댓글 등록 성공");
				
				PrintWriter out=res.getWriter();
				out.print(isOk);
			} catch (Exception e) {
				log.info("댓글 등록 실패");
				e.printStackTrace();
			}
			break;
			
		case "list":
			try {
				List<CommentVO> list=csv.getList(Integer.parseInt(pathVar));
				JSONObject jsonObj=new JSONObject();
				JSONArray jsonObjList=new JSONArray();
				
				for(int i=0;i<list.size();i++) {
					jsonObj=new JSONObject();
					jsonObj.put("cno", list.get(i).getCno());
					jsonObj.put("bno", list.get(i).getBno());
					jsonObj.put("writer", list.get(i).getWriter());
					jsonObj.put("content", list.get(i).getContent());
					jsonObj.put("reg_at", list.get(i).getReg_at());
					
					jsonObjList.add(jsonObj);
				}
				
				String jsonData=jsonObjList.toJSONString();
				
				PrintWriter out=res.getWriter();
				out.print(jsonData);
				log.info("댓글 리스트 성공");
			} catch (Exception e) {
				log.info("댓글 리스트 실패");
				e.printStackTrace();
			}
			break;
		case "remove":
			try {
				isOk=csv.remove(Integer.parseInt(pathVar));
				PrintWriter out=res.getWriter();
				out.print(isOk);
				log.info("댓글 삭제 성공");
			}catch (Exception e) {
				log.info("댓글 삭제 실패");
				e.printStackTrace();
			}
			break;
		case "modify":
			try {
				StringBuffer sb=new StringBuffer();
				String line=null;
				BufferedReader br=req.getReader();
				while((line=br.readLine())!=null) {
					sb.append(line);
				}
				
				JSONParser parser=new JSONParser();
				JSONObject jsonObj=(JSONObject) parser.parse(sb.toString());
				
				int cno=Integer.parseInt(jsonObj.get("cno").toString());
				String content=jsonObj.get("content").toString();
				isOk=csv.modify(new CommentVO(cno, content));
				
				PrintWriter out=res.getWriter();
				out.print(isOk);
				log.info("댓글 수정 성공");
			} catch (Exception e) {
				log.info("댓글 수정 실패");
				e.printStackTrace();
			}
			break;
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
