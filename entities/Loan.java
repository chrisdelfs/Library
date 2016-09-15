/*     */ package library.entities;
/*     */ 
/*     */ import java.text.DateFormat;
/*     */ import java.util.Date;
/*     */ import library.interfaces.entities.ELoanState;
/*     */ import library.interfaces.entities.IBook;
/*     */ import library.interfaces.entities.ILoan;
/*     */ import library.interfaces.entities.IMember;
/*     */ 
/*     */ public class Loan implements ILoan
/*     */ {
/*     */   private int id;
/*     */   private final IMember borrower;
/*     */   private final IBook book;
/*     */   private Date borrowDate;
/*     */   private Date dueDate;
/*     */   private ELoanState state;
/*     */   
/*     */   public Loan(IBook book, IMember borrower, Date borrowDate, Date returnDate)
/*     */   {
/*  21 */     if (!sane(book, borrower, borrowDate, returnDate)) {
/*  22 */       throw new IllegalArgumentException("Loan: constructor : bad parameters");
/*     */     }
/*  24 */     this.book = book;
/*  25 */     this.borrower = borrower;
/*  26 */     this.borrowDate = borrowDate;
/*  27 */     this.dueDate = returnDate;
/*  28 */     this.state = ELoanState.PENDING;
/*     */   }
/*     */   
/*     */   private boolean sane(IBook book, IMember borrower, Date borrowDate, Date returnDate) {
/*  32 */     return (book != null) && 
/*  33 */       (borrower != null) && 
/*  34 */       (borrowDate != null) && 
/*  35 */       (returnDate != null) && (
/*  36 */       borrowDate.compareTo(returnDate) <= 0);
/*     */   }
/*     */   
/*     */   public void commit(int loanId)
/*     */   {
/*  41 */     if (this.state != ELoanState.PENDING) {
/*  42 */       throw new RuntimeException(
/*  43 */         String.format("Loan : commit : incorrect state transition  : %s -> %s\n", new Object[] {
/*  44 */         this.state, ELoanState.CURRENT }));
/*     */     }
/*  46 */     if (loanId <= 0) {
/*  47 */       throw new RuntimeException(
/*  48 */         String.format("Loan : commit : id must be a positive integer  : %d\n", new Object[] {
/*  49 */         Integer.valueOf(loanId) }));
/*     */     }
/*  51 */     this.id = loanId;
/*  52 */     this.state = ELoanState.CURRENT;
/*  53 */     this.book.borrow(this);
/*  54 */     this.borrower.addLoan(this);
/*     */   }
/*     */   
/*     */   public void complete()
/*     */   {
/*  59 */     if ((this.state != ELoanState.CURRENT) && (this.state != ELoanState.OVERDUE)) {
/*  60 */       throw new RuntimeException(
/*  61 */         String.format("Loan : complete : incorrect state transition  : %s -> %s\n", new Object[] {
/*  62 */         this.state, ELoanState.COMPLETE }));
/*     */     }
/*  64 */     this.state = ELoanState.COMPLETE;
/*     */   }
/*     */   
/*     */   public boolean isOverDue()
/*     */   {
/*  69 */     return this.state == ELoanState.OVERDUE;
/*     */   }
/*     */   
/*     */   public boolean checkOverDue(Date currentDate)
/*     */   {
/*  74 */     if ((this.state != ELoanState.CURRENT) && (this.state != ELoanState.OVERDUE)) {
/*  75 */       throw new RuntimeException(
/*  76 */         String.format("Loan : checkOverDue : incorrect state transition  : %s -> %s\n", new Object[] {
/*  77 */         this.state, ELoanState.OVERDUE }));
/*     */     }
/*  79 */     if (currentDate.compareTo(this.dueDate) > 0) {
/*  80 */       this.state = ELoanState.OVERDUE;
/*     */     }
/*  82 */     return isOverDue();
/*     */   }
/*     */   
/*     */   public IMember getBorrower()
/*     */   {
/*  87 */     return this.borrower;
/*     */   }
/*     */   
/*     */   public IBook getBook()
/*     */   {
/*  92 */     return this.book;
/*     */   }
/*     */   
/*     */   public int getID()
/*     */   {
/*  97 */     return this.id;
/*     */   }
/*     */   
/*     */   public ELoanState getState() {
/* 101 */     return this.state;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 106 */     return String.format("Loan ID:  %d\nAuthor:   %s\nTitle:    %s\nBorrower: %s %s\nBorrowed: %s\nDue Date: %s", new Object[] {
/* 107 */       Integer.valueOf(this.id), this.book.getAuthor(), this.book.getTitle(), this.borrower.getFirstName(), this.borrower.getLastName(), 
/* 108 */       DateFormat.getDateInstance().format(this.borrowDate), 
/* 109 */       DateFormat.getDateInstance().format(this.dueDate) });
/*     */   }
/*     */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\entities\Loan.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */