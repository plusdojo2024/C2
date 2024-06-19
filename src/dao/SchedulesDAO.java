//スケジュールを操作するプログラム(DAO) 登録・更新・削除
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Schedules;

public class SchedulesDAO {


	//登録
	public boolean insert(Schedules s_detail) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO schedules VALUES (NULL, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			pStmt.setInt(1, s_detail.getGroup_number());
			if (s_detail.getTask() != null && !s_detail.getTask().equals("")) {
				pStmt.setString(2, s_detail.getTask());
			}
			else {
				pStmt.setString(2, "（未設定）");
			}
			if (s_detail.getContents() != null && !s_detail.getContents().equals("")) {
				pStmt.setString(3, s_detail.getContents());
			}
			else {
				pStmt.setString(3, "（未設定）");
			}
			pStmt.setString(4, s_detail.getRegister());

			// SQL文を実行する　一件登録できたら成功
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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





	//更新
	public boolean update(Schedules s_detail) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE schedules SET task=?, contents=?, register=? WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (s_detail.getTask() != null && !s_detail.getTask().equals("")) {
				pStmt.setString(1, s_detail.getTask());
			}
			else {
				pStmt.setString(1, null);
			}

			if (s_detail.getContents() != null && !s_detail.getContents().equals("")) {
				pStmt.setString(2, s_detail.getContents());
			}
			else {
				pStmt.setString(2, null);
			}

			pStmt.setString(3, s_detail.getRegister());

			pStmt.setInt(4, s_detail.getId());

			// SQL文を実行する　一件登録できたら成功
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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



	//削除
	public boolean delete(int id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql = "DELETE FROM schedules WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, id);

			// SQL文を実行する　一件登録できたら成功
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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
