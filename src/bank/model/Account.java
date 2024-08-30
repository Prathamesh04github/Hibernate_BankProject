package bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
public class Account {
	
	@Id
	private long Acno;
	private String Acname;
	private String AcAddress;
	private long Aadharno;
	private String Panno;
	private long Mobileno;
	private String Gender;
	private double Balance;
	
	
	
	public long getAcno() {
		return Acno;
	}
	public void setAcno(long acno) {
		Acno = acno;
	}
	public String getAcname() {
		return Acname;
	}
	public void setAcname(String acname) {
		Acname = acname;
	}
	public String getAcAddress() {
		return AcAddress;
	}
	public void setAcAddress(String acAddress) {
		AcAddress = acAddress;
	}
	public long getAadharno() {
		return Aadharno;
	}
	public void setAadharno(long aadharno) {
		Aadharno = aadharno;
	}
	public String getPanno() {
		return Panno;
	}
	public void setPanno(String panno) {
		Panno = panno;
	}
	public long getMobileno() {
		return Mobileno;
	}
	public void setMobileno(long mobileno) {
		Mobileno = mobileno;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	
	
	
	
	

}
