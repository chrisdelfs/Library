package library.interfaces.daos;

import java.util.Date;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;

public abstract interface ILoanHelper
{
  public abstract ILoan makeLoan(IBook paramIBook, IMember paramIMember, Date paramDate1, Date paramDate2);
}


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\interfaces\daos\ILoanHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */