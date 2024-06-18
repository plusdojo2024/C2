package servlet;

import java.io.IOException;

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
 * Servlet implementation class ManualRegistServlet
 */
@WebServlet("/ManualRegistServlet")
public class ManualRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManualRegistServlet() {
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
			response.sendRedirect("/C2/LoginServlet");
			return;
		}

		// manual_regist.jspページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manual_resist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_ID") == null) {
			response.sendRedirect("/C2/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		//String task = "1";//request.getParameter("group_id");
		int group_id = 1;//Integer.parseInt(task);
		String heading = request.getParameter("header");
		String contents = request.getParameter("contents");
		String images = request.getParameter("images");
		//String today = request.getParameter("today");

		//java.sql.Date date = Date.valueOf(today);


		// 登録処理を行う
		ItemsDAO bItems = new ItemsDAO();
		if (bItems.insert(new Items(0, group_id, heading, contents, images))) {	// 登録成功
			request.setAttribute("result",new Result("登録成功！", "レコードを登録しました。"));
		}
		else {												// 登録失敗
			request.setAttribute("result", "レコードを登録できませんでした。");
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manual_resist.jsp");
		dispatcher.forward(request, response);
	}

}
