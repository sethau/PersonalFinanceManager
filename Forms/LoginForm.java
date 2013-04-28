   package Forms;
   import Controllers.ProfileController;
   import Domain.Profile;
   import java.io.*;
   import java.util.Scanner;
   import java.lang.String;
  
   public class LoginForm implements Form {
      public LoginForm() {
      
      }
      public Object getInfo() {
         Scanner input = new Scanner(System.in);
         boolean valid = false;
         char in;
         ProfileController pc = new ProfileController();
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
                  profile = newUser(pc);
                  valid = true;
                  break;
               case '2':
               	profile = existingUser(pc);
                  valid = true;
                  break;
               default:
                  System.out.print("\r\n\t\t\t\t\tInvalid Input!");
            }
         }
      	
         return (Object) profile;
      }
      
      public void displayInfo(Object obj) {
         //not needed in this class
      }
      
      private Profile newUser(ProfileController pc) {
         boolean valid = false;
         String in;
         Scanner input = new Scanner(System.in);
         Profile profile;
      	
         while (!valid) {
            System.out.print("\nPlease Enter A Username: ");
            in = input.next();
            if (pc.get(in) == null) {
            	profile = new Profile(in);
               System.out.print("\r\nPlease Enter A Password: ");
            	profile.setPassword(input.next());
            	valid = true;
            } else {
           		System.out.print("\r\n\t\t\t\tThis Username Already Exists!\r"); 
         	}
         }
         
      	pc.create((Object) profile);
      	
      	return profile;
      }
      
      private void existingUser(ProfileController pc) {
         boolean valid = false;
         String in;
         Scanner input = new Scanner(System.in);
         Profile profile;
      	
         while (!valid) {
            System.out.print("\n\t\t\t\t\tPlease Log In.\r"
										+ "\nUsername: ");
            in = input.next();
            profile = (Profile) pc.get(in);
            if (profile != null) {
               System.out.print("\r\nPassword: ");
            	if (profile.getPassword().equals(input.next())) {
            		valid = true;
            	} else {
            		System.out.print("\r\n\t\t\t\tIncorrect Password!\r");
            	}
            } else {
           		System.out.print("\r\n\t\t\t\tProfile Not Found!\r"); 
         	}
         }
         
      	return profile;
      }
   }