package com.imooc.servlet;

import com.imooc.utils.JDBCUtil;
import javafx.beans.binding.ObjectExpression;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;

@WebServlet(name = "AddCourseServlet", urlPatterns = "/AddCourse.do")
public class AddCourseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String name = request.getParameter("courseName");
        String category = request.getParameter("category");
        String desc = request.getParameter("desc");

        //保证参数不是null或者空串
        if (name == null || category == null || desc == null
        || Objects.equals(name,"") || Objects.equals(category, "") || Objects.equals(desc, "")) {
            return;
        }

        //数据库操作
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = JDBCUtil.getConnection();
            String sql = "INSERT course(name,category,desp,createTime) VALUES(?,?,?,?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2,category);
            pstmt.setString(3,desc);
            pstmt.setDate(4, new Date(System.currentTimeMillis()));
            pstmt.executeUpdate();
            response.sendRedirect("/ShowCourse.do");
        } catch (Exception e) {

        } finally {
           JDBCUtil.release(pstmt,connection);
        }

    }
}
