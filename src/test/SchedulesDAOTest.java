package test;
import java.util.List;

import dao.SchedulesDAO;
import model.Schedules;

public class SchedulesDAOTest {
	public static void main(String[] args) {
		SchedulesDAO dao = new SchedulesDAO();
		List<Schedules> List;

		// insertメソッドのテスト
		int upDelNumber = 0;		// 後で更新および削除する番号
		System.out.println("<< insertメソッドのテスト（1件のレコードを登録します）>>");
		Schedules insRec = new Schedules(0, 0, "挿入", "挿入", null, "挿入");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
		}
		else {
			System.out.println("登録失敗！");
		}
		System.out.println();

		// updateメソッドのテスト
		System.out.println("<< updateメソッドのテスト（1件のレコードを更新します）>>");

		Schedules upRec = new Schedules(1, 0, "更新", "更新", null, "更新");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
		}
		else {
			System.out.println("更新失敗！");
		}
		System.out.println();


		// deleteメソッドのテスト
		System.out.println("<< deleteメソッドのテスト（1件のレコードを削除します）>>");
		if (dao.delete(1)) {
			System.out.println("削除成功！");
		}
	else {
			System.out.println("削除失敗！");
		}

	}
}

