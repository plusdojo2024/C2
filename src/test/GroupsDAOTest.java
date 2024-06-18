package test;
import java.util.List;

import dao.GroupsDAO;
import model.Groups;

public class GroupsDAOTest {
	public static void main(String[] args) {
		GroupsDAO dao = new GroupsDAO();
		List<Groups> cardList;

		// insertメソッドのテスト
		int upDelNumber = 0;		// 後で更新および削除する番号
		System.out.println("<< insertメソッドのテスト（1件のレコードを登録します）>>");
		Groups insRec = new Groups(0, "挿入", "挿入", true, "挿入");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			cardList = dao.select(insRec);
			for (Groups card : cardList) {
				upDelNumber = card.getId();	// 最後のレコードを後で更新および削除する
			}
		}
		else {
			System.out.println("登録失敗！");
		}
		System.out.println();



		// updateメソッドのテスト
		System.out.println("<< updateメソッドのテスト（1件のレコードを更新します）>>");
		Groups upRec = new Groups(0, "更新", "更新", true, "更新");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
		}
		else {
			System.out.println("更新失敗！");
		}
		System.out.println();


		// deleteメソッドのテスト
		System.out.println("<< deleteメソッドのテスト（1件のレコードを削除します）>>");
		if (dao.delete("挿入")) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}

		// selectメソッドのテスト
		System.out.println("<< selectメソッドのテスト（すべてのレコードを検索します）>>");
		cardList = dao.select("z");
		for (Groups card : cardList) {
			System.out.println("グループ：" + card.getUser_ID());
			System.out.println("グループ：" + card.getGroup_name());
		}
	}
}
