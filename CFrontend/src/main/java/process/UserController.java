package process;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javafx.util.Pair;
import process.DAO.NetworkDAO;
import process.DAO.UserDAO;
import process.Model.Network;
import process.Model.User;

@Controller
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	NetworkDAO networkDAO;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping("/success")
	public String loginSuccess(HttpSession session,Model m)
	{
		System.out.println("Login Success");
		String page="";
		
		boolean loggedIn=false;
		
		//This object will contain the logged in user detail like username and role.
		SecurityContext sContext=SecurityContextHolder.getContext();
		Authentication authentication=sContext.getAuthentication();
		System.out.println(sContext);
		String username=authentication.getName();
		
		//Getting all the roles associated with the user
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			    session.setAttribute("role", role.getAuthority());
				loggedIn=true;
				page="Home";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
				session.setAttribute("participantId", userDAO.getUserByUserName(username).getParticipantId());
				System.out.println(username+" "+userDAO.getUserByUserName(username).getParticipantId());
		}
		return page;
      }
	  
	
	  @RequestMapping(value="registerUser", method=RequestMethod.POST)
	  public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Map<String, Object> model) 
	  {
	   		if(result.hasErrors()) 
	   		{ 
	   			return "Register"; 
	   		} 
	   		//user.setPassword("$2a$10$smvX6GYtWtS2Ziv5cSifTe.1lGQD7FAUuauefW1ObTQx1ULEhOwfu");
	   		user.setPassword(passwordEncoder.encode(user.getPassword()));
	   		user.setParticipantId(user.getUserName().hashCode());
	   		user.setEnabled(true);
	   		userDAO.registerUser(user);
	   		return "Login";
	  }
	  
  	  @RequestMapping("/perform_logout")
	  public String loggingout(HttpSession session)
	  {
		  session.invalidate();
		  return "Login";
	  }
  	  
  	  @RequestMapping("/Users")
  	  public String showUsers(Model m,HttpSession session)
  	  {
  		  List<User> userList=userDAO.getUserList();
  		 
  		  String un=(String) session.getAttribute("username");
  		  User user=userDAO.getUserByUserName(un);
  		  System.out.println(user.getUserName());
  		  ArrayList<String> network=user.getTemporaryNetwork();
  		  ArrayList<Pair<Integer,String>> p=new ArrayList<Pair<Integer,String>>();
  		  for(String s:network)
  		  {
  			  Pair<Integer,String> ans= new Pair<Integer,String>(userDAO.getUserByUserName(s).getParticipantId(),userDAO.getUserByUserName(s).getRole());
  			  p.add(ans);
  		  }
  		  
  		  m.addAttribute("Network",p);
  		  m.addAttribute("size",p.size());
  		  m.addAttribute("userList", userList);
  		  
  		  return "Users";
  	  }
	 
  	@RequestMapping(value="/addUser/{participantId}")
	public String addUser(@PathVariable("participantId")int participantId, Model m, HttpSession session)
	{
		String un=(String) session.getAttribute("username");
		User user=userDAO.getUserByUserName(un);
		ArrayList<String> network=user.getTemporaryNetwork();
		ArrayList<Integer> p=new ArrayList<Integer>();
		if(network.size()==0)
		{
			network.add((String) session.getAttribute("username"));
			String username=userDAO.getUserByParticipantId(participantId).getUserName();
			if(!(network.contains(username)))
			{
				String role=userDAO.getUserByUserName(username).getRole();
				int f=0;
				for(int i=0;i<network.size();i++)
				{
					String r=userDAO.getUserByUserName(network.get(i)).getRole();
					if(r.equals(role))
					{
						f=1;
						break;
					}
				}
				if(f==0)
					network.add(username);
			}
		}
		else if(network.size()<5)
		{
			String username=userDAO.getUserByParticipantId(participantId).getUserName();
			if(!(network.contains(username)))
			{
				String role=userDAO.getUserByUserName(username).getRole();
				int f=0;
				for(int i=0;i<network.size();i++)
				{
					String r=userDAO.getUserByUserName(network.get(i)).getRole();
					if(r.equals(role))
					{
						f=1;
						break;
					}
				}
				if(f==0)
					network.add(username);
			}
			System.out.println(participantId);
			System.out.println(network.size());
		}
		userDAO.updateUser(user);
		for(String s:network)
			  p.add(userDAO.getUserByUserName(s).getParticipantId());
		m.addAttribute("Network", p);
		m.addAttribute("size", p.size());
		
		List<User> userList=userDAO.getUserList();
		m.addAttribute("userList", userList);
		
		return "Users";
	}
  	
  	@RequestMapping(value="/deleteUser/{participantId}")
	public String deleteUser(@PathVariable("participantId")int participantId, Model m, HttpSession session)
	{
  		String un=(String) session.getAttribute("username");
		User user=userDAO.getUserByUserName(un);
		ArrayList<String> network=user.getTemporaryNetwork();
		ArrayList<Integer> p=new ArrayList<Integer>();
		String username=userDAO.getUserByParticipantId(participantId).getUserName();
		System.out.println(participantId+" "+username);
  		if(network.contains(username))
  		{
  			for(int i=0;i<network.size();i++)
  			{
  				if(network.get(i).equals(username))
  				{
  					System.out.println(network.get(i).equals(username)+" "+network.get(i));
  					network.remove(i);
  				}
  			}
  			
  		}
  		userDAO.updateUser(user);
  		for(String s:network)
			  p.add(userDAO.getUserByUserName(s).getParticipantId());
  		List<User> userList=userDAO.getUserList();
  		
		m.addAttribute("Network", p);
		m.addAttribute("size", p.size());
		m.addAttribute("userList", userList);
		
  		return "Users";
	}
  	
  	@RequestMapping(value="/formNetwork")
  	public String formNetwork(Model m, HttpSession session)
  	{
  		String un=(String) session.getAttribute("username");
		User user=userDAO.getUserByUserName(un);
		ArrayList<ArrayList> al=user.getNetworks();
		ArrayList<String> network=user.getTemporaryNetwork();
		al.add(network);
		networkDAO.formNetwork(network, new java.util.Date());
		network.clear();
		userDAO.updateUser(user);
		
		List<Integer> ln=networkDAO.getNetworkIds(un);
		
		ArrayList<Pair<Integer,Integer>> np = new ArrayList<Pair<Integer,Integer>>();
		List<Network> l=new ArrayList<Network>();
		for(Integer nId: ln)
		{
			List<Network> n=networkDAO.getNetwork(nId);
			Pair < Integer, Integer> ans = new Pair <Integer,Integer>(nId,n.get(0).getPaid());
			np.add(ans);
			for(Network u:n)
				l.add(u);
		}
		Collections.reverse(np);
		m.addAttribute("networkIds",np);
		m.addAttribute("networkList", l);
		
  		return "Network";
  	}
}
