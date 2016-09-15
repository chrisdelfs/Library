package library.interfaces.daos;

import java.util.List;
import library.interfaces.entities.IMember;

public abstract interface IMemberDAO
{
  public abstract IMember addMember(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract IMember getMemberByID(int paramInt);
  
  public abstract List<IMember> listMembers();
  
  public abstract List<IMember> findMembersByLastName(String paramString);
  
  public abstract List<IMember> findMembersByEmailAddress(String paramString);
  
  public abstract List<IMember> findMembersByNames(String paramString1, String paramString2);
}


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\interfaces\daos\IMemberDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */