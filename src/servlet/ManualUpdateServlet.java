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

import dao.ItemsDAO;
import model.Items;
import model.Result;

/**
 * Servlet implementation class ManualUpdateServlet
 */
@WebServlet("/ManualUpdateServlet")
public class ManualUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManualUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}

		// manualUpdateページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manual_update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/C2/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int number = Integer.parseInt(request.getParameter("id"));
		String task = request.getParameter("group_id");
		int group_id = Integer.parseInt(task);
		String heading = request.getParameter("header");
		String contents = request.getParameter("contents");
		String images = request.getParameter("images");
		String today = request.getParameter("today");

		java.sql.Date date = Date.valueOf(today);

		ItemsDAO bManuals = new ItemsDAO();
		// 登録処理を行う
		if (request.getParameter("submit").equals("更新")) {
			if (bManuals.update(new Items(0, group_id, heading, contents, images, date))) {	// 登録成功
				request.setAttribute("result", new Result("更新成功！", "レコードを登録しました。") );
			}
			else {												// 登録失敗
				request.setAttribute("result",  new Result("更新失敗！", "レコードを登録できませんでした。"));
			}
		}
		else {
			if (bManuals.delete(number)) {	// 削除成功
				request.setAttribute("result", new Result("削除成功！", "レコードを削除しました。") );
			}
			else {						// 削除失敗
				request.setAttribute("result",  new Result("削除失敗！", "レコードを削除できませんでした。"));
			}
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/task_update.jsp");
		dispatcher.forward(request, response);
	}

}
