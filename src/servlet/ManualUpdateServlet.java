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
	}	//doGetメソッドの処理終了

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
			System.out.println();
			System.out.println("-------ManualUpdate画面-------");//デバック用

			// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
				//マニュアルのidを取り出す
				int intManual_ID = Integer.parseInt(request.getParameter("manual_id"));
				System.out.println("manual_ID:"+intManual_ID);//コンソール確認(デバック用)

				//更新メソッド判定用パラメータの取得
				String post1 = request.getParameter("manual_update");
				System.out.println("Post1値変更前:" + post1);//コンソール確認(デバック用)
				if(post1 == null) {
					post1 = "このメソッドは呼ばれていません。";
				}
				System.out.println("Post1値変更後:" + post1);//コンソール確認(デバック用)

				//削除メソッド判定用パラメータの取得
				String post2 = request.getParameter("manual_delete");
				System.out.println("Post2値変更前:" + post2);//コンソール確認(デバック用)
				if(post2 == null) {
					post2 = "このメソッドは呼ばれていません。";
				}
				System.out.println("Post2値変更後:" + post2);//コンソール確認(デバック用)

			//インスタンスの生成
			ItemsDAO bManuals = new ItemsDAO();


			//doPostの分岐1：更新を押した場合の処理
			if(post1.equals("OK")){
				//更新に必要なリクエストパラメータを取り出す
				String manual_name = request.getParameter("heading");
				String[] items = request.getParameterValues("header");
				String[] contents = request.getParameterValues("contents");
				String[] images = request.getParameterValues("images");

				// 登録処理を行う
				if (bManuals.update(intManual_ID, manual_name, items, contents, images)) {	// 登録成功
					request.setAttribute("result", new Result("更新成功！", "レコードを登録しました。") );
				}
				else {												// 登録失敗
					request.setAttribute("result",  new Result("更新失敗！", "レコードを登録できませんでした。"));
				}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/task_update.jsp");
				dispatcher.forward(request, response);
			}	//更新を押したときの処理ブロック終了


			//doPostの分岐2：削除を押した場合の処理
			else if (post2.equals("Delete")){
				//削除処理を行う
				if (bManuals.delete(intManual_ID)) {	// 削除成功
					request.setAttribute("result", new Result("削除成功！", "レコードを削除しました。") );
				}
				else {	// 削除失敗
					request.setAttribute("result",  new Result("削除失敗！", "レコードを削除できませんでした。"));
				}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/task_update.jsp");
				dispatcher.forward(request, response);
			}	//削除を押したときの処理ブロック終了


			//doPostの分岐3：一覧から詳細を開く場合の処理
			else {
				//manual_idでマニュアルを検索する処理を行う
				List<Items> itemList = bManuals.selectItems(intManual_ID);

				//検索結果をリクエストスコープに格納する
				request.setAttribute("itemList", itemList);

				// 詳細ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/manual_update.jsp");
				dispatcher.forward(request, response);
			}	//詳細を押したときの処理ブロック終了
		}	//ログインしていた場合の処理終了
	}	//doPostメソッドの処理終了
}
