   package Forms;
   import Domain.Profile;
   import Domain.Account;
   import Domain.CheckingAccount;
   import Domain.SavingsAccount;
   import Domain.CreditAccount;
   import Domain.LoanAccount;
   import java.io.*;
   import java.util.Scanner;
   
   public class AccountForm implements Form {
      public Account newAccount(Profile profile) {
         boolean valid = false;
         char in;
         double num = -1;
         Scanner input = new Scanner(System.in);
      	
         while (!valid) {
            System.out.print("\n1) Back\r"
               					+ "\n2) Checking Account\r"
               					+ "\n3) Savings Account\r"
               					+ "\n3) Credit Account\r"
               					+ "\n4) Loan Account\r"
               					+ "\n\r"
               					+ "\nPlease Select An Account Type: ");
            in = (char) input.nextInt();
            switch (in) {
               case '1':
                  System.out.print("\r\nAccount Name: ");
                  Account account = new CheckingAccount(profile.getName(), input.getNextLine());
                  while (num < 0) {
                     System.out.print("\r\nStarting Balance: ");
                     num = input.getNextDouble();
                  }
                  account.changeBalance(num);
                  System.out.print("\n\r"
                     					+ "\n\t\t\t\t\tAccount Created!\r");
                  AccountController.save(account);
                  return account;
                  valid = true;
                  break;
               case '2':
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
                  AccountController.save(account);
                  return account;
                  valid = true;
                  break;
               case '3':
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
                  AccountController.save(account);
                  return account;
                  valid = true;
                  break;
               case '4':
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
                  AccountController.save(account);
                  return account;
                  valid = true;
                  break;
               default:
                  System.out.print("\r\n\t\t\t\t\tInvalid Input!");
            }
         }
      }
      
      public String closeAccount(ArrayList<String> accounts) {
         int i = 2;
         Scanner input = new Scanner(System.in);
         //System.out.print("\n1) Back\r");
         for (String account : accounts) {
            System.out.print("\n" + i + ") " + account + "\r");
            i++;
         }
         System.out.print("\n\r");
      	
         while (i < 1 || i > accounts.size() + 1) {
            System.out.print("\r\nSelect Account To Be Closed: ");
            i = input.nextInt();
            if (i < 1 || i > size + 1) {
               System.out.print("\r\n\t\t\t\t\tInvalid Selection");
            }
         }
      	
         if (confirmClose(accounts.get(i -1))) {
            return accounts.get(i - 1);
         }
      	
         return "Back";
      }
      
      public boolean confirmClose(Account account) {
         System.out.print("\nAre you sure you want to close this account?\r"
            					+ "\nThe account will not be deleted, but it will become inactive.\r"
            					+ "\n(y/n): ");
         Scanner input = new Scanner(System.in);
         if ((char) input.nextInt() == 'y') {
            AccountController.remove(account);
            System.out.print("\n\t\t\t\t\tAccount Closed!\r");
            return true;
         }
         return false;
      }
      
      public String viewAccount(Account account) {
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