<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模拟设备报警信息</title>
</head>
<body>

	<form action="SaRServlet" method="post">
		<span>设备编号</span><input type="text" id="num" name="num"> <span>报警时间</span><input
			type="text" id="time" name="time"> <span>设备地址</span><input
			type="text" id="adress" name="adress"> <span>链接地址</span><input
			type="text" id="url" name="linkUrl"> <input type="submit"
			value="提交">
	</form>
</body>
</html>