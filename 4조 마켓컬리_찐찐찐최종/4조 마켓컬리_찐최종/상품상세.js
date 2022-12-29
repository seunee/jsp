document.getElementById('first').onclick = () => window.scrollTo({top : 0, behavior: 'smooth'});
let productdt=[{
name : '피자빵',
count : 0,
seller : '파리바게트',
contr : '한국',
comment:["파리바게트에서 만든빵임다"],
reply : function(a){
    this.comment.push(a);
}
},
{name : '토마토',
count : 0,
seller : '농협',
contr : '한국',
comment:["울퉁불퉁 멋진 몸매에","빠알간 옷을 입고","새콤달콤 향기풍기는","토마토는 빼주세요."],
reply : function(a){
    this.comment.push(a);
}
},
{name : '방울토마토',
count : 0,
seller : '농협',
contr : '한국',
comment:["쪼꼬매 귀여워"],
reply : function(a){
    this.comment.push(a);
},
},
{name : '사과',
count : 0,
seller : '컬리',
contr : '한국',
comment:["사과는 맛있어"],
reply : function(a){
    this.comment.push(a);
},
},
{name : '오징어',
count : 0,
seller : '컬리',
contr : '한국',
comment:[],
reply : function(a){
    this.comment.push(a);
},
},
{name : '라면',
count : 0,
seller : '삼양',
contr : '제품에 표시',
comment:[],
reply : function(a){
    this.comment.push(a);
},
},
{name : '허니버터칩',
count : 0,
seller : '해태',
contr : '제품에 표시',
comment:[],
reply : function(a){
    this.comment.push(a);
},
},
{name : '오징어과자',
count : 0,
seller : '오리온',
contr : '제품에 표시',
comment:[],
reply : function(a){
    this.comment.push(a);
},
}
];
