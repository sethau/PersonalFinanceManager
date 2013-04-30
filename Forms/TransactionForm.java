   package Forms;
   import Domain.Account;
import Domain.Transaction;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
   
   public class TransactionForm {
      public static Transaction newTransaction(Account account) {
         Scanner input = new Scanner(System.in);
         Transaction transaction = new Transaction();
      	
      	//potentially add functionality that changes with account type
         System.out.print("\r\nAmount Paid: ");
         transaction.setAmount(input.nextDouble());
         System.out.print("\r\nVendor: ");
         transaction.setVendor(input.next());
         System.out.print("\r\nCategory: ");
         transaction.setCategory(input.next());
         return transaction;
      }
   
      public static String viewTransactions() {
         int in;
         Scanner input = new Scanner(System.in);
      	
         while (true) {
            System.out.print("\n1) Back\r"
               					+ "\n2) All Transactions\r"
               					+ "\n3) Select Transactions By Vendor\r"
               					+ "\n4) Select Transactions By Category\r"
               					+ "\n\r"
               					+ "\nPlease Select An Option: ");
            in = input.nextInt();
            switch (in) {
               case 1:
                  return "Back";
               case 2:
                  return "All";
               case 3:
                  return "Vendor";
               case 4:
                  return "Category";
               default:
                  System.out.print("\r\n\t\t\t\t\tInvalid Input!");
            }
         }
      }
   	
      public static String getVendor() {
		Scanner input = new Scanner(System.in);
      	System.out.print("\r\nVendor: ");
		return input.next();
      }
   	
      public static String getCategory() {
      	Scanner input = new Scanner(System.in);
      	System.out.print("\r\nCategory: ");
		return input.next();
      }
   	
      public static int displayTransactions(ArrayList<Transaction> transactions) {
         int id = 1;
         int in;
         Scanner input = new Scanner(System.in);
         
         for (Transaction transaction : transactions) {
            System.out.print("\n\r"
               					+ "\n" + id + ") " + transaction.getDate() + "\r"
               					+ "\n$" + transaction.getAmount() + " to " + transaction.getVendor() + "\r"
               					+ "\nCategory: " + transaction.getCategory() + "\r"
               					+ "\n\r");
            id++;
         }
      	
         while (true) {
            System.out.print("\n1) Back\r"
               					+ "\n2) Delete Transaction\r"
               					+ "\n\r"
               					+ "\nPlease Select An Option: ");
            in = input.nextInt();
            switch (in) {
               case 1:
                  return 0;
               case 2:
                  while (id < 1 || id > transactions.size()) {
                     System.out.print("\r\nSelect Transaction To Be Deleted: ");
                     id = input.nextInt();
                     if (id < 1 || id > transactions.size()) {
                        System.out.print("\r\n\t\t\t\t\tInvalid Input!");
                     }
                  }
                  return id;
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
         if (input.next().charAt(0) == 'y') {
            System.out.print("\n\t\t\t\tTransaction Deleted!\r");
            return true;
         }
         return false;
      }
   }