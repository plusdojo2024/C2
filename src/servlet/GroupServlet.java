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
/**
 * Servlet implementation class GroupServlet
 */
@WebServlet("/GroupServlet")
public class GroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_ID") == null) {
			response.sendRedirect("/C2/LoginServlet");
			return;
		}

		//ユーザーごとに所属しているグループのデータを取得
		LoginUser login = (LoginUser)session.getAttribute("user_ID");
		String user = login.getLoginUserId();

		//GroupsDAOに処理してもらう
		GroupsDAO groupsDao = new GroupsDAO();
        List<Groups> cardList = groupsDao.select(user);


		//リクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		//ここから現在のグループ名を表示する処理
				//pr_groupを取得
				Accounts group = (Accounts)session.getAttribute("pr_group");
				int pr_group = group.getPr_group();
				GroupsDAO gDao = new GroupsDAO();
		        List<Groups> cList = gDao.selectGroupName(pr_group);
				Groups g = cList.get(0);
				String group_name =g.getGroup_name();
		        request.setAttribute("group_name", group_name);
		//ここまで現在のグループ名を表示する処理


		// グループ一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/group.jsp");
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_ID") == null) {
			response.sendRedirect("/C2/LoginServlet");
			return;
		}


		//反映されているかの確認
		request.setCharacterEncoding("UTF-8");
		String group_name = request.getParameter("changeGroup");
		System.out.println("グループ名：" + group_name);
		String getGroupID = request.getParameter("chgGrpID");
		int group_id = Integer.parseInt(getGroupID);
		System.out.println("グループ番号：" + group_id);

		//ユーザーごとに所属しているグループのデータを取得
		LoginUser login = (LoginUser)session.getAttribute("user_ID");
		String user = login.getLoginUserId();

		//グループの切り替え処理
		AccountsDAO accountsdao = new AccountsDAO();
		boolean change = accountsdao.changeGroup(new Accounts(group_id, user));

		//セッションスコープ情報の書き換え
		session.setAttribute("user_ID", new LoginUser(user, group_id));
		session.setAttribute("pr_group", new Accounts(group_id));

		//反映されているかの確認
		System.out.println("ログインユーザー：" + user);
		System.out.println("更新結果：" + change);

		// ホームページ（マニュアルページ）にリダイレクトする
		response.sendRedirect("/C2/ManualServlet");



	}

}
