package assg3_CERVENKAZ19;
/**
 * Author: Zachary Cervenka
 * SavingsAccount class that is a subclass of Account and allows you to create an object of type SavingsAccount
 * this savings account includes a balance, acctNo, and interest rate
 */

public class SavingsAccount extends Account {
	private double interestRate;
	
	/**
	 * one parameter constructor that calls super of the Account class and sets interest rate to 0
	 * @param accountNo
	 */
	public SavingsAccount(String accountNo) {
		super(accountNo, 0);
		interestRate = 0;
	}
	
	/**
	 * two parameter constructor that calls super of the Account class and sets interest rate to given value.
	 * @param accountNo, initBalance
	 */
	public SavingsAccount(String accountNo, double initBalance, double interestRate) {
		super(accountNo, initBalance);
		this.interestRate = interestRate;
	}
	
	/**
	 * getInterestRate method that returns the interest rate 
	 * @return interestRate
	 */
	public double getInterestRate() {
		return interestRate;
	}
	
	/**
	 * setInterestRate method that allows you to set the interestRate 
	 * @param newInterest
	 */
	public void setInterestRate(double newInterest) {
		interestRate = newInterest;
	}
	
	/**
	 * addInterest method that adds the interest to your balance
	 */
	public void addInterest() {
		this.setBalance((1 + interestRate) * this.getBalance());
	}
	
	/**
	 * override toString method that returns account number, balance, and interest rate as a string
	 * @return "acctNo, balance, interest rate"
	 */
	@Override
	public String toString() {
		return "Account number: " + this.getAcctNo() + "\nCurrent balance: " + this.getBalance() + "\nInterest rate: " + interestRate;
	}
	
	/**
	 * override displayInfo method that displays the acctNo, balance and interest rate to console
	 */
	@Override
	public void displayInfo() {
		System.out.println("Account number: " + this.getAcctNo());
		System.out.println("Current balance: " + this.getBalance());
		System.out.println("Interest rate: " + interestRate);
	}
}
