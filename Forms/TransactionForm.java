   package Forms;
   import Domain.Transaction;
   import java.io.*;
   import java.util.Scanner;
   import java.util.ArrayList;
   
   public class TransactionForm {
      public static Transaction newTransaction(Account account) {
         Scanner input = new Scanner(System.in);
         Transaction transaction = new Transaction(account);
      	
      	//potentially add functionality that changes with account type
         System.out.print("\r\nAmount Paid: ");
         transaction.setAmount(input.getNextDouble());
         System.out.print("\r\nVendor: ");
         transaction.setVendor(input.getNextLine());
         System.out.print("\r\nCategory: ");
         transaction.setCategory(input.getNextLine());
         return transaction;
      }
   
      public static String viewTransactions() {
         boolean valid = false;
         char in;
         Scanner input = new Scanner(System.in);
      	
         while (!valid) {
            System.out.print("\n1) Back\r"
               					+ "\n2) All Transactions\r"
               					+ "\n3) Select Transactions By Vendor\r"
               					+ "\n4) Select Transactions By Category\r"
               					+ "\n\r"
               					+ "\nPlease Select An Option: ");
            in = (char) input.nextInt();
            switch (in) {
               case '1':
                  return "Back";
                  valid = true;
                  break;
               case '2':
                  return "All";
                  valid = true;
                  break;
               case '3':
                  return "Vendor";
                  valid = true;
                  break;
               case '4':
                  return "Category";
                  valid = true;
                  break;
               default:
                  System.out.print("\r\n\t\t\t\t\tInvalid Input!");
            }
         }
      }
   	
      public static String getVendor() {
		Scanner input = new Scanner(System.in);
      	System.out.print("\r\nVendor: ");
		return input.nextLine();
      }
   	
      public static String getCategory() {
      	Scanner input = new Scanner(System.in);
      	System.out.print("\r\nCategory: ");
		return input.nextLine();
      }
   	
      public static String displayTransactions(ArrayList<Transaction> transactions) {
         int id = 1;
         char in;
         boolean valid = false;
         Scanner input = new Scanner(System.in);
         
         for (Transaction transaction : transactions) {
            System.out.print("\n\r"
               					+ "\n" + id + ") " + transaction.getDate() + "\r"
               					+ "\n$" + transaction.getAmount() + " to " + transaction.getVendor() + "\r"
               					+ "\nCategory: " + transaction.getCategory() + "\r"
               					+ "\n\r");
            id++;
         }
      	
         while (!valid) {
            System.out.print("\n1) Back\r"
               					+ "\n2) Delete Transaction\r"
               					+ "\n\r"
               					+ "\nPlease Select An Option: ");
            in = (char) input.nextInt();
            switch (in) {
               case '1':
                  return "Back";
                  valid = true;
                  break;
               case '2':
                  while (id < 1 || id > transactions.size()) {
                     System.out.print("\r\nSelect Transaction To Be Deleted: ");
                     id = input.nextInt();
                     if (id < 1 || id > transactions.size()) {
                        System.out.print("\r\n\t\t\t\t\tInvalid Input!");
                     }
                  }
                  return ((Integer) id).toString();
                  valid = true;
                  break;
               default:
                  System.out.print("\r\n\t\t\t\t\tInvalid Input!");
            }
         }
      }
      
      public static boolean confirmDelete(String id) {
         Scanner input = new Scanner(System.in);
         
         System.out.print("\n\r"
            					+ "\nAre you absolutely sure you want to delete transaction " + id + "?\r"
            					+ "\nThe specified Transaction data will be permanently erased.\r"
            					+ "\n(y/n): ");
         if ((char) input.nextInt() == 'y') {
            System.out.print("\n\t\t\t\tTransaction Deleted!\r");
            return true;
         }
         return false;
      }
   }