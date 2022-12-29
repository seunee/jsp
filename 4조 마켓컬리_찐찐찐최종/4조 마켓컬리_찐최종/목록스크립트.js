    document.getElementById('first').onclick = () => window.scrollTo({top : 0, behavior: 'smooth'});
    function search(){
        let tx=document.getElementById('searchI').value;
        document.querySelector('#aaa').innerText='';
        pcnt=0;
    for(let i=0;i<product.length;i++){
        if(product[i].name.match(tx)){
            let dib = document.createElement('div');
            let at = document.createElement('a');
            at.setAttribute('href',`상품상세.html?${i}`)
            dib.setAttribute('id','probox');
            if(product[i].sale==0){
                dib.innerHTML=`${proList(product[i].name)}<br><b>${product[i].name}</b><br>${product[i].price}<br><sub>${product[i].ex}</sub>`;
            }else{
                dib.innerHTML=`${proList(product[i].name)}<br><b>${product[i].name}</b><br><del>${product[i].price}</del><sup>-${product[i].sale}%</sup>  ${Math.floor(product[i].price*((100-product[i].sale)/100))}<br><sub>${product[i].ex}</sub>`;
            }
            at.appendChild(dib);
            let con = document.createElement('div');
            con.appendChild(at);
            document.querySelector('#aaa').innerHTML+=con.innerHTML;
            pcnt++;
        }
    }if(pcnt==0){
        document.querySelector('#aaa').innerHTML=
        `<h1>찾으시는 상품이 없습니다.</h1>`
    }
    }
    function categoryChart(a){
        document.querySelector('#aaa').innerText='';
        for(let i=0;i<product.length;i++){
            if(product[i].category==a){
            let dib = document.createElement('div');
            let at = document.createElement('a');
            at.setAttribute('href',`상품상세.html?${i}`)
            dib.setAttribute('id','probox');
            if(product[i].sale==0){
                dib.innerHTML=`${proList(product[i].name)}<br><b>${product[i].name}</b><br>${product[i].price}<br><sub>${product[i].ex}</sub>`;
            }else{
                dib.innerHTML=`${proList(product[i].name)}<br><b>${product[i].name}</b><br><del>${product[i].price}</del><sup>-${product[i].sale}%</sup>  ${Math.floor(product[i].price*((100-product[i].sale)/100))}<br><sub>${product[i].ex}</sub>`;
            }
            at.appendChild(dib);
            let con = document.createElement('div');
            con.appendChild(at);
            document.querySelector('#aaa').innerHTML+=con.innerHTML;
        }
    }
}
    function allChart(){
        document.querySelector('#aaa').innerText='';
        for(let i=0;i<product.length;i++){
            let dib = document.createElement('div');
            let at = document.createElement('a');
            at.setAttribute('href',`상품상세.html?${i}`)
            dib.setAttribute('id','probox');
            if(product[i].sale==0){
                dib.innerHTML=`${proList(product[i].name)}<br><b>${product[i].name}</b><br>${product[i].price}<br><sub>${product[i].ex}</sub>`;
            }else{
                dib.innerHTML=`${proList(product[i].name)}<br><b>${product[i].name}</b><br><del>${product[i].price}</del><sup>-${product[i].sale}%</sup>  ${Math.floor(product[i].price*((100-product[i].sale)/100))}<br><sub>${product[i].ex}</sub>`;
            }
            at.appendChild(dib);
            let con = document.createElement('div');
            con.appendChild(at);
            document.querySelector('#aaa').innerHTML+=con.innerHTML;
    }
}
function proList(a){
    for(let i=0;i<product.length;i++){
        if(product[i].name.match(a)){
            return `<img id="pic" src=${product[i].image} alt="사지넝ㅄ음">`;
        }
    }
    }
    