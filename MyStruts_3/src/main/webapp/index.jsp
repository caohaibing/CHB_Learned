<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<form action="servlet/addUser.do" method="post">
		姓名：<input type="text" name="username"><br>
		<input type="submit" value="添加"><br>
	</form>
	
	<form action="servlet/delUser.do" method="post">
        姓名：<input type="text" name="username"><br>
        <input type="submit" value="删除"><br>
    </form>
    
    <form action="servlet/modifyUser.do" method="post">
        姓名：<input type="text" name="username"><br>
        <input type="submit" value="修改"><br>
    </form>
    
    <form action="servlet/queryUser.do" method="post">
        姓名：<input type="text" name="username"><br>
        <input type="submit" value="查询"><br>
    </form>
</body>
</html>