package process.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import process.Model.Network;

public interface NetworkDAO {

	public boolean addUser(String u1, int networkId, String role);
	public boolean updatePaidStatus(int networkId);
	public void formNetwork(ArrayList<String> al, Date date);
	public List<Network> getNetwork(int networkId);
	public List<Integer> getNetworkIds(String username);
	public Network getUser(int networkId, String role);
}
