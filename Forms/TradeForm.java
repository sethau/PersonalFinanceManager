   package Forms;
   import java.util.ArrayList;
import java.util.Scanner;

import Domain.Portfolio;
import Domain.Trade;
import Controllers.RealTimeStockQuote;
   
   public class TradeForm {
      public static Trade buy() {
         boolean valid = false;
         String in;
         double price;
         int num;
         char confirm;
         Scanner input = new Scanner(System.in);
         Trade trade = new Trade();
      	
         while (!valid) {
            System.out.print("\r\nCompany: ");
            in = input.next();
            price = RealTimeStockQuote.price(in);
            if (price != -1) {
               System.out.print("\r\nCurrent Share Price: " + price + "\r"
                  					+ "\nNumber Of Shares To Be Bought: ");
               num = input.nextInt();
               System.out.print("\nThis will Cost $" + num * price + ", confirm (y/n): ");
               confirm = (char) input.nextInt();
               if (confirm == 'y') {
                  trade = new Trade(num, in, price);
                  System.out.print("\n\t\t\t\t\tTrade Successful!\t\t\t\r");
                  return trade;
               } 
               else {
                  valid = true;
               }
            } 
            else {
               System.out.print("\r\n\t\tCompany not found. Please try again.");
            }
         }   
         return null;
      }
   	
      public static Trade sell() {
         boolean valid = false;
         String in;
         double price;
         int num;
         char confirm;
         Scanner input = new Scanner(System.in);
         Trade trade;
      	
         while (!valid) {
            System.out.print("\r\nCompany: ");
            in = input.next();
            price = RealTimeStockQuote.price(in);
            if (price != -1) {
               System.out.print("\r\nCurrent Share Price: " + price + "\r"
                  					+ "\nNumber Of Shares To Be Sold: ");
               num = input.nextInt();
               System.out.print("\nThis will Yield $" + num * price + ", confirm (y/n): ");
               confirm = (char) input.nextInt();
               if (confirm == 'y') {
                  trade = new Trade(num * -1, in, price);
                  System.out.print("\n\t\t\t\t\tTrade Successful!\t\t\t\r");
                  return trade;
               } 
               else {
                  valid = true;
               }
            } 
            else {
               System.out.print("\r\n\t\tCompany not found. Please try again.");
            }
         }   
         return null;
      }
   	
      public static void viewTradeHistory(ArrayList<Trade> trades) {
         for (Trade trade : trades) {
            System.out.print("\r\n " + trade.getDate() + "\r\n");
            if (trade.getNumStocks() < 0) {
               System.out.print("Bought ");
            } 
            else {
               System.out.print("Sold ");
            }
            System.out.print(Math.abs(trade.getNumStocks()) + " in " + trade.getCompany() + " at " + trade.getPrice() + "\r"
               					+ "\n\r");
         }
      }
   }