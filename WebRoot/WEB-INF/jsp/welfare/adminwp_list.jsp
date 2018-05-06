<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
	<div id="right">
        <a href="jsp/welfare/wpChange/wp_add.jsp">添加当月特价商品</a> 
		<c:if test="${requestScope.list!=null}">
			<c:forEach items="${requestScope.list}" var="goodslist">
				<div class="a">
					<table>
						<tr style="text-align:center">
							<td style="width:10px;height:10px;"><img
								style="width:200px;height:200px;"
								src="${goodslist.goodsImagesPath}" />
							</td>
						</tr>
						<tr style="text-align:center">
							<td>${goodslist.goodsName}</td>
						</tr>
						<tr style="text-align:center">
							<td>价格：${goodslist.goodsPrice}工分/份</td>
						</tr>
						<tr style="text-align:center">
							<td>库存量：${goodslist.goodsStock}份</td>
						</tr>
						<tr style="text-align:center">
							<td>
							   <a href="goods?opr=modify&goodsId=${goodslist.goodsId}">修改</a>
							   <a href="goods?opr=del&goodsId=${goodslist.goodsId}">删除</a>			   
							</td>
						</tr>
					</table>
				</div>
			</c:forEach>
		</c:if>
	</div>
	</section>
	<%@ include file="../../common/footer.jsp"%>
<style type="text/css">
.a {
	width: 200px;
	padding: 30px;
	border: 1px solid red;
	float: left;
}
</style>

