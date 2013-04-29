   package Controllers;
   import Forms.LoginForm;
   import Forms.MenuForm;
   import Domain.Profile;
   import java.lang.String;

   public class MenuController {
      public static void main(String[] args) {
         MenuController.createForm();
      }
      
      private static void createForm() {
         Loginform lf = new LoginForm();
         Profile profile;
         MenuForm mf = new MenuForm();
         String result;
         result = "Log Out";
         while (result.equals("Log Out")) {
         	//Log In
            profile = ProfileController.createLoginForm(lf.welcome());
            result = "Main Menu";
            while (result.equals("Main Menu")) {
            	//Main Menu
               result = mf.displayMenu(profile);
               if (result.equals("View Accounts")) {
                  while (result.equals("View Accounts")) {
                  	//View Accounts
                     result = ProfileController.viewAccounts(profile);
                     if (result.equals("Back")) {
                     	//Back To Main Menu
                        result = "Main Menu";
                     } 
                     else {
                     	//Create Account
                     	//Close Account
                     	//View Account
                        result = AccountController.createForm(result, profile);
                     }
                  }
               } 
               else if (result.equals("View Portfolio")) {
                  while (result.equals("View Portfolio")) {
                  	//View Portfolio
                     result = ProfileController.viewPortfolio(profile);
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
                     }
                  }
               } 
               else if (result.equals("Delete Profile")) {
               	//Delete Profile And Log Out
                  if (ProfileController.createDeleteForm(profile.getName())) {
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