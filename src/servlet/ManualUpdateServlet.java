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

import dao.ItemsDAO;
import model.Items;
import model.Result;

/**
 * Servlet implementation class ManualUpdateServlet
 */
@WebServlet("/ManualUpdateServlet")
public class ManualUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManualUpdateServlet() {
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
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}

		// manualUpdateページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manual_update.jsp");
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

		else {//ログインしていた場合の処理
			/*
			//doPostの分岐1：マニュアルを押して詳細画面が出される場合の処理
			request.setCharacterEncoding("UTF-8");
			if(request.getParameter("manualID").equals("マニュアル詳細へ遷移")) {

				//マニュアルのidを取り出す
				HttpSession session2 = request.getSession();
				String manual_ID = (String)session2.getAttribute("manual_id");
				System.out.println("manual_ID:"+manual_ID);
				int intManual_ID = Integer.parseInt(manual_ID);


				//manual_idでマニュアルを検索する処理を行う
				ItemsDAO itemsDao = new ItemsDAO();
		        List<Items> itemList = itemsDao.selectItems(new Items(intManual_ID));

		        //検索結果をリクエストスコープに格納する
				request.setAttribute("itemList", itemList);

				// 詳細ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manual_update.jsp");
				dispatcher.forward(request, response);
			}*/
			//マニュアルのidを取り出す
			HttpSession session2 = request.getSession();
			String manual_ID = (String)session2.getAttribute("manual_id");
			System.out.println("manual_ID:"+manual_ID);
			int intManual_ID = Integer.parseInt(manual_ID);

			//doPostの分岐1：更新を押した場合の処理
			if(request.getParameter("manual_update").equals("OK")){

				// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				int number = Integer.parseInt(request.getParameter("id"));
				//String task = request.getParameter("group_id");
				//int group_id = Integer.parseInt(task);
				String[] items = request.getParameterValues("header");
				String[] contents = request.getParameterValues("contents");
				String[] images = request.getParameterValues("images");
				//String today = request.getParameter("today");

				//java.sql.Date date = Date.valueOf(today);

				ItemsDAO bManuals = new ItemsDAO();
				// 登録処理を行う
				if (request.getParameter("submit").equals("更新")) {
					if (bManuals.update(intManual_ID, items, contents, images)) {	// 登録成功
						request.setAttribute("result", new Result("更新成功！", "レコードを登録しました。") );
					}
					else {												// 登録失敗
						request.setAttribute("result",  new Result("更新失敗！", "レコードを登録できませんでした。"));
					}
				}
				else {
					if (bManuals.delete(number)) {	// 削除成功
						request.setAttribute("result", new Result("削除成功！", "レコードを削除しました。") );
					}
					else {						// 削除失敗
						request.setAttribute("result",  new Result("削除失敗！", "レコードを削除できませんでした。"));
					}
				}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/task_update.jsp");
				dispatcher.forward(request, response);
			}
			else {
				//doPostの分岐1：マニュアルを押して詳細画面が出される場合の処理
				//manual_idでマニュアルを検索する処理を行う
				ItemsDAO itemsDao = new ItemsDAO();
				List<Items> itemList = itemsDao.selectItems(new Items(intManual_ID));

				//検索結果をリクエストスコープに格納する
				request.setAttribute("itemList", itemList);

				// 詳細ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manual_update.jsp");
				dispatcher.forward(request, response);
				}
			}
		}

	}
