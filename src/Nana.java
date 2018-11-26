import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;

@WebServlet("/hello")
public class Nana extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("hello Servlet");
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//기본적으로 출력용 스트림
		/*OutputStream os = response.getOutputStream();
		PrintStream out = new PrintStream(os, true);
		out.println("안녕 서블릿!!");*/
	
	
		/////////////////////////////////////////////////////////////////////////////////////////////////////////

		//문자 전용 출력용 스트림 
		/*response.setContentType("text/html; charset=UTF-8"); //브라우저에 출력이 UTF-8 타입임을 알리는 코드

		response.setCharacterEncoding("UTF-8"); // UTF-8로 인코딩 : out.prinln 보다 이에 써야함
		PrintWriter out = response.getWriter();
		for (int i = 0; i < 100; i++) {
			// int x = 3/0; -> 500에러 발생
			out.println((i+1)+ " : 메롱!!<br/>");
		}
		
		java.lang.annotation.Annotation[] test = this.getClass().getAnnotations();
	
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}*/
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////

		//QueryString 입력받기
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String temp = request.getParameter("cnt");
		int cnt = 1;
		if(temp != null && !temp.equals("")) {
			cnt = Integer.parseInt(temp);
		}
		for (int i = 0; i < cnt; i++) {
			out.println("안녕 servlet <br/>");
		}
		
		
		

		
	}
}
