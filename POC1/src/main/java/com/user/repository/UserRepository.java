package com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.model.User;

@Repository
public interface UserRepository extends  JpaRepository<User, Integer>{

	public List<User> findAllByPincode(int pincode);
	
	public List<User> findAllBySurname(String surname);
	
	public User findById(int userid);
	
	public List<User> findByDob(String dob);
	
}
