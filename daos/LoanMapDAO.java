/*     */ package library.daos;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import library.interfaces.daos.ILoanDAO;
/*     */ import library.interfaces.daos.ILoanHelper;
/*     */ import library.interfaces.entities.IBook;
/*     */ import library.interfaces.entities.ILoan;
/*     */ import library.interfaces.entities.IMember;
/*     */ 
/*     */ public class LoanMapDAO
/*     */   implements ILoanDAO
/*     */ {
/*     */   private int nextID;
/*     */   private Map<Integer, ILoan> loanMap;
/*     */   private ILoanHelper helper;
/*     */   private Calendar cal;
/*     */   
/*     */   public LoanMapDAO(ILoanHelper helper)
/*     */   {
/*  26 */     if (helper == null) {
/*  27 */       throw new IllegalArgumentException(
/*  28 */         String.format("LoanMapDAO : constructor : helper cannot be null.", new Object[0]));
/*     */     }
/*  30 */     this.nextID = 0;
/*  31 */     this.helper = helper;
/*  32 */     this.loanMap = new HashMap();
/*  33 */     this.cal = Calendar.getInstance();
/*     */   }
/*     */   
/*     */   public LoanMapDAO(ILoanHelper helper, Map<Integer, ILoan> loanMap) {
/*  37 */     this(helper);
/*  38 */     if (loanMap == null) {
/*  39 */       throw new IllegalArgumentException(
/*  40 */         String.format("LoanMapDAO : constructor : loanMap cannot be null.", new Object[0]));
/*     */     }
/*  42 */     this.loanMap = loanMap;
/*     */   }
/*     */   
/*     */ 
/*     */   public ILoan getLoanByID(int id)
/*     */   {
/*  48 */     if (this.loanMap.containsKey(Integer.valueOf(id))) {
/*  49 */       return (ILoan)this.loanMap.get(Integer.valueOf(id));
/*     */     }
/*  51 */     return null;
/*     */   }
/*     */   
/*     */   public ILoan getLoanByBook(IBook book)
/*     */   {
/*  56 */     if (book == null) {
/*  57 */       throw new IllegalArgumentException(
/*  58 */         String.format("LoanMapDAO : getLoanByBook : book cannot be null.", new Object[0]));
/*     */     }
/*  60 */     for (ILoan loan : this.loanMap.values()) {
/*  61 */       IBook tempBook = loan.getBook();
/*  62 */       if (book.equals(tempBook)) {
/*  63 */         return loan;
/*     */       }
/*     */     }
/*  66 */     return null;
/*     */   }
/*     */   
/*     */   public List<ILoan> listLoans()
/*     */   {
/*  71 */     List<ILoan> list = new ArrayList(this.loanMap.values());
/*  72 */     return Collections.unmodifiableList(list);
/*     */   }
/*     */   
/*     */   public List<ILoan> findLoansByBorrower(IMember borrower)
/*     */   {
/*  77 */     if (borrower == null) {
/*  78 */       throw new IllegalArgumentException(
/*  79 */         String.format("LoanMapDAO : findLoansByBorrower : borrower cannot be null.", new Object[0]));
/*     */     }
/*  81 */     List<ILoan> list = new ArrayList();
/*  82 */     for (ILoan loan : this.loanMap.values()) {
/*  83 */       if (borrower.equals(loan.getBorrower())) {
/*  84 */         list.add(loan);
/*     */       }
/*     */     }
/*  87 */     return Collections.unmodifiableList(list);
/*     */   }
/*     */   
/*     */   public List<ILoan> findLoansByBookTitle(String title)
/*     */   {
/*  92 */     if ((title == null) || (title.isEmpty())) {
/*  93 */       throw new IllegalArgumentException(
/*  94 */         String.format("LoanMapDAO : findLoansByBookTitle : title cannot be null or blank.", new Object[0]));
/*     */     }
/*  96 */     List<ILoan> list = new ArrayList();
/*  97 */     for (ILoan loan : this.loanMap.values()) {
/*  98 */       String tempTitle = loan.getBook().getTitle();
/*  99 */       if (title.equals(tempTitle)) {
/* 100 */         list.add(loan);
/*     */       }
/*     */     }
/* 103 */     return Collections.unmodifiableList(list);
/*     */   }
/*     */   
/*     */   public void updateOverDueStatus(Date currentDate)
/*     */   {
/* 108 */     for (ILoan loan : this.loanMap.values()) {
/* 109 */       loan.checkOverDue(currentDate);
/*     */     }
/*     */   }
/*     */   
/*     */   public List<ILoan> findOverDueLoans()
/*     */   {
/* 115 */     List<ILoan> list = new ArrayList();
/* 116 */     for (ILoan loan : this.loanMap.values()) {
/* 117 */       if (loan.isOverDue()) {
/* 118 */         list.add(loan);
/*     */       }
/*     */     }
/* 121 */     return Collections.unmodifiableList(list);
/*     */   }
/*     */   
/*     */   private int getNextId() {
/* 125 */     return ++this.nextID;
/*     */   }
/*     */   
/*     */ 
/*     */   public ILoan createLoan(IMember borrower, IBook book)
/*     */   {
/* 131 */     if ((borrower == null) || (book == null)) {
/* 132 */       throw new IllegalArgumentException(
/* 133 */         String.format("LoanMapDAO : createLoan : borrower and book cannot be null.", new Object[0]));
/*     */     }
/* 135 */     Date borrowDate = new Date();
/* 136 */     this.cal.setTime(borrowDate);
/* 137 */     this.cal.add(5, 14);
/* 138 */     Date dueDate = this.cal.getTime();
/* 139 */     ILoan loan = this.helper.makeLoan(book, borrower, borrowDate, dueDate);
/* 140 */     return loan;
/*     */   }
/*     */   
/*     */ 
/*     */   public void commitLoan(ILoan loan)
/*     */   {
/* 146 */     int id = getNextId();
/* 147 */     loan.commit(id);
/* 148 */     this.loanMap.put(Integer.valueOf(id), loan);
/*     */   }
/*     */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\daos\LoanMapDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */