public abstract interface Controller {  
  public abstract boolean create(Object obj);//create data files for new object
  public abstract boolean remove(String id);//remove data files from repository for specified id
  public abstract Object get(String id);//retrieve data for specified id from repository and return as Object
}
