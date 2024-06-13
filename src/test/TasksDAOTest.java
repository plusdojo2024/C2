package test;
import java.sql.Date;
import java.util.List;

import dao.TasksDAO;
import model.Tasks;

public class TasksDAOTest {
	public static void main(String[] args) {
		TasksDAO dao = new TasksDAO();
		List<Tasks> tasksList;

		//insert_test
		String today = "2024-06-13";
		java.sql.Date date = Date.valueOf(today);

		int upDelNumber = 0;		// 後で更新および削除する番号
		System.out.println("<< insertメソッドのテスト（1件のレコードを登録します）>>");
		Tasks insRec = new Tasks(0, 0, "Task", "Contents", date, "From", "to", true, "");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			tasksList = dao.select(insRec);
			for (Tasks card : tasksList) {
				upDelNumber = card.getId();;	// 最後のレコードを後で更新および削除する
			}
		}
		else {
			System.out.println("登録失敗！");
		}
		System.out.println();

		// selectメソッドのテスト
		System.out.println("<< selectメソッドのテスト（すべてのレコードを検索します）>>");
		tasksList = dao.select(new Tasks());
		for (Tasks card : tasksList) {
			System.out.println("ID：" + card.getId());
			System.out.println("グループナンバー:" + card.getGroup_number());
			System.out.println("タスク名：" + card.getTask());
			System.out.println("内容：" + card.getContents());
			System.out.println("期限：" + card.getToday());
			System.out.println("from：" + card.getRegister());
			System.out.println("to：" + card.getTo());
			System.out.println("チェックボックス：" + card.isCheckbox());
			System.out.println("マニュアルリンク：" + card.getManual_link());
		}

		// updateメソッドのテスト
		System.out.println("<< updateメソッドのテスト（1件のレコードを更新します）>>");
		Tasks upRec = new Tasks(upDelNumber, 0, "更新", "更新", date, "更新", "更新", true, "");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			tasksList = dao.select(upRec);
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
