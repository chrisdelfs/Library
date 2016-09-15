package library.interfaces.daos;

import java.util.Date;
import java.util.List;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;

public abstract interface ILoanDAO
{
  public abstract ILoan createLoan(IMember paramIMember, IBook paramIBook);
  
  public abstract void commitLoan(ILoan paramILoan);
  
  public abstract ILoan getLoanByID(int paramInt);
  
  public abstract ILoan getLoanByBook(IBook paramIBook);
  
  public abstract List<ILoan> listLoans();
  
  public abstract List<ILoan> findLoansByBorrower(IMember paramIMember);
  
  public abstract List<ILoan> findLoansByBookTitle(String paramString);
  
  public abstract void updateOverDueStatus(Date paramDate);
  
  public abstract List<ILoan> findOverDueLoans();
}


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\interfaces\daos\ILoanDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */