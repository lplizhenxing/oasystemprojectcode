<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
	<div id="right" >
		<div class="bg">
			<img src="jsp/game/drawgame/style/bg.jpg">
		</div>

		<div class="box">
			<div class="jz">
				<span class="name" style="color:red;" >中奖员工</span><br /> <span class="phone" style="color:red;">中奖号码</span><br />			
				<div class="start" id="btntxt" onclick="start()">大奖</div>
				<div class="start xn2" id="btnluck" onclick="luck()">幸运奖</div>
			</div>
			<div class="zjmd">
				<p class="p1" style="color:red;">中奖者名单</p>
				<div class="list" id="content" style="color:red;">
					<!-- <div class="xyjmd"><h1>幸运奖</h1></div> -->
					<div class="zjmd_bt_xy"></div>
					<div class="dajmd">
						<h1></h1>
					</div>
					<div class="zjmd_bt_dj"></div>
				</div>
				<div class="clear"></div>
			</div>
			<!-- 文件保存格式 value="" -->
			<input type="text" name="filename" id="filename" value="中奖名单.txt"
				style="display:none;" />
			<!-- .csv后缀 -->
			<button class="start svbtn" id="saveBtn">保存名单</button>
		</div>
		<div class="confirmbox">
			<div class="zj_top">
				<img src="jsp/game/drawgame/style/zj_top.png" alt="">
			</div>
			<div class="lucknum"></div>
			<div class="conbox"></div>
			<div class="clear"></div>
			<div class="btnbox">
				<div class="start new_s daj" id="btnqr" onclick="">确认</div>
				<div class="start new_s 22stop" id="btnqx" onclick=""
					style="background:#FC6666;">取消</div>
			</div>
			<div class="zj_bottom">
				<img src="jsp/game/drawgame/style/zj_bottom.png" alt="">
			</div>
		</div>
		<script type="text/javascript" src="jsp/game/drawgame/style/cj.js"></script>
		<script type="text/javascript" src="jsp/game/drawgame/style/blob.js"></script>
		<script type="text/javascript" src="jsp/game/drawgame/style/filesaver.js"></script>
		<script>
			(function() {
				document.getElementById("saveBtn").onclick = function(event) {
					event.preventDefault();
					var BB = self.Blob;
					saveAs(new BB([ "\ufeff"
							+ document.getElementById("content").innerHTML ] //\ufeff防止utf8 bom防止中文乱码
					, {
						type : "text/plain;charset=utf8"
					}), document.getElementById("filename").value);
				};
			})();

			var i = 1;
			$('.xn').live('click', function() {

				$('.lucknum').text('第' + i + '1 -- ' + (i + 1) + '0名');
				i++;
			});
			$('.xn2').one('click', function() {
				$('.lucknum').text('第1 -- 5名');
			})
		</script>
	</div>
	</section>
	<%@ include file="../../common/footer.jsp"%>

