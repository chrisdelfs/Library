/*    */ package library.daos;
/*    */ 
/*    */ import library.entities.Member;
/*    */ import library.interfaces.daos.IMemberHelper;
/*    */ import library.interfaces.entities.IMember;
/*    */ 
/*    */ 
/*    */ public class MemberHelper
/*    */   implements IMemberHelper
/*    */ {
/*    */   public IMember makeMember(String firstName, String lastName, String contactPhone, String emailAddress, int id)
/*    */   {
/* 13 */     return new Member(firstName, lastName, contactPhone, emailAddress, id);
/*    */   }
/*    */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\daos\MemberHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */