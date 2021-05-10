package verificationSimulation;

import java.util.ArrayList;
import java.util.List;

import verificationSimulation.adapters.GoogleAuthorizationAdapter;
import verificationSimulation.business.abstracts.UserAuthorizationService;
import verificationSimulation.business.abstracts.UserService;
import verificationSimulation.business.concretes.UserManager;
import verificationSimulation.business.concretes.UserAuthorizationManager;
import verificationSimulation.dataAccess.concretes.HibernateUserDao;
import verificationSimulation.entities.concretes.User;
import verificationSimulation.google.GoogleAuthorizationService;

public class Main {

	public static void main(String[] args) {
		
		User user1=new User(1,"Yusuf","Koçak","a@a.com","12345627");
		User user2=new User(1,"Ey","Tigu","tigu@HOTMAIL.COM","12345627");
		
		UserService userManager1=new UserManager(new UserAuthorizationManager(),new HibernateUserDao()); 
		userManager1.register(user1);
		userManager1.register(user2);
			
		
		
		
		GoogleAuthorizationAdapter googleAuthorizationAdapter=new GoogleAuthorizationAdapter(3, "1234567");
		User googleUser=googleAuthorizationAdapter.mappingUser();
		
		UserService userManager2=new UserManager(googleAuthorizationAdapter,new HibernateUserDao()); 
		userManager2.register(googleUser);	
		
		
		for (User user : userManager2.getAll()) {
			System.out.println(user.getId() +" --------------  "+user.getFirstName());
		}
		
	}

}
