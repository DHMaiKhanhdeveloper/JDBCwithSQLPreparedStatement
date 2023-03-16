package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;

public class TestJDBCUtil {

	public static void main(String[] args) {
		
//		Connection connection = JDBCUtil.getConnection();
//		
//		JDBCUtil.printInfo(connection);
//		
//		JDBCUtil.closeConnection(connection);
		
		try {
			// Bước 1: Tạo kết nối
			Connection connection = JDBCUtil.getConnection();
			
			// Bước 2: Tạo ra đối tượng statement
			Statement st = connection.createStatement();
			
			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "INSERT INTO THAMGIADT(MAGV,MADT,STT,PHUCAP)"
					+ "VALUES ('001','002',5,5.0)";
			//run câu lệnh SQL
			int check = st.executeUpdate(sql);
			
			// Bước 4: xử lý kết quả 
			System.out.println("Số dòng thay đổi: "+ check);
			if(check>0) {
				System.out.println("Thêm dữ liệu thành công!");
			}else {
				System.out.println("Thêm dữ liệu thất bại!");
			}
			
			// Bước 5: ngắt kết nối
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
