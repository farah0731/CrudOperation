package in.sp.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.sp.main.dao.UserDao;
import in.sp.main.entity.User;

@SpringBootApplication
public class SpringBootCrudOperationApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudOperationApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
	
//		User user1 = new User("farah khan","farah31","female","kanpur");
//	    boolean status = userDao.insertUser(user1);
//	    
//	    if(status) {
//	    	System.out.println("user inserted");
//	    }
//	    else {
//	    	System.out.println("user not inserted");
//	    }

		
		
//		 User user2 = new User("farah","farah@123","female" ,"lucknow");
//		 boolean status = userDao.updateUser(user2);
//		 if(status)
//		 {
//			 System.out.println("updation success");
//		 }
//		 else {
//			 System.out.println("updation failed");
//		 }
		 
		
		
//		 User user = new User("farah", "farah@123", "female", "lucknow");
//		    boolean updateStatus = userDao.updateUser(user);
//		    System.out.println(updateStatus ? "Update success" : "Update failed");
//		
		    
		    
		    User user = userDao.getUserByEmail("farah31");
		    System.out.println("Name :" +user.getName());
		    System.out.println("Email :" +user.getEmail());
		    System.out.println("gender :" +user.getGender());
		    System.out.println("City :" +user.getCity());

	}

}
