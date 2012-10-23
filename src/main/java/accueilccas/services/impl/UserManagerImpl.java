package accueilccas.services.impl;

import java.util.List;

import accueilccas.bean.User;
import accueilccas.dao.UserDAO;
import accueilccas.services.UserManager;

public class UserManagerImpl implements UserManager {

	private UserDAO userdao;
	
	
	public UserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}

	public User getUserById(int id) {
		return userdao.getUserById(id);
	}

	@Override
	public User getUserByLogin(String login) {
		return userdao.getUserByLogin(login);
	}

	@Override
	public List<User> getUsers() {
		return userdao.getUsers();
	}

	@Override
	public void saveUser(User u) {
		userdao.saveUser(u);
		
	}

}

