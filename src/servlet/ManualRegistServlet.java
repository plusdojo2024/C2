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
import dao.ItemsDAO;
import model.Accounts;
import model.Groups;
import model.Items;
import model.LoginUser;
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

		//ここから現在のグループ名を表示する処理
				//pr_groupを取得
				Accounts group = (Accounts)session.getAttribute("pr_group");
				int g = group.getPr_group();
				GroupsDAO gDao = new GroupsDAO();
		        List<Groups> cardList = gDao.selectGroupName(g);
				Groups gr = cardList.get(0);
				String group_name =gr.getGroup_name();
		        request.setAttribute("group_name", group_name);
		//ここまで現在のグループ名を表示する処理

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
		LoginUser group = (LoginUser)session.getAttribute("user_ID");
		int group_id = group.getGroupId();
		String heading = request.getParameter("item");
		String content = request.getParameter("content");
		String image = request.getParameter("images");
		String manual_name = request.getParameter("title");
		//String today = request.getParameter("today");

		String[] items = request.getParameterValues("item");
		String[] contents = request.getParameterValues("content");
		String[] images = request.getParameterValues("images");


		// 登録処理を行う
		ItemsDAO bItems = new ItemsDAO();
		int manual_id = bItems.insert(new Items(0, heading, content, image, manual_name, group_id));
		if (bItems.insert2(manual_id, manual_name, items, contents, images)) {	// 登録成功
			request.setAttribute("result",new Result("登録成功！", "レコードを登録しました。"));
		}
		else {												// 登録失敗
			request.setAttribute("result", new Result("登録失敗！", "レコードを登録できませんでした。"));
		}

		// 結果ページにフォワードする
		response.sendRedirect("/C2/ManualServlet");
	}

}
