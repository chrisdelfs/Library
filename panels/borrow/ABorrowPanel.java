/*    */ package library.panels.borrow;
/*    */ 
/*    */ import javax.swing.JPanel;
/*    */ import library.interfaces.EBorrowState;
/*    */ import library.interfaces.IBorrowUI;
/*    */ 
/*    */ public abstract class ABorrowPanel
/*    */   extends JPanel
/*    */   implements IBorrowUI
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void setState(EBorrowState state)
/*    */   {
/* 15 */     throw new RuntimeException("Illegal operation in current state");
/*    */   }
/*    */   
/*    */ 
/*    */   public void displayMemberDetails(int memberID, String memberName, String memberPhone)
/*    */   {
/* 21 */     throw new RuntimeException("Illegal operation in current state");
/*    */   }
/*    */   
/*    */ 
/*    */   public void displayExistingLoan(String loanDetails)
/*    */   {
/* 27 */     throw new RuntimeException("Illegal operation in current state");
/*    */   }
/*    */   
/*    */ 
/*    */   public void displayOverDueMessage()
/*    */   {
/* 33 */     throw new RuntimeException("Illegal operation in current state");
/*    */   }
/*    */   
/*    */ 
/*    */   public void displayAtLoanLimitMessage()
/*    */   {
/* 39 */     throw new RuntimeException("Illegal operation in current state");
/*    */   }
/*    */   
/*    */ 
/*    */   public void displayOutstandingFineMessage(float amountOwing)
/*    */   {
/* 45 */     throw new RuntimeException("Illegal operation in current state");
/*    */   }
/*    */   
/*    */   public void displayOverFineLimitMessage(float amountOwing)
/*    */   {
/* 50 */     throw new RuntimeException("Illegal operation in current state");
/*    */   }
/*    */   
/*    */ 
/*    */   public void displayScannedBookDetails(String bookDetails)
/*    */   {
/* 56 */     throw new RuntimeException("Illegal operation in current state");
/*    */   }
/*    */   
/*    */ 
/*    */   public void displayPendingLoan(String loanDetails)
/*    */   {
/* 62 */     throw new RuntimeException("Illegal operation in current state");
/*    */   }
/*    */   
/*    */ 
/*    */   public void displayConfirmingLoan(String loanDetails)
/*    */   {
/* 68 */     throw new RuntimeException("Illegal operation in current state");
/*    */   }
/*    */   
/*    */ 
/*    */   public void displayErrorMessage(String errorMesg)
/*    */   {
/* 74 */     throw new RuntimeException("Illegal operation in current state");
/*    */   }
/*    */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\panels\borrow\ABorrowPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */