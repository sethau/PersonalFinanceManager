   package Forms;
   import Controllers.ProfileController;
   import Domain.Profile;
   import java.io.*;
   import java.util.Scanner;
   import java.lang.String;
   
   public class ProfileForm {
      public Profile newUser() {
         boolean valid = false;
         String in;
         Scanner input = new Scanner(System.in);
         Profile profile;
      	
         while (!valid) {
            System.out.print("\nPlease Enter A Username: ");
            in = input.next();
            if (Profilecontroller.get(in) == null) {
               System.out.print("\r\nPlease Enter A Password: ");
               profile = new Profile(in, input.next());
               valid = true;
            } 
            else {
               System.out.print("\r\n\t\t\t\tThis Username Already Exists!\r"); 
            }
         }
         
         ProfileController.create((Object) profile);
      	
         return profile;
      }
      
      public Profile existingUser() {
         boolean valid = false;
         String in;
         Scanner input = new Scanner(System.in);
         Profile profile;
      	
         while (!valid) {
            System.out.print("\n\t\t\t\t\tPlease Log In.\r"
               					+ "\nUsername: ");
            in = input.next();
            profile = (Profile) ProfileController.get(in);
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
      
      public boolean confirmDelete(String id) {
         Scanner input = new Scanner(System.in);
      
         System.out.print("\nAre you absolutely sure you want to delete " + id + "\'s profile?\r"
               					+ "\nAll account and portfolio data will be permanently erased.\r"
               					+ "\n(y/n): ");
         if ((char) input.nextInt() == 'y') {
            ProfileController.remove(id);
            System.out.print("\n\t\t\t\t\tProfile Deleted!\r");
            return true;
         }
         return false;
      }
   }