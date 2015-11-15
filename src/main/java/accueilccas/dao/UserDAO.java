package accueilccas.dao;

import java.util.List;

import accueilccas.bean.User;

public interface UserDAO {
	public void saveUser(User u);
	public User getUserByLogin(String login);
	public User getUserById(int id);
	public List<User> getUsers();
}
