package vn.iotstar.services;

import vn.iotstar.model.UserModel;

public interface UserServices {
	UserModel login(String username, String password);
	UserModel get(String username);
	boolean update(int id, String fullName, String phone, String avatar);
	boolean register(String email, String password, String userName, String fullName, String phone);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String userName);
	boolean checkExistPhone(String phone);
	void resetPassword(String email, String password);
}
