   package Forms;
   import Domain.Profile;
   import java.io.*;
   import java.util.Scanner;
   import java.lang.String;
  
   public class LoginForm {
      public static String welcome() {
         Scanner input = new Scanner(System.in);
         int in;
         Profile profile;
      	
         System.out.print("\t\t\t\t\tWelcome To The PFM!\r");
         while (true) {
            System.out.print("\n\r"
               					+ "\n1) New User\r"
               					+ "\n2) Existing User\r"
               					+ "\n\r"
               					+ "\nPlease Select An Option: ");
            in = input.nextInt();
            switch (in) {
               case 1:
                  return "New User";
               case 2:
                  return "Existing User";
               default:
                  System.out.print("\r\n\t\t\t\t\tInvalid Input!");
            }
         }
      }
   }