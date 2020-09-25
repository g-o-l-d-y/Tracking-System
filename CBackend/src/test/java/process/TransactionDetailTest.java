package process;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import process.DAO.TransactionDetailDAO;
import process.Model.TransactionDetail;


public class TransactionDetailTest {
	
	static TransactionDetailDAO transactionDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("process");
	context.refresh();
	transactionDAO=(TransactionDetailDAO)context.getBean("transactionDAO");
	}
	
	@Ignore
	@Test
	public void createTransactionTest()
	{
		transactionDAO.createTransaction(403117773, new Date());
	
	}
	
	@Test
	public void updateStatusTest()
	{
		transactionDAO.updateStatus(403117773, "EXPORTER", new java.util.Date());
	}
}
