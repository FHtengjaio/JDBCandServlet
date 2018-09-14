<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/14
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加课程</title>
</head>
<body>
<div align="center">
    <h1>添加课程</h1>
    <form action="http://localhost:8080/AddCourse.do" method="post">
        <table>
            <tr>
                <td><label>课程名</label></td>
                <td><input type="text" name="courseName" placeholder="请输入课程名"></td>
            </tr>
            <tr>
                <td><label>所属方向</label></td>
                <td><input type="text" name="category" placeholder="请输入方向"></td>
            </tr>
            <tr>
                <td><label>课程描述</label></td>
                <td><input type="text" name="desc" placeholder="请输入描述"></td>
            </tr>
            <tr><td colspan="2" align="center"><input type="submit" value="添加"></td></tr>
        </table>
    </form>
</div>

</body>
</html>
