   package Forms;
   import Domain.Profile;
   import Domain.Portfolio;
   import Domain.Stock;
   import java.io.*;
   import java.util.Scanner;
   import java.util.ArrayList;
   
   public class PortfolioForm {
      public String viewPortfolio(Profile profile) {
         Portfolio portfolio = PortfolioController.get(profile.getName());
         char in;
         boolean valid = false;
         Scanner input = new Scanner(System.in);
      	
         System.out.print("\n" + profile.getName() + "\'s Portfolio\r"
            					+ "\n- Available Funds For Investment: "/* + portfolio.getAvailableFunds()*/ + "\r"
            					+ "\n- Net Profit: "/* + portfolio.getNetProfit()*/ + "\r"
            					+ "\n- Stock Holdings: "/* + portfolio.getStockHoldings*/);
         while (!valid) {
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
               case '1':
                  return "Back";
                  valid = true;
                  break;
               case '2':
                  return "View Holdings";
                  valid = true;
                  break;
               case '3':
                  return "View Trade History";
                  valid = true;
                  break;
               case '4':
                  return "Buy";
                  valid = true;
                  break;
               case '5':
                  return "Sell";
                  valid = true;
                  break;
               default:
                  System.out.print("\r\n\t\t\t\t\tInvalid Input!");
            }
         }
      }
      
      public void viewHoldings(ArrayList<Stock> stocks) {
         for (Stock stock : stocks) {
            System.out.print("\r\n " + stock.getCompany() + "\r"
               					+ "\nShares: " + stock.getNumShares() + " at " + stock.getPrice() + "\r"
               					+ "\nTotal: $" + stock.getNumShares() * stock.getPrice() + "\r\n");
         }
      }
   }