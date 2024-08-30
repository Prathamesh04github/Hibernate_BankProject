package bank.service.implement;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.configuration.Hbutil;

import bank.model.Account;
import bank.service.RBIbank;

public class Axisbank implements RBIbank{
	
	Scanner sc=new Scanner(System.in);
	Account ac=null;

	@Override
	public void CreateAccount() {
		System.out.println("welcome to Account opening section....");
		ac=new Account();
		
		System.out.println("Enter your Ac number");
		long Acno=sc.nextLong();
		ac.setAcno(Acno);
		
		System.out.println("Enter Your Name");
		ac.setAcname(sc.next()+sc.nextLine());
		
		System.out.println("Enter Your Address");
		ac.setAcAddress(sc.next());
		
		System.out.println("Enter Your AadharNo");
		ac.setAadharno(sc.nextLong());
		
		System.out.println("Enter Your PanNo");
		ac.setPanno(sc.next());
		
		System.out.println("Enter Your Mobile number");
		ac.setMobileno(sc.nextLong());
		
		System.out.println("Enter Your Gender ");
		ac.setGender(sc.next());
		
		System.out.println("Enter Your balance ");
		ac.setBalance(sc.nextDouble());
		
		
		SessionFactory sf = Hbutil.getSessionfactory();
		Session session = sf.openSession();
		
		session.save(ac);
		session.beginTransaction().commit();
		System.out.println("Your Account created Successfully Through Hibernate");
		
		
		
		
	}
	@Override
	public void ViewAccoutDetails() {
		
		SessionFactory sf = Hbutil.getSessionfactory();
		Session session = sf.openSession();
		
		System.out.println("Enter your Acno to ViewAccountDetails :");
		long Ac=sc.nextLong();
		
		Account ac = session.get(Account.class, Ac);
		
		
		if(ac!=null) {
			System.out.println();
			System.out.println("Account holder name :" +ac.getAcname());
			System.out.println("Account holder Address :"+ac.getAcAddress());
			System.out.println("Account holder Aadharno :"+ac.getAadharno());
			System.out.println("Account holder Panno :"+ac.getPanno());
			System.out.println("Account holder Mobileno :"+ac.getMobileno());
			System.out.println("Account holder Gender :"+ac.getGender());
			System.out.println("Account holder Balance :"+ac.getBalance());
			System.out.println();
		}
		else {
			System.out.println("Enter your correct Account number:");
		}
		
	}
	@Override
	public void DepositeMoney() {
		
		SessionFactory sf = Hbutil.getSessionfactory();
		Session session = sf.openSession();
		
		System.out.println("Enter your Account number to Desposite Money");
		long Ac=sc.nextLong();
		
		Account ac = session.get(Account.class, Ac);
		if (ac!=null) {
			
			double Avlbalance=ac.getBalance();
			
			System.out.println("Enter Amount to DespositeMoney");
			double damo=sc.nextDouble();
			
			ac.setBalance(Avlbalance+damo);
			
			System.out.println("Money Deposited Successfully...");
			session.beginTransaction().commit();
			
		}
		
		else {
			System.out.println();
			System.out.println("Enter correct Account number to deposite money");
		}
		
		
	}
	@Override
	public void WithdrawMoney() {
		
		SessionFactory sf = Hbutil.getSessionfactory();
		Session session = sf.openSession();		
		
		System.out.println("Enter Account number to Withdraw Money");
		long Ac = sc.nextLong();
		
		Account ac = session.get(Account.class, Ac);
		if (ac!=null) {
			
			double avlbalance = ac.getBalance();
			
			System.out.println("Enter Amount you want to withdraw");
			 double Wamo=sc.nextDouble();
			 
			 ac.setBalance(avlbalance-Wamo);
			 
			 System.out.println("Withdraw amount succesfully");
			 session.beginTransaction().commit();
			
		}
		else {
			System.out.println();
			System.out.println("Enter your correct  Account number");
		}
		
		
		
		
		
	}@Override
	public void ShowBalance() {
		
		SessionFactory sf = Hbutil.getSessionfactory();
		Session session = sf.openSession();
		
		System.out.println("Enter Account number to see your Balance");
		long Ac=sc.nextLong();
		
		Account ac = session.get(Account.class, Ac);
		
		if (ac!=null) {
			System.out.println("your Account balance :" +ac.getBalance());
			session.beginTransaction().commit();
			
		}
		else {
			System.out.println("Enter correct Account number");
			
		}
		
		
	}
	@Override
	public void UpdateDetails() {
		
		SessionFactory sf = Hbutil.getSessionfactory();
		Session session = sf.openSession();
		
		System.out.println("Enter your Account number  to update your details");
		long Ac=sc.nextLong();
		Account ac = session.get(Account.class, Ac);
		while(ac!=null) {
			
			System.out.println("Enter 1 to update your Acname :"+" "+"your old Acname :"+ac.getAcname());
			System.out.println("Enter 2 to update your Address:"+" "+"your old Address :"+ac.getAcAddress());
			System.out.println("Enter 3 to update your Aadharno :"+" "+"your old Aadharno :"+ac.getAadharno());
			System.out.println("Enter 4 to update your Panno :"+" "+"your old Panno :"+ac.getPanno());
			System.out.println("Enter 5 to update your Mobileno"+" "+"your old mobileno :"+ac.getMobileno());
			System.out.println("Enter 6 to update your gender"+" "+"your old gender :"+ac.getGender());
			System.out.println("Enter 7 to exit");
			
		int ch=sc.nextInt();
		
		switch (ch) {
		case 1:
			System.out.println("Enter your new Acname");
			ac.setAcname(sc.next()+sc.nextLine());
			System.out.println("account name updated successfully");
			break;
		case 2:
			System.out.println("Enter your new Address");
			ac.setAcAddress(sc.next()+sc.nextLine());
			System.out.println("account Address updated successfully ");
			break;
		case 3:
			System.out.println("Enter your new AadharNo");
			ac.setAadharno(sc.nextLong());
			System.out.println("Aadhar no updated successfully");
			break;
		case 4:
			System.out.println("Enter your new PanNo");
			ac.setPanno(sc.next());
			break;
		case 5:
			System.out.println("Enter your new MobileNo");
			ac.setMobileno(sc.nextInt());
			break;
		case 6:
			System.out.println("Enter your new Gender");
			ac.setGender(sc.next());
		case 7:
			ac=null;
		default:
			System.out.println("enter correct number given within the system");
			break;
			}
		session.beginTransaction().commit();
		}
	}
}
