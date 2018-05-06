/*承接建站 270168164*/

var xinm = new Array();
var phone = new Array();

xinm[0]="郑鑫帅"
xinm[1]="林荣"
xinm[2]="何柒"
xinm[3]="陈智君"
xinm[4]="李晨阳"
xinm[5]="李子豪"
xinm[6]="叶宇健"
xinm[7]="朱松柏"
xinm[8]="杨涛"
xinm[9]="熊平"
xinm[10]="王俊杰"
xinm[11]="吕金成"
xinm[12]="鲍光光"
xinm[13]="金炜杰"
xinm[14]="殷东旭"
xinm[15]="张旅玮"
xinm[16]="汪朋朋"
xinm[17]="李振兴"
xinm[18]="田兵"
xinm[19]="龚象广"
xinm[20]="刘盈"

phone[0]="151****3625"
phone[1]="180****3582"
phone[2]="158****3031"
phone[3]="135****0255"
phone[4]="182****2223"
phone[5]="180****5557"
phone[6]="186****7582"
phone[7]="159****8592"
phone[8]="158****7213"
phone[9]="137****2881"
phone[10]="158****6610"
phone[11]="150****6765"
phone[12]="137****9530"
phone[13]="180****9967"
phone[14]="152****5766"
phone[15]="189****2598"
phone[16]="185****2210"
phone[17]="151****8996"
phone[18]="180****4966"
phone[19]="189****7356"
phone[20]="182****3505"

var nametxt = $('.name');
var phonetxt = $('.phone');
var pcount = xinm.length;//参加人数
var runing = true;  
var num = 0; //随机数存储
var to = 0;//从0开始
var numr = 5;//每次抽取幸运奖人数
var t;//循环调用
var lucknum = 0;

var pdnum = pcount;//参加人数判断是否抽取完


//大奖开始停止
function start() {
	var zjnum = $('.list').find('p');
	if(zjnum.length == pdnum){
		alert('无法抽奖');
	}else{
		if (runing) {
			runing = false;
			$('#btntxt').removeClass('start').addClass('stop');
			$('#btntxt').html('停止');
			startNum();
		} else {
			runing = true;
			$('#btntxt').removeClass('stop').addClass('start');
			$('#btntxt').html('抽奖');
			stop();
	        bzd();//中奖函数
	        $('#btnqx').css('display','block');
	        $('.lucknum').css('display','none');
	    }
	}
}

// 幸运奖开始停止
function luck(){
	if(runing){
		runing = false;
		$('#btnluck').removeClass('start').addClass('stop');
		$('#btnluck').html('停止');
		startNum();
	}else{
		runing = true;
		$('#btnluck').removeClass('stop').addClass('start');
		$('#btnluck').html('幸运奖');
		stop();
		luck2();
		dl();
	}
	if(!$('#btnqr').hasClass('xn')){
		$('#btnqr').addClass('xn');
	}
	$('#btnqx').css('display','none');
	$('.lucknum').css('display','block');
}
//循环参加名单
function startNum() {
	pcount = xinm.length;
	num = Math.floor(Math.random() * pcount);
	nametxt.html(xinm[num]);
	phonetxt.html(phone[num]);
	t = setTimeout(startNum, 0);
}
//停止跳动
function stop() {
	clearInterval(t);
	t = 0;
	return pcount;
}
//打印中奖名单
function bzd() {
	pcount = xinm.length;
	//获取中奖人数
	var zjnum = $('.list').find('p');
	//打印中奖者名单
	$('.conbox').prepend("<p style='width:80%;font-size:38px;padding:30px;text-align: center;color:#FF2525;'>"+xinm[num]+"   "+phone[num]+"</p>");
	$('.confirmbox').show();
	//将已中奖者从数组中"删除",防止二次中奖
	xinm.splice($.inArray(xinm[num], xinm), 1);
	phone.splice($.inArray(phone[num], phone), 1);
	
	return pcount;
}
//幸运奖循环
function luck2(){
	var arr=[];
    var json={};
    pcount = xinm.length;
    if(pcount < numr){
    	alert('无法抽奖');
    }else{
	    //循环随机数10次
	    for(var i = 0;arr.length<numr;i++){
	    	//产生单个随机数
            var ranNum = Math.floor(Math.random()*pcount);
            //通过判断json对象的索引值是否存在 来标记 是否重复
            if(!json[ranNum]){
                json[ranNum]=1;
                arr.push(ranNum);
            }
        }
    }
    //打印幸运奖名单,每次10名
    $.each(arr,function(i){
    	$('.conbox').prepend("<p>"+xinm[arr[i]]+" - "+phone[arr[i]]+"</p>");
    	$('.name').html(xinm[arr[i]]);
    	$('.phone').html(phone[arr[i]]);
    	$('.confirmbox').show();

    	delete xinm[arr[i]];
    	delete phone[arr[i]];
    })
    //替换循环停止人名
    $.each(arr,function(z,val){
    	if(z == 9){
    		nametxt.html(xinm[arr[9]]);
			phonetxt.html(phone[arr[9]]);
    	}
    })      
    pcount = xinm.length;
	return pcount;

}

//删除幸运奖中奖
function dl(){
	var testn = [];
	var testp = [];
	$.each(xinm,function(i,vl){
		if(typeof(xinm[i]) != 'undefined'){
			testn.push(xinm[i]);
			testp.push(phone[i]);
		}
	})
	xinm.splice(0,xinm.length);
	phone.splice(0,phone.length);
	xinm = xinm.concat(testn);
	phone = phone.concat(testp);
}
//确认
$('#btnqr').on('click',function(){

	var cp = $('.conbox').find('p').removeAttr('style').clone();
	$('.zjmd_bt_xy').find('p').eq(0).css({'margin-top':'10px','border-top':'1px solid #FF2525'});
	$('.zjmd_bt_xy').prepend(cp);
	$('.conbox').empty();
	$('.confirmbox').hide();
	//中奖名单排序
	$('.list').find('p').each(function(i){
		$(this).find('span').remove();
	})
})

//取消
$('#btnqx').on('click',function(){
	$('.conbox').empty();
	$('.confirmbox').hide();
})












