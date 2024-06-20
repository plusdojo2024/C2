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
import dao.TasksDAO;
import model.Accounts;
import model.LoginUser;
import model.Tasks;

/**
 * Servlet implementation class TaskServletRegist
 */
@WebServlet("/TaskServletRegist")
public class TaskRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_ID") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}
	//registerを自動登録
		//ユーザー情報の現在の情報を持ってくるselect
		HttpSession session2 = request.getSession();
		LoginUser user_ID = (LoginUser)session2.getAttribute("user_ID");
		String user = user_ID.getLoginUserId();

//		 ユーザーの検索処理を行う
		AccountsDAO accountDao = new AccountsDAO();
        List<Accounts> accountList = accountDao.pr_account(new Accounts(user));

//		 検索結果をリクエストスコープに格納する
		request.setAttribute("accountList", accountList);

		// taskページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/task_regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープから取得する
		HttpSession session = request.getSession();
		Accounts group = (Accounts)session.getAttribute("pr_group");
		int group_number = group.getPr_group();

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String task = request.getParameter("task");
		String content = request.getParameter("content");
		String day = request.getParameter("day");
		java.sql.Date date = Date.valueOf(day);
		String register = request.getParameter("register");
		String to = request.getParameter("to");
		String checkbox = request.getParameter("checkbox");
		String manual_link = request.getParameter("manual_link");

//		boolean boo1 = Boolean.valueOf(checkbox);
		//favoritesの値が"yes"かそれ以外の判定を行う。
		boolean check = false;
        String yes = "yes";
		if (yes.equals(checkbox)) {
			check = true;
		}
		// 登録処理を行う
		TasksDAO bTask = new TasksDAO();
		if (bTask.insert(new Tasks(0, group_number, task, content, date, register, to,
				check, manual_link))) {	// 登録成功
			request.setAttribute("result", "レコードを登録しました。");
		}
		else {												// 登録失敗
			request.setAttribute("result", "レコードを登録できませんでした。");
		}

		// リダイレクトする
		response.sendRedirect("/C2/TaskServlet");
	}

}
