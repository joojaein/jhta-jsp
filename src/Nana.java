import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;

@WebServlet("/hello")
public class Nana extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("hello Servlet");
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//�⺻������ ��¿� ��Ʈ��
		/*OutputStream os = response.getOutputStream();
		PrintStream out = new PrintStream(os, true);
		out.println("�ȳ� ����!!");*/
	
	
		/////////////////////////////////////////////////////////////////////////////////////////////////////////

		//���� ���� ��¿� ��Ʈ�� 
		/*response.setContentType("text/html; charset=UTF-8"); //�������� ����� UTF-8 Ÿ������ �˸��� �ڵ�

		response.setCharacterEncoding("UTF-8"); // UTF-8�� ���ڵ� : out.prinln ���� �̿� �����
		PrintWriter out = response.getWriter();
		for (int i = 0; i < 100; i++) {
			// int x = 3/0; -> 500���� �߻�
			out.println((i+1)+ " : �޷�!!<br/>");
		}
		
		java.lang.annotation.Annotation[] test = this.getClass().getAnnotations();
	
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}*/
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////

		//QueryString �Է¹ޱ�
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String temp = request.getParameter("cnt");
		int cnt = 1;
		if(temp != null && !temp.equals("")) {
			cnt = Integer.parseInt(temp);
		}
		for (int i = 0; i < cnt; i++) {
			out.println("�ȳ� servlet <br/>");
		}
		
		
		

		
	}
}
