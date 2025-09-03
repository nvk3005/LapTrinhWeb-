package vn.iotstar.dao;

import vn.iotstar.model.UserModel;

public interface UserDao {
	public UserModel get(String username);
	public void insert(UserModel user);
	public boolean checkExistEmail(String email);
	public boolean checkExistUsername(String userName);
	public boolean checkExistPhone(String phone);
}
