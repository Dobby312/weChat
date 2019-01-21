<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理界面</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script>
	$(function() {
		$("button").click(
						function() {
							var id = $("#scene").val();
							$.ajax({
										url : "GetQrCode",
										type : "POST",
										data : {
											"id" : id
										},
										dataType : "text",
										success : function(data) {
											var src = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="
													+ data;
											$("img").attr("src", src);
										}
									})

						})

	})
</script>
</head>

<body>
	<div>
		<span style="font-size: 25px; color: blue">请输入设备编号</span>: <input
			type="text" id="scene" name="id">
	</div>
	
	<p></p>
	<p></p>
	
	<button>
		<span style="font-size: 25px; color: blue">生成二维码</span>
	</button>
	<br>
	<img alt="" src="">
	<p></p>
	<p></p>

	<div>
		<a href="admin.jsp">添加用户信息</a>
	</div>
</body>

</html>