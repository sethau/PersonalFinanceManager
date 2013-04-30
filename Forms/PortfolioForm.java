   package Forms;
   import Controllers.PortfolioController;
import Controllers.RealTimeStockQuote;
import Domain.Profile;
import Domain.Portfolio;
import Domain.Stock;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
   
   public class PortfolioForm {
      public static String viewPortfolio(Profile profile) throws FileNotFoundException {
         Portfolio portfolio = PortfolioController.get(profile);
         int in;
         Scanner input = new Scanner(System.in);
      	
         System.out.print("\n" + profile.getUsername() + "\'s Portfolio\r"
            					+ "\n- Stock Holdings: "/* + PortfolioController.getStockValue(profile)*/);
         while (true) {
            System.out.print("\r\n\r"
               					+ "\n1) Back\r"
               					+ "\n2) View Holdings\r"
               					+ "\n3) View Trade History\r"
               					+ "\n4) Buy\r"
               					+ "\n5) Sell\r"
               					+ "\n\r"
               					+ "\nPlease Select An Option: ");
            in = (char) input.nextInt();
            switch (in) {
               case 1:
                  return "Back";
               case 2:
                  return "View Holdings";
               case 3:
                  return "View Trade History";
               case 4:
                  return "Buy";
               case 5:
                  return "Sell";
               default:
                  System.out.print("\r\n\t\t\t\t\tInvalid Input!");
            }
         }
      }
      
      public static void viewHoldings(ArrayList<Stock> stocks) {
         for (Stock stock : stocks) {
            System.out.print("\r\n " + stock.getCompany() + "\r"
               					+ "\nShares: " + stock.getNumShares() + " at "
               					+ RealTimeStockQuote.price(stock.getCompany()) + "\r"
               					+ "\nTotal: $" + stock.getNumShares()
               					* RealTimeStockQuote.price(stock.getCompany()) + "\r\n");
         }
      }
   }