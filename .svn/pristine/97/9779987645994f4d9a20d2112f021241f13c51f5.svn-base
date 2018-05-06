<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<form action="goods?opr=add" method="post">
		<table>
			<tr>
				<td style="width:100px">商品名称：&nbsp;&nbsp;</td>
				<td><input type="text" name="goodsName" id="goodsName" />
				</td>
			</tr>
			<tr>
				<td style="width:100px">商品路径：&nbsp;&nbsp;</td>
				<td><input type="text" name="goodsImagesPath"
					id="goodsImagesPath" />
				</td>
			</tr>
			<tr>
				<td style="width:100px">商品价格：&nbsp;&nbsp;</td>
				<td><input type="text" name="goodsPrice" id="goodsPrice" />
				</td>
			</tr>
			<tr>
				<td style="width:100px">商品库存：&nbsp;&nbsp;</td>
				<td><input type="text" name="goodsStock" id="goodsStock" />
				</td>
			</tr>
			<tr>
				<td style="width:100px"><input type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
</div>
</section>
<%@ include file="../../common/footer.jsp"%>
<script type="text/javascript">
	$(function() {
		$("form").submit(function() {
			var postTitle = $("#goodsName").val();
			if (postTitle.trim() == "") {
				alert("商品名称不能为空！");
				return false;
			}
			return true;

		});
	});
</script>
