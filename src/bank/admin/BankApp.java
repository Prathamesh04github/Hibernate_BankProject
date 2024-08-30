package bank.admin;

import java.sql.SQLException;
import java.util.Scanner;

import bank.service.RBIbank;
import bank.service.implement.Axisbank;

public class BankApp {

	public static void main(String[] args) throws ClassNotFoundException , SQLException {
		
		Scanner sc = new Scanner(System.in);
		
			RBIbank r = new Axisbank();
		
			boolean flag =true;
		
		while(flag)
		{
			System.out.println("Welcome to Axis Bank : ");
			System.out.println("Enter 1 to create Account : ");
			System.out.println("Enter 2 to view Account Details : ");
			System.out.println("Enter 3 to deposite Money : ");
			System.out.println("Enter 4 to Withdraw Money :");
			System.out.println("Enter 5 to view Balance : ");
			System.out.println("Enter 6 to update Details : ");
			System.out.println("Enter 7 to Exit from Application : ");
			
			System.out.println("********------*******-------******");
			
			int ch = sc.nextInt();
			
			switch (ch) {
			case 1:
				r.CreateAccount();
				break;
			case 2:
				r.ViewAccoutDetails();
				break;
			case 3:
				r.DepositeMoney();
				break;
			case 4:
				r.WithdrawMoney();
				break;
			case 5 : 
				r.ShowBalance();
				break;
			case 6 :
				r.UpdateDetails();
				break;
			case 7 :
				flag= false;
				break;
			default:
				break;
			}
		}
	}
}