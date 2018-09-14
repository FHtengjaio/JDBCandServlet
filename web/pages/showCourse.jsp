<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/14
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程查询</title>
</head>
<body>
<table>
    <tr>
        <th>课程名称</th>
        <th>所属方向</th>
        <th>课程描述</th>
        <th>创建时间</th>
    </tr>
    <tr>
    <%
        for(Course course: request.getAttribute("courseList")){
    %>
            <td><%=course.getName()%></td>
            <td><%=course.getCategory()%></td>
            <td><%=course.getDesc()%></td>
            <td><%=course.getCreateTime()%></td>
    <%
        }
    %>
    </tr>
</table>
</body>
</html>
