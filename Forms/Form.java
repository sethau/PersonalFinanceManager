   package Forms;
   
   public abstract interface Form {
      //public abstract void init();//perform any initializations
      public abstract Object getInfo();//display form to read in info from user and return object containing new info
      public abstract void displayInfo(Object obj);//display an object's information (by id) to the user
      //public abstract boolean close();//gives user option to close form
   }
