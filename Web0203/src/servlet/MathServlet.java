package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MathServlet
 */
@WebServlet("/math")
public class MathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MathServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int a = 0;
		int b = 0;
		int c = 0;
	
		boolean signal = true;

		String parameterA = request.getParameter("a");
		try {
			a = valueOfA(parameterA);

		} catch (Exception e) {
			signal = false;
			// Null or not a number
			request.setAttribute("errorA", "A is not number!");
		}
		String parameterB = request.getParameter("b");
		try {
			b = valueOfB(parameterB);	
		} catch (Exception e) {
			signal = false;
			// Null or not a number
			request.setAttribute("errorB", "B is not number");
		}
		c = calculateResult(request, a, b, c, signal);
		setContextAttributes(request, c, parameterA, parameterB);
		RequestDispatcher rd = request.getRequestDispatcher("math.jsp");
		rd.forward(request, response);

	}

	private int valueOfB(String parameterB) throws Exception {
		int b;
		if (parameterB.isEmpty())
			throw new Exception("Insert number");
		b = Integer.parseInt(parameterB);
		return b;
	}

	private int valueOfA(String parameterA) throws Exception {
		int a;
		if (parameterA.isEmpty())
			throw new Exception("Insert number!");
		a = Integer.parseInt(parameterA);
		return a;
	}

	private int calculateResult(HttpServletRequest request, int a, int b, int c, boolean signal) {
		if (signal) {
			// add or substract
			if (request.getParameter("add") != null) {
				c = a+b;
			}
			else if (request.getParameter("substract") != null) {
				c = a-b;
			}
			

		} else {
			request.setAttribute("errorC", "Error, cannot calculate!");
		}
		return c;
	}

	private void setContextAttributes(HttpServletRequest request, int c, String parameterA, String parameterB) {
		request.setAttribute("parameterA", parameterA);
		request.setAttribute("parameterB", parameterB);
		request.setAttribute("c", c);
	}

}
