   package Forms;
   import Domain.Profile;
   import Domain.Account;
   import Domain.CheckingAccount;
   import Domain.SavingsAccount;
   import Domain.CreditAccount;
   import Domain.LoanAccount;
   import java.io.*;
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
            switch (in) {
			   case '1':
			      return null;
               case '2':
                  System.out.print("\r\nAccount Name: ");
                  Account account = new CheckingAccount(profile.getName(), input.getNextLine());
                  while (num < 0) {
                     System.out.print("\r\nStarting Balance: ");
                     num = input.getNextDouble();
                  }
                  account.changeBalance(num);
                  System.out.print("\n\r"
                     					+ "\n\t\t\t\t\tAccount Created!\r");
                  return account;
               case '3':
                  System.out.print("\r\nAccount Name: ");
                  Account account = new SavingsAccount(profile.getName(), input.getNextLine());
                  while (num < 0) {
                     System.out.print("\r\nStarting Balance: ");
                     num = input.getNextDouble();
                  }
                  num = -1;
                  while (num < 0) {
                     System.out.print("\r\nMonthly Interest Rate: ");
                     num = input.getNextDouble();
                  }
                  account.setInterest(num);
                  System.out.print("\n\r"
                     					+ "\n\t\t\t\t\tAccount Created!\r");
                  return account;
               case '4':
                  System.out.print("\r\nAccount Name: ");
                  Account account = new CreditAccount(profile.getName(), input.getNextLine());
                  while (num < 0) {
                     System.out.print("\r\nStarting Balance: ");
                     num = input.getNextDouble();
                  }
                  num = -1;
                  while (num < 0) {
                     System.out.print("\r\nMonthly Interest Rate: ");
                     num = input.getNextDouble();
                  }
                  account.setInterest(num);
                  num = -1;
                  while (num < 0) {
                     System.out.print("\r\nCredit Limit: ");
                     num = input.getNextDouble();
                  }
                  ((CreditAccount) account).setLimit(num);
                  System.out.print("\n\r"
                     					+ "\n\t\t\t\t\tAccount Created!\r");
                  return account;
               case '5':
                  System.out.print("\r\nAccount Name: ");
                  Account account = new LoanAccount(profile.getName(), input.getNextLine());
                  while (num < 0) {
                     System.out.print("\r\nStarting Balance: ");
                     num = input.getNextDouble();
                  }
                  num = -1;
                  while (num < 0) {
                     System.out.print("\r\nMonthly Interest Rate: ");
                     num = input.getNextDouble();
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
            if (i < 1 || i > size + 1) {
               System.out.print("\r\n\t\t\t\t\tInvalid Selection");
            }
         }
      	
         if (i == 1) {
			return 0;
		 else if (confirmClose()) {
            return i - 1;
         }
      	
         return "Back";
      }
      
      private static boolean confirmClose(Profile profile) {
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
		Scanner iput = new Scanner(System.in);
		
		System.out.print("\n\t\t\t\t\t" + \*name + *\"\'s Accounts\r"
							+ "\n\r"
							+ "\n1) Back\r"
							+ "\n2) Create Account\r"
							+ "\n3) Close Account\r");
		for (Account account : accounts) {
			+ "\n" + index + ") View " + account.getName() + "\r"
			index++;
		}
		while (true) {
			System.out.print("\n\r\nPlease Select An Option: ");
			index = input.getNextInt();
			if (index < 1 || index > accounts.size() + 3) {
				system.out.print("\r\n\t\t\t\t\tInvalid Selection");
			}
			else {
				return index;
			}
		}
	  }
      
      public static String viewAccount(Account account) {
         int in = 0;
         boolean valid = false;
         Scanner input = new Scanner(System.in);
      	
         System.out.print("\n" + account.getName() + "\r"
            					+ "\nType: " + account.getType() + "\r"
            					+ "\nCurrent Balance: " + account.getBalance() + "\r");
         if (!(account instanceof CheckingAccount)) {
            System.out.print("\n(if !CheckingAccount)Interest Rate: " + account.getInterestRate() + "\r");
         }
         if (account instanceof CreditAccount) {
            System.out.print("\n(if CreditAccount)Credit Limit: " + ((CreditAccount) account).getCreditLimit() + "\r");
         }
         System.out.print("\n\r"
            				+ "\n1) Back\r"
            				+ "\n2) View Transactions\r"
            				+ "\n3) New Transaction\r"
            				+ "\n\r");
         while (!valid) {
            System.out.print("\nPlease Select An Option: ");
            in = input.nextInt();
            switch (in) {
               case 1:
                  return "Back";
                  valid = true;
                  break;
               case 2:
                  return "View Transactions";
                  valid = true;
                  break;
               case 3:
                  return "New Transaction";
                  valid = true;
                  break;
               default:
                  System.out.print("\r\n\t\t\t\t\tInvalid Selection");
            }
         }
      }
   }