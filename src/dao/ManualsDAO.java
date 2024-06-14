package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Manuals;

public class ManualsDAO {

	// マニュアル項目を検索し、検索結果のリストを返す
	public List<Manuals> select (Manuals manualitems) {
		Connection conn = null;
		List<Manuals> manualitemsList = new ArrayList<Manuals>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql ="SELECT * FROM Manuals WHERE manual_name LIKE ? AND group_number = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (manualitems.getManual_name() != null) {
				pStmt.setString(1, "%" + manualitems.getManual_name() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}

			if (manualitems.getGroup_number() !=0) {
				pStmt.setInt(2, manualitems.getGroup_number());
			}
			else {
				pStmt.setInt(2, 0);
			}


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Manuals record = new Manuals(
				rs.getString("manual_name")
				);
				manualitemsList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			manualitemsList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			manualitemsList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					manualitemsList = null;
				}
			}
		}

		// 結果を返す
		return manualitemsList;
	}





}
