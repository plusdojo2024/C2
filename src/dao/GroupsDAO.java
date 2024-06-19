package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Groups;

public class GroupsDAO {
	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す;
	public boolean insert(Groups card) {

		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO groups VALUES (NULL, ?, ?, true, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			//グループ名の登録
			if (card.getGroup_name() != null && !card.getGroup_name().equals("")) {
				pStmt.setString(1, card.getGroup_name());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}

			//アカウントの登録
			if (card.getUser_ID() != null && !card.getUser_ID().equals("")) {
				pStmt.setString(2, card.getUser_ID());
			}
			else {
				pStmt.setString(2, "（未設定）");
			}

			//アイコンの登録
			if (card.getIcon() != null && !card.getIcon().equals("")) {
				pStmt.setString(3, card.getIcon());
			}
			else {
				pStmt.setString(3, "（未設定）");
			}

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


	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Groups card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE groups SET group_name=?, icon=?,editer=? where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			//グループ名の変更、更新
			if (card.getGroup_name() != null && !card.getGroup_name().equals("")) {
				pStmt.setString(1, card.getGroup_name());
			}
			else {
				pStmt.setString(1, null);
			}

			//アイコンの更新
			if (card.getIcon() != null && !card.getIcon().equals("")) {
				pStmt.setString(2, card.getIcon());
			}
			else {
				pStmt.setString(2, null);
			}

			//編集者権限の更新

			pStmt.setBoolean(3, card.isEditer());

			pStmt.setInt(4, card.getId());

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



	// 引数user_IDで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(String user_ID) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql = "DELETE FROM groups WHERE user_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, user_ID);

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



	// グループの詳細表示
	public List<Groups> select(int group) {
		Connection conn = null;
		List<Groups> cardList = new ArrayList<Groups>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");
			// SQL文を準備する
			String sql = "SELECT * FROM groups WHERE id  =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1,group);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Groups record = new Groups(
				rs.getString("user_ID"),
				rs.getString("group_name")
				);
				cardList.add(record);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}


	//groupの一覧表示
public List<Groups> select(String card) {
	Connection conn = null;
	List<Groups> cardList = new ArrayList<Groups>();

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");
		// SQL文を準備する
		String sql = "SELECT * FROM groups WHERE user_ID  =?";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		pStmt.setString(1, card);

		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		while (rs.next()) {
			Groups record = new Groups(
			rs.getString("group_name"),
			rs.getInt("id"),
			rs.getString("user_ID"));
			cardList.add(record);

		}
	}

	catch (SQLException e) {
		e.printStackTrace();
		cardList = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		cardList = null;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardList = null;
			}
		}
	}

	// 結果を返す
	return cardList;
}
}

