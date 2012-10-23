package accueilccas.services;

import java.util.List;

import accueilccas.bean.User;

public interface UserManager {
	public void saveUser(User u);
	public User getUserByLogin(String login);
	public User getUserById(int id);
	public List<User> getUsers();

}
