package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.connection.DBConnect;
import vn.iotstar.dao.UserDao;
import vn.iotstar.model.UserModel;

public class UserDaoImpl implements UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	public UserModel get(String username) {
		String sql = "SELECT * FROM Users WHERE userName = ? ";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("username"));
				user.setFullName(rs.getString("fullname"));
				user.setPassWord(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createdDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO [Users](email, username, fullname, password, avatar, roleid,phone, createddate) VALUES (?,?,?,?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getFullName());
			ps.setString(4, user.getPassWord());
			ps.setString(5, user.getAvatar());
			ps.setInt(6, user.getRoleid());
			ps.setString(7, user.getPhone());
			ps.setDate(8, user.getCreatedDate());
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		String sql = "Select * from [Users] where email = ?";
		boolean duplicated = false;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next())
				duplicated = true;
			ps.close();
			conn.close();
			
		} catch (Exception ex) {	
		}
		return duplicated;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		String sql = "Select * from [Users] where phone = ?";
		boolean duplicated = false;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			if(rs.next())
				duplicated = true;
			ps.close();
			conn.close();
			
		} catch (Exception ex) {	
		}
		return duplicated;
	}

	@Override
	public boolean checkExistUsername(String userName) {
		// TODO Auto-generated method stub
		String sql = "Select * from [Users] where userName = ?";
		boolean duplicated = false;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if(rs.next())
				duplicated = true;
			ps.close();
			conn.close();
			
		} catch (Exception ex) {	
		}
		return duplicated;
	}
}
