package vn.iotstar.services;

import vn.iotstar.model.UserModel;

public interface UserServices {
	UserModel login(String username, String password);
	UserModel get(String username);
	boolean register(String email, String password, String userName, String fullName, String phone);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String userName);
	boolean checkExistPhone(String phone);
}
