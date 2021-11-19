package com.user.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repository.UserRepository;
import com.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository ur;

	@Override
	public void saveUser(User u) {
		
		ur.save(u);
		
	}

	@Override
	public List<User> getUser(int pincode) {
		
		List<User> slist=ur.findAllByPincode(pincode);
		
		return slist;
	}

	@Override
	public List<User> getUserBySurname(String surname) {
		
		List<User> slist=ur.findAllBySurname(surname);
		
		return slist;
	}

	@Override
	public void hardDelete(int userid) {
	
		ur.deleteById(userid);
		
	}

	@Override
	public User editUser(int userid) {
	
		User us=ur.findById(userid);
		
		return us;
	}

	@Override
	public User updateUser(User u) {
		
		User user=ur.save(u);
		
		return user;
	}

	@Override
	public void softDelete(int userid) {
		
		ur.deleteById(userid);
		
	}

	@Override
	public List<User> sortByDob(String field) {
	
		List<User> slist=ur.findAll(Sort.by(Direction.DESC,field));

		return slist;
	}

	@Override
	public List<User> sortByJoiningDate(String field) {
	
		List<User> slist=ur.findAll(Sort.by(Direction.ASC,field));
		
		return slist;
	}
}

