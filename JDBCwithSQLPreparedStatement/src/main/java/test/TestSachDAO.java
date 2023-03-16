package test;

import java.util.ArrayList;


import dao.SachDAO;
import model.Sach;

public class TestSachDAO {

	public static void main(String[] args) {
		
//		Sach sach1 = new Sach("LTHH", "Lập trình C", 60000, 2435);
////		Sach sach2 = new Sach("LTC", "Lập trình C", 70000, 2030);
//		SachDAO.getInstance().insert(sach1);
		
		
//		for (int i = 0; i < 10; i++) {
//			Sach sach = new Sach("LT"+i, "Lập trình i: "+i, 20000, 2015);
//			SachDAO.getInstance().insert(sach);
//		}
		
		
//		Sach sach2 = new Sach("LTHH", "Lập trình C#", 1000, 2230);
//		SachDAO.getInstance().update(sach2);
		
		
//		for (int i = 0; i < 10; i++) {
//			Sach sach = new Sach("LT"+i, "Lập trình i: "+i, 20000, 2015);
//			SachDAO.getInstance().delete(sach);
//		}
		
//		Sach sach = new Sach("LTHH", "Lập trình C#", 1000, 2230);
//		SachDAO.getInstance().delete(sach);
		
		
		ArrayList<Sach> list = SachDAO.getInstance().selectAll();
		for (Sach sach : list) {
			System.out.println(sach.toString());
		}
		
		System.out.println("---------------------");
		Sach find = new Sach();
		find.setId("LTC");
		Sach sach2 = SachDAO.getInstance().selectById(find);
		System.out.println(sach2);
		
//		
//		User u_find = new User("x\' or 1=1; -- ", "", "");
//		User u_result = UserDAO.getInstance().selectById(u_find);
//		System.out.println(u_result)
		
		System.out.println("---------------------");
		ArrayList<Sach> list2 = SachDAO.getInstance().selectByCondition("giaBan<70000");
		for (Sach sach : list2) {
			System.out.println(sach.toString());
		}
	}

}
