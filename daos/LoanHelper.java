/*    */ package library.daos;
/*    */ 
/*    */ import java.util.Date;
/*    */ import library.entities.Loan;
/*    */ import library.interfaces.daos.ILoanHelper;
/*    */ import library.interfaces.entities.IBook;
/*    */ import library.interfaces.entities.ILoan;
/*    */ import library.interfaces.entities.IMember;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoanHelper
/*    */   implements ILoanHelper
/*    */ {
/*    */   public ILoan makeLoan(IBook book, IMember borrower, Date borrowDate, Date dueDate)
/*    */   {
/* 17 */     return new Loan(book, borrower, borrowDate, dueDate);
/*    */   }
/*    */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\daos\LoanHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */