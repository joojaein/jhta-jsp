import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class EL extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(request, response);
		System.out.println("get");

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int sum = 0, x = 0, y = 0;

		
		//Object sum_ = request.getAttribute("sum");
		String sum_ = request.getParameter("ss");
	
		if(sum_ != null) {
			//sum=(int)sum_;
			sum=Integer.parseInt(sum_);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
		request.setAttribute("sum", sum);
		
		dispatcher.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
		
		request.setCharacterEncoding("UTF-8");
		
		int sum = 0, x = 0, y = 0;

		switch(request.getParameter("cmd")) {
		case "µ¡¼À" :
			String strX = request.getParameter("x");
			String strY = request.getParameter("y");

			if (strX != null && !strX.equals("")) {
				x = Integer.parseInt(strX);
			}
			if (strY != null && !strY.equals("")) {
				y = Integer.parseInt(strY);
			}
			sum = x + y;
			break;
			
		case "application" :
			String sum_a = request.getParameter("sum");
			ServletContext application = request.getServletContext();
			application.setAttribute("sum", sum_a);
			break;
			
		case "session" :
			String sum_s = request.getParameter("sum");
			HttpSession session = request.getSession();
			session.setAttribute("sum", sum_s);
		break;
		
		case "cookie" :
		break;
		
		}
		
		
		//redirect
		response.sendRedirect("add?ss="+sum); //Redirect´Â ¹«Á¶°Ç get¿äÃ»
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("--------------------");
		System.out.println("service");
		super.service(req, resp);
	}
}
