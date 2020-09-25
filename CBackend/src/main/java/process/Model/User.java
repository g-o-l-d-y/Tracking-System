package process.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class User{

	@Id
	@NotEmpty(message="Username please!")
	String userName;
	String password;
	String customerName;
	String address;
	@NotEmpty(message="Email please!")
	String emailId;
	String mobileNo;
	String role;
	int participantId;
	boolean enabled;
	ArrayList<String> temporaryNetwork=new ArrayList<String>();
	ArrayList<ArrayList> networks=new ArrayList<ArrayList>();
	
	public ArrayList<String> getTemporaryNetwork() {
		return temporaryNetwork;
	}
	public void setTemporaryNetwork(ArrayList<String> temporaryNetwork) {
		this.temporaryNetwork = temporaryNetwork;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public ArrayList<ArrayList> getNetworks() {
		return networks;
	}
	public void setNetworks(ArrayList<ArrayList> networks) {
		this.networks = networks;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
