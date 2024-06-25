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

import dao.AccountsDAO;
import dao.GroupsDAO;
import dao.ManualsDAO;
import dao.TasksDAO;
import model.Accounts;
import model.Groups;
import model.LoginUser;
import model.Manuals;
import model.Tasks;

/**
 * Servlet implementation class TaskServletRegist
 */
@WebServlet("/TaskServletRegist")
public class TaskRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskRegistServlet() {
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
	//registerを自動登録
		//ユーザー情報の現在の情報を持ってくるselect
		HttpSession session2 = request.getSession();
		LoginUser user_ID = (LoginUser)session2.getAttribute("user_ID");
		String user = user_ID.getLoginUserId();

//		 ユーザーの検索処理を行う
		AccountsDAO accountDao = new AccountsDAO();
        List<Accounts> accountList = accountDao.pr_account(new Accounts(user));
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

//		 検索結果をリクエストスコープに格納する
		request.setAttribute("accountList", accountList);
//マニュアルリンクのプルダウンにグループの全てのmanual_name,idを埋め込む
      //セッションスコープからpr_groupを取得
		Accounts grp = (Accounts)session2.getAttribute("pr_group");
		int pr_group = grp.getPr_group();

	  //pr_groupを使用して全てのマニュアルを検索
		ManualsDAO mDao = new ManualsDAO();
        List<Manuals> manualList = mDao.selectManuals(pr_group);

        //結果リストを格納
        request.setAttribute("manualList", manualList);

		// taskページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/task_regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープから取得する
		HttpSession session = request.getSession();
		Accounts group = (Accounts)session.getAttribute("pr_group");
		int group_number = group.getPr_group();

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String task = request.getParameter("task");
		String content = request.getParameter("contents");
		String day = request.getParameter("day");
		java.sql.Date date = Date.valueOf(day);
		String register = request.getParameter("register");
		String to = request.getParameter("to");
		String checkbox = request.getParameter("checkbox");
		int manual_id=Integer.parseInt(request.getParameter("manual_id"));
		ManualsDAO mDao = new ManualsDAO();

		//manual_idをもとにマニュアル名を検索しリストに格納
		List<Manuals> manualNameList =mDao.selectManualName(manual_id);
		String manual_link;
		if(manual_id!=0) {//マニュアルリンクが選択されている
			Manuals m=manualNameList.get(0);
			manual_link = m.getManual_name();
		}
		else{//マニュアルリンクが未選択
			manual_link = null;
		}
				//		boolean boo1 = Boolean.valueOf(checkbox);
		//favoritesの値が"yes"かそれ以外の判定を行う。
		boolean check = false;
        String yes = "yes";
		if (yes.equals(checkbox)) {
			check = true;
		}
		// 登録処理を行う
		TasksDAO bTask = new TasksDAO();
		if (bTask.insert(new Tasks(0, group_number, task, content, date, register, to,
				check, manual_link,manual_id))) {	// 登録成功
			request.setAttribute("result", "レコードを登録しました。");
		}
		else {												// 登録失敗
			request.setAttribute("result", "レコードを登録できませんでした。");
		}

		// リダイレクトする
		response.sendRedirect("/C2/TaskServlet");
	}

}
