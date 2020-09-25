package process.DAO;

import java.util.Date;
import java.util.List;

import process.Model.TransactionDetail;

public interface TransactionDetailDAO {
	
	public String getNext(int transactionId);
	public boolean createTransaction(int networkId, Date date);
	public boolean addUser(TransactionDetail t);
	public boolean updateStatus(int transactionId, String role, Date date);
	public List<TransactionDetail> getNetwork(int networkId);
	public List<TransactionDetail> getTransaction(int transactionId);
	public List<Integer> getTransactionIds(String username);
}
