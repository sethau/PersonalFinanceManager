   package Forms;
   import Controllers.ProfileController;
   import Domain.Profile;
   import java.io.*;
   import java.util.Scanner;
   import java.lang.String;
  
   public class LoginForm {
      public String welcome() {
         Scanner input = new Scanner(System.in);
         boolean valid = false;
         char in;
         Profile profile;
      	
         System.out.print("\t\t\t\t\tWelcome To The PFM!\r");
         while (!valid) {
            System.out.print("\n\r"
               					+ "\n1) New User\r"
               					+ "\n2) Existing User\r"
               					+ "\n\r"
               					+ "\nPlease Select An Option: ");
            in = (char) input.nextInt();
            switch (in) {
               case '1':
                  return "New User";
                  valid = true;
                  break;
               case '2':
                  return "Existing User";
                  valid = true;
                  break;
               default:
                  System.out.print("\r\n\t\t\t\t\tInvalid Input!");
            }
         }
      	
         return null;
      }
   }