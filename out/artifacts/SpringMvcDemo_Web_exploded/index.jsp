<%--
  Created by IntelliJ IDEA.
  User: 伟
  Date: 2017/9/22
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    String contextPath=request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
    function fun() {
        url="demo/test2"
        params = {
            timestamp : new Date().getTime()
        };
        $.post(url,params,function(data){
            $("#divid").html(data);
        });
    }
</script>
<h2>Hello World!</h2>
<input type="button" value="按钮" onclick="fun()">
<div id="divid"></div>
<img src = "<%=contextPath%>/webapp/img/焰灵姬.jpg">
</body>
</html>
