package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SchedulesDAO;
import model.Schedules;


/**
 * Servlet implementation class ScheduleRegistServlet
 */
@WebServlet("/ScheduleRegistServlet")
public class ScheduleRegistServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_ID") == null) {
			response.sendRedirect("/famiLink/LoginServlet");
			return;
		}

		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_resist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_ID") == null) {
			response.sendRedirect("/famiLink/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String task = request.getParameter("task");
		String contents = request.getParameter("contents");
		String register = request.getParameter("register");

		// セッションパラメーター
		int group_number =(int)session.getAttribute("group_number");


		// 登録処理を行う
		SchedulesDAO sDao = new SchedulesDAO();
		if (sDao.insert(new Schedules(0, group_number, task, contents, register))) {	// 登録成功
			request.setAttribute("result", "登録しました。");
		}
		else {												// 登録失敗
			request.setAttribute("result", "登録できませんでした。");
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/task.jsp");
		dispatcher.forward(request, response);

	}
}
