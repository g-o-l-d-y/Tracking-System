package process;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import process.DAO.UserDAO;
import process.Model.User;

@Controller
public class HomeController {

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value= {"/Home","/"})
	public String showHome()
	{
		return "Home";
	}
	
	@RequestMapping("/Login") 
	public String showlogin() 
	{ 
		return "Login"; 
	}
	
	@RequestMapping(value="/Register", method=RequestMethod.GET) 
	public String showRegister(Map<String, Object> model) 
	{
		model.put("user", new User());
		return "Register"; 
	}
	
	@RequestMapping("/ContactUs")
	public String showContactUs()
	{
		return "ContactUs";
	}
	
	@RequestMapping("/AboutUs")
	public String showAboutUs()
	{
		return "AboutUs";
	}
}
