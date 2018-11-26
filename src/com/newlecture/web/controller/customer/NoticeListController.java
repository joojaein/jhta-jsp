package com.newlecture.web.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/customer/notice/list")
public class NoticeListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page_ = req.getParameter("p");
		int page = 1;

		if(page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		} 
		
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, N.* FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) N) WHERE NUM BETWEEN ? AND ?";
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl"; 
		
		try {
			
			int start = (page-1)*10+1;
			int end = page*10;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"c##sist","dclass");
			//Statement st = con.createStatement();
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, start); // sql 중 첫번째 ? 를  start로 바꾸는 코드
			st.setInt(2, end);// sql 중 두번째 ? 를 end로 바꾸는 코드
	
			//ResultSet rs = st.executeQuery(sql); //sql 의 ? 를 변경하기 전 이기 때문에 PreparedStatement 을 사용할때는 이렇게 안씀
			ResultSet rs = st.executeQuery(); //sql 의 ? 변경 후 이기 때문에 PreparedStatement 을 사용할때는 이렇게 씀!!
			
			List<Notice> list = new ArrayList<>();
			
			while(rs.next()) {
				
				Notice n = new Notice(
						rs.getInt("ID"),
						rs.getString("TITLE"),
						rs.getString("WRITER_ID"),
						rs.getString("CONTENT"),
						rs.getDate("REGDATE"),
						rs.getInt("HIT")
						);
			
			list.add(n);
			}
		
			RequestDispatcher dispatcher = 
	 				req.getRequestDispatcher("/WEB-INF/views/customer/notice/list.jsp");
	
			req.setAttribute("list",list);
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
