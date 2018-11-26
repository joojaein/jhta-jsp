import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcul")
public class CalculMiniTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");		

		String preNum = req.getParameter("pn");
		String rememNum = req.getParameter("rn");
		String all = req.getParameter("all");
		String all2 = req.getParameter("all");
		String outNum = req.getParameter("on");
		if(rememNum==null || rememNum.equals("")) {
			rememNum="0a";
		}

		if(all2!=null) {
			all2=all2.replace('a', '+');
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("calcul.jsp");
		req.setAttribute("pn", preNum);
		req.setAttribute("rn", rememNum);
		req.setAttribute("all", all);
		req.setAttribute("all2", all2);
		req.setAttribute("on", outNum);	
	
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");

		String input = req.getParameter("cmd");
		
		String preNum=req.getParameter("hidden_pn");
		String rememNum=req.getParameter("hidden_rn");
		String all=req.getParameter("hidden_all");
		String outNum=req.getParameter("hidden_on");

		if(input.equals("+")) {
			input="a";
		}
		
		if(all != null && !all.equals("")) {
			all= all+input;
		}else {
			all=input;
		}	
		
		if(input.charAt(0)>='0' && input.charAt(0)<='9') {
			
			if(!preNum.equals(outNum)) {
				outNum="";
			}
			
			if(preNum != null && !preNum.equals("")) {
				preNum = preNum+input;
			}else {
				preNum=input;
			}	
			
			if(outNum != null && !outNum.equals("") && !all.equals("")) {
				outNum = outNum+input;
			}else {
				outNum=input;
			}
		}
		else {
			
			if(input.equals("c")) {
				preNum="";
				rememNum="";
				all="";
				outNum="";				
			}else if(input.equals("d")) {
				System.out.println(all.charAt(all.length()-2));
				if(all.charAt(all.length()-2)>='0'&&all.charAt(all.length()-2)<='9') {
					all=all.substring(0,all.length()-2);
					preNum=preNum.substring(0,preNum.length()-1);
					outNum=outNum.substring(0,outNum.length()-1);
				}
			}else {
				String temp = rememNum+preNum;

				char[] tempChar = temp.toCharArray();
				String sign="";
				int index=0;
				for (int i = 0; i < tempChar.length; i++) {
					if(tempChar[i]<'0' || tempChar[i]>'9' ) {
						sign=tempChar[i]+"";
						index=i;
					}
				}
				int x = Integer.parseInt(temp.substring(0,index));
				int y = Integer.parseInt(temp.substring(index+1));
				int z=0;
				switch (sign) {
					case "a":
						z=x+y;
						break;
					case "-":
						z=x-y;
						break;
					case "*":
						z=x*y;
						break;			
				}
				
				rememNum=z+input;
				outNum=z+"";
				preNum="";
				
				if(input.equals("=")) {
					preNum="";
					all="";
					rememNum="";
				}
			}
			
			
			
		}
				
		
		resp.sendRedirect("calcul?pn="+preNum+"&all="+all+"&rn="+rememNum+"&on="+outNum); 
	}
}
