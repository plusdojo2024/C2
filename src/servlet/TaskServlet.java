package servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SchedulesDAO;
import dao.TasksDAO;
import model.Accounts;
import model.Schedules;
import model.Tasks;

/**
 * Servlet implementation class TaskServlet
 */
@WebServlet("/TaskServlet")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskServlet() {
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
		//pr_groupをセッションから取得
		HttpSession session2 = request.getSession();
		Accounts pr_group = (Accounts)session2.getAttribute("pr_group");
		int group_number = pr_group.getPr_group();
		System.out.println("group:"+group_number);

		//検索処理をおこなう
		Date today= Date.valueOf(LocalDate.now());
		TasksDAO taskDao = new TasksDAO();
        List<Tasks> taskList = taskDao.selectTaskList(group_number,today);

		//リクエストスコープに格納する
		request.setAttribute("taskList", taskList);

		//検索処理をおこなう
		SchedulesDAO schedulesDao = new SchedulesDAO();
        List<Schedules> schedulesList = schedulesDao.selectList(group_number);

		//リクエストスコープに格納する
		request.setAttribute("schedulesList", schedulesList);

		// taskページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/task.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//タスクリストを取得
		// リクエストパラメータを取得する.HTML内の入力内容
		request.setCharacterEncoding("UTF-8");
		String hiduke = request.getParameter("deadline");
		System.out.println("hiduke;"+hiduke);
		Date deadline = Date.valueOf(hiduke);

		// 検索処理を行う
		if (request.getParameter("submit").equals("DLchange")) {
		TasksDAO taskDao = new TasksDAO();
		List<Tasks> taskList = taskDao.select(deadline);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("taskList", taskList);

//スケジュールリストを取得
		//pr_groupをセッションから取得
		HttpSession session2 = request.getSession();
		Accounts pr_group = (Accounts)session2.getAttribute("pr_group");
		int group_number = pr_group.getPr_group();
		System.out.println("group:"+group_number);

		//検索処理をおこなう
		SchedulesDAO schedulesDao = new SchedulesDAO();
        List<Schedules> schedulesList = schedulesDao.selectList(group_number);

		//リクエストスコープに格納する
		request.setAttribute("schedulesList", schedulesList);
		}
		else if(request.getParameter("submit").equals("SD")) {

		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/task.jsp");
		dispatcher.forward(request, response);

	}

}
