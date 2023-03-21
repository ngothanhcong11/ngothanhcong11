package r2s.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import r2s.utils.LogFactory;

@WebServlet(urlPatterns = "/HomePage")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogFactory.getLogger().info("Running on method doGet of HomePageServlet");
		request.getRequestDispatcher("views/HomePage.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("Username", request.getAttribute("UserName"));
		request.getRequestDispatcher("/views/HomePage.jsp").forward(request, response);
	}
}
