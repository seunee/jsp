document.getElementById('first').onclick = () => window.scrollTo({top : 0, behavior: 'smooth'});
let rcnt=0;
        let gnum=window.location.search.charAt(1);
        document.title = product[gnum].name;
    document.querySelector('.imge').innerHTML=
    `<img src="${product[gnum].image}" alt="사진없음">`
    if(product[gnum].sale>0){
        document.querySelector('.info').innerHTML=
    `<div id="pnmae">${product[gnum].name}</div><br><br>
    <div id="pinfo">${product[gnum].ex}</div><br>
    <div id="pprice"><del>${product[gnum].price}</del><sup>-${product[gnum].sale}%</sup>${Math.floor(product[gnum].price*((100-product[gnum].sale)/100))}<sub>원</sub></div><br>
    <table>
    <tr>
    <td>판매자</td>
    <td>${productdt[gnum].seller}</td>
    </tr>
    <tr>
    <td>원산지</td>
    <td>${productdt[gnum].contr}</td>
    </tr>
    <tr>
    <td>상품선택</td>
    <td><button type="button" class="btn" id="decre">-</button><div id="count"> 0 </div><button type="button"  class="btn" id="incre">+</button></td>
    </tr>
    </table>
    <button type="button" id="abc">구매하기</button>
    <button type="button" id="abc" onclick="openConfirm()">장바구니</button>`
    }else{
        document.querySelector('.info').innerHTML=
        `<div id="pnmae">${product[gnum].name}</div><br><br>
    <div id="pinfo">${product[gnum].ex}</div><br>
    <div id="pprice">${product[gnum].price}<sub>원</sub></div><br>
    <table>
    <tr>
    <td>판매자</td>
    <td>${productdt[gnum].seller}</td>
    </tr>
    <tr>
    <td>원산지</td>
    <td>${productdt[gnum].contr}</td>
    </tr>
    <tr>
    <td>상품선택</td>
    <td><button type="button" class="btn" id="decre">-</button><div id="count"> 0 </div><button type="button"  class="btn" id="incre">+</button></td>
    </tr>
    </table>
    <button type="button" id="abc">구매하기</button>
    <button type="button"id="abc" onclick="openConfirm()">장바구니</button>`
}
    let cnt=0;
    document.getElementById('incre').addEventListener('click',()=>{
        cnt++;
        document.getElementById('count').innerText=cnt
    })
    document.getElementById('decre').addEventListener('click',()=>{
        cnt--;
            if(cnt<0){
                cnt=0;
            }
            document.getElementById('count').innerText=cnt
        })
        function reply(){
            let a=document.getElementById('reply').value;
            productdt[gnum].reply(a);
            console.log(productdt[gnum].comment[0]);
            document.querySelector('.repl').innerHTML+=
            `<div class="com"><p>사용자${rcnt+1}</p><br>${productdt[gnum].comment[rcnt]}</div>`
            rcnt++
        }
        for(let i=0;i<productdt[gnum].comment.length;i++){
            document.querySelector('.repl').innerHTML+=
            `<div class="com"><p>사용자${i+1}</p><br>${productdt[gnum].comment[i]}</div>`
            rcnt++
        }