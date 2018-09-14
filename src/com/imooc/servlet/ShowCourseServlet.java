package com.imooc.servlet;

import com.imooc.object.Course;
import com.imooc.utils.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ShowCourseServlet",urlPatterns = "/ShowCourse.do")
public class ShowCourseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "SELECT * FROM course";
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            List<Course> courseList = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");
                String desc = resultSet.getString("desp");
                Date createTime = resultSet.getDate("createTime");
                courseList.add(new Course(name, category, desc, createTime));
            }
            request.setAttribute("List", courseList);
            request.getRequestDispatcher("/pages/showCourse.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           JDBCUtil.release(resultSet, pstmt, connection);
        }
    }
}
