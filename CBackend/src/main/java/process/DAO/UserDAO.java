package process.DAO;

import java.util.List;

import process.Model.User;

public interface UserDAO {
	
	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public User getUserByRole(String role);
	public User getUserByUserName(String username);
	public User getUserByParticipantId(int participantId);
	//public boolean createNetwork(String seller, String customs);
	//public boolean updateNetwork(String seller, int index, User user);
	public List<User> getUserList();
}
