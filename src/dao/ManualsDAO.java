package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Items;
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

	public boolean manu(Items manualregist) {
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

			// SQL文を実行する
			if (pStmt_manual.executeUpdate() == 1) {
				result = true;
			}
		}//try終了タグ
		//エラー処理
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//finaly処理
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
			//結果をコンソールに表示（確認用）
			System.out.println("manualの登録結果" + result);
		}
		// 結果を返す
		return result;
	}//manu_Method終了タグ



	public int count(int groupNum) {

		//変数設定
		Connection conn = null;
		int countNumber = 0;	// 後で更新および削除する番号
		List<Manuals> manualList = select(new Manuals());

		try {

			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");


			//SQL文の準備
			String sql = "SELECT * FROM MANUALS WHERE GROUP_NUMBER = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SQL文の完成
			pStmt.setInt(1, groupNum);
			//SQL文の実行および結果の取得
			ResultSet rs = pStmt.executeQuery();
			//結果表のコピー
			while (rs.next()) {
				Manuals record = new Manuals(
					rs.getString("manual_name"),
					rs.getInt("ID")
				);
				manualList.add(record);
			}
			//count処理
			for (Manuals list : manualList) {
				countNumber = list.getId();	// 最後のレコードを後で更新および削除する
			}
		}	//try終了タグ
		//エラー処理
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//finaly処理
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
			//結果をコンソールに表示（確認用）
			System.out.println("countNumber" + countNumber);
		}
		//戻り値
		return countNumber;
	}	//count_Method終了タグ



	//大戸作成
	//グループ番号からマニュアルを選択して画面に表示する
	public List<Manuals> selectManuals(Manuals manuals) {

		//変数設定
		Connection conn = null;
		int countNumber = 0;	// 後で更新および削除する番号
		List<Manuals> manualNameList = select(new Manuals()); //これなんだ？？？

		try {

			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");


			//SQL文の準備
			String sql = "SELECT manual_name FROM MANUALS WHERE GROUP_NUMBER = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文の完成
			pStmt.setInt(1, manuals.getGroup_number());

			//SQL文の実行および結果の取得
			ResultSet rs = pStmt.executeQuery();
			//結果表のコピー
			while (rs.next()) {
				Manuals record = new Manuals(
					rs.getString("manual_name")
				);
				manualNameList.add(record);
			}
		}	//try終了タグ
		//エラー処理
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//finaly処理
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
			//結果をコンソールに表示（確認用）
			System.out.println("countNumber" + countNumber);
		}
		//戻り値
		return manualNameList;
	}	//selectManuals終了タグ



}//manualDAO終了タグ
