/*     */ package library.entities;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import library.interfaces.entities.EMemberState;
/*     */ import library.interfaces.entities.ILoan;
/*     */ import library.interfaces.entities.IMember;
/*     */ 
/*     */ 
/*     */ public class Member
/*     */   implements IMember
/*     */ {
/*     */   private final String firstName;
/*     */   private final String lastName;
/*     */   private final String contactPhone;
/*     */   private final String emailAddress;
/*     */   private final int id;
/*     */   private EMemberState state;
/*     */   private List<ILoan> loanList;
/*     */   private float totalFines;
/*     */   
/*     */   public Member(String firstName, String lastName, String contactPhone, String email, int memberID)
/*     */   {
/*  25 */     if (!sane(firstName, lastName, contactPhone, email, memberID)) {
/*  26 */       throw new IllegalArgumentException("Member: constructor : bad parameters");
/*     */     }
/*  28 */     this.firstName = firstName;
/*  29 */     this.lastName = lastName;
/*  30 */     this.contactPhone = contactPhone;
/*  31 */     this.emailAddress = email;
/*  32 */     this.id = memberID;
/*  33 */     this.loanList = new ArrayList();
/*  34 */     this.totalFines = 0.0F;
/*  35 */     this.state = EMemberState.BORROWING_ALLOWED;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean sane(String firstName, String lastName, String contactPhone, String emailAddress, int memberID)
/*     */   {
/*  41 */     return (firstName != null) && (!firstName.isEmpty()) && 
/*  42 */       (lastName != null) && (!lastName.isEmpty()) && 
/*  43 */       (contactPhone != null) && (!contactPhone.isEmpty()) && 
/*  44 */       (emailAddress != null) && (!emailAddress.isEmpty()) && (
/*  45 */       memberID > 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean hasOverDueLoans()
/*     */   {
/*  52 */     for (ILoan loan : this.loanList) {
/*  53 */       if (loan.isOverDue()) {
/*  54 */         return true;
/*     */       }
/*     */     }
/*  57 */     return false;
/*     */   }
/*     */   
/*     */   public boolean hasReachedLoanLimit()
/*     */   {
/*  62 */     boolean b = this.loanList.size() >= 5;
/*  63 */     return b;
/*     */   }
/*     */   
/*     */   public boolean hasFinesPayable()
/*     */   {
/*  68 */     boolean b = this.totalFines > 0.0F;
/*  69 */     return b;
/*     */   }
/*     */   
/*     */   public boolean hasReachedFineLimit()
/*     */   {
/*  74 */     boolean b = this.totalFines >= 10.0F;
/*  75 */     return b;
/*     */   }
/*     */   
/*     */   public float getFineAmount()
/*     */   {
/*  80 */     return this.totalFines;
/*     */   }
/*     */   
/*     */   public void addFine(float fine)
/*     */   {
/*  85 */     if (fine < 0.0F) {
/*  86 */       throw new RuntimeException(String.format("Member: addFine : fine cannot be negative", new Object[0]));
/*     */     }
/*  88 */     this.totalFines += fine;
/*  89 */     updateState();
/*     */   }
/*     */   
/*     */   public void payFine(float payment)
/*     */   {
/*  94 */     if ((payment < 0.0F) || (payment > this.totalFines)) {
/*  95 */       throw new RuntimeException(String.format("Member: addFine : payment cannot be negative or greater than totalFines", new Object[0]));
/*     */     }
/*  97 */     this.totalFines -= payment;
/*  98 */     updateState();
/*     */   }
/*     */   
/*     */   public void addLoan(ILoan loan)
/*     */   {
/* 103 */     if (!borrowingAllowed().booleanValue()) {
/* 104 */       throw new RuntimeException(String.format("Member: addLoan : illegal operation in state: %s", new Object[] { this.state }));
/*     */     }
/* 106 */     this.loanList.add(loan);
/* 107 */     updateState();
/*     */   }
/*     */   
/*     */   public List<ILoan> getLoans()
/*     */   {
/* 112 */     return Collections.unmodifiableList(this.loanList);
/*     */   }
/*     */   
/*     */   public void removeLoan(ILoan loan)
/*     */   {
/* 117 */     if ((loan == null) || (!this.loanList.contains(loan))) {
/* 118 */       throw new RuntimeException(String.format("Member: removeLoan : loan is null or not found in loanList", new Object[0]));
/*     */     }
/* 120 */     this.loanList.remove(loan);
/* 121 */     updateState();
/*     */   }
/*     */   
/*     */ 
/*     */   public EMemberState getState()
/*     */   {
/* 127 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getFirstName()
/*     */   {
/* 133 */     return this.firstName;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getLastName()
/*     */   {
/* 139 */     return this.lastName;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getContactPhone()
/*     */   {
/* 145 */     return this.contactPhone;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getEmailAddress()
/*     */   {
/* 151 */     return this.emailAddress;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getID()
/*     */   {
/* 157 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 163 */     return String.format(
/* 164 */       "Id: %d\nName: %s %s\nContact Phone: %s\nEmail: %s\nOutstanding Charges: %0.2f", new Object[] { Integer.valueOf(this.id), 
/* 165 */       this.firstName, this.lastName, this.contactPhone, this.emailAddress, Float.valueOf(this.totalFines) });
/*     */   }
/*     */   
/*     */   private Boolean borrowingAllowed() {
/* 169 */     boolean b = (!hasOverDueLoans()) && 
/* 170 */       (!hasReachedFineLimit()) && 
/* 171 */       (!hasReachedLoanLimit());
/* 172 */     return Boolean.valueOf(b);
/*     */   }
/*     */   
/*     */   private void updateState() {
/* 176 */     if (borrowingAllowed().booleanValue()) {
/* 177 */       this.state = EMemberState.BORROWING_ALLOWED;
/*     */     }
/*     */     else {
/* 180 */       this.state = EMemberState.BORROWING_DISALLOWED;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\entities\Member.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */