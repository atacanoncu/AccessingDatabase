package DatabaseTest.DatabaseTest.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import DatabaseTest.DatabaseTest.Entities.User;
import DatabaseTest.DatabaseTest.Repositories.UserRepository;



@Controller
public class UserController {
	private UserRepository userRepository;
	
	
	
	@Autowired
    public void setProductService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	
	@GetMapping("/index")
	public String test() {
		return "Turkcell test!";
	}
	
	
	@GetMapping(path="/")
	  public @ResponseBody Iterable<User> getAllUsers() {
	    // This returns a JSON or XML with the users
	    return userRepository.findAll();
	  }
	
	@PostMapping(path="/add" , consumes = "application/json") // Map ONLY POST Requests
	  public @ResponseBody String addNewUser (@RequestBody User	user) {
	    // @ResponseBody means the returned String is the response, not a view name
	    User n = user ;
	    userRepository.save(n);
	    return "Saved";
	  }
	
	 @GetMapping(path="/user/show" , consumes = "application/json" )
	 public @ResponseBody User getProduct(@RequestBody User user) throws Exception{
		 
		 Optional<User> n = userRepository.findById(user.getUser_id());
		 //  userRepository.findById(user_id)
		 	
	     if(n.isPresent()) {
	    	return n.get();
	    	
	     }
	     else 
	    	 return new User();
	        
	    }
}
