package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Sach;

public class SachDAO implements DAOInterface<Sach>{

	
	public static SachDAO getInstance() {
		return new SachDAO();
	}
	
	@Override
	public int insert(Sach t) {
		
		int ketQua = 0;
		try {
			
			Connection con = JDBCUtil.getConnection();
			
			
//			Statement st = con.createStatement();
			
		
			String sql = "INSERT INTO sach (id, tenSach, giaBan, namXuatBan) "+
						" VALUES (?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getId());
			st.setString(2, t.getTenSach());
			st.setFloat(3, t.getGiaBan());
			st.setInt(4, t.getNamXuatBan());
//			st.setString(3, String.valueOf(t.getGiaBan()));
//			st.setString(4, String.valueOf(t.getNamXuatBan()));
			
			ketQua = st.executeUpdate();
			
		
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
		
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int update(Sach t) {
	
		int ketQua = 0;
		try {
			
			Connection con = JDBCUtil.getConnection();
			
		
//			Statement st = con.createStatement();
			
			
			String sql = "UPDATE sach "+
						 " SET " +
						 " tenSach=?"+
						 ", giaBan=?"+
						 ", namXuatBan=?"+
						 " WHERE id=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, t.getTenSach());
			st.setFloat(2, t.getGiaBan());
			st.setInt(3, t.getNamXuatBan());
			st.setString(4, t.getId());
			
			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int delete(Sach t) {
		
		int ketQua = 0;
		try {
			
			Connection con = JDBCUtil.getConnection();
			
//		
//			Statement st = con.createStatement();
			
			
			String sql = "DELETE from sach "+
						 " WHERE id=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getId());
			
			System.out.println(sql);
			ketQua = st.executeUpdate();
			
		
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public ArrayList<Sach> selectAll() {
	
		ArrayList<Sach> ketQua = new ArrayList<Sach>();
		try {
	
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
//			Statement st = con.createStatement();
			

			
			String sql = "SELECT * FROM sach";
			PreparedStatement st = con.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				float giaBan = rs.getFloat("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				
				Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
				ketQua.add(sach);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public Sach selectById(Sach t) {
	
		Sach ketQua = null;
		try {
		
			Connection con = JDBCUtil.getConnection();
			

			
			String sql = "SELECT * FROM sach where id=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getId());
			
			
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				float giaBan = rs.getFloat("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				
				ketQua = new Sach(id, tenSach, giaBan, namXuatBan);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<Sach> selectByCondition(String condition) {
		
		ArrayList<Sach> ketQua = new ArrayList<Sach>();
		try {

			Connection con = JDBCUtil.getConnection();
			
			
			String sql = "SELECT * FROM sach where "+ condition;
			
			PreparedStatement st = con.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			

			while(rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				float giaBan = rs.getFloat("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				
				Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
				ketQua.add(sach);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

}
