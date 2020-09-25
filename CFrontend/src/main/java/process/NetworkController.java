package process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javafx.util.Pair;
import process.DAO.NetworkDAO;
import process.DAO.TransactionDetailDAO;
import process.DAO.UserDAO;
import process.Model.Network;
import process.Model.User;

@Controller
public class NetworkController {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	NetworkDAO networkDAO;
	
	@Autowired
	TransactionDetailDAO transactionDAO;
	
	int nId;
	
	@RequestMapping(value="/Network")
	public String showNetwork(HttpSession session, Model m)
	{
		String un=(String)session.getAttribute("username");
		List<Integer> ln=networkDAO.getNetworkIds(un);
		
		ArrayList<Pair<Integer,Integer>> np = new ArrayList<Pair<Integer,Integer>>();
		List<Network> l=new ArrayList<Network>();
		for(Integer nId: ln)
		{
			List<Network> n=networkDAO.getNetwork(nId);
			Pair < Integer, Integer> ans = new Pair <Integer,Integer>(nId,n.get(0).getPaid());
			np.add(ans);
			for(Network user:n)
				l.add(user);
		}
		Collections.reverse(np);
		m.addAttribute("networkIds",np);
		m.addAttribute("networkList", l);
		return "Network";
	}
	
	
	@RequestMapping(value="/Payment/{networkId}")
	public String showPayment(@PathVariable("networkId")int networkId)
	{
		nId=networkId;
		return "Payment";
	}
	
	@RequestMapping(value="/Pay")
	public String showSuccessPage()
	{
		networkDAO.updatePaidStatus(nId);
		transactionDAO.createTransaction(nId, new java.util.Date());
		return "Success";
	}
}
