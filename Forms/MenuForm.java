   package Forms;
   import Domain.Profile;
   import java.io.*;
   import java.lang.String;
   import java.util.Scanner;
   
   public class MenuForm {	
      public static String displayMenu(Profile profile) {
         char in;
         boolean valid = false;
         Scanner input = new Scanner(System.in);
      	
         System.out.print("\n\t\t\t\t\tWelcome, " + profile.getName() + "!\r"
            					+ "\n\t\t\t\t- Net Worth: " + profile.getNetWorth() + "\r");
         while (!valid) {
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
                  valid = true;
                  break;
               case '2':
                  return "View Portfolio";
                  valid = true;
                  break;
               case '3':
                  return "Delete Profile";
                  valid = true;
                  break;
               case '4':
                  return "Log Out";
                  valid = true;
                  break;
               default:
                  System.out.print("\r\n\t\t\t\t\tInvalid Input!");
            }
         }
      }
   }