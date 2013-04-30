 package Controllers;
 import java.lang.NumberFormatException;
 public class RealTimeStockQuote {

	// Given symbol, get current stock price.
	// Input: Stock symbol
	// Output: Stock price if valid symbol
	//            -1 if symbol invalid
	// Note: This can be used as a boolean test to see if a stock exists.

	 public static double price(String symbol)
	 {
		 In page = new In("http://www.google.com/finance?q=NASDAQ" + ":" + symbol);
		 String input = page.readAll();
		 if(!input.contains("Did you mean:"))
		 {
		    int trade = input.indexOf("<span id=\"", 0); // "Last trade:" index
		    int from = 1+ input.indexOf(">", trade);        // "<b><span" index
		    int to = input.indexOf("<", from);      // "</b>" index
		    String price = input.substring(from, to);
		    try{
		       return Double.parseDouble(price);
		    }
		       catch(NumberFormatException v)
		       {
		          return -1;
		       }
		 }
		 return -1;
	 }
}