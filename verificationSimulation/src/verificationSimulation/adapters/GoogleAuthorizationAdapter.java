package verificationSimulation.adapters;

import verificationSimulation.business.abstracts.UserAuthorizationService;
import verificationSimulation.dataAccess.abstracts.UserDao;
import verificationSimulation.entities.concretes.User;
import verificationSimulation.google.GoogleUser;
import verificationSimulation.google.GoogleAuthorizationService;

public class GoogleAuthorizationAdapter implements UserAuthorizationService {
	
	
	private String password;
	private int id;
	
	public GoogleAuthorizationAdapter(int id,String password) {
		
		this.password=password;
		this.id=id;
	}
	
	
	public User mappingUser() {
		User user = new User();
		GoogleUser googleUser=new GoogleUser();
		
		user.setId(id);
		user.setFirstName(googleUser.getFirstName());
		user.setLastName(googleUser.getLastName());
		user.setEMail(googleUser.geteMail());
		user.setPassword(password);
		
		return user;
	}
	
	@Override
	public boolean validation(String email) {
		if (email!=null) {
			GoogleAuthorizationService googleAuthorizationService=new GoogleAuthorizationService();
			googleAuthorizationService.Authorization();
			return true;
		}
		
		
		
		return false;
	}

}
