package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountsDAO;
import model.Accounts;

/**
 * Servlet implementation class AccountRegistServlet
 */
@WebServlet("/AccountRegistServlet")
public class AccountRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create_account.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String user_ID = request.getParameter("user_ID");
		String mail = request.getParameter("mail");
		String pw = request.getParameter("pw");
		String nickname = request.getParameter("nickname");

		AccountsDAO accountsDAO = new AccountsDAO();
        if (accountsDAO.insert(new Accounts(user_ID,mail,pw,nickname,0)))
        {
        	System.out.println("成功");
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create_account_result.jsp");
    		dispatcher.forward(request, response);
        }
        else {
        	System.out.println("失敗");
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create_account.jsp");
    		dispatcher.forward(request, response);
        }


	}

}
