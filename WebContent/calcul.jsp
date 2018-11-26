<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="calcul" method="post">
		<table>
			<tr><td>
				<label>${all2}</label>
			</td></tr>
			<tr><td>
				<label>${on}</label>
			</td></tr>
						<tr><td>
							<input type="hidden" name="hidden_all" value="${all}" />
						</td></tr>
						<tr><td>
							<input type="hidden" name="hidden_rn" value="${rn}" />
						</td></tr>
						<tr><td>
							<input type="hidden" name="hidden_pn" value="${pn}" />
						</td></tr>						
						<tr><td>
							<input type="hidden" name="hidden_on" value="${on}" />
						</td></tr>		
			<tr><td>
				<input type="submit" name="cmd" value="7" />
				<input type="submit" name="cmd" value="8" />
				<input type="submit" name="cmd" value="9" />
				<input type="submit" name="cmd" value="*" />
			</td></tr>
			<tr><td>
				<input type="submit" name="cmd" value="4" />
				<input type="submit" name="cmd" value="5" />
				<input type="submit" name="cmd" value="6" />
				<input type="submit" name="cmd" value="-" />
			</td></tr>
			<tr><td>
				<input type="submit" name="cmd" value="1" />
				<input type="submit" name="cmd" value="2" />
				<input type="submit" name="cmd" value="3" />
				<input type="submit" name="cmd" value="+" />
			</td></tr>
			<tr><td>
				<input type="submit" name="cmd" value="0" />
				<input type="submit" name="cmd" value="c" />
				<input type="submit" name="cmd" value="d" />
				<input type="submit" name="cmd" value="=" />
			</td></tr>	
		</table>
	</form>
</body>
</html>