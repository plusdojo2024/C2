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
		int autoIncrementKey = 0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			//groupsDBの処理
			String sql = "INSERT INTO groups VALUES (NULL, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);

			// SQL文を完成させる
			//グループ名の登録
			if (card.getGroup_name() != null && !card.getGroup_name().equals("")) {
				pStmt.setString(1, card.getGroup_name());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}

			//アイコンの登録
			if (card.getIcon() != null && !card.getIcon().equals("")) {
				pStmt.setString(2, card.getIcon());
			}
			else {
				pStmt.setString(2, "（未設定）");
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

			//実行時に生成されたAIkeyの取得
			ResultSet rs = pStmt.getGeneratedKeys();
			if(rs.next()) {
				autoIncrementKey = rs.getInt(1);
			}
			System.out.println(autoIncrementKey);

			/*アカウントの登録
			if (card.getUser_ID() != null && !card.getUser_ID().equals("")) {
				pStmt.setString(2, card.getUser_ID());
			}
			else {
				pStmt.setString(2, "（未設定）");
			}*/


			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			//group_menberDBの処理
			String sql_member = "INSERT INTO groups_member VALUES (NULL, ?, ?, ?, true)";
			PreparedStatement pStmt_menber = conn.prepareStatement(sql_member);

			// SQL文を完成させる
			//グループIDの登録
			if (card.getGroup_name() != null && !card.getGroup_name().equals("")) {
				pStmt_menber.setInt(1, autoIncrementKey);//グループID*DBから引用
			}
			else {
				pStmt_menber.setString(1, "（未設定）");
			}
			//グループ名の登録
			if (card.getGroup_name() != null && !card.getGroup_name().equals("")) {
				pStmt_menber.setString(2, card.getGroup_name());
			}
			else {
				pStmt_menber.setString(2, "（未設定）");
			}
			//アカウントの登録
			if (card.getUser_ID() != null && !card.getUser_ID().equals("")) {
				pStmt_menber.setString(3, card.getUser_ID());
			}
			else {
				pStmt_menber.setString(3, "（未設定）");
			}
			// SQL文を実行する
			if (pStmt_menber.executeUpdate() == 1) {
				result = true;
			}
		}	//tryend


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


	// グループ（アイコン、グループ名）を更新し、成功したらtrueを返す
	public boolean update(Groups g_list) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する(UPDATE)
			String sql = "UPDATE groups set group_name =?, icon =? WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を準備する(UPDATE)GROUPS_MEMBER
			String sql1 = "UPDATE groups_member set group_name =? WHERE group_id=?";
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);

			// SQL文を完成させる
			pStmt.setString(1, g_list.getGroup_name());
			pStmt.setString(2, g_list.getIcon());
			pStmt.setInt(3, g_list.getId());

			// SQL文を完成させるgroups_member
			pStmt1.setString(1, g_list.getGroup_name());
			pStmt1.setInt(2, g_list.getId());

			// SQL文を実行する　一件登録できたら成功
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

			// SQL文を実行する　一件登録できたら成功groups_member
			if (pStmt1.executeUpdate() == 1) {
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


	//メンバーの招待チェック
	public boolean cheack(String name) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			//SQLを準備する
			String sql = "SELECT COUNT(*) FROM ACCOUNTS WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setString(1, name);

			// SQL文を実行する　一件登録できたら成功
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("COUNT(*)") == 1) {
				result = true;
				//↓コンソール確認↓
				System.out.println();
				System.out.println("追加したいユーザを見つけました。");
			}
			else {
				//↓コンソール確認↓
				System.out.println();
				System.out.println("追加したいユーザが見つかりませんでした。");
				System.out.println();
			}
		}	//tryEnd
		catch (SQLException e) {
			e.printStackTrace();
		}	//catchEnd1
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	//catchEnd2
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
		}	//finallyEnd
		return result;
	}


	//メンバーの招待
	public boolean invite(int group_id, String group_name, String user_id) {

		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			//SQLを準備する
			String sql = "INSERT INTO groups_member VALUES  (NULL, ?, ?, ?, true)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setInt(1, group_id);

			pStmt.setString(2, group_name);

			pStmt.setString(3, user_id);

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


	//メンバーの招待チェック
		public boolean cheack2(int g_id, String name) {
			Connection conn = null;
			boolean result = true;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

				//SQLを準備する
				String sql = "SELECT COUNT(*) FROM groups_member WHERE group_id = ? AND user_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//SQL文を完成させる
				pStmt.setInt(1, g_id);
				pStmt.setString(2, name);

				// SQL文を実行する　一件登録できたら成功
				ResultSet rs = pStmt.executeQuery();

				// ユーザーIDが一致するユーザーがいたかどうかをチェックする
				rs.next();
				if (rs.getInt("COUNT(*)") == 1) {
					result = false;
					//↓コンソール確認↓
					System.out.println();
					System.out.println("ユーザーが重複しています。");
				}
			}	//tryEnd
			catch (SQLException e) {
				e.printStackTrace();
			}	//catchEnd1
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}	//catchEnd2
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
			}	//finallyEnd
			return result;
		}


	//ユーザーの追放
	public boolean delete(int g_id, String g_UserId) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");

			// SQL文を準備する
			String sql = "DELETE FROM groups_member WHERE group_id =? and user_ID =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, g_id);
			pStmt.setString(2, g_UserId);

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
			String sql = "SELECT * FROM groups_member WHERE group_id  =?";
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


	//groupの詳細表示
	public List<Groups> select(String card) {
		Connection conn = null;
		List<Groups> cardList = new ArrayList<Groups>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");
			// SQL文を準備する
			String sql = "SELECT * FROM groups_member WHERE user_ID  =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, card);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Groups record = new Groups(
						rs.getString("group_name"),
						rs.getInt("group_id"),
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


	//groupの一覧表示
	public List<Groups> selectGroupName(int pr_group) {
		Connection conn = null;
		List<Groups> cardList = new ArrayList<Groups>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/famiLink", "sa", "");
			// SQL文を準備する
			String sql = "SELECT * FROM groups WHERE ID  =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, pr_group);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Groups record = new Groups(
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
}

