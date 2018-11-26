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
			st.setInt(1, start); // sql �� ù��° ? ��  start�� �ٲٴ� �ڵ�
			st.setInt(2, end);// sql �� �ι�° ? �� end�� �ٲٴ� �ڵ�
	
			//ResultSet rs = st.executeQuery(sql); //sql �� ? �� �����ϱ� �� �̱� ������ PreparedStatement �� ����Ҷ��� �̷��� �Ⱦ�
			ResultSet rs = st.executeQuery(); //sql �� ? ���� �� �̱� ������ PreparedStatement �� ����Ҷ��� �̷��� ��!!
			
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
