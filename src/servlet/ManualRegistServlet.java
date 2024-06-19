package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemsDAO;
import dao.ManualsDAO;
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
		String contents = request.getParameter("content");
		String images = request.getParameter("images");
		String manual_name = request.getParameter("title");
		//String today = request.getParameter("today");

		//java.sql.Date date = Date.valueOf(today);

		//System.out.println(heading);
		//System.out.println(contents);
		//System.out.println(images);

		// 登録処理を行う
		ItemsDAO bItems = new ItemsDAO();
		ManualsDAO bManuals = new ManualsDAO();
		bManuals.manu(new Items(0, heading, contents, images, manual_name, group_id));
		int manualId = bManuals.count(group_id);
		if (bItems.insert(new Items(0, manualId, heading, contents, images, manual_name, group_id))) {	// 登録成功
			request.setAttribute("result",new Result("登録成功！", "レコードを登録しました。"));
		}
		else {												// 登録失敗
			request.setAttribute("result", new Result("登録失敗！", "レコードを登録できませんでした。"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manual_resist.jsp");
		dispatcher.forward(request, response);
	}

}
