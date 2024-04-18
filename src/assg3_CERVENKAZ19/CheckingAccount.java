package assg3_CERVENKAZ19;

/**
 * Author: Zachary Cervenka
 * CheckingAccount class that is a subclass of the Account class
 * Allows you to create a checkingAcct with a balance, acctNo, and overdraft, and overdraft fee
 */

public class CheckingAccount extends Account {
	private double overdraft;
	private static double fee;
	
	/**
	 * constructor with one parameter sets overdraft to 0
	 * @param accountNO
	 */
	public CheckingAccount(String accountNo) {
		super(accountNo);
		overdraft = 0;
	}
	
	/**
	 * Constructor with three parameters 
	 * @param accountNo, initBalance, overdraft
	 */
	public CheckingAccount(String accountNo, double initBalance, double overdraft) {
		super(accountNo, initBalance);
		this.overdraft = overdraft;
	}
	
	/**
	 * get method that returns the overdraft
	 * @return overdraft
	 */
	public double getOverdraft() {
		return overdraft;
	}
	
	/*
	 * set method that allows you to change the value of the overdraft
	 * @param newOverDraft
	 */
	public void setOverdraft(double newOverdraft) {
		overdraft = newOverdraft;
	}
	
	/**
	 * get method that returns the value of fee
	 * @return fee
	 */
	public double getFee() {
		return fee;
	}
	
	/**
	 * set method that allows you to change the value of the fee for all checking accounts
	 * @param newFee
	 */
	public void setFee(double newfee) {
		fee = newfee;
	}
	
	/**
	 * override toString method that returns the acctNo, balance, and overdraft as a string
	 * @return "acctNo, balance, overdraft"
	 */
	@Override
	public String toString() {
		return "Account number: " + this.getAcctNo() + "\nCurrent balance: " + this.getBalance() + "\nOverdraft amount: " + overdraft;
	}
	
	/**
	 * Override withdraw method that allows you to withdraw within iverdraft limit
	 * @param amount
	 */
	@Override
	public void withdraw(double amount) {
		if(amount < 0) {
			System.out.println("Error: Cannot withdraw negative amount.");
		}
		else if((this.getBalance() - amount) >= 0) {
			this.setBalance(this.getBalance() - amount);
		}
		else if((this.getBalance() - amount) - fee >= -overdraft) {
			this.setBalance((this.getBalance() - amount) - fee);
		}
		else {
			System.out.println("Error: Insufficient funds.");
		}
	}
	
	/**
	 * override transfer method that allows you to transfer within the overdraft limit
	 * @param acct, amount
	 */
	@Override
	public void transfer(Account acct, double amount) {
		if(amount < 0) {
			System.out.println("Error: Cannot transfer negative amount.");
		}
		else if(this.getBalance() - amount >= 0) {
			this.setBalance(this.getBalance() - amount);
			acct.setBalance(acct.getBalance() + amount);
		}
		else if((this.getBalance() - amount) - fee >= -overdraft) {
			this.setBalance((this.getBalance() - amount) - fee);
			acct.setBalance(acct.getBalance() + amount);
		}
		else {
			System.out.println("Error: Insufficient Funds.");
		}
	}
	
	/**
	 * override displayInfo method that displays acctNo, balance, and overdraft in console
	 */
	@Override
	public void displayInfo() {
		System.out.println("Account number: " + this.getAcctNo());
		System.out.println("Current balance: " + this.getBalance());
		System.out.println("Overdraft amount: " + overdraft);
	}
}
