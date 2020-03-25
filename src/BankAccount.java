import java.util.Scanner;

public class BankAccount {
	
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	BankAccount(String customerName, String customerID){
		//constructor that takes a users name and ID
		this.customerName = customerName;
		this.customerID = customerID;
		//calls the menu method
		showMenu();
	}//constructor
	
	void deposit(int amount) {
		//checks the value isn't negative
		if(amount > 0) {
			//updates the balance and most recent transaction
			balance = balance + amount;
			previousTransaction = amount;
		}else {//if the user enters an invalid value, inform them.
			System.out.println("-------------------------"
					+ "\n  Invalid value entered."
					+ "\n-------------------------\n");
		}
	}//deposit
	
	void withdraw(int amount) {
		//checks the user has enough in their account
		if ((balance - amount) < 0 ) {
			System.out.println("-------------------------"
					+ "\n   Insufficient funds."
					+ "\n-------------------------\n");
		}else if (amount > 0) {//checks the value isn't negative
			//updates the balance and most recent transaction
			balance = balance - amount;
			previousTransaction = -amount;
		}else {//if the user enters an invalid value, inform them.
			System.out.println("-------------------------"
					+ "\n  Invalid value entered."
					+ "\n-------------------------\n");
		}
	}//withdraw
	
	void getPreviousTransaction() {
		if(previousTransaction > 0) {//if the value is positive the user deposited
			System.out.println("     Deposited: " + previousTransaction);
		}else if (previousTransaction < 0) {//if its negative they withdrew
			System.out.println("     Withdrew: " + Math.abs(previousTransaction));
			//displays the value as a positive, as they wouldn't withdraw a negative amount
		}else {
			//if no transaction has happened yet
			System.out.println("No transaction recorded");
		}
	}//previous transaction
	
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		//prints the options available to the user
		System.out.println("Welcome " + customerName + 
						"\nYour ID is " + customerID +"\n");
		System.out.println("A: Check Balance"
						+ "\nB: Deposit	"
						+ "\nC: Withdraw"
						+ "\nD: View Previous Transaction"
						+ "\nE: Exit");	
		
		do {//ask the user for an option
			System.out.println("+++++++++++++++++++++++++"
					+ "\n Please enter an option."
					+ "\n+++++++++++++++++++++++++\n");
			
			//scan the first character the user enters 
			option = scanner.next().charAt(0);
			//makes sure the char is uppercase
			option = Character.toUpperCase(option);
			
			switch(option){
			
			case 'A':
				//display the account balance
				System.out.println("-------------------------"
						+ "\n    Balance = "+balance
						+ "\n-------------------------\n");
				break;
				
			case 'B':
				//ask the user for an amount
				System.out.println("-----------------------------"
						+ "\n Enter an amount to deposit: "
						+ "\n-----------------------------\n");
						
				try {//make sure the user has entered an int
					int depAmount = scanner.nextInt();
					deposit(depAmount);
					break;
					}
					catch(Exception e) {
						//if they haven't inform them and clear the scanner
						System.out.println("-------------------------"
								+ "\n  Invalid value entered."
								+ "\n-------------------------\n");
						scanner.next();
						break;
					}
						
			case 'C'://ask the user for an amount
				System.out.println("------------------------------"
						+ "\n Enter an amount to withdraw: "
						+ "\n------------------------------\n");
				
				try {//make sure the user has entered an int
						int withAmount = scanner.nextInt();
						withdraw(withAmount);
						break;
					}
					catch(Exception e) {
						//if they haven't inform them and clear the scanner
						System.out.println("-------------------------"
								+ "\n  Invalid value entered."
								+ "\n-------------------------\n");
						scanner.next();
						break;
					}
				
			case 'D':
				//show the previous transaction method
				System.out.println("-------------------------");
				getPreviousTransaction();
				System.out.println("-------------------------\n");
				break;
				
			case 'E':
				//exit the app and move to the syso after the while statement
				System.out.println("++++++++++++++++++++++++++++++++++++++++++");
				break;
				
			default://if the user enters an invalid value
				System.out.println("Invalid option! Please enter another option.");
			}//switch
			
		//if the user entered E, exit the loop and print syso below	
		}while(option != 'E');//loop
		
		System.out.println(" Thank you for using our banking service!"
				+ "\n++++++++++++++++++++++++++++++++++++++++++");
	}//menu	
	
}//class
