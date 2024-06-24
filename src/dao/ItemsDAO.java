package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Items;

public class ItemsDAO {


	// マニュアルの項目を登録し、成功したらtrueを返す
	public int insert(Items manualregist) {
		Connection conn = null;
		boolean result = false;
		int autoIncrementKey = 0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");


			//Manualsに項目を一つ増やす
			String sql_manual = "INSERT INTO Manuals VALUES (NULL, ?, ?)";
			PreparedStatement pStmt_manual = conn.prepareStatement(sql_manual, java.sql.Statement.RETURN_GENERATED_KEYS);

			// SQL文を完成させる
			System.out.println("");//デバック用
			System.out.println("--------登録処理-------");//デバック用
			pStmt_manual.setInt(1, manualregist.getGroup_number());
			System.out.println("ItemsDAO/group_ID:"+ manualregist.getGroup_number());//デバック用
			pStmt_manual.setString(2, manualregist.getManual_Name());
			System.out.println("ItemsDAO/group_name:"+ manualregist.getManual_Name());//デバック用

			// SQL文を実行する
			if (pStmt_manual.executeUpdate() == 1) {
				result = true;
			}

			//AI取得
			ResultSet r = pStmt_manual.getGeneratedKeys();
			if(r.next()){
				autoIncrementKey = r.getInt(1);
			}
			System.out.println("ItemsDAO/AI:"+ autoIncrementKey);//デバック用

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO Items VALUES (NULL,?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, autoIncrementKey);
			pStmt.setString(2, manualregist.getManual_Name());
			if (manualregist.getHeading() != null && !manualregist.getHeading().equals("")) {
				pStmt.setString(3, manualregist.getHeading());
			}
			else {
				pStmt.setString(3, "（未設定）");
			}
			if (manualregist.getContents() != null && !manualregist.getContents().equals("")) {
				pStmt.setString(4, manualregist.getContents());
			}
			else {
				pStmt.setString(4, "（未設定）");
			}
			if (manualregist.getImage() != null && !manualregist.getImage().equals("")) {
				pStmt.setString(5, manualregist.getImage());
			}
			else {
				pStmt.setString(5, "（未設定）");
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
			System.out.println("登録結果:" + result);
		}

		// 結果を返す
		return autoIncrementKey;
	}


	// 登録の処理2
	public boolean insert2(int manual_id, String manual_name, String[] items, String[] contents, String[] images) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql = "DELETE FROM items WHERE manual_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, manual_id);

			// SQL文を実行する　一件登録できたら成功
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

			//insertのバージョンを作る
			String sql3 = "INSERT INTO Items VALUES (NULL, ?,  ?, ?, ?, ?, CURRENT_TIMESTAMP)";
			PreparedStatement pStmt3 = conn.prepareStatement(sql3);

			// SQL文を完成させる
			int i = 0;

			pStmt3.setInt(1, manual_id);
			pStmt3.setString(2, manual_name);
			while(i < items.length) {
				if (items[i] != null && !items[i].equals("")) {
					pStmt3.setString(3, items[i]);
				}
				else {
					pStmt3.setString(3, "（未設定）");
				}
				if (contents[i] != null && !contents[i].equals("")) {
					pStmt3.setString(4, contents[i]);
				}
				else {
					pStmt3.setString(4, "（未設定）");
				}
				if (images[i] != null && !images[i] .equals("")) {
					pStmt3.setString(5, images[i] );
				}
				else {
					pStmt3.setString(5, "（未設定）");
				}
				if (pStmt3.executeUpdate() != 1) {
					result = false;
					break;
				}
				System.out.println("項目登録数:" + (i + 1));//デバック用
				i ++;
			}//while end
			if(i == items.length) {
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
	public boolean update(int manual_id, String manual_name, String[] items, String[] contents, String[] images) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql = "DELETE FROM items WHERE manual_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			String sql2 = "UPDATE MANUALS SET MANUAL_NAME = ? WHERE id=?";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);


			// SQL文を完成させる
			pStmt.setInt(1, manual_id);
			pStmt2.setString(1, manual_name);
			pStmt2.setInt(2, manual_id);

			// SQL文を実行する　一件登録できたら成功
			pStmt.executeUpdate();
			if(pStmt2.executeUpdate() == 1) {
				result = true;
				System.out.println("Manuals更新成功:ItemsDAO228");//デバック用
			}
			else {
				System.out.println("Manuals更新失敗:ItemsDAO231");//デバック用
			}

			//insertのバージョンを作る
			String sql3 = "INSERT INTO Items VALUES (NULL, ?,  ?, ?, ?, ?, CURRENT_TIMESTAMP)";
			PreparedStatement pStmt3 = conn.prepareStatement(sql3);

			// SQL文を完成させる
			int i = 0;

			pStmt3.setInt(1, manual_id);
			pStmt3.setString(2, manual_name);
			while(i < items.length) {
				if (items[i] != null && !items[i].equals("")) {
					pStmt3.setString(3, items[i]);
				}
				else {
					pStmt3.setString(3, "（未設定）");
				}
				if (contents[i] != null && !contents[i].equals("")) {
					pStmt3.setString(4, contents[i]);
				}
				else {
					pStmt3.setString(4, "（未設定）");
				}
				/*if (images[i] != null && !images[i] .equals("")) {
					pStmt3.setString(5, images[i] );
				}
				else {
					pStmt3.setString(5, "（未設定）");
				}
				*/

				pStmt3.setString(5, "image" );

				if (pStmt3.executeUpdate() != 1) {
					result = false;
					break;
				}
				System.out.println("項目登録数:" + (i + 1));//デバック用
				i ++;
			}//while end
			if(i == items.length) {
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
			String sql = "DELETE FROM Items WHERE manual_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			String sql2 = "DELETE FROM Manuals WHERE id=?";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			// SQL文を完成させる
			pStmt.setInt(1, id);
			pStmt2.setInt(1, id);

			// SQL文を実行する
			pStmt.executeUpdate();
			if (pStmt2.executeUpdate() == 1) {
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




	//大戸作成
	//マニュアルIDでマニュアルの詳細を表示する
	public List<Items> selectItems(int items) {
		Connection conn = null;
		List<Items> itemList = new ArrayList<Items>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql ="SELECT * FROM Items WHERE manual_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, items);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Items record = new Items(
						rs.getInt("id"),
						rs.getInt("manual_id"),
						rs.getString("heading"),
						rs.getString("contents"),
						rs.getString("image"),
						rs.getDate("regist_day"),
						rs.getString("manual_name")
						);
				System.out.println("ItemsDAOの結果表/ID:" + rs.getInt("id"));//デバック用
				System.out.println("ItemsDAOの結果表/manual_name:" + rs.getString("manual_name"));//デバック用
				itemList.add(record);
			}
			System.out.println("ItemsDAOの詳細/itemList:"+ itemList);//デバック用
		}
		catch (SQLException e) {
			e.printStackTrace();
			itemList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			itemList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					itemList = null;
				}
			}
		}

		// 結果を返す
		return itemList;
	}

	//松岡作成
	//ホームから検索を行う処理
	public List<Items> seach(int ID, String title) {
		Connection conn = null;
		List<Items> seachList = new ArrayList<Items>();

		//処理内容
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql ="SELECT * FROM Items WHERE manual_name Like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if(title != null) {
				pStmt.setString(2, "%" + title + "%");
			}
			else {
				pStmt.setString(2, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Items record = new Items(
						rs.getInt("id"),
						rs.getInt("manual_id"),
						rs.getString("heading"),
						rs.getString("contents"),
						rs.getString("image"),
						rs.getDate("regist_day"),
						rs.getString("manual_name")
						);
				seachList.add(record);
			}
		}	//try終了タグ
		catch (SQLException e) {
			e.printStackTrace();
			seachList = null;
		}	//catch終了タグ1
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			seachList = null;
		}	//catch終了タグ2
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					seachList = null;
				}
			}
		}	//finally終了タグ

		return seachList;
	}	//seach処理終了タグ
}
