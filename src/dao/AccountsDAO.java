package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Accounts;

public class AccountsDAO {
	// 登録
	public boolean insert(Accounts account) {
		Connection conn = null;
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO Accounts Values (?,?,?,?,0)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (account.getUser_ID() != null && !account.getUser_ID().equals("")) {
				pStmt.setString(1, account.getUser_ID());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			if (account.getMail() != null && !account.getMail().equals("")) {
				pStmt.setString(2, account.getMail());
			}
			else {
				pStmt.setString(2, "（未設定）");
			}
			if (account.getPw() != null && !account.getPw().equals("")) {
				pStmt.setString(3, account.getPw());
			}
			else {
				pStmt.setString(3, "（未設定）");
			}
			if (account.getNickname() != null && !account.getNickname().equals("")) {
				pStmt.setString(4, account.getNickname());
			}
			else {
				pStmt.setString(4, "（未設定）");
			}
//SQL文を実行する。
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
	public boolean update(Accounts account) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE Accounts SET user_ID=?, mail=?, pw=?, nickname=?, pr_group=? WHERE user_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (account.getUser_ID() != null && !account.getUser_ID().equals("")) {
				pStmt.setString(1, account.getUser_ID());
			}
			else {
				pStmt.setString(1, null);
			}
			if (account.getMail() != null && !account.getMail().equals("")) {
				pStmt.setString(2, account.getMail());
			}
			else {
				pStmt.setString(2, null);
			}
			if (account.getPw() != null && !account.getPw().equals("")) {
				pStmt.setString(3, account.getPw());
			}
			else {
				pStmt.setString(3, null);
			}
			if (account.getNickname() != null && !account.getNickname().equals("")) {
				pStmt.setString(4, account.getNickname());
			}
			else {
				pStmt.setString(4, null);
			}
			if (account.getPr_group() != 0) {
				pStmt.setInt(5, account.getPr_group());
			}
			else {
				pStmt.setInt(5, 0);
			}
			pStmt.setString(6, account.getUser_ID());

			// SQL文を実行する
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
//表示グループの切り替え

	public boolean changeGroup(Accounts account) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE Accounts SET pr_group=? WHERE user_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (account.getPr_group() != 0) {
				pStmt.setInt(1, account.getPr_group());
			}
			else {
				pStmt.setInt(1, 0);
			}
			pStmt.setString(2, account.getUser_ID());

			// SQL文を実行する
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
