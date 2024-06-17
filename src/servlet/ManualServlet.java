package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManualsDAO;
import model.Accounts;
import model.LoginUser;
import model.Manuals;

/**
 * Servlet implementation class ManualServlet
 */
@WebServlet("/ManualServlet")
public class ManualServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManualServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    //doGetメソッド
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_ID") == null) {
			response.sendRedirect("/C2/LoginServlet");
			return;
		}

		LoginUser login = (LoginUser)session.getAttribute("id_group");
		request.setAttribute("id_group",login);

		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manual.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	//doPostメソッド
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_ID") == null) {
			response.sendRedirect("/C2/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String manual_name = request.getParameter("manual_name");
		//セッションスコープから取得
		HttpSession session2 = request.getSession();
		Accounts pr_group = (Accounts)session2.getAttribute("pr_group");
		int group = pr_group.getPr_group();


		// 検索処理を行う
		ManualsDAO mDAO = new ManualsDAO();

		List<Manuals> manualList = mDAO.select(new Manuals(manual_name, group));

				// 検索結果をリクエストスコープに格納する
				request.setAttribute("manualList", manualList);

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manual_search_result.jsp");
				dispatcher.forward(request, response);
			}
		}












