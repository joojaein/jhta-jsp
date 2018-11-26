//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebServlet("/add")
//public class QueryStringMinitest extends HttpServlet {
//	
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//super.doGet(request, response);
//		System.out.println("get");
//
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		int sum = 0, x = 0, y = 0;
//
//		
//		//Object sum_ = request.getAttribute("sum");
//		String sum_ = request.getParameter("sum");
//	
//		if(sum_ != null) {
//			//sum=(int)sum_;
//			sum=Integer.parseInt(sum_);
//		}
//
//		out.write("<!DOCTYPE html>");
//		out.write("<html>");
//		out.write("<head>");
//		out.write("<meta charset=\"UTF-8\">");
//		out.write("<title>Insert title here</title>");
//		out.write("</head>");
//		out.write("<body>");
//		out.write("<form action=\"add\" method=\"post\">");
//		out.write("<table border=\"1\">");
//		out.write("<tr>");
//		out.write("<td>´õÇÏ°í ½ÍÀº µÎ °ªÀ» ÀÔ·ÂÇÏ¼¼¿ä</td>");
//		out.write("</tr>");
//		out.write("<tr>");
//		out.write("	<td>");
//		out.printf("x : <input type=\"text\" name=\"x\" value=\"%d\"/>", x);
//		out.write("	</td>");
//		out.write("	</tr>");
//		out.write("<tr>");
//		out.write("	<td>");
//		out.printf("y : <input type=\"text\" name=\"y\" value=\"%d\"/>", y);
//		out.write("	</td>");
//		out.write("</tr>");
//		out.write("<tr>");
//		out.write("<td>");
//		out.printf("µ¡¼À °á°ú : %d", sum);
//		out.write("</td>");
//		out.write("</tr>");
//		out.write("<tr>");
//		out.write("<td> ");
//		out.write("<input type=\"submit\" value=\"µ¡¼À\" />");
//		out.write("	</td>");
//		out.write("	</tr>");
//		out.write("	</table>");
//		out.write("	</form>");		
//		out.write("</body>");
//		out.write("</html>");
//		
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//super.doPost(request, response);
//		System.out.println("post");
//
///*		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();*/
//
//		String strX = request.getParameter("x");
//		String strY = request.getParameter("y");
//
//		int sum = 0, x = 0, y = 0;
//
//		if (strX != null && !strX.equals("")) {
//			x = Integer.parseInt(strX);
//		}
//		if (strY != null && !strY.equals("")) {
//			y = Integer.parseInt(strY);
//		}
//		sum = x + y;
//		
///*		
// 		//forward	
// 		RequestDispatcher dispatcher = request.getRequestDispatcher("/add");
//		request.setAttribute("sum", sum);
//		dispatcher.forward(request,response);
//	 	post Ã³¸® forward´Â post¸¦ ¿äÃ»ÇÏ°í get Ã³¸® forward´Â getÀ» ¿äÃ»
//*/		
//		//redirect
//		response.sendRedirect("add?x="+x+"&y="+y+"&sum="+sum+""); //Redirect´Â ¹«Á¶°Ç get¿äÃ»
//		
//		
//		//doGet(request, response);
//		
//		/*out.write("<!DOCTYPE html>");
//		out.write("<html>");
//		out.write("<head>");
//		out.write("<meta charset=\"UTF-8\">");
//		out.write("<title>Insert title here</title>");
//		out.write("</head>");
//		out.write("<body>");
//		out.write("<form action=\"add\" method=\"post\">");
//		out.write("<table border=\"1\">");
//		out.write("<tr>");
//		out.write("<td>´õÇÏ°í ½ÍÀº µÎ °ªÀ» ÀÔ·ÂÇÏ¼¼¿ä</td>");
//		out.write("</tr>");
//		out.write("<tr>");
//		out.write("	<td>");
//		out.printf("x : <input type=\"text\" name=\"x\" value=\"%d\"/>", x);
//		out.write("	</td>");
//		out.write("	</tr>");
//		out.write("<tr>");
//		out.write("	<td>");
//		out.printf("y : <input type=\"text\" name=\"y\" value=\"%d\"/>", y);
//		out.write("	</td>");
//		out.write("</tr>");
//		out.write("<tr>");
//		out.write("<td>");
//		out.printf("µ¡¼À °á°ú : %d", add);
//		out.write("</td>");
//		out.write("</tr>");
//		out.write("<tr>");
//		out.write("<td> ");
//		out.write("<input type=\"submit\" value=\"µ¡¼À\" />");
//		out.write("	</td>");
//		out.write("	</tr>");
//		out.write("	</table>");
//		out.write("	</form>");
//		out.write("</body>");
//		out.write("</html>");*/
//	}
//	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("service");
//		super.service(req, resp);
//	}
//	
//	/*public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//
//		String strX = request.getParameter("x");
//		String strY = request.getParameter("y");
//
//		int add = 0, x = 0, y = 0;
//
//		if (request.getMethod().equals("POST")) {
//
//			if (strX != null && !strX.equals("")) {
//				x = Integer.parseInt(strX);
//			}
//			if (strY != null && !strY.equals("")) {
//				y = Integer.parseInt(strY);
//			}
//			add = x + y;
//		}
//
//		out.write("<!DOCTYPE html>");
//		out.write("<html>");
//		out.write("<head>");
//		out.write("<meta charset=\"UTF-8\">");
//		out.write("<title>Insert title here</title>");
//		out.write("</head>");
//		out.write("<body>");
//		out.write("<form action=\"add\" method=\"post\">");
//		out.write("<table border=\"1\">");
//		out.write("<tr>");
//		out.write("<td>´õÇÏ°í ½ÍÀº µÎ °ªÀ» ÀÔ·ÂÇÏ¼¼¿ä</td>");
//		out.write("</tr>");
//		out.write("<tr>");
//		out.write("	<td>");
//		out.printf("x : <input type=\"text\" name=\"x\" value=\"%d\"/>", x);
//		out.write("	</td>");
//		out.write("	</tr>");
//		out.write("<tr>");
//		out.write("	<td>");
//		out.printf("y : <input type=\"text\" name=\"y\" value=\"%d\"/>", y);
//		out.write("	</td>");
//		out.write("</tr>");
//		out.write("<tr>");
//		out.write("<td>");
//		out.printf("µ¡¼À °á°ú : %d", add);
//		out.write("</td>");
//		out.write("</tr>");
//		out.write("<tr>");
//		out.write("<td> ");
//		out.write("<input type=\"submit\" value=\"µ¡¼À\" />");
//		out.write("	</td>");
//		out.write("	</tr>");
//		out.write("	</table>");
//		out.write("	</form>");
//		out.write("</body>");
//		out.write("</html>");
//	}*/
//}
