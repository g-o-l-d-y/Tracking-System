package process.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import process.Model.Network;
import process.Model.User;

@Repository("networkDAO")
@Transactional
public class NetworkImpl implements NetworkDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserDAO userDAO;
	
	public void formNetwork(ArrayList<String> al, Date date) {
		
		String s="";
		for(String a:al)
			s+=a;
		s+=String.valueOf(date);
		int networkId=s.hashCode();
		
		for(String a:al)
			this.addUser(a, networkId,userDAO.getUserByUserName(a).getRole());			
	}


	public boolean addUser(String userName, int networkId, String role) {
		
		Network n=new Network();
		n.setUserName(userName);
		n.setNetworkId(networkId);
		n.setPaid(0);
		n.setParticipantId(userName.hashCode());
		n.setRole(role);
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(n);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		    return false;
		}
	}

	public boolean updatePaidStatus(int networkId) {
		
		
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Network set paid=1 where networkId=:nId");
		query.setParameter("nId", networkId);
		
		int done=query.executeUpdate();
		if(done>0)
			return true;
		else
			return false;

	}


	public List<Network> getNetwork(int networkId) {
		
		Session session=sessionFactory.openSession();
		Query query =session.createQuery("from Network where networkId=:nId");
		query.setParameter("nId", networkId);
		List<Network> network=query.list();
		session.close();
		return network;
	}


	public List<Integer> getNetworkIds(String username) {
		System.out.println(username);
		Session session=sessionFactory.openSession();
		Query query =session.createQuery("from Network where userName=:uname");
		query.setParameter("uname", username);
		List<Network> networks=query.list();
		
		List<Integer> list=new ArrayList<Integer>();
		for(Network n:networks)
			list.add(n.getNetworkId());
		session.close();
		return list;
	}


	public Network getUser(int networkId, String role) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Network where networkId=:nId and role=:r");
		query.setParameter("nId",networkId);
		query.setParameter("r", role);
		Network user=(Network)query.getSingleResult();
		return user;
	}

}
