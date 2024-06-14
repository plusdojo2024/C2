package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GroupsDAO;
import model.Groups;

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
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/famiLink/LoginServlet");
			return;
		}

		//グループ新規登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create_group.jsp");
		dispatcher.forward(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/famiLink/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String group_name = request.getParameter("name");
		String icon = request.getParameter("images");

		// 登録処理を行う
		GroupsDAO abc = new GroupsDAO();
		if (abc.insert(new Groups(group_name,icon))) {
			request.setAttribute("result", "レコードを登録しました。");
		}
		else {
			request.setAttribute("result", "レコードの登録できません。");
		}

		//登録後にグループ一覧画面にフォワードする。
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/group.jsp");
				dispatcher.forward(request, response);
			}


 	}

