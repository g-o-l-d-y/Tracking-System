package process;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import process.DAO.UserDAO;
import process.Model.User;

public class UserTest {
	
	static UserDAO userDAO;
	@BeforeClass
	public static void executeFirst()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("process");
	context.refresh();
	userDAO=(UserDAO)context.getBean("userDAO");
	}

	@Test
	public void registerUserTest()
	{
		User user=new User();
		user.setUserName("buyer");
		user.setCustomerName("Lidya Dashwood");
		user.setAddress("Chennai");
		user.setEmailId("lidya18@gmail.com");
		user.setMobileNo("9898989898");
		user.setPassword("$2a$10$smvX6GYtWtS2Ziv5cSifTe.1lGQD7FAUuauefW1ObTQx1ULEhOwfu");
		user.setRole("BUYER");
		assertTrue("Problem in registering", userDAO.registerUser(user));
	}
	
	@Ignore
	@Test
	public void updateUserTest()
	{
		User user= new User();
		user=userDAO.getUserByUserName("lidya18");
		user.setCustomerName("Lidya Dashwood");
		assertTrue("Update failed", userDAO.updateUser(user));
	}
	
	@Ignore
	@Test
	public void getUserListTest()
	{
		List<User> userList=userDAO.getUserList();
		assertNotNull("No Users",userList);
		for(User user:userList)
		{
		System.out.print(user.getCustomerName()+":::");
		System.out.print(user.getUserName()+":::");
		}
	}
	
	@Ignore
	@Test
	public void getUserByUserNameTest()
	{
		User user=userDAO.getUserByUserName("lidya18");
		System.out.println(user.getRole());
	}
	
	@Ignore
	@Test
	public void getUserByRoleTest()
	{
		User user=userDAO.getUserByRole("SELLER");
		System.out.println(user.getRole());
	}
	
	@Ignore
	@Test
	public void createNetworkTest()
	{
		//assertTrue(userDAO.createNetwork("lidya18", "customs"));
	}
	
	@Ignore
	@Test
	public void updateNetworkTest()
	{
		  User user=userDAO.getUserByUserName("seller");
		  ArrayList<String> als=user.getTemporaryNetwork();
		  ArrayList<ArrayList> al=user.getNetworks();
		  als.clear();
		  al.clear();
		  assertTrue("Problem",userDAO.updateUser(user));
	}
	
	@Ignore
	@Test
	public void getNetworks()
	{
		User u=userDAO.getUserByUserName("lidya18");
		ArrayList<ArrayList> al=u.getNetworks();
		
		for(ArrayList a:al)
		{
			for(int i=0;i<5;i++)
				System.out.println(a.get(i));
		}
	}
}
