package test;

import java.sql.Date;

import dao.ItemsDAO;
import model.Items;

public class ItemsDAOTest {
	public static void main(String[] args) {
		ItemsDAO dao = new ItemsDAO();

		String today = "2024-06-13";
		java.sql.Date date = Date.valueOf(today);

		// insertメソッドのテスト
		int updelid = 0;		// 後で更新および削除するid
		System.out.println("<< insertメソッドのテスト（1件のレコードを登録します）>>");
		Items insRec = new Items(0, 0, "挿入", "挿入", "挿入", date);
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");

			updelid = 5;	// 最後のレコードを後で更新および削除する

		}
		else {
			System.out.println("登録失敗！");
		}
		System.out.println();



		// updateメソッドのテスト
		System.out.println("<< updateメソッドのテスト（1件のレコードを更新します）>>");
		Items upRec = new Items(updelid, 0, "更新", "更新", "更新", date);
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			//itemsList = dao.select(upRec);
		}
		else {
			System.out.println("更新失敗！");
		}
		System.out.println();



		// deleteメソッドのテスト
		System.out.println("<< deleteメソッドのテスト（1件のレコードを削除します）>>");
		if (dao.delete(updelid)) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}
	}

}
