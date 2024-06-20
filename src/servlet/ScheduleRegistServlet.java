package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountsDAO;
import dao.SchedulesDAO;
import model.Accounts;
import model.LoginUser;
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
		//ユーザー情報の現在の情報を持ってくるselect
		HttpSession session2 = request.getSession();
		LoginUser user_ID = (LoginUser)session2.getAttribute("user_ID");
		String user = user_ID.getLoginUserId();

//		 ユーザーの検索処理を行う
		AccountsDAO accountDao = new AccountsDAO();
        List<Accounts> accountList = accountDao.pr_account(new Accounts(user));

//		 検索結果をリクエストスコープに格納する
		request.setAttribute("accountList", accountList);

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
		String d = request.getParameter("deadline");
		java.sql.Date deadline= Date.valueOf(d);
		// セッションスコープ
		HttpSession session2 = request.getSession();
		Accounts group = (Accounts)session2.getAttribute("pr_group");
		int group_number = group.getPr_group();
		LoginUser user_ID = (LoginUser)session.getAttribute("user_ID");
		String register = user_ID.getLoginUserId();

		// 登録処理を行う
		SchedulesDAO sDao = new SchedulesDAO();
		if (sDao.insert(new Schedules(0 ,group_number, task, contents, register,deadline))) {	// 登録成功
			request.setAttribute("result", "登録しました。");
			System.out.println("スケジュール登録成功");
		}
		else {												// 登録失敗
			request.setAttribute("result", "登録できませんでした。");
			System.out.println("スケジュール登録失敗");
		}

		// リダイレクトする
		response.sendRedirect("/C2/TaskServlet");
	}
}
