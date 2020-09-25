package process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javafx.util.Pair;
import process.DAO.TransactionDetailDAO;
import process.DAO.UserDAO;
import process.Model.Network;
import process.Model.TransactionDetail;
import process.Model.User;

@Controller
public class TransactionController {
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	TransactionDetailDAO transactionDAO;
	
	@RequestMapping(value="/Shipments")
	public String showShipments(HttpSession session, Model m)
	{
		String un=(String)session.getAttribute("username");
		List<Integer> lt=transactionDAO.getTransactionIds(un);
		ArrayList<Pair<Integer,String>> list=new ArrayList<Pair<Integer,String>>();
		for(int i=0;i<lt.size();i++)
		{
			Pair < Integer, String> ans = new Pair <Integer,String> (lt.get(i),transactionDAO.getNext(lt.get(i)));
			list.add(ans);
		}
		Collections.reverse(list);
		m.addAttribute("transactionIds",list);
		
		List<TransactionDetail> l=new ArrayList<TransactionDetail>();
		for(Integer tId: lt)
		{
			List<TransactionDetail> t=transactionDAO.getTransaction(tId);
			for(TransactionDetail user:t)
				l.add(user);
		}
		m.addAttribute("transactionList", l);
		
		return "Shipments";
	}
	
	@RequestMapping(value="/Received/{transactionId}")
	public String updateStatus(@PathVariable(value="transactionId") int transactionId,HttpSession session, Model m)
	{
		String role=(String) session.getAttribute("role");
		transactionDAO.updateStatus(transactionId, role, new java.util.Date());
		
		String un=(String)session.getAttribute("username");
		List<Integer> lt=transactionDAO.getTransactionIds(un);
		ArrayList<Pair<Integer,String>> list=new ArrayList<Pair<Integer,String>>();
		for(int i=0;i<lt.size();i++)
		{
			Pair < Integer, String> ans = new Pair <Integer,String> (lt.get(i),transactionDAO.getNext(lt.get(i)));
			list.add(ans);
		}
		Collections.reverse(list);
		m.addAttribute("transactionIds",list);
		
		List<TransactionDetail> l=new ArrayList<TransactionDetail>();
		for(Integer tId: lt)
		{
			List<TransactionDetail> t=transactionDAO.getTransaction(tId);
			for(TransactionDetail user:t)
				l.add(user);
		}
		m.addAttribute("transactionList", l);
		
		return "Shipments";
	}
	
}
