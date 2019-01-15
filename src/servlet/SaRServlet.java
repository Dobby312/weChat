package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import templateMessage.TemplateMessageManager;
import util.SearchDB;

@WebServlet("/SaRServlet")
public class SaRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * 用于接受设备传来的报警信息，并获取相应的参数 调用sendTemplateMessage()方法
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 接收设备传过来的报警信息
		String linkUrl = request.getParameter("linkUrl");
		String num = request.getParameter("num");
		String adress = request.getParameter("adress");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formatter.format(new Date(Long.parseLong(request.getParameter("time"))));

		// 根据设备编号去查询对应的管理员
		ArrayList<String> list = SearchDB.search(num);
		TemplateMessageManager tm = new TemplateMessageManager();
		// 将报警信息发送给某台设备的所有管理员
		for (String touser : list) {
			tm.sendTemplateMessage(touser, linkUrl, num, time, adress);
		}
	}
}