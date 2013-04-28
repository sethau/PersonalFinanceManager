package Controllers;

import java.util.ArrayList;

public abstract class Controller {  
  
	//create data files for new object
	public static boolean create(Object obj) {
		return true;
	}

	//remove data files from repository for specified id
	public static boolean remove(String id) {
		return true;
	}

	//retrieve data for specified id from repository and return as Object
	public static  Object get(String id) {
		return null;
	}

	//retrive data for all objects in a directory
	public static ArrayList<Object> getAll(Object obj) {
		return null;
	}
}
