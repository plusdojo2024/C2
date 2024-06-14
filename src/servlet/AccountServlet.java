package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		//フォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/account_update.jsp");
		dispatcher.forward(request, response);

		//ユーザー情報の現在の情報を持ってくる。
		HttpSession session = request.getSession();
	String user_ID = String.toString(session.getAttribute("user_ID"));
		System.out.println(session.getAttribute("user_ID"));
		// 検索処理を行う
//		AccountsDAO accountDao = new AccountsDAO();
//        List<Accounts> accountList = accountDao.select(new Accounts(user_ID,mail,pw,nickname));

		// 検索結果をリクエストスコープに格納する
//		request.setAttribute("accountList", accountList);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
