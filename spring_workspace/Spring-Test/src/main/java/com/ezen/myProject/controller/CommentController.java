package com.ezen.myProject.controller;

import java.util.List;

import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.myProject.domain.CommentVO;
import com.ezen.myProject.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/cmt/*")
@Controller
public class CommentController {
	
	@Inject
	private CommentService csv;
	
	
	//value: mapping값 설정
	//consumes: 가져오는 값의 형태(application/json 형태)
	//produces: 보낼 때의 형식{MediaType.text_plain_value}
	@PostMapping(value="/post", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> post(@RequestBody CommentVO cvo){
		//아까 보낸 것의 body를 cvo 형태로 받아옴
		log.info(">>>comment post: "+cvo.toString());
		int isOk=csv.register(cvo);
		log.info(">>>comment register: "+(isOk>0?"성공":"실패"));
		
		return isOk>0? new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/{bno}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<CommentVO>> spread(@PathVariable("bno")int bno){
		log.info(">>>comment List: "+bno);
		List<CommentVO> list=csv.getList(bno);
		return new ResponseEntity<List<CommentVO>>(list, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{cno}", consumes = "application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> edit(@PathVariable("cno")int cno, @RequestBody CommentVO cvo){
		log.info(">>>comment modify: "+cno);
		log.info(">>>comment modify: "+cvo.toString());
		int isOk=csv.modify(cvo);
		return isOk>0? new ResponseEntity<String>("1", HttpStatus.OK): new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value="/{cno}", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> delete(@PathVariable("cno")int cno){
		log.info(">>>comment delete: "+cno);
		int isOk=csv.remove(cno);
		return isOk>0?new ResponseEntity<String>("1", HttpStatus.OK): new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
