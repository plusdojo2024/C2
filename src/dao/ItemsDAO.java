package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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


			//Manualsに項目を一つ増やす
			String sql_manual = "INSERT INTO Manuals VALUES (NULL, ?, ?)";
			PreparedStatement pStmt_manual = conn.prepareStatement(sql_manual);

			// SQL文を完成させる

			pStmt_manual.setInt(1, manualregist.getGroup_number());

			pStmt_manual.setString(2, manualregist.getManual_Name());

			int  manual_number = 0;
			// SQL文を実行する
			if (pStmt_manual.executeUpdate() == 1) {
				result = true;

				String sql_manual_select = "SELECT * FROM MANUALS WHERE MANUAL_NAME = ?";
				PreparedStatement pStmt_manual_select = conn.prepareStatement(sql_manual_select);
				pStmt_manual_select.setString(1, manualregist.getManual_Name());
				ResultSet rs = pStmt_manual_select.executeQuery();
				manual_number = rs.getInt("ID");
			}



			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO Items VALUES (NULL,? , ?, ?, ?, CURRENT_TIMESTAMP)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, manual_number);
			if (manualregist.getHeading() != null && !manualregist.getHeading().equals("")) {
				pStmt.setString(2, manualregist.getHeading());
			}
			else {
				pStmt.setString(2, "（未設定）");
			}
			if (manualregist.getContents() != null && !manualregist.getContents().equals("")) {
				pStmt.setString(3, manualregist.getContents());
			}
			else {
				pStmt.setString(3, "（未設定）");
			}
			if (manualregist.getImage() != null && !manualregist.getImage().equals("")) {
				pStmt.setString(4, manualregist.getImage());
			}
			else {
				pStmt.setString(4, "（未設定）");
			}
				//pStmt.setDate(5, manualregist.getRegist_day());
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
				}
			else {
				result = false;
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
				String sql = "DELETE FROM items WHERE manual_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);;


				// SQL文を完成させる
				pStmt.setInt(1, manualupdate.getManual_id());

				// SQL文を実行する　一件登録できたら成功
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}

				//insertのバージョンを作る
				String sql2 = "INSERT INTO Items VALUES (NULL,NULL, ?, ?, ?, ?)";
				PreparedStatement pStmt3 = conn.prepareStatement(sql2);

				// SQL文を完成させる
				if (manualupdate.getHeading() != null && !manualupdate.getHeading().equals("")) {
					pStmt3.setString(1, manualupdate.getHeading());
				}
				else {
					pStmt3.setString(1, "（未設定）");
				}
				if (manualupdate.getContents() != null && !manualupdate.getContents().equals("")) {
					pStmt3.setString(2, manualupdate.getContents());
				}
				else {
					pStmt3.setString(2, "（未設定）");
				}
				if (manualupdate.getImage() != null && !manualupdate.getImage().equals("")) {
					pStmt3.setString(3, manualupdate.getImage());
				}
				else {
					pStmt3.setString(3, "（未設定）");
				}
					pStmt3.setDate(4, manualupdate.getRegist_day());


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


		// マニュアルを削除して、成功したらtrueを返す
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
