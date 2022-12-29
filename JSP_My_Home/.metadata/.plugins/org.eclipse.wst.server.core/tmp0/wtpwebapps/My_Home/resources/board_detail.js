//댓글 등록
async function postCommentToServer(cmtData){
	try{
		const url="/cmt/post";
		const config={
			method: 'post',
			headers: {
				'Content-Type': 'application/json; charset=utf-8'
			},
			body: JSON.stringify(cmtData)
		};
		const resp=await fetch(url, config);
		const result=await resp.text();
		return result;
	}catch(error){
		consol.log(error);
	}
}

document.getElementById('cmtAddBtn').addEventListener('click', ()=>{
	const cmtText=document.getElementById('cmtText').value;
			console.log(document.getElementById('cmtText'));
	if(cmtText==null||cmtText==''){
		alert('댓글을 입력해주세요.');
		return false;
	}else{
		let cmtData={
			bno: bnoVal,
			writer: document.getElementById('cmtWriter').value,
			content: cmtText
		};

		
		postCommentToServer(cmtData).then(result=>{
			if(result>0){
				alert("댓글 등록 성공");
				document.getElementById('cmtText').value="";
			}
			printCommentList(cmtData.bno);
		})
	}
})

//댓글 리스트
function printCommentList(bno){
	getCommentListFromServer(bno).then(result => {
		if(result.length>0){
			spreadCommentList(result);
		}else{
			let table=document.getElementById('commentList');
			table.innerHTML=`<tr><td colspan="4">ADD COMMENT!</td></tr>`;
		}
	})
};

async function getCommentListFromServer(bno){
	try{
		const resp=await fetch("/cmt/list/"+bno);
		const cmtList=await resp.json();
		return cmtList;
	}catch(error){
		console.log(error);
	}
}

function spreadCommentList(result){
	let table=document.getElementById('commentList');
	table.innerText='';
	console.log(commentList);
	for(let i=0;i<result.length;i++){
		let html=``;
		html+=`<tr>`;
		html+=`<td class="border_right">${result[i].writer}</td>`;
		html+=`<td class="border_right">
                <textarea id="cmtArea" cols="30" rows="1">${result[i].content}</textarea>
            </td>`;
		html+=`<td class="border_right">${result[i].reg_at}</td>`;
		html+=`<td>
				<button type="button" data-cno="${result[i].cno}" class="cmtEditBtn">EDIT</button>
				<button type="button" data-cno="${result[i].cno}" class="cmtDelBtn">DELETE</button>
			</td>`;
		html+=`</tr>`;
		table.innerHTML+=html;
	}
}


//댓글 삭제
async function removeCommentFromServer(cnoVal){
	try{
		const url="/cmt/remove/"+cnoVal;
		const config={method: "post"};
		const resp=await fetch(url, config);
		const result=resp.text();
		return result;
	}catch(error){
		console.log(error);
	}
}

document.addEventListener("click", e=>{
	if(e.target.classList.contains("cmtEditBtn")){
		let cnoVal=e.target.dataset.cno;
		let tr=e.target.closest('tr');
		console.log(tr);
		let cmtText=tr.querySelector('#cmtArea').value;
		updateCommentFromServer(cnoVal, cmtText).then(result =>{
			if(result>0){
				alert("댓글 수정 성공");
				printCommentList(bnoVal);
			}
		})
	}	
	if(e.target.classList.contains("cmtDelBtn")){
		let cnoVal=e.target.dataset.cno;
		removeCommentFromServer(cnoVal).then(result=>{
			if(result>0) alert("댓글 삭제 성공");
			printCommentList(bnoVal);
		});
	}
});


//댓글 수정
async function updateCommentFromServer(cnoVal, cmtText){
	try{
		const url='/cmt/modify';
		const config={
			method: 'post',
			header:{
				'Content-Type': 'application/json; charset=utf-8'
			},
			body: JSON.stringify({cno: cnoVal, content: cmtText})
		}
		const resp=await fetch(url, config);
		const result=await resp.text();
		return result;
	}catch(error){
		console.lof(error);
	}
}

