package process.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import process.Model.User;

@Repository("userDAO")
@Transactional
public class UserImpl implements UserDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean registerUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	public boolean updateUser(User user) {
		
		try
		{
			System.out.println("Here");
			sessionFactory.getCurrentSession().update(user);
			System.out.println("Here2");
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	
	public User getUserByRole(String role) {
		
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where role=:r");
		query.setParameter("r",role);
		List<User> u=(List<User>)query.list();
		User us=null;
		for(User user: u)
			us=user;
		return us;
	}
	
	public User getUserByUserName(String username) {
			
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from User where userName=:uname");
			query.setParameter("uname",username);
			User user=(User)query.getSingleResult();
			return user;
		}

	public User getUserByParticipantId(int participantId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where participantId=:pId");
		query.setParameter("pId",participantId);
		User user=(User)query.getSingleResult();
		return user;
	}

	public List<User> getUserList() {
		Session session=sessionFactory.openSession();
		List<User> listUsers=(List<User>)(session.createQuery("from User where role!='CUSTOMS'").list());
		session.close();
		return listUsers;
	}
	
	/*
	public boolean createNetwork(String seller, String customs) {
		
		ArrayList<String> al =new ArrayList<String>();
		al.add(seller);
		al.add(customs);
		User user=this.getUserByUserName(seller);
		user.getNetworks().add(al);
		this.updateUser(user);
		return true;
	}

	public boolean updateNetwork(String seller, int index, User user) {
		
		User u=this.getUserByUserName(seller);
		u.getNetworks().get(index).add(user.getUserName());
		this.updateUser(u);
		return true;
	}
	*/

}
