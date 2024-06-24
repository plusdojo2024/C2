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
import dao.GroupsDAO;
import model.Accounts;
import model.Groups;
import model.LoginUser;
import model.Result;

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

//		 ユーザーの検索処理を行う
		AccountsDAO accountDao = new AccountsDAO();
        List<Accounts> accountList = accountDao.pr_account(new Accounts(user));

//		 検索結果をリクエストスコープに格納する
		request.setAttribute("accountList", accountList);

//現在のグループ名を表示する処理
		//pr_groupを取得
		Accounts group = (Accounts)session.getAttribute("pr_group");
		int pr_group = group.getPr_group();
		GroupsDAO gDao = new GroupsDAO();
        List<Groups> cardList = gDao.selectGroupName(pr_group);
		Groups g = cardList.get(0);
		String group_name =g.getGroup_name();
		System.out.println("group_name"+group_name);
        request.setAttribute("pr_group", pr_group);

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

//リクエストスコープから取得(ユーザーが打ち込んだ情報)
	request.setCharacterEncoding("UTF-8");
	String user_ID = request.getParameter("user_ID");
	String mail = request.getParameter("mail");
	String password = request.getParameter("password");
	String newPassword = request.getParameter("newPassword");
	String nickname = request.getParameter("nickname");
	String pw = request.getParameter("pw");
	System.out.println("password:"+password);
	//password、newPasswordに入力があるとき、以前のパスワードと比較して新しいパスワードを登録
	if(password.equals(pw)) {
		password = newPassword;
	}
	else if(!newPassword.equals("") && !password.equals("") && !password.equals(pw)){//失敗の時
	request.setAttribute("result",new Result("登録失敗！", "パスワードが間違っています。"));
	}

	//データの更新
	AccountsDAO accountsDao = new AccountsDAO();
	//パスワードを含む更新
	if(!newPassword.equals("")) {
		if (accountsDao.update(new Accounts(user_ID,mail,password,nickname,1))){
			request.setAttribute("result",new Result("登録成功！", "アカウントを更新しました。"));
		}
		else {
			request.setAttribute("result",new Result("登録失敗！", "アカウントをできませんでした。"));
		}
	}
	//パスワードを含まない更新
	if(newPassword.equals("")) {
		if(accountsDao.updateWithoutPw(new Accounts(user_ID,mail,nickname,1))) {
			request.setAttribute("result",new Result("登録成功！", "アカウントを更新しました。"));
		}
		else {
			request.setAttribute("result",new Result("登録失敗！", "アカウントをできませんでした。"));
		}
	}

	// 結果ページにフォワードする
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/account_update.jsp");
	dispatcher.forward(request, response);

	}

}
