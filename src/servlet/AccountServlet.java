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

		//ユーザー情報の現在の情報を持ってくるselect
		HttpSession session = request.getSession();
		LoginUser user_ID = (LoginUser)session.getAttribute("user_ID");
		String user = user_ID.getLoginUserId();
		System.out.println("user_ID:"+user);

//		 ユーザーの検索処理を行う
		AccountsDAO accountDao = new AccountsDAO();
        List<Accounts> accountList = accountDao.pr_account(new Accounts(user));

//		 検索結果をリクエストスコープに格納する
		request.setAttribute("accountList", accountList);
		//フォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/account_update.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

//リクエストスコープから取得
	request.setCharacterEncoding("UTF-8");
	String user_ID = request.getParameter("user_ID");
	String mail = request.getParameter("mail");
	String password = request.getParameter("password");
	String newPassword = request.getParameter("newPassword");
	String nickname = request.getParameter("nickname");

//セッションスコープから取得
//グループ参加機能ができてから実装
//	HttpSession session = request.getSession();
//	Accounts pr_group = (Accounts)session.getAttribute("pr_group");
//	int group = pr_group.getPr_group();
//	System.out.println("pr_group:"+pr_group);

//古いパスワードをセッションスコープから取得
//新しいパスワード変更の場合分け
	HttpSession session = request.getSession();
	Accounts pass = (Accounts)session.getAttribute("pw");
	String oldPass = pass.getPw();
	if(newPassword != "" && password == oldPass) {
		password = newPassword;
	}
	else {//失敗の時
		request.setAttribute("result","前のパスワードが正しくありません");
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/account_update.jsp");
		dispatcher.forward(request, response);


	}
	//データの更新
	AccountsDAO accountDao = new AccountsDAO();
    if (accountDao.update(new Accounts(user_ID,mail,password,nickname,1)))
    {
    	System.out.println("アカウント更新成功");
    	System.out.println(mail);
//		request.setAttribute("result",
//		new Result("登録成功！", "レコードを登録しました。", "/simpleBC/MenuServlet"));
//	}
//	else {												// 登録失敗
//		request.setAttribute("result",
//		new Result("登録失敗！", "レコードを登録できませんでした。", "/simpleBC/MenuServlet"));
	}

	// 結果ページにフォワードする
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manual.jsp");
	dispatcher.forward(request, response);

	}

}
