package verificationSimulation.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import verificationSimulation.dataAccess.abstracts.UserDao;
import verificationSimulation.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	
	List<User> userList = new ArrayList<User>();
	

	public void add(User user) {
		System.out.println(user.getFirstName() + " Kiþisi eklendi");
		userList.add(user);

	}

	public void update(User user) {

		User updatedUser;

		for (User user1 : userList) {
			if (user1.getId() == user.getId()) {
				updatedUser = user1;
				updatedUser.setFirstName(user.getFirstName());
				updatedUser.setLastName(user.getLastName());
				updatedUser.setEMail(user.getEMail());
				updatedUser.setPassword(user.getPassword());
			}

		}

	}

	public void delete(User user) {
		for (User user1 : userList) {
			if (user1.getId() == user.getId()) {
				User deletedUser = user1;
				userList.remove(deletedUser);

			}
		}

	}

	public List<User> getAll() {

		return userList;
	}

	public User getById(int id) {
		for (User user1 : userList) {
			if (user1.getId() == id) {
				return user1;
			}
		}
		return null;
	}

}
