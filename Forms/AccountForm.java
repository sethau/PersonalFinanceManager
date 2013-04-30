   package Forms;
   import Domain.Profile;
import Domain.Account;
import Domain.CheckingAccount;
import Domain.SavingsAccount;
import Domain.CreditAccount;
import Domain.LoanAccount;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
   
   public class AccountForm {
      public static Account newAccount(Profile profile) {
         char in;
         double num = -1;
         Scanner input = new Scanner(System.in);
      	
         while (true) {
            System.out.print("\n1) Back\r"
               					+ "\n2) Checking Account\r"
               					+ "\n3) Savings Account\r"
               					+ "\n4) Credit Account\r"
               					+ "\n5) Loan Account\r"
               					+ "\n\r"
               					+ "\nPlease Select An Account Type: ");
            in = (char) input.nextInt();
            Account account = null;
            switch (in) {
			   case '1':
			      return account;
               case '2':
                  System.out.print("\r\nAccount Name: ");
                  account = new CheckingAccount(profile.getUsername(), input.nextLine());
                  while (num < 0) {
                     System.out.print("\r\nStarting Balance: ");
                     num = input.nextDouble();
                  }
                  account.changeBalance(num);
                  System.out.print("\n\r"
                     					+ "\n\t\t\t\t\tAccount Created!\r");
                  return account;
               case '3':
                  System.out.print("\r\nAccount Name: ");
                  account = new SavingsAccount(profile.getUsername(), input.nextLine());
                  while (num < 0) {
                     System.out.print("\r\nStarting Balance: ");
                     num = input.nextDouble();
                  }
                  num = -1;
                  while (num < 0) {
                     System.out.print("\r\nMonthly Interest Rate: ");
                     num = input.nextDouble();
                  }
                  account.setInterest(num);
                  System.out.print("\n\r"
                     					+ "\n\t\t\t\t\tAccount Created!\r");
                  return account;
               case '4':
                  System.out.print("\r\nAccount Name: ");
                  account = new CreditAccount(profile.getUsername(), input.nextLine());
                  while (num < 0) {
                     System.out.print("\r\nStarting Balance: ");
                     num = input.nextDouble();
                  }
                  num = -1;
                  while (num < 0) {
                     System.out.print("\r\nMonthly Interest Rate: ");
                     num = input.nextDouble();
                  }
                  account.setInterest(num);
                  num = -1;
                  while (num < 0) {
                     System.out.print("\r\nCredit Limit: ");
                     num = input.nextDouble();
                  }
                  ((CreditAccount) account).setLimit(num);
                  System.out.print("\n\r"
                     					+ "\n\t\t\t\t\tAccount Created!\r");
                  return account;
               case '5':
                  System.out.print("\r\nAccount Name: ");
                  account = new LoanAccount(profile.getUsername(), input.nextLine());
                  while (num < 0) {
                     System.out.print("\r\nStarting Balance: ");
                     num = input.nextDouble();
                  }
                  num = -1;
                  while (num < 0) {
                     System.out.print("\r\nMonthly Interest Rate: ");
                     num = input.nextDouble();
                  }
                  account.setInterest(num);
                  System.out.print("\n\r"
                     					+ "\n\t\t\t\t\tAccount Created!\r");
                  return account;
               default:
                  System.out.print("\r\n\t\t\t\t\tInvalid Input!");
            }
         }
      }
      
      public static int closeAccount(ArrayList<Account> accounts) {
         int i = 2;
         Scanner input = new Scanner(System.in);
         System.out.print("\n1) Back\r");
         for (Account account : accounts) {
            System.out.print("\n" + i + ") " + account.getName() + "\r");
            i++;
         }
         System.out.print("\n\r");
      	
         while (i < 1 || i > accounts.size() + 1) {
            System.out.print("\r\nSelect Account To Be Closed (1 for Back): ");
            i = input.nextInt();
            if (i < 1 || i > accounts.size() + 1) {
               System.out.print("\r\n\t\t\t\t\tInvalid Selection");
            }
         }
      	
         if (i == 1) {
			return 0;
         } else if (confirmClose()) {
            return i - 1;
         }
      	
         return 1;
      }
      
      private static boolean confirmClose() {
         System.out.print("\nAre you sure you want to close this account?\r"
            					+ "\nThe account will not be deleted, but it will become inactive.\r"
            					+ "\n(y/n): ");
         Scanner input = new Scanner(System.in);
         if ((char) input.nextInt() == 'y') {
            System.out.print("\n\t\t\t\t\tAccount Closed!\r");
            return true;
         }
         return false;
      }
	  
	  public static int viewAccounts(Profile profile, ArrayList<Account> accounts) {
		int index = 3;
		Scanner input = new Scanner(System.in);
		
		System.out.print("\n\t\t\t\t\t" + profile.getUsername() + "\'s Accounts\r"
							+ "\n\r"
							+ "\n1) Back\r"
							+ "\n2) Create Account\r"
							+ "\n3) Close Account\r");
		for (Account account : accounts) {
			System.out.print("\n" + index + ") View " + account.getName() + "\r");
			index++;
		}
		while (true) {
			System.out.print("\n\r\nPlease Select An Option: ");
			index = input.nextInt();
			if (index < 1 || index > accounts.size() + 3) {
				System.out.print("\r\n\t\t\t\t\tInvalid Selection");
			}
			else {
				return index;
			}
		}
	  }
      
      public static String viewAccount(Account account) {
         int in = 0;
         Scanner input = new Scanner(System.in);
      	
         String type;
 		 if (account instanceof LoanAccount) {
 			type = "Loan Account";
 		 } else if (account instanceof CreditAccount) {
 			type = "Credit Account";
 		 } else if (account instanceof CheckingAccount) {
 			type = "Checking Account";
 		 } else {
 			type = "Savings Account";
 		 }
         
         System.out.print("\n" + account.getName() + "\r"
            					+ "\nType: " + type + "\r"
            					+ "\nCurrent Balance: " + account.getBalance() + "\r");
         if (!(account instanceof CheckingAccount)) {
            System.out.print("\n(if !CheckingAccount)Interest Rate: " + account.getInterest() + "\r");
         }
         if (account instanceof CreditAccount) {
            System.out.print("\n(if CreditAccount)Credit Limit: " + ((CreditAccount) account).getLimit() + "\r");
         }
         System.out.print("\n\r"
            				+ "\n1) Back\r"
            				+ "\n2) View Transactions\r"
            				+ "\n3) New Transaction\r"
            				+ "\n\r");
         while (true) {
            System.out.print("\nPlease Select An Option: ");
            in = input.nextInt();
            switch (in) {
               case 1:
                  return "Back";
               case 2:
                  return "View Transactions";
               case 3:
                  return "New Transaction";
               default:
                  System.out.print("\r\n\t\t\t\t\tInvalid Selection");
            }
         }
      }
   }