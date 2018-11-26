package com.newlecture.web.controller.customer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/customer/notice/reg")
@MultipartConfig( //��Ƽ��Ʈ�� ���ڵ��� ���� ������̼�
		fileSizeThreshold=1024*1024,
		maxFileSize=1024*1024*10,//10�ް� ����
		maxRequestSize=1024*1024*10*5//10�ް� 5������
)
public class NoticeRegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
	 		RequestDispatcher dispatcher = 
	 				req.getRequestDispatcher("/WEB-INF/views/customer/notice/reg.jsp");

			dispatcher.forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		
		String path=req.getServletContext().getRealPath("/upload");
		System.out.println(path);
		//String filePath = path+"\\a.jpg"; //������� \ �� ���� , ���н��� /�� �����ϱ� ������
		String filePath = path+File.separator+"aa.jpg"; 
		//��θ� ������� \ �� , ���н��� /�� �����ϱ� ������ ��� �����ڰ� �ü���� ���� �޶��� �� �ֵ��� File.separator �� ���

		Part part = req.getPart("file");		
		InputStream fis = part.getInputStream();
		OutputStream fos = new FileOutputStream(filePath);
		
		byte[] buf = new byte[1024];
		
		int size =1024;
		
		while((size=fis.read(buf))>=0) {
			fos.write(buf, 0, size);
		}
		
		
		
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl"; 
		String sql = "INSERT INTO NOTICE(ID, TITLE, WRITER_ID, CONTENT) "
				+ "VALUES (NOTICE_SEQ.NEXTVAL, ?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"c##sist","dclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, "JOOJAEIN");
			st.setString(3, content);

			int affected = st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("list");

	
	}
}
