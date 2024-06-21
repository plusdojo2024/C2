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

import dao.SchedulesDAO;
import model.Schedules;

/**
 * Servlet implementation class ScheduleUpdateServlet
 */
@WebServlet("/ScheduleUpdateServlet")
public class ScheduleUpdateServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_ID") == null) {
			response.sendRedirect("/famiLink/LoginServlet");
			return;
		}

		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));

		SchedulesDAO schedulesDao = new SchedulesDAO();
        List<Schedules> scheduleList = schedulesDao.selectDetail(id);

		request.setAttribute("scheduleList", scheduleList);
		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_update.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String task = request.getParameter("task");
		String contents = request.getParameter("contents");
		String register = request.getParameter("register");
		String d = request.getParameter("deadline");
		java.sql.Date deadline = Date.valueOf(d);

		// 更新または削除を行う
		SchedulesDAO sDao = new SchedulesDAO();

		//"Update" == "更新"
		if (request.getParameter("submit").equals("更新")) {

		if (sDao.update(new Schedules(task, contents, register,deadline,id))) {		// 更新成功

				request.setAttribute("result","内容を更新しました。");
				System.out.println("スケジュール更新成功");
		}
		else {			// 更新失敗
				request.setAttribute("result","内容を更新できませんでした。");
				System.out.println("スケジュール更新失敗");
		}
		}
		else if(request.getParameter("submit").equals("削除")) {
			if (sDao.delete(id)) {	// 削除成功
				request.setAttribute("result", "削除しました。");
			}
			else {			// 削除失敗
				request.setAttribute("result", "削除できませんでした。");
			}
		}

		//リダイレクト
		response.sendRedirect("/C2/TaskServlet");

	}
}
