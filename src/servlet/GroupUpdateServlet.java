package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GroupsDAO;
import model.Groups;


/**
 * Servlet implementation class GroupUpdateServlet
 */
@WebServlet("/GroupUpdateServlet")
public class GroupUpdateServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/famiLink/LoginServlet");
			return;
		}

		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_update.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// // もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/famiLink/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String group_name = request.getParameter("group_name");
		String user_ID = request.getParameter("user_ID");
		Boolean editer = Boolean.valueOf(request.getParameter("editer"));
		String icon = request.getParameter("icon");


		// 更新または削除を行う
		GroupsDAO sDao = new GroupsDAO();
		System.out.println("「"+request.getParameter("submit")+"」");

		//"Update" == "更新"
		if (request.getParameter("submit").equals("Update")) {

		if (sDao.update(new Groups(0,group_name, user_ID, editer, icon))) {		// 更新成功

				request.setAttribute("result","内容を更新しました。");
		}
		else {			// 更新失敗
				request.setAttribute("result","内容を更新できませんでした。");
			}
		}
		else {
			if (sDao.delete(user_ID)) {	// 削除成功
				request.setAttribute("result", "削除しました。");
			}
			else {			// 削除失敗
				request.setAttribute("result", "削除できませんでした。");
			}
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/group.jsp");
		dispatcher.forward(request, response);
	}

}


