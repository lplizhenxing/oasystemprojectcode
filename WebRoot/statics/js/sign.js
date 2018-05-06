/*签到模块日期捕捉：*/
function week(){
	var objDate= new Date();
	var week = objDate.getDay();
	switch(week)
		{
			case 0:
			week="周日";
			break;
			case 1:
			week="周一";
			break;
			case 2:
			week="周二";
			break;
			case 3:
			week="周三";
			break;
			case 4:
			week="周四";
			break;
			case 5:
			week="周五";
			break;
			case 6:
			week="周六";
			break;
		}
	$("#sing_for_number").html(week);
}



$(document).ready(function(){
	week();
	
	var url = "SignServlet";
	$.post(url,callBack);
	
	function callBack(s1){
		if(s1=="true"){
			$(".singer_r_img").addClass("current");
			$(".singer_r_img").click(function(){
				alert("今天已签到，请勿重复签到");
			})	
		}	
	}
	$(".singer_r_img").click(function(){
		
		$(this).addClass("current");
		$.get(url);
	})
	
	
	

})