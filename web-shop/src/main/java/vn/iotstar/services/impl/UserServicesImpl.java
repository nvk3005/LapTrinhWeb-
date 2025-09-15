package vn.iotstar.services.impl;

import vn.iotstar.dao.impl.UserDaoImpl;

import vn.iotstar.model.UserModel;
import vn.iotstar.services.UserServices;
import vn.iotstar.dao.UserDao;

public class UserServicesImpl implements UserServices{
	
	UserDao userDao = new UserDaoImpl();
	public UserModel login(String username, String password) {
		UserModel user = this.get(username);
		if(user != null && password.equals(user.getPassWord()))
			return user;
		return null;
	}
	
	@Override
	public boolean update(int id, String fullName, String phone, String avatar) {
		// TODO Auto-generated method stub
		return userDao.update(id, fullName, phone, avatar);
	}
	
	@Override
	public UserModel get(String username) {
		return userDao.get(username);	
	}
	
	@Override
	public boolean register(String email, String password, String userName, String fullName, String phone) {
		if(userDao.checkExistUsername(userName))
			return false;
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		userDao.insert(new UserModel(email, userName, fullName, password, null, 5, phone, date));
		return true;
	}
	
	@Override
	public boolean checkExistUsername(String userName) {
		// TODO Auto-generated method stub
		return userDao.checkExistUsername(userName);
	}
	
	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.checkExistEmail(email);
	}
	
	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return userDao.checkExistPhone(phone);
	}
	
	
	@Override
	public void resetPassword(String email, String password) {
		// TODO Auto-generated method stub
		userDao.resetPassword(email, password);
	}
}
