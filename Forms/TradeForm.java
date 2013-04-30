   package Forms;
   import Domain.Portfolio;
   import Domain.Trade;
   import Controllers.TradeController;
   import Controllers.RealTimeStockQuote;
   
   public class TradeForm {
      public Trade buy(Portfolio portfolio) {
         boolean valid = false;
         String in;
         double price;
         int num;
         char confirm;
         Scanner input = new Scanner(System.in);
         Trade trade = new Trade(portfolio);
      	
         while (!vaild) {
            System.out.print("\r\nCompany: ");
            in = input.getNext();
            price = RealTimeStockQuote.price(in);
            if (price != -1) {
               System.out.print("\r\nCurrent Share Price: " + price + "\r"
                  					+ "\nNumber Of Shares To Be Bought: ");
               num = input.getNextInt();
               System.out.print("\nThis will Cost $" + num * price + ", confirm (y/n): ");
               confirm = (char) input.getNextInt();
               if (confirm == 'y') {
                  trade.setNumShares(num);
                  trade.setPrice(price);
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
   	
      public Trade sell() {
         boolean valid = false;
         String in;
         double price;
         int num;
         char confirm;
         Scanner input = new Scanner(System.in);
         Trade trade = new Trade(portfolio);
      	
         while (!vaild) {
            System.out.print("\r\nCompany: ");
            in = input.getNext();
            price = RealTimeStockQuote.price(in);
            if (price != -1) {
               System.out.print("\r\nCurrent Share Price: " + price + "\r"
                  					+ "\nNumber Of Shares To Be Sold: ");
               num = input.getNextInt();
               System.out.print("\nThis will Yield $" + num * price + ", confirm (y/n): ");
               confirm = (char) input.getNextInt();
               if (confirm == 'y') {
                  trade.setNumShares(num * -1);
                  trade.setPrice(price);
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
   	
      public void viewTradeHistory(ArrayList<Trade> trades) {
         for (Trade trade : trades) {
            System.out.print("\r\n " + trade.getDate() + "\r\n");
            if (trade.getNumShares() < 0) {
               System.print("Bought ");
            } 
            else {
               System.print("Sold ");
            }
            System.out.print(Math.abs(trade.getNumShares()) + " in " + trade.getCompany() + " at " + trade.getPrice() + "\r"
               					+ "\n\r");
         }
      }
   }