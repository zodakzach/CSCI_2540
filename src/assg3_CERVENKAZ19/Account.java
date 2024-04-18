package assg3_CERVENKAZ19;
/**
 * Author: Zachary Cervenka
 * Account class that allows you to create an object
 *  of type Account and give it an account number and balance
 */

public class Account {
	private String acctNo;
	private double balance;
	
	/**
	 * Constructor with one parameter sets balance to zero and acctNo to the given string
	 * @Param accountNo
	 */
	public Account(String accountNo) {
		acctNo = accountNo;
		balance = 0;
	}
	
	/**
	 * Constructor with two parameters 
	 * @Param accountNo, initBalance
	 */
	public Account(String accountNo, double initBalance) {
		acctNo = accountNo;
		balance = initBalance;
	}
	
	/**
	 * get method for acctNo that returns the acctNo
	 * @returns acctNo
	 */
	public String getAcctNo() {
		return acctNo;
	}
	
	/**
	 * get method for balance that returns the balance
	 * @returns balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * set method for balance that allows you to change the value of balance
	 * @returns newBalance
	 */
	public void setBalance(double newBalance) {
		balance = newBalance;
	}
	
	/**
	 * deposit method that allows your to deposit an amount into an account.
	 * @Param amount
	 */
	public void deposit(double amount) {
		if(amount < 0) {
			System.out.println("Error: Cannont deposit negative amount.");
		}
		else {
			balance = amount;
		}
	}
	
	/**
	 * withdraw method that allows you to withdraw a positive amount from an account if you have enough money
	 * @pParam amount
	 */
	public void withdraw(double amount) {
		if(amount < 0) {
			System.out.println("Error: Cannot withdraw negative amount.");
		}
		else if((balance - amount) >= 0) {
			balance -= amount;
		}
		else {
			System.out.println("Error: Insufficient funds.");
		}
	}
	
	/**
	 * transfer method that allows you to transfer an amount from one account to another as long as its positive and you have enough money
	 * @Param acct, amount
	 */
	public void transfer(Account acct, double amount) {
		if(amount < 0) {
			System.out.println("Error: Cannot transfer negative amount.");
		}
		else if(balance - amount >= 0) {
			this.balance -= amount;
			acct.setBalance(acct.getBalance() + amount);
		}
		else {
			System.out.println("Error: Insufficient Funds.");
		}
	}
	
	/**
	 * displayInfo method that displays the account number and balance using system.out.println
	 */
	public void displayInfo() {
		System.out.println("Account number: " + acctNo);
		System.out.println("Current balance: " + balance);
	}
	
	/**
	 * override toString method that returns account number and balance as a string
	 * @returns "Account number: \nBalance: "
	 */
	@Override
	public String toString() {
		return "Account number: " + acctNo + "\nCurrent balance: " + balance;
	}
	
	/**
	 * override equals method that returns true if two accounts have same acctNo
	 * @returns true/false
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj instanceof Account) {
			Account temp = (Account)obj;
			return temp.getAcctNo().equals(acctNo);
		}
		else {
			return false;
		}
	}
}
