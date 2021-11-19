package com.user.homecontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

@RestController
public class HomeController {

	@Autowired
	UserService us;
	
	@PostMapping("/saveuser")
	public String SaveUser(@RequestBody User u)
	{
		us.saveUser(u);
		
		return "User saved successfully";	
	}
	
	@GetMapping("/getuserbypin/{pincode}")
	public List<User> findByPincode(@PathVariable int pincode)
	{
		List<User> slist=us.getUser(pincode);
		
		return slist;	
	}
	
	@GetMapping("/getuserbysurname/{surname}")
	public List<User> findBySurname(@PathVariable String surname)
	{
	
		List<User> slist=us.getUserBySurname(surname);
		
		return slist;
	}
	
	@DeleteMapping("/harddelete/{userid}")
	public void hardDelete(@PathVariable int userid)
	{
		us.hardDelete(userid);
		
	}
	
	@GetMapping("/edituser/{userid}")
	public User editUser(@PathVariable int userid)
	{
		User user=us.editUser(userid);
		
		return user;
	}
	
	
	@PutMapping("/update")
	public String updateUser(@RequestBody User u)
	{
		us.updateUser(u);
		
		return "User Updated Successfully";
	}
	
	@DeleteMapping("/softdelete/{userid}")
	public String softDelete(@PathVariable int userid)
	{
		us.softDelete(userid);
		
		return "User Softly Deleted";
	}

    @GetMapping("/sortbydob/{field}")
	public List<User> sortByDob(@PathVariable String field)
	{
	 List<User> slist=us.sortByDob(field);
		
		return slist;
	}


    @GetMapping("/sortbyjoiningdate/{field}")
    public List<User> sortByJoiningDate(@PathVariable String field)
    {
    	List<User> slist=us.sortByJoiningDate(field);
    	
    	return slist;
    }
    
}


