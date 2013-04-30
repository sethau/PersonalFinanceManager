   package Forms;
   import Controllers.ProfileController;
import Domain.Profile;
import java.io.*;
import java.util.Scanner;
import java.lang.String;
   
   public class ProfileForm {
      public static Profile newUser() throws FileNotFoundException {
         boolean valid = false;
         String in;
         Scanner input = new Scanner(System.in);
         Profile profile = null;
      	
         while (!valid) {
            System.out.print("\nPlease Enter A Username: ");
            in = input.next();
            if (ProfileController.get(in) == null) {
               System.out.print("\r\nPlease Enter A Password: ");
               profile = new Profile(in, input.next());
               valid = true;
            } 
            else {
               System.out.print("\r\n\t\t\t\tThis Username Already Exists!\r"); 
            }
         }
      	
         return profile;
      }
      
      public static Profile existingUser() throws FileNotFoundException {
         boolean valid = false;
         String in;
         Scanner input = new Scanner(System.in);
         Profile profile = null;
      	
         while (!valid) {
            System.out.print("\n\t\t\t\t\tPlease Log In.\r"
               					+ "\nUsername: ");
            in = input.next();
            profile = ProfileController.get(in);
            if (profile != null) {
               System.out.print("\r\nPassword: ");
               if (profile.getPassword().equals(input.next())) {
                  valid = true;
               } 
               else {
                  System.out.print("\r\n\t\t\t\tIncorrect Password!\r");
               }
            } 
            else {
               System.out.print("\r\n\t\t\t\tProfile Not Found!\r"); 
            }
         }
         
         return profile;
      }
      
      public static boolean confirmDelete(Profile profile) {
         Scanner input = new Scanner(System.in);
      
         System.out.print("\nAre you absolutely sure you want to delete " + profile.getUsername() + "\'s profile?\r"
               					+ "\nAll account and portfolio data will be permanently erased.\r"
               					+ "\n(y/n): ");
         if ((char) input.next().charAt(0) == 'y') {
            System.out.print("\n\t\t\t\t\tProfile Deleted!\r");
            return true;
         }
         return false;
      }
   }