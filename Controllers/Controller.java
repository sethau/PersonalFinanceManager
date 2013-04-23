public abstract interface Controller {  
  public abstract boolean create(String name, String type);
  public abstract boolean remove(String name);
  public abstract Object get(String name);
}
