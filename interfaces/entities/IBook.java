package library.interfaces.entities;

public abstract interface IBook
{
  public abstract void borrow(ILoan paramILoan);
  
  public abstract ILoan getLoan();
  
  public abstract void returnBook(boolean paramBoolean);
  
  public abstract void lose();
  
  public abstract void repair();
  
  public abstract void dispose();
  
  public abstract EBookState getState();
  
  public abstract String getAuthor();
  
  public abstract String getTitle();
  
  public abstract String getCallNumber();
  
  public abstract int getID();
}


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\interfaces\entities\IBook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */