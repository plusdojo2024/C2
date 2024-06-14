package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TasksDAO;
import model.LoginUser;
import model.Tasks;

/**
 * Servlet implementation class TaskUpdateServlet
 */
@WebServlet("/TaskUpdateServlet")
public class TaskUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}

		// taskページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/task_update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int number = Integer.parseInt(request.getParameter("id"));
		LoginUser login = (LoginUser)session.getAttribute("group_id");
		String task = request.getParameter("task");
		String contents = request.getParameter("contents");
		String today = request.getParameter("today");
		String register = request.getParameter("register");
		String to = request.getParameter("zipcode");
		String checkbox = request.getParameter("checkbox");
		String manual_link = request.getParameter("manual_link");
		java.sql.Date date = Date.valueOf(today);
		boolean boo1 = Boolean.valueOf(checkbox);

		TasksDAO bTask = new TasksDAO();
		// 登録処理を行う
		if (request.getParameter("submit").equals("更新")) {
			if (bTask.update(new Tasks(0, login.getGroupId(), task, contents, date, register, to,
					boo1, manual_link))) {	// 登録成功
				request.setAttribute("result", "レコードを登録しました。");
			}
			else {												// 登録失敗
				request.setAttribute("result", "レコードを登録できませんでした。");
			}
		}
		else {
			if (bTask.delete(number)) {	// 削除成功
				request.setAttribute("result", "レコードを削除しました。");
			}
			else {						// 削除失敗
				request.setAttribute("result", "レコードを削除できませんでした。");
			}
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/task_update.jsp");
		dispatcher.forward(request, response);
	}
}

