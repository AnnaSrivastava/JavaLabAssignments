package day2;
/**
 * Documentation required
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day2
 * Class: BankingSystem
 * Description: class to help a bank manage the bank accounts of its customers
 * Created On:26 July 2021
 * @author Ananya Srivastava
 *	
 */
import java.util.Scanner;

//base class for Savings and Current Account
class Account{
	private String memberName;
	private String accountNumber ;
	private double accountBalance=0.0;
	
	Account(String memberName){ 
		this.memberName = memberName;
		accountNumber = 10000 + (int)(Math.random()*89999) + ""; 
	}
	public void deposit(double amt) {
		accountBalance += amt;
		System.out.println("Amount Deposited!");
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
}
class Savings extends Account {
	private int interest =5;
	private int maxWithdrawLimit=10000;
	Savings(String memberName){
		super(memberName);
	}
	
	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public int getMaxWithdrawLimit() {
		return maxWithdrawLimit;
	}

	public void setMaxWithdrawLimit(int maxWithdrawLimit) {
		this.maxWithdrawLimit = maxWithdrawLimit;
	}

	public double getBalance() {
		return super.getAccountBalance()*(1+(double)(interest/100));
	}
	public void withdraw(double amt) {
		if(amt>maxWithdrawLimit) {
			System.out.println("This amount exceeds the maximum withdraw limit");
			return;
		}
		super.setAccountBalance(super.getAccountBalance() - amt);
		return;
	}
}
class CurrentAccount extends Account {
	private int tradeLicenseNumber;

	public int getTradeLicenseNumber() {
		return tradeLicenseNumber;
	}

	public void setTradeLicenseNumber(int tradeLicenseNumber) {
		this.tradeLicenseNumber = tradeLicenseNumber;
	}

	CurrentAccount(String memberName, int tradeLicenseNumber){
		super(memberName);
		this.tradeLicenseNumber = tradeLicenseNumber; 
	}
	
	public double getBalance() {
		return super.getAccountBalance();
	}
	public void withdraw(double amt) {
		if(amt>this.getBalance()) {
			System.out.println("This amount exceeds the account balance");
			return;
		}
		super.setAccountBalance(super.getAccountBalance() - amt);
		return;
	}
}
//class with main function
public class BankingSystem {
	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		
		//prompt the user to create an account
		System.out.println("Create an account with us first! Enter 1 to create a Savings account or 2 to create a Current account!");
		Integer accountType = scMain.nextInt();
	
		//User selected to create a savings account
		if(accountType==1) {
			System.out.println("Enter name of account holder:");
			String memberName = scMain.next();
			Savings savings = new Savings(memberName);
			while(true) {
				System.out.println("Input ‘1’ means deposit money.");
				System.out.println("Input ‘2’ means withdraw money");
				System.out.println("Input ‘3’ means display the balance of the account");
				System.out.println("Input ‘0’ means exit the system.");
				int choice = scMain.nextInt();
				switch(choice) {
				case 1:System.out.println("Do you need to know the balance as well? Enter 1 for yes or 2 for no.");
						int knowBalance = scMain.nextInt();
						if(knowBalance==1)
							System.out.println(savings.getBalance());
						System.out.println("Enter the amount you want to deposit:");
						double amnt = scMain.nextDouble();
						savings.deposit(amnt);
						if(knowBalance==1)
							System.out.println(savings.getBalance());
						break;
				case 2:System.out.println("Do you need to know the balance as well? Enter 1 for yes or 2 for no.");
						int knowBalance1 = scMain.nextInt();
						if(knowBalance1==1)
							System.out.println(savings.getBalance());
						System.out.println("Enter the amount you want to withdraw:");
							double amnt1 = scMain.nextDouble();
						savings.withdraw(amnt1);
						if(knowBalance1==1)
							System.out.println(savings.getBalance());
						break;
				case 3:System.out.println(savings.getBalance());
						break;
				case 0:System.exit(0);
						break;
				default:System.out.println("Wrong Input! Try Again");
				}
			}
		}
		if(accountType==2) {
			System.out.println("Enter name of business:");
			String memberName = scMain.next();
			System.out.println("Enter Trader License Number:");
			int traderLicenseNumber = scMain.nextInt();
			CurrentAccount  currentAccount = new CurrentAccount(memberName, traderLicenseNumber);
			while(true) {
				System.out.println("Input ‘1’ means deposit money.");
				System.out.println("Input ‘2’ means withdraw money");
				System.out.println("Input ‘3’ means display the balance of the account");
				System.out.println("Input ‘0’ means exit the system.");
				int choice = scMain.nextInt();
				switch(choice) {
				case 1:System.out.println("Do you need to know the balance as well? Enter 1 for yes or 2 for no.");
						int knowBalance = scMain.nextInt();
						if(knowBalance==1)
							System.out.println(currentAccount.getBalance());
						System.out.println("Enter the amount you want to deposit:");
						double amnt = scMain.nextDouble();
						currentAccount.deposit(amnt);
						if(knowBalance==1)
							System.out.println(currentAccount.getBalance());
						break;
				case 2:System.out.println("Do you need to know the balance as well? Enter 1 for yes or 2 for no.");
						int knowBalance1 = scMain.nextInt();
						if(knowBalance1==1)
							System.out.println(currentAccount.getBalance());
						System.out.println("Enter the amount you want to withdraw:");
							double amnt1 = scMain.nextDouble();
							currentAccount.withdraw(amnt1);
						if(knowBalance1==1)
							System.out.println(currentAccount.getBalance());
						break;
				case 3:System.out.println(currentAccount.getBalance());
						break;
				case 0:System.exit(0);
						break;
				default:System.out.println("Wrong Input! Try Again");
				}
			}
		}
		scMain.close();
	}//main
}//class end
