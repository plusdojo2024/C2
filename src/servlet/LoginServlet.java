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

import dao.AccountsDAO;
import model.Accounts;
import model.LoginUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_ID= request.getParameter("user_ID");
		String pw = request.getParameter("pw");

		// ログイン処理を行う
		AccountsDAO aDao = new AccountsDAO();
		if (  aDao.isLoginOK(  new Accounts( user_ID, pw )   )  ) {	// ログイン成功

////セッションスコープにpr_groupを格納する
//		 ユーザーの検索処理を行う
		AccountsDAO accountDao = new AccountsDAO();
        List<Accounts> accountList = accountDao.pr_account(new Accounts(user_ID));
//		検索結果からpr_groupを取得
		Accounts g = accountList.get(0);
		int pr_group =g.getPr_group();


			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("user_ID", new LoginUser(user_ID, pr_group));
			session.setAttribute("group_ID", new Accounts(pr_group));
			System.out.println("user_ID:"+user_ID+".pr_group:"+pr_group+".ログイン成功");
			// マニュアルサーブレットにリダイレクトする
			response.sendRedirect("/C2/ManualServlet");
		}
		else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result","ログイン失敗！");
			System.out.println("ログイン失敗");

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
