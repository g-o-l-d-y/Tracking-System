package process;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import process.DAO.NetworkDAO;
import process.DAO.UserDAO;
import process.Model.User;


public class NetworkTest {

static NetworkDAO networkDAO;
static UserDAO userDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("process");
	context.refresh();
	networkDAO=(NetworkDAO)context.getBean("networkDAO");
	}

	@Ignore
	@Test
	public void formNetworkTest()
	{
		ArrayList<String> al=new ArrayList<String>();
		al.add("lidya18");
		al.add("buyer");
		al.add("customs");
		al.add("exporter");
		al.add("importer");
		
		networkDAO.formNetwork(al,new java.util.Date());
	}
	
	@Ignore
	@Test
	public void updatePaidStatusTest()
	{
		networkDAO.updatePaidStatus(403117773);
	}
	
	@Test
	public void getNetworkIdsTest()
	{
		networkDAO.getNetworkIds("lidya18");
	}

}
