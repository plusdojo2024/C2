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
			response.sendRedirect("/famiLink/LoginServlet");
			return;
		}


		//ユーザー情報の現在の情報を持ってくるselect
		HttpSession session2 = request.getSession();
		LoginUser user_ID = (LoginUser)session2.getAttribute("user_ID");
		String user = user_ID.getLoginUserId();
		System.out.println("user_ID:"+user);
		int groupID = user_ID.getGroupId();
		System.out.println("group_ID:"+ groupID);

		//group_idでマニュアルを検索する処理を行う
		ManualsDAO manualsDao = new ManualsDAO();
        List<Manuals> manualNameList = manualsDao.selectManuals(new Manuals(groupID));

        //検索結果をリクエストスコープに格納する
		request.setAttribute("manualNameList", manualNameList);

		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manual.jsp");
		dispatcher.forward(request, response);
/*
//		 ユーザーの検索処理を行う
		AccountsDAO accountDao = new AccountsDAO();
        List<Accounts> accountList = accountDao.pr_account(new Accounts(user));

//		 検索結果をリクエストスコープに格納する
		request.setAttribute("accountList", accountList);
		LoginUser login = (LoginUser)session.getAttribute("id_group");
		request.setAttribute("id_group",login);

		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manual.jsp");
		dispatcher.forward(request, response);



	//大戸バージョン

		//group_idをセッションから取りだす大戸
		HttpSession session3 = request.getSession();
		LoginUser user_group = (LoginUser)session3.getAttribute("group_id");


		int group_number = user_group.getGroupId();
		System.out.println("group_id"+group_number);

		//group_idでマニュアルを検索する処理を行う
		ManualsDAO manualsDao = new ManualsDAO();
        List<Manuals> manualNameList = manualsDao.selectManuals(new Manuals(group_number));

        //検索結果をリクエストスコープに格納する
		request.setAttribute("manualNameList", manualNameList);

		// 登録ページにフォワードする
		RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/jsp/manual.jsp");
		dispatcher2.forward(request, response);
*/

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
		String group=request.getParameter("pr_group");
		int pr_group=Integer.parseInt(group);
		System.out.println("pr_group");
		//セッションスコープから取得




		// 検索処理を行う
		ManualsDAO mDAO = new ManualsDAO();

		List<Manuals> manualList = mDAO.select(new Manuals(manual_name, pr_group));

				// 検索結果をリクエストスコープに格納する
				request.setAttribute("manualList", manualList);

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manual_search_result.jsp");
				dispatcher.forward(request, response);
			}
		}












