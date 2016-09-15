/*     */ package library;
/*     */ 
/*     */ import java.awt.CardLayout;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.swing.JPanel;
/*     */ import library.interfaces.EBorrowState;
/*     */ import library.interfaces.IBorrowUI;
/*     */ import library.interfaces.IBorrowUIListener;
/*     */ import library.panels.borrow.ABorrowPanel;
/*     */ import library.panels.borrow.ConfirmLoanPanel;
/*     */ import library.panels.borrow.RestrictedPanel;
/*     */ import library.panels.borrow.ScanningPanel;
/*     */ import library.panels.borrow.SwipeCardPanel;
/*     */ 
/*     */ 
/*     */ public class BorrowUC_UI
/*     */   extends JPanel
/*     */   implements IBorrowUI
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private IBorrowUIListener listener;
/*     */   private EBorrowState state;
/*     */   private Map<EBorrowState, IBorrowUI> panels;
/*     */   
/*     */   public BorrowUC_UI(IBorrowUIListener listener)
/*     */   {
/*  28 */     this.listener = listener;
/*  29 */     this.panels = new HashMap();
/*  30 */     setLayout(new CardLayout());
/*     */     
/*  32 */     addPanel(new SwipeCardPanel(listener), EBorrowState.INITIALIZED);
/*  33 */     addPanel(new ScanningPanel(listener), EBorrowState.SCANNING_BOOKS);
/*  34 */     addPanel(new RestrictedPanel(listener), EBorrowState.BORROWING_RESTRICTED);
/*  35 */     addPanel(new ConfirmLoanPanel(listener), EBorrowState.CONFIRMING_LOANS);
/*     */   }
/*     */   
/*     */ 
/*     */   private void addPanel(ABorrowPanel panel, EBorrowState state)
/*     */   {
/*  41 */     this.panels.put(state, panel);
/*  42 */     add(panel, state.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   public void setState(EBorrowState state)
/*     */   {
/*  48 */     CardLayout cl = (CardLayout)getLayout();
/*     */     
/*  50 */     switch (state) {
/*     */     case CANCELLED: 
/*  52 */       cl.show(this, state.toString());
/*  53 */       break;
/*     */     
/*     */     case COMPLETED: 
/*  56 */       cl.show(this, state.toString());
/*  57 */       break;
/*     */     
/*     */     case INITIALIZED: 
/*  60 */       cl.show(this, state.toString());
/*  61 */       break;
/*     */     
/*     */     case CONFIRMING_LOANS: 
/*  64 */       cl.show(this, state.toString());
/*  65 */       break;
/*     */     
/*     */     case CREATED: 
/*     */       break;
/*     */     
/*     */     case SCANNING_BOOKS: 
/*     */       break;
/*     */     
/*     */     default: 
/*  74 */       throw new RuntimeException("Unknown state");
/*     */     }
/*  76 */     this.state = state;
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayMemberDetails(int memberID, String memberName, String memberPhone)
/*     */   {
/*  82 */     IBorrowUI ui = (IBorrowUI)this.panels.get(this.state);
/*  83 */     ui.displayMemberDetails(memberID, memberName, memberPhone);
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayOverDueMessage()
/*     */   {
/*  89 */     IBorrowUI ui = (IBorrowUI)this.panels.get(this.state);
/*  90 */     ui.displayOverDueMessage();
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayAtLoanLimitMessage()
/*     */   {
/*  96 */     IBorrowUI ui = (IBorrowUI)this.panels.get(this.state);
/*  97 */     ui.displayAtLoanLimitMessage();
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayOutstandingFineMessage(float amountOwing)
/*     */   {
/* 103 */     IBorrowUI ui = (IBorrowUI)this.panels.get(this.state);
/* 104 */     ui.displayOutstandingFineMessage(amountOwing);
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayOverFineLimitMessage(float amountOwing)
/*     */   {
/* 110 */     IBorrowUI ui = (IBorrowUI)this.panels.get(this.state);
/* 111 */     ui.displayOverFineLimitMessage(amountOwing);
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayExistingLoan(String loanDetails)
/*     */   {
/* 117 */     IBorrowUI ui = (IBorrowUI)this.panels.get(this.state);
/* 118 */     ui.displayExistingLoan(loanDetails);
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayScannedBookDetails(String bookDetails)
/*     */   {
/* 124 */     IBorrowUI ui = (IBorrowUI)this.panels.get(this.state);
/* 125 */     ui.displayScannedBookDetails(bookDetails);
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayPendingLoan(String loanDetails)
/*     */   {
/* 131 */     IBorrowUI ui = (IBorrowUI)this.panels.get(this.state);
/* 132 */     ui.displayPendingLoan(loanDetails);
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayConfirmingLoan(String loanDetails)
/*     */   {
/* 138 */     IBorrowUI ui = (IBorrowUI)this.panels.get(this.state);
/* 139 */     ui.displayConfirmingLoan(loanDetails);
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayErrorMessage(String errorMesg)
/*     */   {
/* 145 */     IBorrowUI ui = (IBorrowUI)this.panels.get(this.state);
/* 146 */     ui.displayErrorMessage(errorMesg);
/*     */   }
/*     */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\BorrowUC_UI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */