package library.interfaces;

public abstract interface IBorrowUI
{
  public abstract void setState(EBorrowState paramEBorrowState);
  
  public abstract void displayMemberDetails(int paramInt, String paramString1, String paramString2);
  
  public abstract void displayExistingLoan(String paramString);
  
  public abstract void displayOverDueMessage();
  
  public abstract void displayAtLoanLimitMessage();
  
  public abstract void displayOutstandingFineMessage(float paramFloat);
  
  public abstract void displayOverFineLimitMessage(float paramFloat);
  
  public abstract void displayScannedBookDetails(String paramString);
  
  public abstract void displayPendingLoan(String paramString);
  
  public abstract void displayConfirmingLoan(String paramString);
  
  public abstract void displayErrorMessage(String paramString);
}


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\interfaces\IBorrowUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */