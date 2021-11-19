package com.user.service;

import java.util.List;

import com.user.model.User;

public interface UserService {

	public void saveUser(User u);
	
	public List<User> getUser(int pincode);
	
	public List<User> getUserBySurname(String surname);
	
	public void hardDelete(int userid);
	
	public User editUser(int rollno);
	
	public User updateUser(User u);
	
	public void softDelete(int userid);
	
	public List<User> sortByDob(String field);
	
	public List<User> sortByJoiningDate(String field);
}
