package library.interfaces.daos;

import java.util.List;
import library.interfaces.entities.IBook;

public abstract interface IBookDAO
{
  public abstract IBook addBook(String paramString1, String paramString2, String paramString3);
  
  public abstract IBook getBookByID(int paramInt);
  
  public abstract List<IBook> listBooks();
  
  public abstract List<IBook> findBooksByAuthor(String paramString);
  
  public abstract List<IBook> findBooksByTitle(String paramString);
  
  public abstract List<IBook> findBooksByAuthorTitle(String paramString1, String paramString2);
}


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\interfaces\daos\IBookDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */