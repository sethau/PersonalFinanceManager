   package Controllers;
   import Forms.LoginForm;
import Forms.MenuForm;
import Domain.Profile;

import java.io.IOException;
import java.lang.String;

   public class MenuController {
      public static void main(String[] args) throws IOException {
         MenuController.createForm();
      }
      
      private static void createForm() throws IOException {
		int selection;
         Profile profile;
         String result;
         result = "Log Out";
         while (result.equals("Log Out")) {
         	//Log In
            profile = ProfileController.createForm(LoginForm.welcome(), null);
            result = "Main Menu";
            while (result.equals("Main Menu")) {
            	//Main Menu
               result = MenuForm.displayMenu(profile);
               if (result.equals("View Accounts")) {
                  while (result.equals("View Accounts")) {
                  	//View Accounts
                     selection = AccountController.viewAccounts(profile);
					 if (selection == 1) result = "Back";
                     if (result.equals("Back")) {
                     	//Back To Main Menu
                        result = "Main Menu";
                     } 
                     else {
                     	//Create Account
                     	//Close Account
                     	//View Account
						if (selection == 2) {
							result = "Create Account";
							result = AccountController.createForm(result, profile, 0);
							result = "Main Menu";
						}
						else if (selection == 3) {
							result = "Close Account";
							result = AccountController.createForm(result, profile, 0);
							result = "Main Menu";
						}
						else {
							result = "View Account";
							result = AccountController.createForm(result, profile, selection);
							result = "Main Menu";
						}
                     }
                  }
               } 
               else if (result.equals("View Portfolio")) {
                  while (result.equals("View Portfolio")) {
                  	//View Portfolio
                     result = PortfolioController.createForm(result, profile);
                     if (result.equals("Back")) {
                     	//Back To Main Menu
                        result = "Main Menu";
                     } 
                     else {
                     	//View Holdings
                     	//View Trade History
                     	//Buy
                     	//Sell
                        result = PortfolioController.createForm(result, profile);
                        result = "Main Menu";
                     }
                  }
               } 
               else if (result.equals("Delete Profile")) {
               	//Delete Profile And Log Out
				  if (ProfileController.createForm(result, profile) == null) {
					result = "Log Out";
				  }
                  //Do Not Delete Profile, Bact To Main Menu
                  else {
                     result = "Main Menu";
                  }
               }
            }
         }
      }
   }