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

import dao.GroupsDAO;
import model.Groups;
import model.LoginUser;


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
		if (session.getAttribute("user_ID") == null) {
			response.sendRedirect("/C2/LoginServlet");
			return;
		}

		//セッションスコープからpr_groupを持ってくる
		LoginUser groupID = (LoginUser)session.getAttribute("user_ID");
		int intGroupID = groupID.getGroupId();


		//pr_groupを使ってDBから情報持ってくる。
		GroupsDAO group = new GroupsDAO();
		List<Groups> GroupsList = group.select(intGroupID);

		//リクエストスコープに入れる
		request.setAttribute("GroupsList", GroupsList);


		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/group_update.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// // もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_ID") == null) {
			response.sendRedirect("/C2/LoginServlet");
			return;
		}

		//ユーザーごとに所属しているグループのデータを取得
		LoginUser login = (LoginUser)session.getAttribute("user_ID");
		String user = login.getLoginUserId();

		//セッションスコープからpr_groupを持ってくる
		LoginUser groupID = (LoginUser)session.getAttribute("user_ID");
		int intGroupID = groupID.getGroupId();


		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		//更新メソッド判定用パラメータの取得
		String post1 = request.getParameter("submit");
		System.out.println("Post1値変更前:" + post1);//コンソール確認(デバック用)
		if(post1 == null) {
			post1 = "このメソッドは呼ばれていません。";
		}
		System.out.println("Post1値変更後:" + post1);//コンソール確認(デバック用)



		String group_name = request.getParameter("group_name");
		String user_ID = request.getParameter("user_ID");
		Boolean editer = Boolean.valueOf(request.getParameter("editer"));
		String icon = request.getParameter("icon");
		String invite = request.getParameter("invite");
		System.out.println("招待状:" + invite);//デバック用
		String delete = request.getParameter("delete");
		System.out.println("追放:" + delete);//デバック用



		// 更新または削除を行う
		GroupsDAO sDao = new GroupsDAO();
		System.out.println("「"+request.getParameter("submit")+"」");



		//"Update" == "更新"
		if (post1.equals("登録")) {

			if (sDao.update(new Groups(intGroupID, group_name, user_ID, editer, icon))) {		// 更新成功

				request.setAttribute("result","内容を更新しました。");
			}
			else {			// 更新失敗
				request.setAttribute("result","内容を更新できませんでした。");
			}
		}
		else if(post1.equals("招待")) {
			if (sDao.invite(intGroupID, group_name, invite)) {		// 更新成功
				System.out.println(request.getParameter("submit") + "実行");
				request.setAttribute("result","内容を更新しました。");
			}
			else {			// 更新失敗
				request.setAttribute("result","内容を更新できませんでした。");
			}
		}

		else {
			if (sDao.delete(intGroupID,delete)) {	// 削除成功
				request.setAttribute("result", "削除しました。");
			}
			else {			// 削除失敗
				request.setAttribute("result", "削除できませんでした。");
			}
		}

		//GroupsDAOに処理してもらう
		GroupsDAO groupsDao = new GroupsDAO();
        List<Groups> cardList = groupsDao.select(user);


		//リクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/group.jsp");
		dispatcher.forward(request, response);
	}

}


