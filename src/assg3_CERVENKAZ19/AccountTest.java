package assg3_CERVENKAZ19;

/**
 * Author: Zachary Cervenka
 * AccountTest class that tests all methods and constructors in the Account, CheckingAccount, SavingsAccount class
 */

public class AccountTest {
	public static void main (String[] args) {
		//Account class test
		Account acct1 = new Account("A01");
		Account acct2 = new Account("A02", 100);
		
		System.out.println("Account number: " + acct1.getAcctNo());
		System.out.println("Current balance: " + acct1.getBalance());
		
		System.out.println("\n" + acct2.toString() + "\n");
		
		System.out.println("Depositing -10 into acct1.");
		acct1.deposit(-10);
		System.out.println("Current balance: " + acct1.getBalance());
		
		System.out.println("\nDepositing 10 into acct1.");
		acct1.deposit(10);
		System.out.println("Current balance: " + acct1.getBalance());
		
		System.out.println("\nWithdrawling 50 from acct1");
		acct1.withdraw(50);
		
		System.out.println("\nTransfering 40 from acct2 to acct1.");
		acct2.transfer(acct1, 40);
		acct1.displayInfo();
		System.out.println("\n" + acct2.toString());
		
		System.out.println("\nWithdrawling 50 from acct1");
		acct1.withdraw(50);
		acct1.displayInfo();
		
		System.out.println("\nTransfering -40 from acct2 to acct1.");
		acct2.transfer(acct1, -40);
		
		System.out.println("\nTransfering 100 from acct2 to acct1.");
		acct2.transfer(acct1, 100);
		System.out.println();
		acct2.displayInfo();
		
		Account acct3 = new Account("A01", 50);
		System.out.println("\nAcct3 info:");
		acct3.displayInfo();
		System.out.println("\nacct1 == acct3: " + acct1.equals(acct3));
		System.out.println("acct1 == acct2: " + acct1.equals(acct2));
		
		//CheckingAccount class test
		CheckingAccount checkingAcct1 = new CheckingAccount("C01");
		CheckingAccount checkingAcct2 = new CheckingAccount("C02", 50, 100);
		
		checkingAcct1.setFee(10);
		System.out.println("\nOverdraft fee for checking accounts: " + checkingAcct2.getFee());
		
		System.out.println("\n" + checkingAcct1.toString() + "\n");
		checkingAcct2.displayInfo();
		
		System.out.println("\nWithdrawling -10 from checkingAcct1");
		checkingAcct1.withdraw(-10);
		
		System.out.println("\nWithdrawling 10 from checkingAcct1");
		checkingAcct1.withdraw(10);
		
		System.out.println("\nSetting overdraft of checkingAcct1 to 20");
		checkingAcct1.setOverdraft(20);
		
		System.out.println("\n" + checkingAcct1.toString() + "\n");
		System.out.println("Withdrawling 10 from checkingAcct1 overdraft fee included.");
		checkingAcct1.withdraw(10);
		System.out.println("\n" + checkingAcct1.toString() + "\n");
		
		System.out.println("Transfering -50 from checkingAcct2 to checkingAcct1.");
		checkingAcct2.transfer(checkingAcct1, -50);
		checkingAcct2.displayInfo();
		
		System.out.println("\nTransfering 200 from checkingAcct2 to checkingAcct1.");
		checkingAcct2.transfer(checkingAcct1, 200);
		checkingAcct2.displayInfo();
		
		checkingAcct2.transfer(checkingAcct1, 50);
		System.out.println("\nTransfering 50 from checkingAcct2 to checkingAcct1.");
		checkingAcct2.displayInfo();
		
		checkingAcct2.transfer(checkingAcct1, 50);
		System.out.println("\ncheckingAcct2 overdraft limit: " + checkingAcct2.getOverdraft());
		System.out.println("Transfering 50 from checkingAcct2 to checkingAcct1 overdraft fee included.");
		checkingAcct2.displayInfo();
		System.out.println("\n" + checkingAcct1.toString() + "\n");
		
		//SavingsAccount class test
		SavingsAccount savingAcct1 = new SavingsAccount("S01");
		SavingsAccount savingAcct2 = new SavingsAccount("S02", 500, 0.1);
		
		System.out.println("Setting savingsAcct1 interest to 0.2");
		savingAcct1.setInterestRate(0.2);
		System.out.println("savingsAcct1 interest rate: " + savingAcct1.getInterestRate());
		
		System.out.println("\n" + savingAcct2.toString() + "\n");
		
		savingAcct2.addInterest();
		savingAcct2.displayInfo();
		
		savingAcct2.transfer(checkingAcct1, 50);
		System.out.println("\n" + savingAcct2.toString() + "\n");
		checkingAcct2.transfer(savingAcct1, 10);
		savingAcct1.displayInfo();
	}		
}
