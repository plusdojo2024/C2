package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Tasks;

public class TasksDAO {

	//日付で検索するselect
	public List<Tasks> select(Tasks task) {
		Connection conn = null;
		List<Tasks> taskList = new ArrayList<Tasks>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql ="SELECT * FROM TASKS WHERE register LIKE ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			Date today= Date.valueOf(LocalDate.now());
	        java.sql.Date d = java.sql.Date.valueOf("2024-06-20");
			// SQL文を完成させる
			pStmt.setString(1,task.getRegister());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Tasks record = new Tasks(
				rs.getInt("id"),
				rs.getBoolean("checkbox"),
				rs.getString("task"),
				rs.getString("to")
				);
				taskList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			taskList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			taskList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					taskList = null;
				}
			}
		}

		// 結果を返す
		return taskList;
	}

	//doGetでのタスク一覧表示:select
	public List<Tasks> selectTaskList(int group_number) {
		Connection conn = null;
		List<Tasks> taskList = new ArrayList<Tasks>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql ="SELECT * FROM TASKS WHERE group_number = ? AND today = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			Date today= Date.valueOf(LocalDate.now());
			pStmt.setInt(1,group_number);
			pStmt.setDate(2,today);
			System.out.println("今日の日付："+Date.valueOf(LocalDate.now()));
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Tasks record = new Tasks(
				rs.getInt("id"),
				rs.getBoolean("checkbox"),
				rs.getString("task"),
				rs.getString("to")
				);
				taskList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			taskList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			taskList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					taskList = null;
				}
			}
		}

		// 結果を返す
		return taskList;
	}
	//doGetでのスケジュール一覧表示
	public List<Tasks> selectScheduleList(int group_number) {
		Connection conn = null;
		List<Tasks> taskList = new ArrayList<Tasks>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql ="SELECT * FROM TASKS WHERE group_number = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			pStmt.setInt(1,group_number);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Tasks record = new Tasks(
				rs.getInt("id"),
				rs.getBoolean("checkbox"),
				rs.getString("task")
				);
				taskList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			taskList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			taskList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					taskList = null;
				}
			}
		}

		// 結果を返す
		return taskList;
	}

	//タスクの登録(成功でtrueを返す):insert
	public boolean insert(Tasks list) {

		Connection conn = null;
		boolean result = false;

		//registの処理内容
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO Tasks VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			//group_number文
				pStmt.setInt(1, list.getGroup_number());
			//task文
			if (list.getTask() != null && !list.getTask().equals("")) {
				pStmt.setString(2, list.getTask());
			}
			else {
				pStmt.setString(2, "（未設定）");
			}
			//Contents文
			if (list.getContent() != null && !list.getContent().equals("")) {
				pStmt.setString(3, list.getContent());
			}
			else {
				pStmt.setString(3, "（未設定）");
			}
			//today文
				pStmt.setDate(4, list.getDay());
			//from文
				pStmt.setString(5, list.getRegister());
			//to文
			if (list.getTo() != null && !list.getTo().equals("")) {
				pStmt.setString(6, list.getTo());
			}
			else {
				pStmt.setString(6, "全員");
			}
			//taskCheckBox文
				pStmt.setBoolean(7, list.isCheckbox());
			//manual文
			if (list.getManual_link() != null && !list.getManual_link().equals("")) {
				pStmt.setString(8, list.getManual_link());
			}
			else {
				pStmt.setString(8, "");
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}

		//エラー処理
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		//DB切断
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		//結果を返す
		return result;
	}



	//タスクの更新(成功でtrueを返す):update
	public boolean update(Tasks up) {

		Connection conn = null;
		boolean result = false;

		//処理内容
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE Tasks SET task=?, contents=?, today=?, register=?, to=? WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			//task文
			if (up.getTask() != null && !up.getTask().equals("")) {
				pStmt.setString(1, up.getTask());
			}
			else {
				pStmt.setString(1, null);
			}
			//Contents文
			if (up.getContent() != null && !up.getContent().equals("")) {
				pStmt.setString(2, up.getContent());
			}
			else {
				pStmt.setString(2, null);
			}
			//day文
				pStmt.setDate(3, up.getDay());
			//from文
				pStmt.setString(4, up.getRegister());
			//to文
			if (up.getTo() != null && !up.getTo().equals("")) {
				pStmt.setString(5, up.getTo());
			}
			else {
				pStmt.setString(5, "全員");
			}
			//id文
			pStmt.setInt(6, up.getId());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

		}

		//エラー処理
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		//DB切断
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}



	//タスクの削除(成功でtrueを返す):delete
	public boolean delete(int number) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql = "DELETE FROM Tasks WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, number);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}

		//errar
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		//DB切断
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
}
