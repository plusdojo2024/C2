package test;
import java.util.List;

import dao.ManualsDAO;
import model.Manuals;


public class ManualsDAOTest {
	public static void main(String[] args) {
		ManualsDAO dao = new ManualsDAO();
			// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Manuals> manualList2 = dao.select(new Manuals());

		for (Manuals manualitems : manualList2) {
			System.out.println("マニュアル名" + manualitems.getManual_name());
			System.out.println();
		}
	}
}