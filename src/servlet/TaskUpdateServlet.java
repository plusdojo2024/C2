package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManualsDAO;
import dao.TasksDAO;
import model.Accounts;
import model.Manuals;
import model.Tasks;

/**
 * Servlet implementation class TaskUpdateServlet
 */
@WebServlet("/TaskUpdateServlet")
public class TaskUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskUpdateServlet() {
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

		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));

		TasksDAO tasksDao = new TasksDAO();
        List<Tasks> taskList = tasksDao.selectDetail(id);

		request.setAttribute("taskList", taskList);
//マニュアルリンクのプルダウンにグループの全てのmanual_name,idを埋め込む
    //セッションスコープからpr_groupを取得
		Accounts group = (Accounts)session.getAttribute("pr_group");
		int pr_group = group.getPr_group();

    //pr_groupを使用して全てのマニュアルを検索
		ManualsDAO mDao = new ManualsDAO();
        List<Manuals> manualList = mDao.selectManuals(pr_group);

    //結果リストを格納
        request.setAttribute("manualList", manualList);

	// taskページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/task_update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String i = request.getParameter("id");
		System.out.println(i);
		int id= Integer.parseInt(i);
		String task = request.getParameter("task");
		String contents = request.getParameter("contents");
		String d= request.getParameter("deadline");
		String register = request.getParameter("register");
		String to = request.getParameter("to");
		String bool = request.getParameter("checkbox");
		int manual_id=Integer.parseInt(request.getParameter("manual_id"));
		java.sql.Date deadline = Date.valueOf(d);
		ManualsDAO mDao = new ManualsDAO();
		List<Manuals> manualNameList = mDao.selectManualName(manual_id);
		String manual_link;
		if(manual_id!=0) {//マニュアルリンクが選択されている
			Manuals m=manualNameList.get(0);
			manual_link = m.getManual_name();
		}
		else{//マニュアルリンクが未選択
			manual_link = "未登録";
		}

		boolean checkbox = false;
        String yes = "yes";
		if (yes.equals(bool)) {
			checkbox = true;
		}

		TasksDAO bTask = new TasksDAO();
		// 登録処理を行う
		if (request.getParameter("submit").equals("更新")) {
			if (bTask.update(new Tasks(task, contents, deadline, register, to,
				checkbox,manual_link,manual_id,id))) {	// 登録成功
				request.setAttribute("result", "レコードを登録しました。");
			}
			else {												// 登録失敗
				request.setAttribute("result", "レコードを登録できませんでした。");
			}
		}
		else if(request.getParameter("submit").equals("削除")){
			if (bTask.delete(id)) {	// 削除成功
				request.setAttribute("result", "レコードを削除しました。");
			}
			else {						// 削除失敗
				request.setAttribute("result", "レコードを削除できませんでした。");
			}
		}

		// 結果ページにフォワードする
		response.sendRedirect("/C2/TaskServlet");
	}
}

