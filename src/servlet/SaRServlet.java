package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaRServlet")
public class SaRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaRServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * 用于接受设备传来的报警信息，并获取相应的参数
	 * 调用sendTemplateMessage()方法
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String touser = null;
		String linkUrl = request.getParameter("linkUrl");
		String num = request.getParameter("num");
		String adress = request.getParameter("adress");
		String time = request.getParameter("time");

		//request.getParameter();
		//这个post方法用于接受设备传过来的信息，并将之处理转化，在转发给用户。
		//touser是通过num的值去数据库中查找到的
	}

}
