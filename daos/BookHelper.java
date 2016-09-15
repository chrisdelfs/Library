/*    */ package library.daos;
/*    */ 
/*    */ import library.entities.Book;
/*    */ import library.interfaces.daos.IBookHelper;
/*    */ import library.interfaces.entities.IBook;
/*    */ 
/*    */ public class BookHelper implements IBookHelper
/*    */ {
/*    */   public IBook makeBook(String author, String title, String callNumber, int id)
/*    */   {
/* 11 */     return new Book(author, title, callNumber, id);
/*    */   }
/*    */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\daos\BookHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */