   package Forms;
   import Controllers.ProfileController;
import Domain.Profile;
import java.io.*;
import java.lang.String;
import java.util.Scanner;
   
   public class MenuForm {	
      public static String displayMenu(Profile profile) throws FileNotFoundException {
         char in;
         Scanner input = new Scanner(System.in);
      	
         System.out.print("\n\t\t\t\t\tWelcome, " + profile.getUsername() + "!\r"
            					+ "\n\t\t\t\t- Net Worth: " + ProfileController.getNetWorth(profile) + "\r");
         while (true) {
            System.out.print("\n\r"
               					+ "\n1) View Accounts\r"
               					+ "\n2) View Portfolio\r"
               					+ "\n3) Delete Profile\r"
               					+ "\n4) Log Out\r"
               					+ "\n\r"
               					+ "\nPlease Select An Option: ");
            in = (char) input.nextInt();
            switch (in) {
               case '1':
                  return "View Accounts";
               case '2':
                  return "View Portfolio";
               case '3':
                  return "Delete Profile";
               case '4':
                  return "Log Out";
               default:
                  System.out.print("\r\n\t\t\t\t\tInvalid Input!");
            }
         }
      }
   }