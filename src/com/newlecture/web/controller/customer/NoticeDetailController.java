package com.newlecture.web.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/customer/notice/detail")
public class NoticeDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id =Integer.parseInt(req.getParameter("id"));

		String sql = "SELECT * FROM NOTICE WHERE ID="+id+"";
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl"; 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"c##sist","dclass");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			
/*			String title = rs.getString("TITLE");
			String writer_id = rs.getString("WRITER_ID");
			String content = rs.getString("CONTENT");
			Date regdate = rs.getDate("REGDATE");
			int hit = rs.getInt("HIT");		*/
			
			Notice n = new Notice(
					rs.getInt("ID"),
					rs.getString("TITLE"),
					rs.getString("WRITER_ID"),
					rs.getString("CONTENT"),
					rs.getDate("REGDATE"),
					rs.getInt("HIT")
					);
			
			
	 		RequestDispatcher dispatcher = 
	 				req.getRequestDispatcher("/WEB-INF/views/customer/notice/detail.jsp");
/*			req.setAttribute("title", title);
			req.setAttribute("writer_id", writer_id);
			req.setAttribute("content", content);
			req.setAttribute("regdate", regdate);
			req.setAttribute("hit", hit);*/
	 		req.setAttribute("n",n);
			dispatcher.forward(req,resp);
			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}



	}
}
