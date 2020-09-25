package process.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import process.Model.Network;
import process.Model.TransactionDetail;
import process.Model.User;

@Repository("transactionDAO")
@Transactional
public class TransactionDetailImpl implements TransactionDetailDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	NetworkDAO networkDAO;
	
	@Autowired
	UserDAO userDAO;
	

public boolean addUser(TransactionDetail t) {
	try
	{
		sessionFactory.getCurrentSession().saveOrUpdate(t);
		return true;
	}
	catch(Exception e)
	{
		System.out.println(e);
	    return false;
	}
}

public boolean createTransaction(int networkId, Date date) {
	
	List<Network> network=networkDAO.getNetwork(networkId);
	List<Network> netw=new ArrayList<Network>();
	netw.add(networkDAO.getUser(networkId, "SELLER"));
	netw.add(networkDAO.getUser(networkId, "EXPORTER"));
	netw.add(networkDAO.getUser(networkId, "CUSTOMS"));
	netw.add(networkDAO.getUser(networkId, "IMPORTER"));
	netw.add(networkDAO.getUser(networkId, "BUYER"));

	for(Network n:netw)
	{
		TransactionDetail t=new TransactionDetail();
		t.setUserName(n.getUserName());
		t.setParticipantId(n.getParticipantId());
		t.setDate(null);
		t.setNetworkId(networkId);
		t.setRole(userDAO.getUserByUserName(n.getUserName()).getRole());
		if (t.getRole().equals("SELLER"))
			t.setStatus(1);
		else
			t.setStatus(0);
		t.setTransactionId((String.valueOf(networkId)+String.valueOf(date)).hashCode());
		this.addUser(t);	
	}
	return true;
}

public boolean updateStatus(int transactionId, String role, Date date) {

	Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from TransactionDetail where transactionId=:tId and role=:r");
	query.setParameter("tId",transactionId);
	query.setParameter("r", role);
	TransactionDetail t1=(TransactionDetail)query.getSingleResult();
	t1.setStatus(1);
	t1.setDate(date);
	sessionFactory.getCurrentSession().update(t1);
	
	String r="IMPORTER";
	
	if (role.equals("EXPORTER"))
		r="SELLER";
	else if(role.equals("CUSTOMS"))
		r="EXPORTER";
	else if(role.equals("IMPORTER"))
		r="CUSTOMS";
	System.out.println(r+" "+role);
	query.setParameter("r", r);
	TransactionDetail t2=(TransactionDetail)query.getSingleResult();
	t2.setStatus(2);
	sessionFactory.getCurrentSession().update(t2);
	
	return true;
}

public List<TransactionDetail> getNetwork(int networkId) {
	
	Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from Transaction where networkId=:nId");
	query.setParameter("nId",networkId);
	List<TransactionDetail> network=query.list();
	return network;
}

public List<Integer> getTransactionIds(String username) {
	Session session=sessionFactory.openSession();
	Query query =session.createQuery("from TransactionDetail where userName=:uname");
	query.setParameter("uname", username);
	List<TransactionDetail> transaction=query.list();
	
	List<Integer> list=new ArrayList<Integer>();
	for(TransactionDetail t: transaction)
		list.add(t.getTransactionId());
	session.close();
	return list;
}

public List<TransactionDetail> getTransaction(int transactionId) {
	
	Session session=sessionFactory.openSession();
	Query query =session.createQuery("from TransactionDetail where transactionId=:tId");
	query.setParameter("tId", transactionId);
	List<TransactionDetail> transaction=query.list();
	session.close();
	return transaction;
}

public String getNext(int transactionId) {
	List<TransactionDetail> transaction=this.getTransaction(transactionId);
	for(int i=0;i<4;i++)
	{
		if(transaction.get(i).getStatus()==1)
			return transaction.get(i+1).getRole();
	}
	return "NONE";
}

}
