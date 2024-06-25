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
import model.Accounts;
import model.Groups;
import model.LoginUser;

/**
 * Servlet implementation class GroupCreateServlet
 */
@WebServlet("/GroupCreateServlet")
public class GroupCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupCreateServlet() {
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
		//ここから現在のグループ名を表示する処理
				//pr_groupを取得
				Accounts group = (Accounts)session.getAttribute("pr_group");
				int pr_group = group.getPr_group();
				GroupsDAO gDao = new GroupsDAO();
		        List<Groups> cardList = gDao.selectGroupName(pr_group);
				Groups g = cardList.get(0);
				String group_name =g.getGroup_name();
		        request.setAttribute("group_name", group_name);
		//ここまで現在のグループ名を表示する処理

		//グループ新規登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create_group.jsp");
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

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String group_name = request.getParameter("group_name");
		String icon = request.getParameter("icon");

		//ユーザーごとに所属しているグループのデータを取得
		LoginUser user_ID = (LoginUser)session.getAttribute("user_ID");
		String user = user_ID.getLoginUserId();


		//GroupsDAOに処理してもらう
		GroupsDAO abc = new GroupsDAO();
		if (abc.insert(new Groups(group_name,icon,user))) {
			request.setAttribute("result", "レコードを登録しました。");

			//登録後のリストを取得
			List<Groups> cardList = abc.select(user);
			request.setAttribute("cardList", cardList);

			//登録したリストをフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/group.jsp");
    		dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("result", "レコードの登録できません。");

			//登録できなかった際はcreate_groupにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create_group.jsp");
    		dispatcher.forward(request, response);
		}





			}


 	}

