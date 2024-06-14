package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Items;

public class ItemsDAO {


	// マニュアルの項目を登録し、成功したらtrueを返す
	public boolean insert(Items manualregist) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO Items VALUES (NULL,NULL, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (manualregist.getHeading() != null && !manualregist.getHeading().equals("")) {
				pStmt.setString(1, manualregist.getHeading());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			if (manualregist.getContents() != null && !manualregist.getContents().equals("")) {
				pStmt.setString(2, manualregist.getContents());
			}
			else {
				pStmt.setString(2, "（未設定）");
			}
			if (manualregist.getImage() != null && !manualregist.getImage().equals("")) {
				pStmt.setString(3, manualregist.getImage());
			}
			else {
				pStmt.setString(3, "（未設定）");
			}
				pStmt.setDate(4, manualregist.getRegist_day());

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



	// マニュアルを更新し、成功したらtrueを返す
		public boolean update(Items manualupdate) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

				// SQL文を準備する
				String sql = "UPDATE Items SET heading=?, contents=?, image=?, regist_day=? WHERE id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (manualupdate.getHeading() != null && !manualupdate.getHeading().equals("")) {
					pStmt.setString(1, manualupdate.getHeading());
				}
				else {
					pStmt.setString(1, null);
				}
				if (manualupdate.getContents() != null && !manualupdate.getContents().equals("")) {
					pStmt.setString(2, manualupdate.getContents());
				}
				else {
					pStmt.setString(2, null);
				}
				if (manualupdate.getImage() != null && !manualupdate.getImage().equals("")) {
					pStmt.setString(3, manualupdate.getImage());
				}
				else {
					pStmt.setString(3, null);
				}
					pStmt.setDate(4, manualupdate.getRegist_day());
					pStmt.setInt(5, manualupdate.getId());

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



	// マニュアルを削除し、成功したらtrueを返す
		public boolean delete(int id) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

				// SQL文を準備する
				String sql = "DELETE FROM Items WHERE id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setInt(1, id);

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
